package com.pixlog.client.userlogin;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserLogin
        extends AsyncTask<Void,Void,String> {

    public UserLoginResponse delegate = null;

    private JSONObject json;
    private String token, type, expires;

    public UserLogin(JSONObject json, String token, String type, String expires) {
        this.json = json;
        this.token = token;
        this.type = type;
        this.expires = expires;
    }

    @Override
    protected String doInBackground(Void... voids) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json.toString());
        Request request = new Request.Builder()
                .url("https://dev.pixlog.com.br/api/customers/login")
                .method("POST", body)
                .addHeader("Authorization", "Bearer "+token)
                .addHeader("Content-Type", "application/json")
                .build();

        String retorno = "";
        Response response;
        try {
            response = client.newCall(request).execute();
            retorno = response.body().string();
        } catch (IOException e) {
            Log.e("Log In","Problem with user log in, "+e.getMessage());
        }

        return retorno;
    }

    @Override
    protected void onPostExecute(String s) {
        String output = s+";;"+token+";;"+type+";;"+expires;
        delegate.onUserLoginFinish(output);
    }

}
