package com.pixlog.results;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.pixlog.MenuActivity;
import com.pixlog.Others;
import com.pixlog.Preferences;
import com.pixlog.R;
import com.pixlog.Translator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ResultsActivity
        extends AppCompatActivity {

    private FoldersAdapter foldersAdapter;
    private Integer lastPos;
    private ItemsAdapter itemsAdapter;
    private List<Folders> folders;
    private Others others = new Others();
    private RecyclerView recyclerItems, recyclerFolders;
    private Translator translator;
    private String zipToDelete = "";

    private static int ZIP_OK = 104;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);



        ImageView buttonBack = findViewById(R.id.buttonBackResults);
        recyclerFolders = findViewById(R.id.recyclerFolders);
        recyclerItems = findViewById(R.id.recyclerItems);
        final TextView itemsSelectAll = findViewById(R.id.itemsSelectAll),
                itemsExport = findViewById(R.id.itemsExport),
                reports = findViewById(R.id.reports);

        translator = others.setLang(new Preferences(getApplicationContext()));

        reports.setText(translator.Reports());

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                //Desliza para a esquerda
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });

        itemsSelectAll.setText(translator.SelectAll());
        itemsSelectAll.setPaintFlags(itemsSelectAll.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        final Integer[] allChecked = new Integer[]{0};

        itemsSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allChecked[0] == 0) {
                    itemsSelectAll.setText(translator.DeselectAll());
                    itemsAdapter.setCheck(true);
                    allChecked[0] = 1;
                } else {
                    itemsSelectAll.setText(translator.SelectAll());
                    itemsAdapter.setCheck(false);
                    allChecked[0] = 0;
                }
                itemsAdapter.notifyDataSetChanged();
            }
        });

        itemsExport.setText(translator.Export().toUpperCase());
        itemsExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Items[] itemsForExport = itemsAdapter.getItemsForExport();

                int notNull = 0;
                for (int i = 0; i < itemsForExport.length; i++)
                    if (itemsForExport[i] != null)
                        notNull += 1;

                if (notNull >= 1) {

                    LayoutInflater layoutInflater = LayoutInflater.from(ResultsActivity.this);
                    View promptsView = layoutInflater.inflate(R.layout.export, null);

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ResultsActivity.this, R.style.CustomAlertDialog);
                    alertDialogBuilder.setView(promptsView);

                    final AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.setCancelable(false);
                    alertDialog.show();

                    final ImageView exportPdf = promptsView.findViewById(R.id.exportPdf),
                            exportCsv = promptsView.findViewById(R.id.exportCsv),
                            exportImg = promptsView.findViewById(R.id.exportImg),
                            exportDet = promptsView.findViewById(R.id.exportDet);

                    TextView exportOk = promptsView.findViewById(R.id.exportOk),
                            exportCancel = promptsView.findViewById(R.id.exportCancel);

                    final Integer[] pdf_checked = new Integer[]{1},
                            csv_checked = new Integer[]{1},
                            img_checked = new Integer[]{1},
                            det_checked = new Integer[]{1};

                    exportPdf.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (pdf_checked[0] == 1){
                                pdf_checked[0] = 0;
                                exportPdf.setImageResource(R.drawable.ic_pdf_off);
                            } else {
                                pdf_checked[0] = 1;
                                exportPdf.setImageResource(R.drawable.ic_pdf_on);
                            }
                        }
                    });

                    exportCsv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (csv_checked[0] == 1){
                                csv_checked[0] = 0;
                                exportCsv.setImageResource(R.drawable.ic_csv_off);
                            } else {
                                csv_checked[0] = 1;
                                exportCsv.setImageResource(R.drawable.ic_csv_on);
                            }
                        }
                    });

                    exportImg.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (img_checked[0] == 1){
                                img_checked[0] = 0;
                                exportImg.setImageResource(R.drawable.ic_img_off);
                            } else {
                                img_checked[0] = 1;
                                exportImg.setImageResource(R.drawable.ic_img_on);
                            }
                        }
                    });

                    exportDet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (det_checked[0] == 1){
                                det_checked[0] = 0;
                                exportDet.setImageResource(R.drawable.ic_detect_off);
                            } else {
                                det_checked[0] = 1;
                                exportDet.setImageResource(R.drawable.ic_detect_on);
                            }
                        }
                    });

                    exportCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss();
                        }
                    });

                    exportOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss();
                            exportItems(itemsForExport,
                                    pdf_checked[0], csv_checked[0], img_checked[0], det_checked[0]);
                        }
                    });
                } else others.showToast(getApplicationContext(),translator.NothingToExport());
            }
        });

        RecyclerView.LayoutManager layoutManager;

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerFolders.setLayoutManager(layoutManager);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerItems.setLayoutManager(layoutManager);

        folders = others.setFolders(ResultsActivity.this);


        if (folders.size() > 0){
            lastPos = 0;

            foldersAdapter = new FoldersAdapter(folders, getApplicationContext());

            recyclerFolders.setAdapter(foldersAdapter);




            itemsAdapter = new ItemsAdapter(others.setItems(folders.get(lastPos).getFolder()),
                    foldersAdapter,
                    recyclerFolders,
                    ResultsActivity.this);
            recyclerItems.setAdapter(itemsAdapter);

            foldersAdapter.setPaintFirst(true);

            recyclerFolders.addOnItemTouchListener(
                    new RecyclerItemClickListener(
                            getApplicationContext(),
                            recyclerFolders,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    foldersAdapter.setPaintFirst(false);

                                    RecyclerView.ViewHolder viewOld = recyclerFolders.findViewHolderForAdapterPosition(lastPos),
                                            viewNew = recyclerFolders.findViewHolderForAdapterPosition(position);
                                    ConstraintLayout viewByIdOld = viewOld.itemView.findViewById(R.id.layoutSelected),
                                            viewByIdNew = viewNew.itemView.findViewById(R.id.layoutSelected);
                                    viewByIdOld.setBackground(null);
                                    viewByIdNew.setBackground(getResources().getDrawable(R.drawable.shadowselected));
                                    lastPos = position;

                                    if (!itemsAdapter.getMovingItem()) {
                                        itemsAdapter = new ItemsAdapter(
                                                others.setItems(others.setFolders(ResultsActivity.this).get(position).getFolder()),
                                                foldersAdapter,
                                                recyclerFolders,
                                                ResultsActivity.this);
                                        recyclerItems.setAdapter(itemsAdapter);
                                    } else {
                                        TextView viewById = viewNew.itemView.findViewById(R.id.jobName);
                                        String newDir = viewById.getText().toString(),
                                                oldDir = itemsAdapter.getOldDir();

                                        if (oldDir.split("/")[8].equals(newDir))
                                            others.showToast(getApplicationContext(),translator.ChooseAnotherFOlder());
                                        else {
                                            File[] files = (new File(oldDir)).listFiles();
                                            String[] split = files[0].toString().split("/");
                                            String base = "/" + split[1] + "/" + split[2] + "/" + split[3] + "/" + split[4] + "/" + split[5] + "/" + split[6] + "/" + split[7];
                                            boolean mkdir = new File(base + "/" + newDir + "/" + split[9]).mkdir();
                                            if (mkdir){
                                                for (int i = 0; i < files.length; i++){
                                                    String[] s = files[i].toString().split("/");
                                                    String oldOne = base+"/"+s[8]+"/"+s[9]+"/"+s[10],
                                                            newOne = base+"/"+newDir+"/"+s[9]+"/"+s[10];
                                                    (new File(oldOne)).renameTo(new File(newOne));
                                                }
                                            } else others.showToast(getApplicationContext(),translator.NotMoved());

                                            (new File(base+"/"+split[8]+"/"+split[9])).delete();

                                            foldersAdapter.notifyDataSetChanged();
                                            itemsAdapter = new ItemsAdapter(
                                                    others.setItems(others.setFolders(ResultsActivity.this).get(position).getFolder()),
                                                    foldersAdapter,
                                                    recyclerFolders,
                                                    ResultsActivity.this);
                                            recyclerItems.setAdapter(itemsAdapter);

                                            others.showToast(getApplicationContext(),translator.SuccessfullyMoved());
                                        }
                                    }
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    final int[] pos = new int[1];
                                    pos[0] = position;
                                    final PopupMenu popupMenu = new PopupMenu(view.getContext(),view);
                                    popupMenu.inflate(R.menu.popup_itemleft);

                                    Menu menu = popupMenu.getMenu();
                                    menu.getItem(0).setTitle(translator.Rename());
                                    menu.getItem(1).setTitle(translator.Delete());

                                    popupMenu.show();
                                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem item) {
                                            switch (item.getItemId()){
                                                case R.id.leftRename:
                                                    popupMenu.dismiss();
                                                    renameJob(pos[0]);
                                                    break;
                                                case R.id.leftExclude:
                                                    popupMenu.dismiss();
                                                    AlertDialog.Builder builder = new AlertDialog.Builder(ResultsActivity.this);
                                                    builder.setMessage(translator.AreYouSure())
                                                            .setPositiveButton(translator.Yes(), new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    boolean deleted = excludeJob(new File(folders.get(pos[0]).getFolder()));
                                                                    if (deleted){
                                                                        List<Folders> folders = others.setFolders(ResultsActivity.this);
                                                                        foldersAdapter = new FoldersAdapter(folders, ResultsActivity.this);
                                                                        recyclerFolders.setAdapter(foldersAdapter);

                                                                        others.showToast(getApplicationContext(),translator.SuccessfullyDeleted());
                                                                    } else others.showToast(getApplicationContext(),translator.NotDeleted());
                                                                }
                                                            })
                                                            .setNegativeButton(translator.No(), new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    dialog.cancel();
                                                                }
                                                            })
                                                            .show();
                                                    break;
                                            }
                                            return false;
                                        }
                                    });
                                }

                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                }
                            }
                    )
            );
        } else others.showToast(getApplicationContext(),translator.NoResultsYet());
    }

    private void exportItems(Items[] export, Integer pdf, Integer csv, Integer img, Integer det) {

        String[] zipSubFolders = new String[export.length];
        String[] s = export[0].getItemName().split("/");
        String base = "/"+s[1]+"/"+s[2]+"/"+s[3]+"/"+s[4]+"/"+s[5]+"/"+s[6]+"/"+s[7]+"/"+s[8];
        String zipFolder = base+".zip";

        for (int a = 0; a < export.length; a++){
            String itemName = export[a].getItemName();
            String[] ss = itemName.split("/");
            String subbase = "/"+ss[1]+"/"+ss[2]+"/"+ss[3]+"/"+ss[4]+"/"+ss[5]+"/"+ss[6]+"/"+ss[7]+"/"+ss[8]+"/"+ss[9];
            zipSubFolders[a] = subbase+".zip";

            File[] files = (new File(itemName)).listFiles();
            String[] subItems = new String[files.length];
            for (int b = 0; b < files.length; b++){
                String item = files[b].toString();
                switch (item.substring(item.length()-4)){
                    case ".pdf":
                        if (pdf == 1) subItems[b] = item;
                        break;
                    case ".csv":
                        if (csv == 1) subItems[b] = item;
                        break;
                    case ".jpg":
                        if (item.substring(item.length()-6).equals("dt.jpg")) {
                            if (img == 1) subItems[b] = item;
                        } else {
                            if (det == 1) subItems[b] = item;
                        }
                        break;
                }
            }
            zip(subItems, zipSubFolders[a]);
        }
        zip(zipSubFolders,zipFolder);
        deleteZipped(zipSubFolders);
        try{
            sendZipFile(zipFolder);
            zipToDelete = zipFolder;
        } catch (Exception e) {
            others.showToast(getApplicationContext(),translator.NotExported());
        }
    }

    private void renameJob(int position) {
        RecyclerView.ViewHolder viewHolderForAdapterPosition = recyclerFolders.findViewHolderForAdapterPosition(position);
        TextView jobName = viewHolderForAdapterPosition.itemView.findViewById(R.id.jobName);

        final File oldJob = new File(getExternalFilesDir(null)+"/"+jobName.getText().toString());

        LayoutInflater layoutInflater = LayoutInflater.from(ResultsActivity.this);
        View promptsView = layoutInflater.inflate(R.layout.newname, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ResultsActivity.this);
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
                    File newJob = new File(getExternalFilesDir(null)+"/"+newJobNameType.getText().toString());
                    boolean success = oldJob.renameTo(newJob);
                    alertDialog.dismiss();
                    if (success) {
                        others.showToast(getApplicationContext(),translator.SuccessfullyRenamed());

                        folders = others.setFolders(ResultsActivity.this);
                        List<Items> itemsList = others.setItems(folders.get(lastPos).getFolder());
                        foldersAdapter = new FoldersAdapter(folders, getApplicationContext());
                        recyclerFolders.setAdapter(foldersAdapter);
                    } else others.showToast(getApplicationContext(),translator.NotRenamed());
                }
            }
        });

        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, translator.Cancel(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

    private boolean excludeJob(File path) {
        if(path.exists()) {
            File[] files = path.listFiles();
            if (files == null) {
                return false;
            }
            for (File file : files) {
                if (file.isDirectory()) {
                    excludeJob(file);
                } else {
                    boolean wasSuccessful = file.delete();
                    if (wasSuccessful) {
                        Log.i("Deleted ", "successfully");
                    }
                }
            }
        }
        return(path.delete());
    }

    private void zip(String[] _files, String zipFileName) {
        final int BUFFER = 2048;
        try {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(zipFileName);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            byte data[] = new byte[BUFFER];

            for (int i = 0; i < _files.length; i++) {

                if (null != _files[i]){
                    Log.v("Compress", "Adding: " + _files[i]);
                    FileInputStream fi = new FileInputStream(_files[i]);
                    origin = new BufferedInputStream(fi, BUFFER);

                    ZipEntry entry = new ZipEntry(_files[i]
                            .substring(_files[i].lastIndexOf("/") + 1));
                    out.putNextEntry(entry);

                    int count;
                    while ((count = origin.read(data, 0, BUFFER)) != -1) {
                        out.write(data, 0, count);
                    }
                }
                origin.close();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteZipped(String[] zipped) {
        for (int i = 0; i < zipped.length; i++){
            File file = new File(zipped[i]);
            file.delete();
        }
    }

    private void sendZipFile(String zip) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(zip));
        sendIntent.setType("application/zip");
        startActivityForResult(sendIntent, ZIP_OK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ZIP_OK) deleteZipped(new String[]{zipToDelete});
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
