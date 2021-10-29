package com.pixlog.client.token;

import android.os.AsyncTask;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Token
        extends AsyncTask<Void, Void, String> {

    public TokenResponse delegate = null;

    @Override
    protected String doInBackground(Void... params) {

        OkHttpClient client = new OkHttpClient();

        JSONObject json = new JSONObject();
        try{
            json.put("username", "app");
            json.put("password", "4Dj09q9M");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Configura tipo o arquivo e o tipo
        MediaType JSON = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(json.toString(), JSON);

        //Configura envio de dados ao servidor
        Request request = new Request.Builder()
                .url("https://dev.pixlog.com.br/api/auth/login")
                .header("Content-Type", "application/json")
                .header("X-Requested-With", "XMLHttpRequest")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                delegate.onTokenFinish(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()){
                    delegate.onTokenFinish(response.body().string());
                    Log.i("Token","it has been successfully generated");
                }
            }
        });

        return null;
    }
}
