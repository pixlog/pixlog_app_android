package com.pixlog;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import com.pixlog.results.Folders;
import com.pixlog.results.Items;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Others {

    public Others() {

    }

    public boolean checkTokenExpiration(String expiresAt) {
        boolean isValid = false;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date expiration = sdf.parse(expiresAt);
            String datehour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                    Locale.getDefault()).format(new Date());
            Date current = sdf.parse(datehour);

            if (!current.after(expiration)) isValid = true;
        } catch (ParseException e) {
            Log.e("Validation","Problem parsing date from string, "+e.getMessage());
        }

        return isValid;
    }

    public Translator setLang(Preferences preferences) {
        Translator translator = new Translator();

        String idConfig = preferences.getSettingsLang(),
                idLogin = preferences.getLoginLang();
        if (null != idConfig) translator.setLanguage(Integer.parseInt(idConfig));
        else if (null != idLogin) translator.setLanguage(Integer.parseInt(idLogin));
        else translator.setLanguage(0);

        return translator;
    }

    public void showToast(Context context, String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(Context context, String text){
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }

    public boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected());
    }

    public String getFvName(Translator translator, Integer fv) {
        String formula = "";

        if (fv == 1) formula = translator.VolumeFormula01();
        else if (fv == 2) formula = translator.VolumeFormula02();
        else if (fv == 3) formula = translator.VolumeFormula03();
        else if (fv == 4) formula = translator.VolumeFormula04();
        else if (fv == 5) formula = translator.VolumeFormula05();
        else if (fv == 6) formula = translator.VolumeFormula06();
        else if (fv == 7) formula = translator.VolumeFormula07();
        else if (fv == 8) formula = translator.VolumeFormula08();
        else if (fv == 9) formula = translator.VolumeFormula09();
        else if (fv == 10) formula = translator.VolumeFormula10();
        else if (fv == 11) formula = translator.VolumeFormula11();
        else if (fv == 12) formula = translator.VolumeFormula12();
        else if (fv == 13) formula = translator.VolumeFormula13();
        else if (fv == 14) formula = translator.VolumeFormula14();
        else if (fv == 15) formula = translator.VolumeFormula15();

        return formula;
    }

    public List<Folders> setFolders(Context context) {
        List<Folders> foldersList = new ArrayList<>();

        File f = new File(String.valueOf(context.getExternalFilesDir(null)));
        Log.d("verificar_pasta","pasta"+ f);
        File[] files = f.listFiles();
        Log.d("verificar_pasta","pasta"+ files);
        for (File file : files)
            if (file.isDirectory()){
                Folders folders = new Folders(file.toString());
                foldersList.add(folders);
            }

        return foldersList;
    }

    public List<Folders> setMedia() {
        List<Folders> foldersList = new ArrayList<>();

        File f = new File("/storage/emulated/0/Android/media/com.pixlog");

        if (!f.exists()) {
            f.mkdirs();
        }

        File[] files = f.listFiles();
        for (File file : files)
            if (file.isDirectory()){
                Folders folders = new Folders(file.toString());
                foldersList.add(folders);
            }

        return foldersList;
    }



    public List<Items> setItems(String folder) {
        List<Items> itemsList = new ArrayList<>();

        File f = new File(folder);
        File[] files = f.listFiles();
        for (File file : files) {
            itemsList.add(new Items(file.toString()));
        }

        return itemsList;
    }

    public Animation getBlinkAnim(){
        Animation animation = new AlphaAnimation(1,0);
        animation.setDuration(1000); //1 second duration for each animation cycle
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE); //repeating indefinitely
        animation.setRepeatMode(Animation.REVERSE); //animation will start from end point once ended.
        return animation;
    }
}
