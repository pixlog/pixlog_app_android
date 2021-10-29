package com.pixlog.detect.csv;

import android.os.AsyncTask;

import com.pixlog.Translator;
import com.pixlog.detect.Calculos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSV
        extends AsyncTask<Void,Void,String> {

    public CSVresponse delegate = null;

    private Translator idioma;
    private Calculos calculos;
    private String csvName;
    private String[] unidadesPadrao;
    private double fatorPixels;
    private ArrayList<Double> r, volume;

    public CSV(Translator idioma, Calculos calculos,
               String csvName,
               String[] unidadesPadrao,
               double fatorPixels,
               ArrayList<Double> r,
               ArrayList<Double> volume) {

        this.idioma = idioma;
        this.calculos = calculos;
        this.csvName = csvName;
        this.unidadesPadrao = unidadesPadrao;
        this.fatorPixels = fatorPixels;
        this.r = r;
        this.volume = volume;
    }

    @Override
    protected String doInBackground(Void... voids) {

        String status = "";

        try{
            FileWriter csvWriter = new FileWriter(csvName);

            String column1 = "ID";
            csvWriter.append(column1);
            csvWriter.append(",");

            String column2 = idioma.DIB()+"_"+unidadesPadrao[0];
            csvWriter.append(column2);
            csvWriter.append(",");

            String column3 = idioma.Volume()+"_"+unidadesPadrao[2];
            csvWriter.append(column3);

            csvWriter.append("\n");

            for (int i = 0; i < r.size(); i++){
                csvWriter.append(String.valueOf(i));
                csvWriter.append(",");

                if (unidadesPadrao[0].equals("cm"))
                    csvWriter.append(String.valueOf(calculos.round(calculos.pixels2cm(r.get(i),fatorPixels),2)));
                else if (unidadesPadrao[0].equals("in"))
                    csvWriter.append(String.valueOf(calculos.round(calculos.pixels2pol(r.get(i),fatorPixels),2)));

                csvWriter.append(",");
                csvWriter.append(String.valueOf(calculos.round(volume.get(i),2)));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

            status = "success";

        } catch (IOException e) { status = "error: "+e.getMessage(); }

        return status;
    }

    @Override
    protected void onPostExecute(String s) {
        delegate.onCSVfinish(s);
    }

}
