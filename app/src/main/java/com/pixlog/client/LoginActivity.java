package com.pixlog.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pixlog.MenuActivity;
import com.pixlog.Preferences;
import com.pixlog.R;
import com.pixlog.Translator;
import com.pixlog.Others;
import com.pixlog.client.token.Token;
import com.pixlog.client.token.TokenResponse;
import com.pixlog.client.userlogin.UserLogin;
import com.pixlog.client.userlogin.UserLoginResponse;
import com.pixlog.dao.User;
import com.pixlog.dao.UserDAO;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class LoginActivity
        extends AppCompatActivity
        implements UserLoginResponse, TokenResponse {

    private ConstraintLayout layout;
    private EditText et_username, et_userpassword;
    private Preferences preferences;
    private TextView txt_username,
            txt_userpassowrd,
            recover_username,
            recover_password,
            login,
            txt_createaccount,
            createAccount;
    private String username, password;
    private Translator translator = new Translator();
    private Others others = new Others();
    private ProgressBar progressBar;

    @Override
    protected void onStart() {
        super.onStart();
        checkAutLogin();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = new Preferences(getApplicationContext());
        
        setContentView(R.layout.activity_main);

        ImageView buttonPort = findViewById(R.id.buttonPort),
                buttonEng = findViewById(R.id.buttonEng),
                buttonEsp = findViewById(R.id.buttonEsp);

        login = findViewById(R.id.buttonLogin);

        txt_username = findViewById(R.id.txt_username);
        et_username = findViewById(R.id.et_username);
        recover_username = findViewById(R.id.recover_username);

        txt_userpassowrd = findViewById(R.id.txt_userpassword);
        et_userpassword = findViewById(R.id.et_password);
        recover_password = findViewById(R.id.recover_password);

        txt_createaccount = findViewById(R.id.txt_createaccount);
        createAccount = findViewById(R.id.create_account);

        layout = findViewById(R.id.loginLayout);
        progressBar = findViewById(R.id.loggingin);

        translator = others.setLang(preferences);
        setNames();
        
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

        final Drawable background1 = et_username.getBackground();
        et_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                username = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                et_username.setBackground(background1);
            }
        });

        final Drawable background2 = et_userpassword.getBackground();
        et_userpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                et_userpassword.setBackground(background2);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean item1 = false, item2 = false, item3 = false;

                if (null == et_username.getText()
                        || et_username.getText().toString().equals("")) {
                    et_username.setBackground(getResources().getDrawable(R.drawable.error_background));
                } else item1 = true;

                if (null == et_userpassword.getText()
                        || et_userpassword.getText().toString().equals("")) {
                    et_userpassword.setBackground(getResources().getDrawable(R.drawable.error_background));
                } else item2 = true;

                if (!others.isNetworkConnected(v.getContext())) {
                    others.showToast(v.getContext(),translator.NoInternet());
                }else item3 = true;

                if (item1 && item2 && item3) {
                    try{
                        JSONObject json = new JSONObject();
                        json.put("username", username);
                        json.put("password", password);

                        UserDAO userDAO = new UserDAO(getApplicationContext());
                        List<User> user = userDAO.get();
                        String accessToken = user.get(0).getAccessToken(),
                                tokenType = user.get(0).getTokenType(),
                                expiresAt = user.get(0).getExpiresAt();

                        progressBar.setVisibility(View.VISIBLE);
                        layout.setBackground(getResources().getDrawable(R.drawable.progress_on));

                        if (!accessToken.equals("")) {
                            if (others.checkTokenExpiration(expiresAt)) {
                                UserLogin userLogin = new UserLogin(json, accessToken, tokenType, expiresAt);
                                userLogin.delegate = LoginActivity.this;
                                userLogin.execute();

                                Log.i("Log in","Token is up to date, registering use");
                            } else {
                                Token token = new Token();
                                token.delegate = LoginActivity.this;
                                token.execute();

                                Log.e("Log in","Token is out of date , getting another one");
                            }
                        } else {
                            Token token = new Token();
                            token.delegate = LoginActivity.this;
                            token.execute();

                            Log.e("Log in","No token, getting other now");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),NewClientActivity.class));
            }
        });

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

    private void setNames() {
        txt_username.setText(translator.UserName().toUpperCase());
        et_username.setHint(translator.TypeUserName());
        recover_username.setText(translator.RecoverUsername()+"    ");

        txt_userpassowrd.setText(translator.Password().toUpperCase());
        et_userpassword.setHint(translator.TypePassword());
        recover_password.setText(translator.RecoverPassword()+"    ");

        login.setText(translator.login().toUpperCase());
        txt_createaccount.setText(translator.TxtCreateAccount()+"  ");
        createAccount.setText(translator.CreateAccount()+"  ");
    }

    private void checkAutLogin() {
        List<User> userList = new UserDAO(getApplicationContext()).get();

        String loginAut = userList.get(0).getLoginAut();
        if (loginAut.equals("true")){
            startActivity(new Intent(getApplicationContext(), MenuActivity.class));
            Log.i("Log in", "Automatic log in set as true");
        }else Log.i("Log in","Automatic log in still set as false");
    }

    @Override
    public void onTokenFinish(String output) {
        try {
            JSONObject json = new JSONObject(output);
            String token = json.get("access_token").toString(),
                    type = json.get("token_type").toString(),
                    expires = json.get("expires_at").toString();

            if (type.equals("Bearer")){

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("username", username);
                jsonObject.put("password", password);

                UserLogin userLogin = new UserLogin(jsonObject, token, type, expires);
                userLogin.delegate = LoginActivity.this;
                userLogin.execute();

                Log.i("Log in", "Token generated, registering user now");
            }
        } catch (JSONException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    layout.setBackground(null);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });
            others.showToast(getApplicationContext(),translator.LoginProblem());
            Log.e("Log in","Problem with returned JSON from Token class, "+e.getMessage());
        }
    }

    @Override
    public void onUserLoginFinish(String output) {
        layout.setBackground(null);
        progressBar.setVisibility(View.INVISIBLE);

        boolean success = false;
        JSONObject json, data = null;

        String[] out = output.split(";;");

        try {
            json = new JSONObject(out[0]);
            success = Boolean.parseBoolean(json.getString("success"));
            data = new JSONObject(json.getString("data"));
        } catch (JSONException e) {
            Log.e("Log in", "Error getting values of returned JSON, "+e.getMessage());
        }

        if (success){
            try {
                Log.i("Log in","Server response is ok, user uuid: "+data.getString("uuid"));

                User user = new User();
                user.setUuid(data.getString("uuid"));
                user.setName("Nicolas");
                user.setEmail(username);
                user.setPassword(password);
                user.setFv("1");
                user.setUd("cm");
                user.setUc("m");
                user.setUv("m³");
                user.setAccessToken(out[1]);
                user.setTokenType(out[2]);
                user.setExpiresAt(out[3]);
                user.setLoginAut("true"); //Define login automático

                UserDAO userDAO = new UserDAO(getApplicationContext());
                if (userDAO.get().get(0).getUuid().equals(""))
                    userDAO.add(user);
                else userDAO.update(user);

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);

                Log.i("Log in", "User has been successfully logged in");
            } catch (JSONException e) {
                Log.e("Log in","Error getting uuid of returned JSON, "+e.getMessage());
            }

        }else {
            others.showToast(getApplicationContext(),translator.LoginProblem());
            Log.e("Log in", "Problem logging user in, output: "+output);
        }
    }
}
