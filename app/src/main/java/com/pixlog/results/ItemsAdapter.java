package com.pixlog.results;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pixlog.Others;
import com.pixlog.Preferences;
import com.pixlog.R;
import com.pixlog.Translator;
import com.pixlog.detect.Calculos;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

public class ItemsAdapter
        extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {

    private Boolean movingItem = false;
    private Calculos calculos = new Calculos();
    private Context context;
    private FoldersAdapter foldersAdapter;
    private List<Items> itemsList;
    private Translator translator;
    private boolean check = false;
    private Others others = new Others();
    private RecyclerView recyclerFolders;
    private String oldDir = "";
    private Items[] itemsForExport;

    public ItemsAdapter(List<Items> itemsList, FoldersAdapter foldersAdapter, RecyclerView recyclerFolders, Context context) {
        this.itemsList = itemsList;
        this.context = context;
        this.foldersAdapter = foldersAdapter;
        this.recyclerFolders = recyclerFolders;

        translator = others.setLang(new Preferences(context));
        itemsForExport = new Items[itemsList.size()];
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        final Items items = itemsList.get(position);

        holder.cb_item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) itemsForExport[position] = items;
                else itemsForExport[position] = null;
            }
        });

        String pileFolder = items.getItemName().split("/")[9];
        holder.item_name.setText(pileFolder);

        File f = new File(items.getItemName());
        File[] files = f.listFiles();
        String pdfName = "", csvName = "", img = "";



        if (files != null && files.length > 0){
            for (int i = 0; i < files.length; i++) {
                String s = files[i].toString();
                if (s.contains(".pdf")) pdfName = s;
                else if (s.contains("dt.jpg")) img = s;
                else if (s.contains(".csv")) csvName = s;
            }
        }

        Log.d("filess","filess"+ pdfName);
        Log.d("filess","filess"+ csvName);
        Log.d("filess","filess"+ img);

        if (!pdfName.equals("")) {
            String itemString = pdfName.substring(pdfName.length()-19),
                    date = itemString.substring(0,4)+"/"+itemString.substring(4,6)+"/"+itemString.substring(6,8),
                    hour = itemString.substring(9,11)+":"+itemString.substring(11,13);

            holder.item_date.setText(date);
            holder.item_hour.setText(hour);
        } else {
            holder.item_date.setText("");
            holder.item_hour.setText("");
        }

        if (!csvName.equals("")){
            String[] volumeFromCSV = calculos.getVolumeFromCSV(csvName);
            String vol = volumeFromCSV[0]+" "+volumeFromCSV[1];

            holder.item_volume.setText(vol);
        } else holder.item_volume.setText("");

        if (!img.equals("")) {
            holder.item_icon.setImageBitmap(BitmapFactory.decodeFile(img));
        } else holder.item_icon.setImageBitmap(null);

        final String finalPdfName = pdfName;
        holder.item_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!finalPdfName.equals("")) openPDF(v, finalPdfName);
                else others.showToast(v.getContext(),translator.NoPDF());
            }
        });

        holder.item_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File[] inFiles = new File(items.getItemName()).listFiles();
                if (inFiles != null && inFiles.length > 0) {
                    PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
                    popupMenu.inflate(R.menu.popup_itemright);

                    Menu menu = popupMenu.getMenu();
                    menu.getItem(0).setTitle(translator.Rename());
                    MenuItem menuItem = menu.getItem(1);
                    if (!movingItem) menuItem.setTitle(translator.Move());
                    else menuItem.setTitle(translator.Cancel());
                    menu.getItem(2).setTitle(translator.Delete());

                    popupMenu.show();
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.itemRename:
                                    renameItem(items, position);
                                    break;
                                case R.id.itemMove:
                                    if (!movingItem) moveItem(items, position);
                                    else {
                                        movingItem = false;
                                        others.showToast(context,translator.NotMoved());
                                    }
                                    break;
                                case R.id.itemExclude:
                                    deleteItem(items, position);
                                    break;
                            }
                            return false;
                        }
                    });
                } else others.showToast(context, translator.EmptyFolder());
            }
        });

        holder.cb_item.setChecked(check);
    }

    private void renameItem(final Items items, final int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promptsView = layoutInflater.inflate(R.layout.newname, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(promptsView);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);

        TextView newJobName = promptsView.findViewById(R.id.newJobName);
        newJobName.setText(translator.FillNewName());

        final EditText newJobNameType = promptsView.findViewById(R.id.newJobNameType);

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = newJobNameType.getText().toString();
                if (!name.equals("")){
                    if (!name.contains("/")){
                        String[] s = items.getItemName().split("/");
                        String base = "/"+s[1]+"/"+s[2]+"/"+s[3]+"/"+s[4]+"/"+s[5]+"/"+s[6]+"/"+s[7]+"/"+s[8];

                        File oldName = new File(base+"/"+s[9]),
                                newName = new File(base+"/"+name);

                        boolean success = oldName.renameTo(newName);
                        dialog.cancel();
                        if (success) {
                            others.showToast(context,translator.SuccessfullyRenamed());

                            itemsList.set(position,new Items(newName.toString()));
                            notifyDataSetChanged();
                        } else others.showToast(context,translator.NotRenamed());
                    } else others.showToast(context,translator.InvalidCharacters());
                }
            }
        });

        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, translator.Cancel(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();
    }

    private void moveItem(final Items items, final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(translator.MoveItem())
                .setPositiveButton(translator.ExistingOne(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        others.showToast(context,translator.ChooseNewFolder());
                        movingItem = true;
                        oldDir = itemsList.get(position).getItemName();
                    }
                })
                .setNegativeButton(translator.CreateNew(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        createDirToMoveItem(items, position);
                    }
                })
                .show();
    }

    public Boolean getMovingItem() {
        return movingItem;
    }

    public String getOldDir() {
        return oldDir;
    }

    private void createDirToMoveItem(final Items items, int position){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promptsView = layoutInflater.inflate(R.layout.newname, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
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
                    File f = new File(context.getExternalFilesDir(null)+"/"+newJobNameType.getText().toString());

                    if (f.exists()) others.showToast(context,translator.AlreadyExists());
                    else {
                        File fs = new File(items.getItemName());
                        File[] files = fs.listFiles();
                        File fInside = new File(f.toString()+"/"+files[0].toString().split("/")[9]);

                        boolean mkdirs = fInside.mkdirs();
                        if (mkdirs) {
                            List<Folders> folders = others.setFolders(context);
                            foldersAdapter = new FoldersAdapter(folders, context);
                            recyclerFolders.setAdapter(foldersAdapter);

                            for (int i = 0; i < files.length; i++){
                                File oldName = new File(fs.toString()+"/"+files[i].toString().split("/")[10]);
                                File newName = new File(fInside.toString()+"/"+files[i].toString().split("/")[10]);

                                boolean success = oldName.renameTo(newName);
                                if (success) {
                                    boolean deleted = fs.delete();
                                    if (deleted) {
                                        foldersAdapter.notifyDataSetChanged();
                                        others.showToast(context,translator.SuccessfullyMoved());
                                    } else others.showToast(context,translator.NotMoved());
                                } else others.showToast(context,translator.NotMoved());
                            }
                        }
                    }
                }
            }
        });

        alertDialog.show();
    }

    private void deleteItem(final Items items, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(translator.AreYouSure())
                .setPositiveButton(translator.Yes(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                        File f = new File(items.getItemName());
                        boolean deleted = deleteDir(f);

                        if (deleted) {
                            others.showToast(context,translator.SuccessfullyDeleted());

                            itemsList.remove(position);
                            notifyDataSetChanged();
                            foldersAdapter.notifyDataSetChanged();
                        }
                        else others.showToast(context,translator.NotDeleted());
                    }
                })
                .setNegativeButton(translator.No(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    private boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class MyViewHolder
            extends RecyclerView.ViewHolder{

        CheckBox cb_item;
        TextView item_name, item_hour, item_date, item_volume;
        ImageView item_icon, item_options;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cb_item = itemView.findViewById(R.id.cb_item);
            item_name = itemView.findViewById(R.id.itemName);
            item_hour = itemView.findViewById(R.id.itemHour);
            item_date = itemView.findViewById(R.id.itemDate);
            item_volume = itemView.findViewById(R.id.itemVolume);
            item_icon = itemView.findViewById(R.id.itemIcon);
            item_options = itemView.findViewById(R.id.itemOptions);
        }
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public Items[] getItemsForExport() {
        return itemsForExport;
    }

    private void openPDF(View view, String nomePDF){
        try{
            Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
            m.invoke(null);
            Intent pdfViewIntent = new Intent(Intent.ACTION_VIEW);
            pdfViewIntent.setDataAndType(Uri.fromFile(new File(nomePDF)),"application/pdf");
            pdfViewIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            Intent intent = Intent.createChooser(pdfViewIntent, translator.OpenPDF());

            try {
                view.getContext().startActivity(intent);
            } catch (ActivityNotFoundException e) {
                others.showToast(context,translator.NoPDFviewer());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
