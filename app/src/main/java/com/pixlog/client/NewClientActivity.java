package com.pixlog.client;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.pixlog.MenuActivity;
import com.pixlog.Others;
import com.pixlog.Preferences;
import com.pixlog.R;
import com.pixlog.Translator;
import com.pixlog.client.registration.Registration;
import com.pixlog.client.registration.RegistrationResponse;
import com.pixlog.client.token.Token;
import com.pixlog.client.token.TokenResponse;
import com.pixlog.dao.User;
import com.pixlog.dao.UserDAO;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class NewClientActivity
        extends AppCompatActivity
        implements TokenResponse, RegistrationResponse {

    private CheckBox cb_accept;
    private ConstraintLayout layout;
    private Double[] gpsLocation = new Double[2];
    private EditText et_name, et_email, et_company, et_password,
            et_phone_cc, et_phone_ac, et_phone_number;
    private static int REQUEST_GPS = 101;
    private Preferences preferences;
    private ProgressBar progressBar;
    private String name, email, company, password,
            phone, phone_cc, phone_ac, phone_number;
    private TextView et_location, buttonRegister, termsConditions;
    private Translator translator = new Translator();
    private Others others = new Others();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = new Preferences(getApplicationContext());

        setContentView(R.layout.activity_new_client);

        layout = findViewById(R.id.clientLayout);

        ImageView buttonPort = findViewById(R.id.buttonPort3),
                buttonEng = findViewById(R.id.buttonEng3),
                buttonEsp = findViewById(R.id.buttonEsp3),
                buttonBack = findViewById(R.id.buttonBack);

        et_name = findViewById(R.id.et_name);
        et_phone_cc = findViewById(R.id.et_phone_cc);
        et_phone_ac = findViewById(R.id.et_phone_ac);
        et_phone_number = findViewById(R.id.et_phone_number);
        et_email = findViewById(R.id.et_email);
        et_location = findViewById(R.id.et_location);
        et_company = findViewById(R.id.et_company);
        et_password = findViewById(R.id.et_password);

        buttonRegister = findViewById(R.id.buttonRegister);
        cb_accept = findViewById(R.id.cb_accept);
        termsConditions = findViewById(R.id.terms_conditions);

        progressBar = findViewById(R.id.registering);

        translator = others.setLang(preferences);
        setNames();

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        buttonPort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.setLoginLang(0);
                translator = others.setLang(preferences);
                setNames();
            }
        });

        buttonEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.setLoginLang(1);
                translator = others.setLang(preferences);
                setNames();
            }
        });

        buttonEsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.setLoginLang(2);
                translator = others.setLang(preferences);
                setNames();
            }
        });

        final Drawable background1 = et_name.getBackground();
        et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                et_name.setBackground(background1);
            }
        });

        final Drawable background2 = et_phone_cc.getBackground();
        et_phone_cc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                phone_cc = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                et_phone_cc.setBackground(background2);
            }
        });

        final Drawable background3 = et_phone_ac.getBackground();
        et_phone_ac.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                phone_ac = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                et_phone_ac.setBackground(background3);
            }
        });

        final Drawable background4 = et_phone_number.getBackground();
        et_phone_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                phone_number = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                et_phone_number.setBackground(background4);
            }
        });

        final Drawable background5 = et_email.getBackground();
        et_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                email = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                et_email.setBackground(background5);
            }
        });

        final Drawable background6 = et_location.getBackground();
        et_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_location.setBackground(background6);
                requestGPSpermission();
            }
        });

        final Drawable background7 = et_company.getBackground();
        et_company.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                accountInfo();
                company = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                et_company.setBackground(background7);
            }
        });

        final Drawable background8 = et_password.getBackground();
        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                et_password.setBackground(background8);
            }
        });

        final Drawable background9 = cb_accept.getBackground();
        cb_accept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cb_accept.setBackground(background9);
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean item1 = false, item2 = false, item3 = false, item4 = false, item5 = false,
                        item6 = false, item7 = false, item8 = false, item9 = false, item10 = false;

                if (null == et_name.getText()
                        || et_name.getText().toString().equals("")){
                    et_name.setBackground(getResources().getDrawable(R.drawable.error_background));
                } else item1 = true;

                if (null == et_phone_cc.getText()
                        || et_phone_cc.getText().toString().equals("")
                        || et_phone_cc.getText().toString().toLowerCase().contains("+")){
                    et_phone_cc.setBackground(getResources().getDrawable(R.drawable.error_background));
                } else item2 = true;

                if (null == et_phone_ac.getText()
                        || et_phone_ac.getText().toString().equals("")
                        || et_phone_cc.getText().toString().contains("(")
                        || et_phone_cc.getText().toString().contains(")")){
                    et_phone_ac.setBackground(getResources().getDrawable(R.drawable.error_background));
                } else item3 = true;

                if (null == et_phone_number.getText()
                        || et_phone_number.getText().toString().equals("")
                        || et_phone_number.getText().toString().toLowerCase().contains("-")){
                    et_phone_number.setBackground(getResources().getDrawable(R.drawable.error_background));
                } else item4 = true;

                if (null == et_email.getText()
                        || et_email.getText().toString().equals("")
                        || !et_email.getText().toString().toLowerCase().contains(".com")
                        || !et_email.getText().toString().toLowerCase().contains("@")){
                    et_email.setBackground(getResources().getDrawable(R.drawable.error_background));
                } else item5 = true;

                if (null == gpsLocation[0] || null == gpsLocation[1]){
                    et_location.setBackground(getResources().getDrawable(R.drawable.error_background));
                } else item6 = true;

//                if (null == et_company.getText()
//                        || et_company.getText().toString().equals("")){
//                    et_company.setBackground(getResources().getDrawable(R.drawable.error_background));
//                } else item7 = true;

                if (null == et_password.getText()
                        || et_password.getText().toString().equals("")){
                    et_password.setBackground(getResources().getDrawable(R.drawable.error_background));
                } else item8 = true;

                if (!cb_accept.isChecked()){
                    cb_accept.setBackground(getResources().getDrawable(R.drawable.error_background));
                } else item9 = true;

                if (!others.isNetworkConnected(v.getContext())){
                    others.showToast(v.getContext(),translator.NoInternet());
                } else item10 = true;

                if (item1 && item2 && item3 && item4 && item5
                        && item6 && item8 && item9 && item10){

                    UserDAO userDAO = new UserDAO(getApplicationContext());
                    List<User> user = userDAO.get();

                    String accessToken = user.get(0).getAccessToken(),
                            tokenType = user.get(0).getTokenType(),
                            expiresAt = user.get(0).getExpiresAt();

                    if (!accessToken.equals("")){

                        if (others.checkTokenExpiration(expiresAt)){
                            registerUser(accessToken,tokenType,expiresAt);
                            Log.i("Registration","Token is up to date, overwriting user");
                        } generateToken();

                    }else generateToken();
                }
            }
        });
    }

    private void accountInfo() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog
                .Builder(NewClientActivity.this);
        alertDialogBuilder
                .setTitle(translator.AccountInfo())
                .setPositiveButton(translator.Yes(),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setNegativeButton(translator.No(),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }
                );
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
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

    private void setNames(){
        et_name.setHint(translator.Name());
        et_location.setHint(translator.Location());
        et_company.setHint(translator.Company());
        et_password.setHint(translator.Password());
        buttonRegister.setText(translator.Register());
        cb_accept.setText(translator.Accept()+"  ");
        termsConditions.setText(translator.TermsConditions()+"  ");
    }

    private void requestGPSpermission(){
        ActivityCompat.requestPermissions(NewClientActivity.this,
                new String[]{ACCESS_FINE_LOCATION},REQUEST_GPS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_GPS){
            FusedLocationProviderClient client = LocationServices
                    .getFusedLocationProviderClient(NewClientActivity.this);

            if (ActivityCompat.checkSelfPermission(
                    NewClientActivity.this, ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) requestGPSpermission();
            else client.getLastLocation().addOnSuccessListener(NewClientActivity.this,
                    new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                gpsLocation = new Double[]{location.getLatitude(), location.getLongitude()};
                                et_location.setHint(translator.LocationOk());
                            }
                        }
                    });
        }
    }

    private void generateToken() {
        progressBar.setVisibility(View.VISIBLE);
        layout.setBackground(getResources().getDrawable(R.drawable.progress_on));

        Token token = new Token();
        token.delegate = this;
        token.execute();
    }

    private void registerUser(String accesToken, String tokenType, String expiresAt) {
        try{
            JSONObject json = new JSONObject();
            json.put("name", et_name.getText().toString());
            json.put("business_name", et_company.getText().toString());
            json.put("email", et_email.getText().toString());
            json.put("cellphone", /*"+"+et_phone_cc.getText().toString()+"("+*/et_phone_ac.getText().toString()/*+")"*/+et_phone_number.getText().toString());
            json.put("password", et_password.getText().toString());
            json.put("lat", gpsLocation[0].toString());
            json.put("lng", gpsLocation[1].toString());

            Registration registration = new Registration(json, accesToken, tokenType, expiresAt);
            registration.delegate = this;
            registration.execute();
        } catch (JSONException e) {
            Log.e("Registration","Problem with user data JSON, "+e.getMessage());
        }
    }

    @Override
    public void onTokenFinish(String output) {
        try {
            JSONObject json = new JSONObject(output);
            String token = json.get("access_token").toString(),
                    type = json.get("token_type").toString(),
                    expires = json.get("expires_at").toString();

            if (type.equals("Bearer")){
                registerUser(token, type, expires);
                Log.i("Registration", "Token generated, registering user now");
            }

        } catch (JSONException e) {
            Log.e("Registration","Problem with returned JSON from Token class, "+e.getMessage());
        }
    }

    @Override
    public void onRegistrationFinish(String output) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                layout.setBackground(null);
            }
        });

        try{
            String[] split = output.split(";;");
            JSONObject json = new JSONObject(split[0]);
            if (json.getString("success").equals("true")){
                User user = new User();

                JSONObject data = new JSONObject(json.getString("data"));

                user.setUuid(data.get("uuid").toString());
                user.setName(data.get("name").toString());
                user.setEmail(data.get("email").toString());
                user.setBusinessName(data.get("business_name").toString());
                user.setPassword(et_password.getText().toString());
                user.setAccountType("perCredits");
                user.setCredits(String.valueOf(10));
                user.setAccessToken(split[1]);
                user.setTokenType(split[2]);
                user.setExpiresAt(split[3]);
                user.setLoginAut(String.valueOf(true));

                UserDAO userDAO = new UserDAO(getApplicationContext());
                if (userDAO.get().get(0).getAccessToken().equals("")) userDAO.add(user);
                else userDAO.update(user);

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);

                Log.i("Registration","User has been successfully registered");
            }else {
                others.showToast(getApplicationContext(),json.getString("data"));
                Log.e("Registration","Problem registering user, "+json.getString("message"));
            }

        } catch (JSONException e) {
            Log.e("Registration","Problem with returned JSON, "+e.getMessage());
        }

    }
}
