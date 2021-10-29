package com.pixlog.detect.report;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.debenu.pdflibrary.DebenuPDFLibraryCPAndroidJava1711;

import com.pixlog.Translator;
import com.pixlog.dao.User;
import com.pixlog.detect.Calculos;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Report
        extends AsyncTask<Void, Void, String> {

    public ReportResponse delegate = null;

    private ArrayList<String> species;
    private ArrayList<Double> diameters, volumes;
    private Calculos calculos = new Calculos();
    private DebenuPDFLibraryCPAndroidJava1711 mDQPL;
    private Double pixelsConv, logsLength, spatialRef;
    private double[] coordinates;
    private Integer formulaVolume;
    private String reportName, img_dt_nome, destination;
    private String[] dataHora, units;
    private Translator translator;
    private User user;

    public Report(Translator translator,
                  String[] dataHora,
                  double[] coordinates,
                  Double pixelsConv,
                  String[] units,
                  DebenuPDFLibraryCPAndroidJava1711 mDQPL,
                  String reportName,
                  String img_dt_nome,
                  ArrayList<Double> diametro_calc,
                  ArrayList<Double> volume_calc,
                  Integer formulaVolume,
                  Double logsLength,
                  ArrayList<String> species,
                  String destination,
                  Double spatialRef,
                  User user) {

        this.translator = translator;
        this.dataHora = dataHora;
        this.coordinates = coordinates;
        this.pixelsConv = pixelsConv;
        this.units = units;
        this.mDQPL = mDQPL;
        this.reportName = reportName;
        this.img_dt_nome = img_dt_nome;
        this.diameters = diametro_calc;
        this.volumes = volume_calc;
        this.formulaVolume = formulaVolume;
        this.logsLength = logsLength;
        this.species = species;
        this.destination = destination;
        this.spatialRef = spatialRef;
        this.user = user;

        calculos.setLoglength(logsLength);
//        calculos.setDiametros(diameters);

        ArrayList<Double> newDiametro = new ArrayList<>();
        for (int i = 0; i < diameters.size(); i++){
            newDiametro.add(diameters.get(i)/100);
        }

        calculos.setDiametros(calculos.diametros2cm(newDiametro, pixelsConv));
        calculos.setVolumes(volumes);
    }

    @Override
    protected String doInBackground(Void... voids) {

        //Define como milímetros
        mDQPL.SetMeasurementUnits(1);

        /*
        FONTES
         */
        mDQPL.SetHTMLNormalFont("Default", mDQPL.AddTrueTypeFont("Arial", 0));
        mDQPL.SetHTMLBoldFont("Default", mDQPL.AddTrueTypeFont("Arial [Bold]", 0));

        /*
        ADICIONANDO O TÍTULO
         */
        mDQPL.SetOrigin(1);
        mDQPL.SetTextSize(16); //tamanho da letra
        mDQPL.SetTextColor(0.55,0.7,0.27); //cor do texto
        mDQPL.SetTextAlign(1); //centralizado
        mDQPL.DrawText(mDQPL.PageWidth()/2,35, translator.ReportTitle()); //plota o texto

        /*
        ADICIONANDO OS HEADERS
         */
        int rows = 2, cols = 4, cellWidth = 30, headers = mDQPL.CreateTable(rows, cols);

        mDQPL.SetTableColumnWidth(headers, 1, cols, cellWidth);
        mDQPL.SetTableCellTextSize(headers,1,1,rows,cols,12);

        mDQPL.SetTableCellContent(headers, 1,1, "<b>"+translator.data()+"</b>");
        mDQPL.SetTableCellContent(headers, 1,2, "<b>"+translator.hora()+"</b>");
        mDQPL.SetTableCellContent(headers, 1,3, "<b>"+translator.latitude()+"</b>");
        mDQPL.SetTableCellContent(headers, 1,4, "<b>"+translator.longitude()+"</b>");
        mDQPL.SetTableCellContent(headers,2,1,dataHora[0]);
        mDQPL.SetTableCellContent(headers,2,2,dataHora[1]);
        mDQPL.SetTableCellContent(headers,2,3,String.valueOf(coordinates[0]));
        mDQPL.SetTableCellContent(headers,2,4,String.valueOf(coordinates[1]));

        mDQPL.SetTableBorderColor(headers,0,1,1,1);
        mDQPL.SetTableCellBorderColor(headers,1,1,rows,cols,0,1,1,1);
        mDQPL.SetTableCellAlignment(headers,1,1,rows,cols,4);

        mDQPL.DrawTableRows(headers, (mDQPL.PageWidth()-(cellWidth*4))/2,40, 30, 1, 0);

        /*
        ADICIONA NOME DO CLIENTE OU ORIGEM/DESTINO
         */
        mDQPL.SetOrigin(1); //centralizado
        mDQPL.SetTextSize(12); //tamanho da letra
        mDQPL.SetTextColor(0,0,0); //cor do texto
        mDQPL.SetTextAlign(1);
        if (destination.equals("")){ //Adiciona nome do cliente
            String txt = "";
            if (user.getBusinessName().equals("null"))
                txt = translator.Cliente()+": "+user.getName();
            else txt = translator.Cliente()+": "+user.getBusinessName();
            mDQPL.DrawText(mDQPL.PageWidth()/2,75,txt);
        } else {
            String txt = "";
            if (user.getBusinessName().equals("null"))
                txt = translator.Origin()+": "+user.getName()+"          "+translator.Destination()+": "+destination;
            else txt = translator.Origin()+": "+user.getBusinessName()+"          "+translator.Destination()+": "+destination;
            mDQPL.DrawText(mDQPL.PageWidth()/2,75,txt);
        }

        /*
        ADICIONANDO OS DADOS INFORMADOS PELO USUÁRIO
         */
        mDQPL.SetOrigin(1);
        mDQPL.SetTextSize(12);
        mDQPL.SetTextColor(0,0,0);
        mDQPL.SetTextAlign(0);

        String txt1, txt2, txt3, txt4;
        txt1 = translator.VolumeFormula()+": "+getNomeFormulaVolume(formulaVolume);
        txt2 = translator.Info2Mes_ref()+": "+spatialRef+" "+units[0];
        txt3 = translator.Info2Mes_comp()+": "+logsLength+" "+units[1];
        txt4 = translator.LogSpecie()+": ";
        for (int i = 0; i < species.size(); i++)
            txt4.concat(species+", ");

        mDQPL.DrawText(15,90,txt1);
        mDQPL.DrawText(15,100,txt2);
        mDQPL.DrawText(15,110,txt3);
        mDQPL.DrawText(15,120,txt4);

        /*
        ADICIONANDO TABELA DE DIÂMETROS
         */
        mDQPL.SetOrigin(1);
        mDQPL.SetTextSize(16);
        mDQPL.SetTextColor(0.55,0.7,0.27);
        mDQPL.SetTextAlign(1);
        mDQPL.DrawText((mDQPL.PageWidth()/2)-45,147, translator.relatorioInfos05());

        int dadosDiametroRow = 8, dadosDiametroColumn = 2,
                dadosDiametro = mDQPL.CreateTable(dadosDiametroRow,dadosDiametroColumn);

        //mDQPL.SetTableRowHeight(dadosDiametro,1,dadosDiametroRow,10.0);
        mDQPL.SetTableColumnWidth(dadosDiametro, 1, dadosDiametroColumn, 35);

        mDQPL.SetTableCellContent(dadosDiametro,1,1,"<b>"+translator.descricao()+"</b>");
        mDQPL.SetTableCellContent(dadosDiametro,2,1,"<b>"+translator.Avg()+"</b>");
        //mDQPL.SetTableCellContent(dadosDiametro,3,1,"<b>"+translator.erroPadrao()+"</b>");
        mDQPL.SetTableCellContent(dadosDiametro,3,1,"<b>"+translator.Median()+"</b>");
        mDQPL.SetTableCellContent(dadosDiametro,4,1,"<b>"+translator.Mode()+"</b>");
        mDQPL.SetTableCellContent(dadosDiametro,5,1,"<b>"+translator.Std()+"</b>");
        //mDQPL.SetTableCellContent(dadosDiametro,7,1,"<b>"+translator.variancia()+"</b>");
        //mDQPL.SetTableCellContent(dadosDiametro,8,1,"<b>"+translator.curtose()+"</b>");
        //mDQPL.SetTableCellContent(dadosDiametro,9,1,"<b>"+translator.assimetria()+"</b>");
        //mDQPL.SetTableCellContent(dadosDiametro,10,1,"<b>"+translator.intervalo()+"</b>");
        mDQPL.SetTableCellContent(dadosDiametro,6,1,"<b>"+translator.Min()+"</b>");
        mDQPL.SetTableCellContent(dadosDiametro,7,1,"<b>"+translator.Max()+"</b>");
        //mDQPL.SetTableCellContent(dadosDiametro,13,1,"<b>"+translator.soma()+"</b>");
        mDQPL.SetTableCellContent(dadosDiametro,8,1,"<b>"+translator.Total()+"</b>");

        mDQPL.SetTableCellContent(dadosDiametro,1,2,"<b>"+translator.Value()+" "+units[0]+"</b>");
        mDQPL.SetTableCellContent(dadosDiametro,2,2,String.valueOf(calculos.getMedia()));
        //mDQPL.SetTableCellContent(dadosDiametro,3,2,String.valueOf(calculos.getErroPadrao()));
        mDQPL.SetTableCellContent(dadosDiametro,3,2,String.valueOf(calculos.getMediana()));
        mDQPL.SetTableCellContent(dadosDiametro,4,2,String.valueOf(calculos.getModa()));
        mDQPL.SetTableCellContent(dadosDiametro,5,2,String.valueOf(calculos.getDesvioPadrao()));
        //mDQPL.SetTableCellContent(dadosDiametro,7,2,String.valueOf(calculos.getVariancia()));
        //mDQPL.SetTableCellContent(dadosDiametro,8,2,String.valueOf(calculos.getCurtose()));
        //mDQPL.SetTableCellContent(dadosDiametro,9,2,String.valueOf(calculos.getAssimetria()));
        //mDQPL.SetTableCellContent(dadosDiametro,10,2,String.valueOf(calculos.getIntervalo()));
        mDQPL.SetTableCellContent(dadosDiametro,6,2,String.valueOf(calculos.getMinimo()));
        mDQPL.SetTableCellContent(dadosDiametro,7,2,String.valueOf(calculos.getMaximo()));
        //mDQPL.SetTableCellContent(dadosDiametro,13,2,String.valueOf(calculos.getSoma()));
        mDQPL.SetTableCellContent(dadosDiametro,8,2,String.valueOf(calculos.getContagem()));

        mDQPL.SetTableBorderColor(dadosDiametro,0,0,0,0);
        mDQPL.SetTableCellBorderColor(dadosDiametro,1,1,dadosDiametroRow,dadosDiametroColumn,0,0,0,0);
        mDQPL.SetTableCellAlignment(dadosDiametro,1,1,dadosDiametroRow,dadosDiametroColumn,4);

        mDQPL.DrawTableRows(dadosDiametro, (mDQPL.PageWidth()-(35*dadosDiametroColumn))/4-10,150, 50*dadosDiametroRow, 1, 0);

        /*
        ADICIONANDO TABELA DE VOLUME
         */
        mDQPL.SetOrigin(1);
        mDQPL.SetTextSize(16);
        mDQPL.SetTextColor(0.55,0.7,0.27);
        mDQPL.SetTextAlign(1);
        mDQPL.DrawText((mDQPL.PageWidth()/2)+45,147, translator.relatorioInfos06());

        int dadosVolumeRow = 7, dadosVolumeColumn = 2,
                dadosVolume = mDQPL.CreateTable(dadosVolumeRow,dadosVolumeColumn);

        mDQPL.SetTableColumnWidth(dadosVolume, 1, dadosVolumeColumn, 35);

        mDQPL.SetTableCellContent(dadosVolume,1,1,"<b>"+translator.descricao()+"</b>");
        mDQPL.SetTableCellContent(dadosVolume,2,1,"<b>"+translator.Avg()+"</b>");
        mDQPL.SetTableCellContent(dadosVolume,3,1,"<b>"+translator.Min()+"</b>");
        mDQPL.SetTableCellContent(dadosVolume,4,1,"<b>"+translator.Max()+"</b>");
        mDQPL.SetTableCellContent(dadosVolume,5,1,"<b>"+translator.Sum()+"</b>");
        mDQPL.SetTableCellContent(dadosVolume,6,1,"<b>"+translator.Std()+"</b>");
        mDQPL.SetTableCellContent(dadosVolume,7,1,"<b>"+translator.Variance()+"</b>");

        mDQPL.SetTableCellContent(dadosVolume,1,2,"<b>"+translator.Value()+" "+units[2]+"</b>");
        mDQPL.SetTableCellContent(dadosVolume,2,2,String.valueOf(calculos.getVolumeMedio()));
        mDQPL.SetTableCellContent(dadosVolume,3,2,String.valueOf(calculos.getVolumeMinimo()));
        mDQPL.SetTableCellContent(dadosVolume,4,2,String.valueOf(calculos.getVolumeMaximo()));
        mDQPL.SetTableCellContent(dadosVolume,5,2,String.valueOf(calculos.getVolumeTotal()));
        mDQPL.SetTableCellContent(dadosVolume,6,2,String.valueOf(calculos.getVolumeDesvioPadrao()));
        mDQPL.SetTableCellContent(dadosVolume,7,2,String.valueOf(calculos.getVolumeVariancia()));

        mDQPL.SetTableBorderColor(dadosVolume,0,0,0,0);
        mDQPL.SetTableCellBorderColor(dadosVolume,1,1,dadosVolumeRow,dadosVolumeColumn,0,0,0,0);
        mDQPL.SetTableCellAlignment(dadosVolume,1,1,dadosVolumeRow,dadosVolumeColumn,4);

        mDQPL.DrawTableRows(dadosVolume, (mDQPL.PageWidth()/2)+10,150, 50*dadosVolumeRow, 1, 0);

        /*
        INICIANDO UMA NOVA PÁGINA
         */
        mDQPL.NewPage();

        /*
        ADICIONANDO UMA IMAGEM OU MOSAICO
         */
        Bitmap bitmap = BitmapFactory.decodeFile(img_dt_nome);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] bitmapdata = stream.toByteArray();
        mDQPL.AddImageFromString(bitmapdata,0);
        mDQPL.DrawImage(20,20,mDQPL.PageWidth()-40,(mDQPL.PageHeight()/2)-20);

        /*
        INICIANDO UMA NOVA PÁGINA
         */
        mDQPL.NewPage();

        /*
        ADICIONANDO TABELA DE DADOS TOTAIS
         */
        mDQPL.SetOrigin(1);
        mDQPL.SetTextSize(16);
        mDQPL.SetTextColor(0.55,0.7,0.27);
        mDQPL.SetTextAlign(1);
        String infos06 = translator.relatorioInfos07();
        mDQPL.DrawText(mDQPL.PageWidth()/2,20, infos06);

        int dadosTotaisRow = diameters.size()+1, dadosTotaisColumn = 3,
                dadosTotais = mDQPL.CreateTable(dadosTotaisRow,dadosTotaisColumn);

        //mDQPL.SetTableRowHeight(dadosTotais,1,mDQPL.GetTableRowCount(dadosTotais),10.0);
        mDQPL.SetTableColumnWidth(dadosTotais, 1, dadosTotaisColumn, 35);

        mDQPL.SetTableCellContent(dadosTotais,1,1,"<b>ID</b>");
        mDQPL.SetTableCellContent(dadosTotais,1,2,"<b>"+translator.Diameter()+" "+units[0]+"</b>");
        mDQPL.SetTableCellContent(dadosTotais,1,3,"<b>"+translator.Volume()+" "+units[2]+"</b>");

        ArrayList<Double> diametros_conv;
        if (units[0].equals("cm"))
            diametros_conv = calculos.diametros2cm(diameters, pixelsConv);
        else diametros_conv = calculos.diametros2pol(diameters,pixelsConv);


        Log.d("reportsz","reportsz: "+ diametros_conv);
        Log.d("reportsz","reportsz: "+ diameters);


        for (int i = 0; i < diameters.size(); i++){
            mDQPL.SetTableCellContent(dadosTotais,i+2,1,String.valueOf(i+1));
            //mDQPL.SetTableCellContent(dadosTotais,i+2,2,String.valueOf(calculos.round(diametros_conv.get(i),2)));
            //mDQPL.SetTableCellContent(dadosTotais,i+2,3,String.valueOf(calculos.round(volumes.get(i),2)));
            mDQPL.SetTableCellContent(dadosTotais,i+2,2,String.valueOf(calculos.round((diametros_conv.get(i))/100,2)));
            mDQPL.SetTableCellContent(dadosTotais,i+2,3,String.valueOf(calculos.round((volumes.get(i))/10000,2)));
//            mDQPL.SetTableCellContent(dadosTotais,i+2,3,String.valueOf(calculos.round((volumes.get(i)),2)));
        }

        mDQPL.SetTableBorderColor(dadosTotais,0,0,0,0);
        mDQPL.SetTableCellBorderColor(dadosTotais,1,1,dadosTotaisRow,dadosTotaisColumn,0,0,0,0);

        mDQPL.SetTableCellAlignment(dadosTotais,1,1,dadosTotaisRow,dadosTotaisColumn,4);
        mDQPL.SetTableCellTextSize(dadosTotais,1,1,dadosTotaisRow,dadosTotaisColumn,18);

        mDQPL.DrawTableRows(dadosTotais, (mDQPL.PageWidth()-(35*dadosTotaisColumn))/2,25, mDQPL.PageHeight()-40, 1, 0);

        for (;;)
            if (mDQPL.GetTableLastDrawnRow(dadosTotais) < mDQPL.GetTableRowCount(dadosTotais)){
                mDQPL.NewPage();
                mDQPL.DrawTableRows(dadosTotais, (mDQPL.PageWidth()-(35*dadosTotaisColumn))/2,20, mDQPL.PageHeight()-40, mDQPL.GetTableLastDrawnRow(dadosTotais)+1, 0);
            }else break;

        mDQPL.SaveToFile(reportName);
        Log.i("Report","Report successfully generated");

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        delegate.onReportFinish("success");
    }

    private String getNomeFormulaVolume(Integer fv) {
        String formula = "";

        switch (fv){
            case 1:
                formula = translator.VolumeFormula01();
                break;
            case 2:
                formula = translator.VolumeFormula02();
                break;
            case 3:
                formula = translator.VolumeFormula03();
                break;
            case 4:
                formula = translator.VolumeFormula04();
                break;
            case 5:
                formula = translator.VolumeFormula05();
                break;
            case 6:
                formula = translator.VolumeFormula06();
                break;
            case 7:
                formula = translator.VolumeFormula07();
                break;
            case 8:
                formula = translator.VolumeFormula08();
                break;
            case 9:
                formula = translator.VolumeFormula09();
                break;
            case 10:
                formula = translator.VolumeFormula10();
                break;
            case 11:
                formula = translator.VolumeFormula11();
                break;
            case 12:
                formula = translator.VolumeFormula12();
                break;
            case 13:
                formula = translator.VolumeFormula13();
                break;
            case 14:
                formula = translator.VolumeFormula14();
                break;
            case 15:
                formula = translator.VolumeFormula15();
                break;
        }

        return formula;
    }
}
