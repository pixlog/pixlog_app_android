package com.pixlog.results;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.pixlog.R;
import com.pixlog.dao.UserDAO;
import com.pixlog.detect.Calculos;

import java.io.File;
import java.util.List;

public class FoldersAdapter
        extends RecyclerView.Adapter<FoldersAdapter.MyViewHolder> {

    private Boolean paintFirst = false;
    private Calculos calculos = new Calculos();
    private Context context;
    private List<Folders> foldersList;

    public FoldersAdapter(List<Folders> foldersList, Context context) {
        this.foldersList = foldersList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_folders, parent, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        Folders folder = foldersList.get(position);

        if (position == 0 && paintFirst)
            holder.layout.setBackground(context.getResources().getDrawable(R.drawable.shadowselected));

        String[] split = folder.getFolder().split("/");


        holder.jobName.setText(split[8]);


        UserDAO userDAO = new UserDAO(context);
        String uv = userDAO.get().get(0).getUv();

        double volume = 0.0;
        File file = new File(folder.getFolder());
        File[] piles = file.listFiles();
        if (piles != null && piles.length > 0){
            for (int a = 0; a < piles.length; a++){
                File[] files = piles[a].listFiles();

                if (files != null && files.length > 0){
                    for (int b = 0; b < files.length; b++){
                        String s = files[b].toString();

                        if (s.substring(s.length()-4).equals(".csv")){
                            String[] volumeFromCSV = calculos.getVolumeFromCSV(s);

                            if (volumeFromCSV[1].equals(uv)) volume += Double.parseDouble(volumeFromCSV[0]);
                            else {
                                if (uv.equals("ft³"))
                                    volume += calculos.m32ft3(Double.parseDouble(volumeFromCSV[0]));
                                else volume += calculos.ft32m3(Double.parseDouble(volumeFromCSV[0]));
                            }
                        }
                    }
                }
            }
            String vol = calculos.round(volume,2)+" "+uv;
            holder.jobVolume.setText(vol);
        }

        Folders folders = foldersList.get(position);
        File[] f = (new File(folders.getFolder())).listFiles();
        if (f != null && f.length > 0){
            File[] files = f[f.length-1].listFiles();
            String name = "";
            if (files != null && files.length > 0){
                for (int i = 0; i < files.length; i++){
                    String s = files[i].toString();
                    if (s.substring(s.length()-4).equals(".pdf")){
                        name = files[i].toString();
                        break;
                    }
                }
                String itemString = name.substring(name.length() - 19), // -19??
                        date = itemString.substring(0,4)+"/"+itemString.substring(4,6)+"/"+itemString.substring(6,8),
                        hour = itemString.substring(9,11)+":"+itemString.substring(11,13);

                holder.lastJobDate.setText(date);
                holder.lastJobHour.setText(hour);
            }
        } else {
            holder.jobVolume.setText("");
            holder.lastJobDate.setText("");
            holder.lastJobHour.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return foldersList.size();
    }

    public void setPaintFirst(boolean paintFirst) {
        this.paintFirst = paintFirst;
    }

    public class MyViewHolder
            extends RecyclerView.ViewHolder{

        ConstraintLayout layout;
        ImageView jobIcon;
        TextView jobName, jobVolume, lastJobDate, lastJobHour;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layoutSelected);
            jobIcon = itemView.findViewById(R.id.jobIcon);
            jobName = itemView.findViewById(R.id.jobName);
            jobVolume = itemView.findViewById(R.id.jobVolume);
            lastJobDate = itemView.findViewById(R.id.lastJobDate);
            lastJobHour = itemView.findViewById(R.id.lastJobHour);
        }
    }



}
