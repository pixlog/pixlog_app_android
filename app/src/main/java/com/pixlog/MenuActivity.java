package com.pixlog;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.pixlog.camera.CameraActivity;
import com.pixlog.client.LoginActivity;
import com.pixlog.dao.User;
import com.pixlog.dao.UserDAO;
import com.pixlog.results.ResultsActivity;

import java.util.Locale;

public class MenuActivity
        extends AppCompatActivity {

    private Preferences preferences;
    private Translator translator;
    private Others others = new Others();
    private static int REQUEST_CALL = 102;
    private TextView userLicense, userStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //Log.d("verificar_pasta","pasta"+ pasta);
        //Log.v("my activity","estou aqui");

        preferences = new Preferences(getApplicationContext());
        translator = others.setLang(preferences);

        setContentView(R.layout.activity_menu);

        ImageView buttonStart = findViewById(R.id.buttonStart),
                buttonResults = findViewById(R.id.buttonResults),
                buttonTutorials = findViewById(R.id.buttonTutorials);

        ImageView buttonContact = findViewById(R.id.buttonContact),
                buttonPayments = findViewById(R.id.buttonPayments),
                buttonSettings = findViewById(R.id.buttonSettings);

        ImageView buttonPort = findViewById(R.id.buttonPort2),
                buttonEng = findViewById(R.id.buttonEng2),
                buttonEsp = findViewById(R.id.buttonEsp2);

        userLicense = findViewById(R.id.userLicense);
        userStatus = findViewById(R.id.userStatus);

        userInfo();

        buttonPort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.setLoginLang(0);
                translator = others.setLang(preferences);
                others.showToast(getApplicationContext(), translator.ChangedToPort());
                userInfo();
            }
        });

        buttonEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.setLoginLang(1);
                translator = others.setLang(preferences);
                others.showToast(getApplicationContext(), translator.ChangedToEng());
                userInfo();
            }
        });

        buttonEsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.setLoginLang(2);
                translator = others.setLang(preferences);
                others.showToast(getApplicationContext(), translator.ChangedToEsp());
                userInfo();
            }
        });

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CameraActivity.class));
//                startActivity(new Intent(getApplicationContext(), Mosaico.class));
            }
        });

        buttonResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ResultsActivity.class));
            }
        });

        buttonTutorials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), VideoActivity.class));
            }
        });

        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(MenuActivity.this);
                View promptsView = layoutInflater.inflate(R.layout.contactus, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MenuActivity.this, R.style.CustomAlertDialog);
                alertDialogBuilder.setView(promptsView);

                AlertDialog alertDialog = alertDialogBuilder.create();

                ImageView contactus_email = promptsView.findViewById(R.id.contactus_email),
                        contactus_phone = promptsView.findViewById(R.id.contactus_phone),
                        contactus_location = promptsView.findViewById(R.id.contactus_location),
                        contactus_website = promptsView.findViewById(R.id.contactus_website);

                contactus_email.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_EMAIL,
                                new String[]{"contato@hexxageo.com.br", "ns@hexxageo.com.br"});
                        intent.setType("message/rfc822");
                        startActivity(Intent.createChooser(intent, translator.appEmail()));
                    }
                });

                contactus_phone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ContextCompat.checkSelfPermission(MenuActivity.this,
                                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                            requestCallPermission();
                        else startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+554130957300")));
                    }
                });

                contactus_location.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String loc = String.format(Locale.ENGLISH, "geo:%f,%f", -25.438339, -49.2828321);
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(loc)));
                    }
                });

                contactus_website.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pixlog.com.br")));
                    }
                });

                alertDialog.show();
            }
        });

        buttonPayments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MenuActivity.this, R.style.CustomAlertDialog);

                UserDAO userDAO = new UserDAO(v.getContext());
                User user = userDAO.get().get(0);
                String accountType1 = user.getAccountType();

                if (accountType1.equals("dev")){
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.setMessage(translator.DoesNotApplyForYou());
                    alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alertDialog.show();
                } else if (accountType1.equals("perCredits")){
                    showCreditsOptions();
                } else if (accountType1.equals("null")) {
                    LayoutInflater layoutInflater = LayoutInflater.from(MenuActivity.this);
                    View promptsView = layoutInflater.inflate(R.layout.account, null);

                    alertDialogBuilder.setView(promptsView);
                    final AlertDialog alertDialog = alertDialogBuilder.create();

                    TextView lastPayment = promptsView.findViewById(R.id.lastPayment),
                            lastpaymentDate = promptsView.findViewById(R.id.lastpaymentDate),
                            accountChange = promptsView.findViewById(R.id.accountChange);

                    lastPayment.setText(translator.LastPayment());
                    accountChange.setText(translator.AccountChange());

                    alertDialog.show();
                }
            }
        });

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(MenuActivity.this);
                View promptsView = layoutInflater.inflate(R.layout.settings, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MenuActivity.this, R.style.CustomAlertDialog);
                alertDialogBuilder.setView(promptsView);

                final AlertDialog alertDialog = alertDialogBuilder.create();

                TextView vFormula = promptsView.findViewById(R.id.settings_vformula),
                        userData = promptsView.findViewById(R.id.settings_userdata),
                        logout = promptsView.findViewById(R.id.settings_logout);

                vFormula.setText(translator.VolumeFormula());
                userData.setText(translator.YourData());
                logout.setText(translator.Logout());

                vFormula.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
                        popupMenu.inflate(R.menu.popup_vformula);
                        popupMenu.show();
                        setMenuItemNames(popupMenu);
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.cylindricalFormula:
                                        alertDialog.dismiss();
                                        setFormulaAndUnits(1, "metrical");
                                        break;
                                    case R.id.jasScale:
                                        alertDialog.dismiss();
                                        setFormulaAndUnits(2, "metrical");
                                        break;
                                    case R.id.gost270875:
                                        alertDialog.dismiss();
                                        setFormulaAndUnits(3, "metrical");
                                        break;
                                    case R.id.doyleLogRule:
                                        alertDialog.dismiss();
                                        setFormulaAndUnits(4, "imperial");
                                        break;
                                    case R.id.internationalRule14:
                                        alertDialog.dismiss();
                                        setFormulaAndUnits(5, "imperial");
                                        break;
                                    case R.id.royLogRule:
                                        alertDialog.dismiss();
                                        setFormulaAndUnits(6, "imperial");
                                        break;
                                    case R.id.scribnerDecimalC:
                                        alertDialog.dismiss();
                                        setFormulaAndUnits(7, "imperial");
                                        break;
                                    case R.id.ontarioLogRule:
                                        alertDialog.dismiss();
                                        setFormulaAndUnits(8, "imperial");
                                        break;
                                    case R.id.aNilsonFormula:
                                        alertDialog.dismiss();
                                        setFormulaAndUnits(12, "metrical");
                                        break;
                                    case R.id.imperialHoppus:
                                        alertDialog.dismiss();
                                        setFormulaAndUnits(13, "imperial");
                                        break;
                                    case R.id.metricalHoppus:
                                        alertDialog.dismiss();
                                        setFormulaAndUnits(14, "metrical");
                                        break;
                                }
                                return false;
                            }
                        });
                    }
                });

                userData.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        setUserDataView();
                    }
                });

                logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        logUserOut();
                    }
                });

                alertDialog.show();
            }
        });
    }

    private void userInfo() {
        UserDAO userDAO = new UserDAO(getApplicationContext());
        User user = userDAO.get().get(0);
        String accountType = user.getAccountType();
        String credits = user.getCredits();

        if (accountType.equals("perCredits")) {
            if (credits.equals("null")) credits = "0";
            rename(translator.Credits()+": "+credits, translator.Status()+": "+translator.Active());
        } else if (accountType.equals("perMonth"))
            rename(translator.License()+": "+translator.PerMonth(), translator.Status()+": "+translator.Active());
        else if (accountType.equals("perYear"))
            rename(translator.License()+": "+translator.PerYear(), translator.Status()+": "+translator.Active());
        else if (accountType.equals("dev") || accountType.equals("null")) //retirar a opção null depois
            rename(translator.License()+": "+translator.DevAccount(),translator.Status()+": "+translator.Active());
    }

    private void rename(String license, String status) {
        userLicense.setText(license);
        userStatus.setText(status);
    }

    private void showCreditsOptions() {
        LayoutInflater layoutInflater = LayoutInflater.from(MenuActivity.this);
        View promptsView = layoutInflater.inflate(R.layout.credits, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MenuActivity.this, R.style.CustomAlertDialog);
        alertDialogBuilder.setView(promptsView);

        final TextView chooseAnOption = promptsView.findViewById(R.id.chooseAnOption),
                credits5 = promptsView.findViewById(R.id.credits5),
                credits10 = promptsView.findViewById(R.id.credits10),
                credits20 = promptsView.findViewById(R.id.credits20),
                credits50 = promptsView.findViewById(R.id.credits50),
                buyCredits = promptsView.findViewById(R.id.buyCredits);

        chooseAnOption.setText(translator.ChooseAnOption());
        credits5.setText("+ 5 " + translator.Credits().toLowerCase());
        credits10.setText("+ 10 " + translator.Credits().toLowerCase());
        credits20.setText("+ 20 " + translator.Credits().toLowerCase());
        credits50.setText("+ 50 " + translator.Credits().toLowerCase());
        buyCredits.setText(translator.Buy().toUpperCase());

        final Integer[] quant = {0};

        credits5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackground(getResources().getDrawable(R.drawable.shadowfile));
                credits10.setBackground(null);
                credits20.setBackground(null);
                credits50.setBackground(null);
                quant[0] = 5;
            }
        });

        credits10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credits5.setBackground(null);
                v.setBackground(getResources().getDrawable(R.drawable.shadowfile));
                credits20.setBackground(null);
                credits50.setBackground(null);
                quant[0] = 10;
            }
        });

        credits20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credits5.setBackground(null);
                credits10.setBackground(null);
                v.setBackground(getResources().getDrawable(R.drawable.shadowfile));
                credits50.setBackground(null);
                quant[0] = 20;
            }
        });

        credits50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credits5.setBackground(null);
                credits10.setBackground(null);
                credits20.setBackground(null);
                v.setBackground(getResources().getDrawable(R.drawable.shadowfile));
                quant[0] = 50;
            }
        });

        buyCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quant[0] == 0)
                    others.showToast(v.getContext(), translator.SelectAnOptionABove());
                else others.showToast(v.getContext(), "SOON BUYING");
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void setMenuItemNames(PopupMenu popupMenu) {
        MenuItem item1 = popupMenu.getMenu().getItem(0);
        MenuItem item2 = popupMenu.getMenu().getItem(1);
        MenuItem item3 = popupMenu.getMenu().getItem(2);
        MenuItem item4 = popupMenu.getMenu().getItem(3);
        MenuItem item5 = popupMenu.getMenu().getItem(4);
        MenuItem item6 = popupMenu.getMenu().getItem(5);
        MenuItem item7 = popupMenu.getMenu().getItem(6);
        MenuItem item8 = popupMenu.getMenu().getItem(7);
        MenuItem item9 = popupMenu.getMenu().getItem(8);
        MenuItem item10 = popupMenu.getMenu().getItem(9);
        MenuItem item11 = popupMenu.getMenu().getItem(10);

        String volumeFormula01 = translator.VolumeFormula01();
        item1.setTitle(volumeFormula01.substring(0,1).toUpperCase()+volumeFormula01.substring(1));
        String volumeFormula02 = translator.VolumeFormula02();
        item2.setTitle(volumeFormula02.substring(0,1).toUpperCase()+volumeFormula02.substring(1));
        String volumeFormula03 = translator.VolumeFormula03();
        item3.setTitle(volumeFormula03.substring(0,1).toUpperCase()+volumeFormula03.substring(1));
        String volumeFormula04 = translator.VolumeFormula04();
        item4.setTitle(volumeFormula04.substring(0,1).toUpperCase()+volumeFormula04.substring(1));
        String volumeFormula05 = translator.VolumeFormula05();
        item5.setTitle(volumeFormula05.substring(0,1).toUpperCase()+volumeFormula05.substring(1));
        String volumeFormula06 = translator.VolumeFormula06();
        item6.setTitle(volumeFormula06.substring(0,1).toUpperCase()+volumeFormula06.substring(1));
        String volumeFormula07 = translator.VolumeFormula07();
        item7.setTitle(volumeFormula07.substring(0,1).toUpperCase()+volumeFormula07.substring(1));
        String volumeFormula08 = translator.VolumeFormula08();
        item8.setTitle(volumeFormula08.substring(0,1).toUpperCase()+volumeFormula08.substring(1));
        String volumeFormula12 = translator.VolumeFormula12();
        item9.setTitle(volumeFormula12.substring(0,1).toUpperCase()+volumeFormula12.substring(1));
        String volumeFormula13 = translator.VolumeFormula13();
        item10.setTitle(volumeFormula13.substring(0,1).toUpperCase()+volumeFormula13.substring(1));
        String volumeFormula14 = translator.VolumeFormula14();
        item11.setTitle(volumeFormula14.substring(0,1).toUpperCase()+volumeFormula14.substring(1));
    }

    private void setFormulaAndUnits(int formulaID, String units) {
        UserDAO userDAO = new UserDAO(getApplicationContext());
        User user = new User();
        user.setUuid(userDAO.get().get(0).getUuid());
        user.setFv(String.valueOf(formulaID));

        switch (units){
            case "metrical":
                user.setUd("cm");
                user.setUc("m");
                user.setUv("m³");
                break;
            case "imperial":
                user.setUd("in");
                user.setUc("ft");
                user.setUv("ft³");
                break;
        }

        userDAO.update(user);
        others.showToast(getApplicationContext(),translator.VolumeFormulaChanged());
    }

    private void setUserDataView() {

        UserDAO userDAO = new UserDAO(getApplicationContext());
        final User user = userDAO.get().get(0);

        LayoutInflater layoutInflater = LayoutInflater.from(MenuActivity.this);
        View promptsView = layoutInflater.inflate(R.layout.userdata, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MenuActivity.this, R.style.CustomAlertDialog);
        alertDialogBuilder.setView(promptsView);

        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);

        ImageView ud_companyOrPerson = promptsView.findViewById(R.id.ud_companyOrPerson);
        TextView ud_companyOrPerson_txt = promptsView.findViewById(R.id.ud_companyOrPerson_txt);
        if (user.getName().equals("null") && !user.getBusinessName().equals("null")) {
            ud_companyOrPerson.setImageResource(R.drawable.ic_company);
            ud_companyOrPerson_txt.setText(user.getBusinessName());
        } else if (!user.getName().equals("null") && user.getBusinessName().equals("null")) {
            ud_companyOrPerson.setImageResource(R.drawable.ic_user);
            ud_companyOrPerson_txt.setText(user.getName());
        }

        final ImageView ud_password_visibility = promptsView.findViewById(R.id.ud_password_visibility),
                ud_password_change = promptsView.findViewById(R.id.ud_password_change);

        final TextView ud_email_txt = promptsView.findViewById(R.id.ud_email_txt),
                ud_password_txt = promptsView.findViewById(R.id.ud_password_txt),
                ud_vformula_txt = promptsView.findViewById(R.id.ud_vformula_txt),
                ud_diameter_txt = promptsView.findViewById(R.id.ud_diameter_txt),
                ud_length_txt = promptsView.findViewById(R.id.ud_length_txt),
                ud_volume_txt = promptsView.findViewById(R.id.ud_volume_txt);

        ud_email_txt.setText(user.getEmail());
        final String hidden = "--------------------";
        ud_password_txt.setText(hidden);

        String formula = "";
        if (!user.getFv().equals("null")) {
            formula = user.getFv();
            ud_vformula_txt.setText(others.getFvName(translator,Integer.parseInt(formula)).toLowerCase());
        }else ud_vformula_txt.setText("");

        ud_diameter_txt.setText(user.getUd());
        ud_length_txt.setText(user.getUc());
        ud_volume_txt.setText(user.getUv());

        ud_password_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                changePassword();
            }
        });

        ud_password_visibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ud_password_txt.getText().equals(hidden)) {
                    ud_password_visibility.setImageResource(R.drawable.ic_visibility_on);
                    ud_password_txt.setText(user.getPassword());
                } else {
                    ud_password_visibility.setImageResource(R.drawable.ic_visibility_off);
                    ud_password_txt.setText(hidden);
                }
            }
        });

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();
    }

    private void changePassword() {
        LayoutInflater layoutInflater = LayoutInflater.from(MenuActivity.this);
        View promptsView = layoutInflater.inflate(R.layout.password, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MenuActivity.this, R.style.CustomAlertDialog);
        alertDialogBuilder.setView(promptsView);

        final String[] password = new String[1];
        final String[] confirmPassword = new String[1];

        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, translator.Change(),
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

                UserDAO userDAO = new UserDAO(getApplicationContext());
                User user = new User();

                user.setUuid(userDAO.get().get(0).getUuid());
                user.setPassword(password[0]);

                userDAO.update(user);
                others.showToast(getApplicationContext(),translator.Updated());
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, translator.Cancel(),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        TextView tv_newPassword = promptsView.findViewById(R.id.newPassword);
        TextView tv_ConfirmPassword = promptsView.findViewById(R.id.confirmPassword);

        tv_newPassword.setText(translator.NewPassword());
        tv_ConfirmPassword.setText(translator.ConfirmPassword());

        final EditText et_newPassword = promptsView.findViewById(R.id.et_newPassword);
        final EditText et_confirmPassword = promptsView.findViewById(R.id.et_confirmPassword);
        et_confirmPassword.setEnabled(false);

        et_newPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password[0] = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!password[0].equals("")) et_confirmPassword.setEnabled(true);
                else et_confirmPassword.setEnabled(false);
            }
        });

        final Drawable background = et_confirmPassword.getBackground();
        et_confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                et_confirmPassword.setBackground(background);
                confirmPassword[0] = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (confirmPassword[0].equals(""))
                    alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(false);
                else if (!confirmPassword[0].equals(password[0])) {
                    et_confirmPassword.setBackground(getResources().getDrawable(R.drawable.error_background));
                } else alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(true);
            }
        });

        alertDialog.show();
        alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(false);
    }

    private void logUserOut() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        UserDAO userDAO = new UserDAO(getApplicationContext());

                        User user = new User();
                        user.setUuid(userDAO.get().get(0).getUuid());
                        user.setLoginAut("false");

                        userDAO.update(user);

                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        Log.i("Menu", "User logged out");
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        dialog.cancel();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this, R.style.CustomAlertDialog);
        builder.setMessage(translator.Exit())
                .setPositiveButton(translator.Yes(), dialogClickListener)
                .setNegativeButton(translator.No(), dialogClickListener)
                .show();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void requestCallPermission(){
        ActivityCompat.requestPermissions(MenuActivity.this,
                new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL)
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                return;
            else startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+554130957300")));
    }
}
