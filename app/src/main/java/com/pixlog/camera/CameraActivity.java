package com.pixlog.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pixlog.MenuActivity;
import com.pixlog.Others;
import com.pixlog.Preferences;
import com.pixlog.R;
import com.pixlog.Translator;
import com.pixlog.results.Folders;
import com.pixlog.results.FoldersAdapter;
import com.pixlog.results.RecyclerItemClickListener;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class CameraActivity
        extends AppCompatActivity {

    private List<Folders> folders;
    private List<Folders> foldersFiles;
    private Others others = new Others();
    private Translator translator;
    private Boolean comecou = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_camera);

        translator = others.setLang(new Preferences(getApplicationContext()));

        LayoutInflater layoutInflater = LayoutInflater.from(CameraActivity.this);
        View promptsView = layoutInflater.inflate(R.layout.chooseone, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CameraActivity.this, R.style.CustomAlertDialog);
        alertDialogBuilder.setView(promptsView);

        alertDialogBuilder.setNegativeButton(translator.backDialog(), (dialog, id) -> CameraActivity.super.onBackPressed());

        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);


        //folders = others.setMedia(); // Primeira inicialização não cria a pasta



        folders = others.setFolders(getApplicationContext());



        if (folders.size() > 0) {

            TextView jobChoose = promptsView.findViewById(R.id.jobChoose),
                    jobCreateNew = promptsView.findViewById(R.id.jobCreateNew);

            jobChoose.setText(translator.PlaceToSave().toUpperCase());
            jobCreateNew.setText(translator.NewPlace().toUpperCase());
            FoldersAdapter foldersAdapter = new FoldersAdapter(folders, getApplicationContext());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            RecyclerView recyclerCurrentJobs = promptsView.findViewById(R.id.recyclerCurrentJobs);
            recyclerCurrentJobs.setLayoutManager(layoutManager);
            recyclerCurrentJobs.setAdapter(foldersAdapter);

            recyclerCurrentJobs.addOnItemTouchListener(
                    new RecyclerItemClickListener(
                            getApplicationContext(),
                            recyclerCurrentJobs,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    alertDialog.dismiss();
                                    String foldersName = folders.get(position).getFolder();
                                    File f = new File(foldersName);
                                    int num = f.listFiles().length+1;
                                    go2CameraX(foldersName.split("/")[8]+"/"+translator.Pile()+" "+num);
                                    //go2CameraX(foldersName.split("/")[8]);
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {

                                }

                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                }
                            }));

            ImageView jobNew = promptsView.findViewById(R.id.jobNew);
            jobNew.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    inflateNewJobCreator();
                    alertDialog.dismiss();

                }
            });

            alertDialog.show();


        } else inflateNewJobCreator();
    }

    private void inflateNewJobCreator() {
        LayoutInflater layoutInflater = LayoutInflater.from(CameraActivity.this);
        View promptsView = layoutInflater.inflate(R.layout.newname, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CameraActivity.this, R.style.CustomAlertDialog);
        alertDialogBuilder.setView(promptsView);

        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);

        TextView newJobName = promptsView.findViewById(R.id.newJobName);
        newJobName.setText(translator.FillNewName());

        final EditText newJobNameType = promptsView.findViewById(R.id.newJobNameType);

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!newJobNameType.getText().toString().equals("")){

                    File pasta = new File(getExternalFilesDir(null) + "/" + newJobNameType.getText().toString());
                    //File pasta = new File("/storage/emulated/0/Android/media/com.pixlog/" + "/" + newJobNameType.getText().toString());
                    if(pasta.exists()) {
                        others.showToast(getApplicationContext(),translator.FolderAlreadyExists());
                        inflateNewJobCreator();
                    } else {

                        if (!comecou) {

                            if (!pasta.exists()) {
                                pasta.mkdirs();
                            }
                            comecou = true;
                        }

                        alertDialog.dismiss();
                        go2CameraX(newJobNameType.getText().toString()+"/"+translator.Pile()+" 1");
                        //go2CameraX(newJobNameType.getText().toString());
                    }

                } else {
                    others.showToast(getApplicationContext(),translator.FillNewName());
                    inflateNewJobCreator();

                }
            }
        });

        alertDialog.show();
    }


    private void go2CameraX(String foldersName) {
        Intent intent = new Intent(getApplicationContext(), XCamera.class);
        intent.putExtra("folder", foldersName);
        startActivity(intent);

    }


    public void back2menu(){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        back2menu();
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


}
