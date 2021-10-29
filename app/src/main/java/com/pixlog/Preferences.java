package com.pixlog;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String FILE_NAME = "user.preferences";
    private final String KEY_LOGIN_LANG = "idiomaLogin";
    private final String KEY_SETTINGS_LANG = "idiomaConfig";

    public Preferences() {

    }

    public Preferences(Context context) {
        preferences = context.getSharedPreferences(FILE_NAME,0);
        editor = preferences.edit();
    }

    public void setLoginLang(Integer idiomaLogin){
        editor.putString(KEY_LOGIN_LANG,idiomaLogin.toString());
        editor.commit();
    }

    public String getLoginLang(){
        return preferences.getString(KEY_LOGIN_LANG,null);
    }

    public void setSettingsLang(Integer idiomaConfig){
        editor.putString(KEY_SETTINGS_LANG,idiomaConfig.toString());
        editor.commit();
    }

    public String getSettingsLang(){
        return preferences.getString(KEY_SETTINGS_LANG,null);
    }

}
