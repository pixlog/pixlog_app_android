package com.pixlog.detect;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import com.debenu.pdflibrary.DebenuPDFLibraryCPAndroidJava1711;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.jaygoo.widget.OnRangeChangedListener;
import com.jaygoo.widget.RangeSeekBar;
import com.pixlog.MenuActivity;
import com.pixlog.Others;
import com.pixlog.Preferences;
import com.pixlog.R;
import com.pixlog.Translator;
import com.pixlog.dao.UserDAO;
import com.pixlog.detect.csv.CSV;
import com.pixlog.detect.csv.CSVresponse;
import com.pixlog.detect.report.Report;
import com.pixlog.detect.report.ReportResponse;
import com.pixlog.detect.tflite.Classifier;
import com.pixlog.detect.tflite.TFLiteObjectDetectionAPIModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class DetectionActivity
        extends AppCompatActivity
        implements DetectionResponse, CSVresponse, ReportResponse {

    private AlertDialog alertDialog;
    private Bitmap bitmap;
    private Calculos calculos = new Calculos();
    private ConstraintLayout layout_all, layout_range, layout_edit;
    private LogsView logsView;
    private ImageView buttonROI, buttonEdit, buttonInfo, buttonNext, buttonChange;
    private static int REQUEST_GPS = 1, REQUEST_WRITE = 2;
    private Others others = new Others();
    private RangeSeekBar range;
    private String img_dt = "", img = "", destination = "";
    private Translator translator;

    //LOG VARIABLES
    private ArrayList<Boolean> inside_list = new ArrayList<>();
    private ArrayList<Double> cx_list = new ArrayList<>(),
            cy_list = new ArrayList<>(),
            r_list = new ArrayList<>(),
            conf_list = new ArrayList<>();
    private ArrayList<String> label_list = new ArrayList<>();
    public double[] sf = new double[2];
    private Integer volumeFormula;
    private String diameterUnit = "", lengthUnit = "", volumeUnit = "";
    private TextView[] rangeValues = new TextView[2];

    //REPORT VARIABLES
    private int mUnlocked = 0;
    private double logsLength, spatialRef, pixelsFactor; //converte de pixels para metros ou pés
    private String[] datahora = new String[2];
    static {
        switch (Build.SUPPORTED_ABIS[0]) {
            case "x86":
                System.loadLibrary("DebenuPDFLibraryAndroidx861711");
                break;
            case "armeabi-v7a":
                System.loadLibrary("DebenuPDFLibraryAndroidArm1711");
                break;
            case "arm64-v8a":
                System.loadLibrary("DebenuPDFLibraryAndroidArm641711");
                break;
            case "x86_64":
                System.loadLibrary("DebenuPDFLibraryAndroidx86_641711");
                break;
        }
    }

    //TENSORFLOW VARIABLES
    private Classifier detector;
    private List<Classifier.Recognition> logs;
    private static final int TF_OD_API_INPUT_SIZE = 300;
    private static final boolean TF_OD_API_IS_QUANTIZED = true;
    private static final String TF_OD_API_MODEL_FILE = "pixlog_detect_2.tflite",
            TF_OD_API_LABELS_FILE = "file:///android_asset/pixlog_labelmap.txt";
    private static final float MINIMUM_CONFIDENCE_TF_OD_API = 0.7f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detection);

        translator = others.setLang(new Preferences(getApplicationContext()));

        getUserData();



        /*
        USADO NO PADRÃO SUL-AFRICANO E NA FÓRMULA DE A. NILSON
         */
        calculos.setEspecieArvore(10); //10 = pinus

        calculos.setGost2708_75(readCSVfile(R.raw.gost2708_75_tabela01),
                readCSVfile(R.raw.gost2708_75_tabela02),
                readCSVfile(R.raw.gost2708_75_tabela03));

        layout_all = findViewById(R.id.layout_all);
        layout_range = findViewById(R.id.layout_range);
        layout_edit = findViewById(R.id.layout_edit);

        range = findViewById(R.id.range);

        rangeValues[0] = findViewById(R.id.minRange);
        rangeValues[1] = findViewById(R.id.maxRange);

        logsView = findViewById(R.id.logsView);

        ImageView buttonBack = findViewById(R.id.buttonBackDetect);
        buttonROI = findViewById(R.id.buttonROI);
        buttonEdit = findViewById(R.id.buttonEdit);
        buttonInfo = findViewById(R.id.buttonInfo);
        buttonNext = findViewById(R.id.buttonNext);

        buttonChange = findViewById(R.id.buttonChange);
        ImageView buttonAdd = findViewById(R.id.buttonAdd);
        ImageView buttonExclude = findViewById(R.id.buttonExclude);

        layout_all.bringToFront();
        layout_range.setVisibility(View.VISIBLE);
        layout_edit.setVisibility(View.INVISIBLE);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog
                        .Builder(DetectionActivity.this);
                alertDialogBuilder
                        .setTitle(translator.DeleteCurrent())
                        .setPositiveButton(translator.Yes(),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        /*File file = new File(img);
                                        boolean delete = file.delete();
                                        if (delete){*/
                                            startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                                            //Desliza para a esquerda
                                            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                                        //}else others.showToast(getApplicationContext(),translator.ErrorDeleting());
                                    }
                                })
                        .setNegativeButton(translator.No(),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                }
                        );
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        /*
        MEASUREMENT BUTTONS
         */
        buttonROI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!logsView.isRoi()) {
                    buttonROI.setImageResource(R.drawable.ic_polygon_on);
                    buttonEdit.setVisibility(View.INVISIBLE);
                    buttonInfo.setVisibility(View.INVISIBLE);
                    buttonNext.setVisibility(View.INVISIBLE);
                    rangeValues[0].setVisibility(View.INVISIBLE);
                    rangeValues[1].setVisibility(View.INVISIBLE);
                    range.setVisibility(View.INVISIBLE);
                    logsView.setRoi(true);
                    logsView.invalidate();
                } else {
                    buttonROI.setImageResource(R.drawable.ic_polygon_off);
                    buttonEdit.setVisibility(View.VISIBLE);
                    buttonInfo.setVisibility(View.VISIBLE);
                    buttonNext.setVisibility(View.VISIBLE);
                    rangeValues[0].setVisibility(View.VISIBLE);
                    rangeValues[1].setVisibility(View.VISIBLE);
                    range.setVisibility(View.VISIBLE);
                    logsView.setRoi(false);
                    logsView.invalidate();
                }
            }
        });
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!logsView.isEditing()){
                    buttonROI.setVisibility(View.INVISIBLE);
                    buttonEdit.setVisibility(View.VISIBLE);
                    buttonEdit.setImageResource(R.drawable.ic_modify_on);
                    buttonInfo.setVisibility(View.INVISIBLE);

                    layout_all.bringToFront();
                    layout_range.bringToFront();
                    layout_range.setVisibility(View.INVISIBLE);
                    layout_edit.setVisibility(View.VISIBLE);

                    logsView.setRoi(false);
                    logsView.setEditing(true);
                    logsView.invalidate();
                } else {
                    buttonROI.setVisibility(View.VISIBLE);
                    buttonEdit.setVisibility(View.VISIBLE);
                    buttonEdit.setImageResource(R.drawable.ic_modify_off);
                    buttonInfo.setVisibility(View.VISIBLE);

                    layout_all.bringToFront();
                    layout_range.bringToFront();
                    layout_range.setVisibility(View.VISIBLE);
                    layout_edit.setVisibility(View.INVISIBLE);

                    logsView.setRoi(false);
                    logsView.setEditing(false);
                    logsView.invalidate();
                }
            }
        });
        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String totalCount = translator.Logs()+": "+ logsView.getTotalRange(),
                        totalVolume = translator.Volume()+": "
                                + calculos.round(logsView.getVolumeRange(),2)+" "+volumeUnit;
                others.showToast(getApplicationContext(),totalCount + "\n" + totalVolume);
            }
        });

        /*
        EDITION BUTTONS
         */
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!logsView.isRemoving()){
                    buttonChange.setImageResource(R.drawable.ic_change_on);
                    logsView.setRemoving(true);
                    logsView.invalidate();
                } else {
                    buttonChange.setImageResource(R.drawable.ic_change_off);
                    logsView.setRemoving(false);
                    logsView.invalidate();
                }
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!logsView.isAdding()){
                    logsView.setAdding(true);
                    logsView.invalidate();
                } else {
                    logsView.setAdding(false);
                    logsView.invalidate();
                }
            }
        });
        buttonExclude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (logsView.isAdding() || logsView.isRemoving()) {
                    logsView.setAdding(false);
                    logsView.setRemoving(false);
                    buttonChange.setImageResource(R.drawable.ic_change_off);
                    logsView.invalidate();
                }
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GET SPATIAL REFERENCE
                if (logsView.isSpatial() && !logsView.isRoi() && !logsView.isEditing()
                        && !logsView.isAdding() && !logsView.isRemoving())
                    infos2measure();
                    //SAVE MEASUREMENT
                else if (!logsView.isSpatial() && !logsView.isRoi() && !logsView.isEditing()
                        && !logsView.isAdding() && !logsView.isRemoving())
                    requestWritePermission();
                    //SAVE EDITED LOGS
                else if (!logsView.isSpatial() && !logsView.isRoi() && logsView.isEditing()
                        && (logsView.isAdding() || logsView.isRemoving())){

                    buttonChange.setImageResource(R.drawable.ic_change_off);

                    float[] xy_cc = logsView.getXY_cc(); //Adiciona a nova tora ou a tora editada

                    cx_list = logsView.getCx();
                    cx_list.add((double) xy_cc[0]);
                    logsView.setCx(cx_list);

                    cy_list = logsView.getCy();
                    cy_list.add((double) xy_cc[1]);
                    logsView.setCy(cy_list);

                    r_list = logsView.getR();
                    r_list.add((double) logsView.getEditRadius());
                    logsView.setR(r_list);

                    range.setRange(Collections.min(r_list).floatValue(),
                            Collections.max(r_list).floatValue());

                    inside_list = logsView.getInside();
                    inside_list.add(true);
                    logsView.setInside(inside_list);

                    conf_list = logsView.getConf();
                    conf_list.add(1.0);
                    logsView.setConf(conf_list);

                    label_list = logsView.getLabel();
                    label_list.add("pinus");
                    logsView.setLabel(label_list);

                    logsView.invalidate();

                    if (logsView.isAdding()) logsView.setAdding(false);
                    if (logsView.isRemoving()) logsView.setRemoving(false);

                    /*
                    Define as coordenada para o novo círculo aparecer no meio da tela,
                    independente da posição da imagem.
                     */
                    Rect screenSize = getScreenSize();
                    float w = ((float)screenSize.width()/2-logsView.getTranslateX())/logsView.getScale(),
                            h = ((float)screenSize.height()/2-logsView.getTranslateY())/logsView.getScale();
                    logsView.setXY_cc(new float[]{w,h});

                    others.showToast(getApplicationContext(),translator.EditionFinished());
                }
            }
        });

        if (!img.isEmpty()) {
            initTFLite();
            setImgsForDetection();
            detectLogs(img);

            buttonROI.setVisibility(View.INVISIBLE);
            buttonEdit.setVisibility(View.INVISIBLE);
            buttonInfo.setVisibility(View.INVISIBLE);
            layout_range.setVisibility(View.INVISIBLE);
            layout_edit.setVisibility(View.INVISIBLE);

            logsView.setSpatial(true);

        } else others.showToast(getApplicationContext(),translator.imgsIntent());
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

    private void getUserData() {
        if (getIntent().getStringExtra("imagem_unica") == null)
            img = getIntent().getStringExtra("mosaico");
        else img = getIntent().getStringExtra("imagem_unica");

        /*UserDAO userDAO = new UserDAO(DetectionActivity.this);
        User user = userDAO.get().get(0);

        volumeFormula = Integer.parseInt("0"); //user.getFv()
        diameterUnit = user.getUd();
        lengthUnit = user.getUc();
        volumeUnit = user.getUv();*/

        diameterUnit = "cm";
        lengthUnit = "m";
        volumeFormula = Integer.parseInt("1");
        volumeUnit = "m3";


    }

    private String[][] readCSVfile(int id_tabela) {
        ArrayList<ArrayList<String>> dados = new ArrayList<>();

        InputStream is = getResources().openRawResource(id_tabela);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        try{
            while ((line = reader.readLine()) != null){
                ArrayList<String> subdados = new ArrayList<>();
                String[] substring = line.split(";");

                for (int i = 0; i < substring.length; i++)
                    subdados.add(substring[i]);

                dados.add(subdados);
            }
        }catch (IOException e){
            Log.i("GOST2798-75", "Error reading data on line "+line, e);
        }

        String[][] retorno = new String[dados.size()][dados.get(0).size()];
        for (int i = 0; i < dados.size(); i++){
            ArrayList<String> temp = dados.get(i);
            for (int j = 0; j < dados.get(0).size(); j++){
                if (temp.get(j).equals("")) retorno[i][j] = "x";
                else retorno[i][j] = temp.get(j);
            }
        }

        return retorno;
    }

    private void initTFLite() {
        try {
            detector = TFLiteObjectDetectionAPIModel.create(
                    getAssets(),
                    TF_OD_API_MODEL_FILE,
                    TF_OD_API_LABELS_FILE,
                    TF_OD_API_INPUT_SIZE,
                    TF_OD_API_IS_QUANTIZED);
        } catch (IOException e) {
            Log.e("TFlite", "Error initializing classifier, output: "+e.getMessage());
            others.showToast(getApplicationContext(),translator.TFproblem());
            finish();
        }
    }

    private void setImgsForDetection() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;

        bitmap = BitmapFactory.decodeFile(img, options);

        //Bitmaps are imutable, so we need to convert it to mutable one
        bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);

        logsView.setImageBitmap(bitmap);
        logsView.bringToFront();
        layout_all.bringToFront();
        layout_range.bringToFront();

        Matrix initialMatrix = logsView.getImageMatrix();
        float[] initialMatrixValues = new float[9];
        initialMatrix.getValues(initialMatrixValues);
    }

    private void detectLogs(String imgPath) {
        //A rede neural espera receber uma imagem de 300 x 300
        Bitmap bit = BitmapFactory.decodeFile(imgPath),
                sbit = Bitmap.createScaledBitmap(bit, TF_OD_API_INPUT_SIZE, TF_OD_API_INPUT_SIZE,false);

        //Calcula os fatores de escala para redimensionar a imagem
        sf[0] = (double)TF_OD_API_INPUT_SIZE / (double)bit.getWidth();
        sf[1] = (double)TF_OD_API_INPUT_SIZE / (double)bit.getHeight();

        Detection detection = new Detection(detector, sbit);
        detection.delegate = this;
        detection.execute();
    }

    private void infos2measure() {
        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
        View promptsView = layoutInflater.inflate(R.layout.infos_detect, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DetectionActivity.this);
        alertDialogBuilder.setView(promptsView);

        alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);

        TextView[] titles = new TextView[2];
        titles[0] = promptsView.findViewById(R.id.nome_referencia);
        titles[1] = promptsView.findViewById(R.id.nome_comprimento);
        titles[0].setText(translator.Info2Mes_ref());
        titles[1].setText(translator.Info2Mes_comp());

        final EditText[] infos = new EditText[2];
        infos[0] = promptsView.findViewById(R.id.valor_referencia);
        infos[1] = promptsView.findViewById(R.id.valor_comprimento);


        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!infos[0].getText().toString().matches("") &&
                        !infos[1].getText().toString().matches("")){
                    alertDialog.dismiss();

                    buttonROI.setVisibility(View.VISIBLE);
                    buttonEdit.setVisibility(View.VISIBLE);
                    buttonInfo.setVisibility(View.VISIBLE);
                    //layout_range.setVisibility(View.VISIBLE);
                    layout_edit.setVisibility(View.INVISIBLE);

                    spatialRef = Double.parseDouble(infos[0].getText().toString());
                    logsLength = Double.parseDouble(infos[1].getText().toString());

                    //Recupera as coordenadas da ferramenta de escala
                    float[] xy1 = logsView.getStartXY(), xy2 = logsView.getEndXY();

                    //calcula as diferenças em x e y
                    double[] dxdy = {xy1[0]-xy2[0], xy1[1]-xy2[1]};

                    pixelsFactor = spatialRef/(Math.sqrt(Math.pow(dxdy[0],2)+Math.pow(dxdy[1],2)));

                    logsView.setSpatial(false);
                    buttonNext.setImageResource(R.drawable.ic_save_off);
                    layout_range.setVisibility(View.VISIBLE);
                    layout_range.bringToFront();
                    //if (logs.size() >= 1) getCircles();
                    try {
                        getCircles();
                    }
                    catch (Exception e){
                        buttonROI.setVisibility(View.INVISIBLE);
                        buttonEdit.setVisibility(View.INVISIBLE);
                        buttonInfo.setVisibility(View.INVISIBLE);
                        layout_range.setVisibility(View.INVISIBLE);
                        buttonNext.setVisibility(View.INVISIBLE);

                        others.showToast(getApplicationContext(),translator.NoLogs());
                    }

                }else others.showToast(getApplicationContext(),translator.MandatoryFiling());
            }
        });

        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, translator.Cancel(),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alertDialog.show();
    }

    private void getCircles() {

        for (Classifier.Recognition det : logs) {
            RectF ret = det.getLocation();
            double x1 = ret.left, y1 = ret.top, x2 = ret.right, y2 = ret.bottom,
                    cx = (x1 + ((x2 - x1) / 2))/sf[0], cy = (y1 + ((y2 - y1) / 2))/sf[1],
                    r1 = ((x2 - x1) / 2)/sf[0], r2 = ((y2 - y1) / 2)/sf[1], r = (r1 + r2)/2;
//            double r;
//            if (r1 < r2) r = r1/sf[0];
//            else r = r2/sf[1];

            /*
            Adicionando as toras que estão com confiabilidade acima do mínimo definido
             */
            if (det.getConfidence() >= MINIMUM_CONFIDENCE_TF_OD_API && det.getConfidence() <= 1.0f){
                cx_list.add(cx);
                cy_list.add(cy);
                r_list.add(r);
                inside_list.add(true);
                conf_list.add(det.getConfidence().doubleValue());
                label_list.add(det.getTitle());
            }
        }
        logsView.setHullPoints(Point2ArrayList(CalculateConvexHull()));

        range.setRange(Collections.min(r_list).floatValue(), Collections.max(r_list).floatValue());

        logsView.setFormulaVolume(volumeFormula);
        logsView.setFatorPixels(pixelsFactor);
        logsView.setComprimentoToras(logsLength);

        logsView.setCx(cx_list);
        logsView.setCy(cy_list);
        logsView.setR(r_list);
        logsView.setInside(inside_list);
        logsView.setConf(conf_list);
        logsView.setLabel(label_list);

        logsView.setShowLogs(true);

        Log.d("verificar_label","label: "+ logsView.getR());

        range.setOnRangeChangedListener(new OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float leftValue, float rightValue,
                                       boolean isFromUser) {
                /*
                Atualiza qual tora está dentro ou fora do intervalo selecionado na barra
                 */
                for (int i = 0; i < r_list.size(); i++){
                    if (r_list.get(i) >= leftValue && r_list.get(i) <= rightValue)
                        inside_list.set(i,true);
                    else inside_list.set(i,false);
                }
                logsView.setInside(inside_list);
                logsView.invalidate();

                /*
                Atualiza os valores informado ao usuário
                 */
                double[] rMinMax = new double[2];
                if (diameterUnit.equals("cm"))
                    rMinMax = new double[]{
                            calculos.round(calculos.pixels2cm(leftValue,pixelsFactor),2),
                            calculos.round(calculos.pixels2cm(rightValue,pixelsFactor),2)};
                else if (diameterUnit.equals("in"))
                    rMinMax = new double[]{
                            calculos.round(calculos.pixels2pol(leftValue,pixelsFactor),2),
                            calculos.round(calculos.pixels2pol(rightValue,pixelsFactor),2)};

                String[] dMinMax = new String[]{2*rMinMax[0] +" "+diameterUnit,
                        2*rMinMax[1] +" "+diameterUnit};

                rangeValues[0].setText(dMinMax[0]);
                rangeValues[1].setText(dMinMax[1]);
            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }
        });
    }

    private ArrayList<double[]> Point2ArrayList(Vector<Point> points) {
        ArrayList<double[]> hullPoints = new ArrayList<>();

        for (int i = 0; i < points.size(); i++)
            hullPoints.add(new double[]{points.get(i).x, points.get(i).y});

        return hullPoints;
    }

    private Vector<Point> CalculateConvexHull() {
        Point[] points = new Point[inside_list.size()];

        for (int c  = 0; c < inside_list.size(); c++)
            if (inside_list.get(c)) {
                Drawable d = logsView.getDrawable();
                int w = d.getIntrinsicWidth();
                int h = d.getIntrinsicHeight();

                if (cx_list.get(c) <= w/2 && cy_list.get(c) <= h/2)
                    points[c] = new Point(cx_list.get(c)-r_list.get(c),cy_list.get(c)-r_list.get(c));
                else if (cx_list.get(c) > w/2 && cy_list.get(c) <= h/2)
                    points[c] = new Point(cx_list.get(c)+r_list.get(c),cy_list.get(c)-r_list.get(c));
                else if (cx_list.get(c) > w/2 && cy_list.get(c) > h/2)
                    points[c] = new Point(cx_list.get(c)+r_list.get(c),cy_list.get(c)+r_list.get(c));
                else if (cx_list.get(c) <= w/2 && cy_list.get(c) > h/2)
                    points[c] = new Point(cx_list.get(c)-r_list.get(c),cy_list.get(c)+r_list.get(c));
            }

        return convexHullPolygon(points, points.length);
    }

    public Vector<Point> convexHullPolygon(Point[] points, int n) {
        // There must be at least 3 points
        if (n < 3) return null;

        // Initialize Result
        Vector<Point> hull = new Vector<Point>();

        // Find the leftmost point
        int l = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[l].x)
                l = i;

        // Start from leftmost point, keep moving
        // counterclockwise until reach the start point
        // again. This loop runs O(h) times where h is
        // number of points in result or output.
        int p = l, q;
        do
        {
            // Add current point to result
            hull.add(points[p]);

            // Search for a point 'q' such that
            // orientation(p, x, q) is counterclockwise
            // for all points 'x'. The idea is to keep
            // track of last visited most counterclock-
            // wise point in q. If any point 'i' is more
            // counterclock-wise than q, then update q.
            q = (p + 1) % n;

            for (int i = 0; i < n; i++)
            {
                // If i is more counterclockwise than
                // current q, then update q
                if (orientation(points[p], points[i], points[q])
                        == 2)
                    q = i;
            }

            // Now q is the most counterclockwise with
            // respect to p. Set p as q for next iteration,
            // so that q is added to result 'roi'
            p = q;

        } while (p != l);  // While we don't come to first

        return hull;
    }

    public int orientation(Point p, Point q, Point r) {
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0;  // collinear
        return (val > 0)? 1: 2; // clock or counterclock wise
    }


//    private void plotLogs() {
//        Canvas canvas = new Canvas(bitmap);
//
//        Paint paint = new Paint();
//        paint.setTextSize(35);
//
//        ArrayList<Double> cx_draw = logsView.getCx_draw(),
//                cy_draw = logsView.getCy_draw(),
//                r_draw = logsView.getR_draw(),
//                //raio = logsView.getR(),
//                diametros_conv = calculos.diametros2cm(logsView.getDiametro_draw(), pixelsFactor);
//        ArrayList<String> label_draw = logsView.getLabel_draw();
//
//        for (int i = 0; i < r_draw.size(); i++){
//            if (label_draw.get(i).equals("pinus")){
//                paint.setStyle(Paint.Style.STROKE);
//                paint.setStrokeWidth(4);
//                paint.setColor(Color.GREEN); //VERDE
//                canvas.drawCircle(cx_draw.get(i).floatValue(),
//                        cy_draw.get(i).floatValue(),
//                        r_draw.get(i).floatValue(),
//                        paint);
//
//                //double diametro_round = raio.get(i)*2;
//                DecimalFormat numberFormat = new DecimalFormat("#.00");
//                String diametro = numberFormat.format(diametros_conv.get(i)/100);
//                paint.setStyle(Paint.Style.FILL_AND_STROKE);
//                paint.setColor(Color.WHITE); //BRANCO
//                paint.setStrokeWidth(2);
//                paint.setTextAlign(Paint.Align.CENTER);
//                canvas.drawText(diametro,
//                        cx_draw.get(i).floatValue(),
//                        cy_draw.get(i).floatValue(),
//                        paint);
//            }else if (label_draw.get(i).equals("eucalyptus")){
//                paint.setColor(Color.rgb(255,255,0)); //LARANJA
//                canvas.drawCircle(cx_draw.get(i).floatValue(),
//                        cy_draw.get(i).floatValue(),
//                        r_draw.get(i).floatValue(),
//                        paint);
//            }
//        }
//    }

//    private void plotLogs() {
//        Canvas canvas = new Canvas(bitmap);
//
//        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(4);
//
//        ArrayList<Double> cx_draw = logsView.getCx_draw(),
//                cy_draw = logsView.getCy_draw(),
//                r_draw = logsView.getR_draw();
//        ArrayList<String> label_draw = logsView.getLabel_draw();
//
//        for (int i = 0; i < r_draw.size(); i++){
//            if (label_draw.get(i).equals("pinus")){
//                paint.setColor(Color.GREEN); //VERDE
//                canvas.drawCircle(cx_draw.get(i).floatValue(),
//                        cy_draw.get(i).floatValue(),
//                        r_draw.get(i).floatValue(),
//                        paint);
//            }else if (label_draw.get(i).equals("eucalyptus")){
//                paint.setColor(Color.rgb(255,255,0)); //LARANJA
//                canvas.drawCircle(cx_draw.get(i).floatValue(),
//                        cy_draw.get(i).floatValue(),
//                        r_draw.get(i).floatValue(),
//                        paint);
//            }
//        }
//    }


    private void plotLogs() {
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        Paint textPaint = new Paint();
        Paint borderPaint = new Paint();

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);

        ArrayList<Double> cx_draw = logsView.getCx_draw(),
                cy_draw = logsView.getCy_draw(),
                r_draw = logsView.getR_draw();
        ArrayList<String> label_draw = logsView.getLabel_draw();

        for (int i = 0, count = 0; i < r_draw.size(); i++, count++){
            if (label_draw.get(i).equals("pinus")){
                paint.setColor(Color.GREEN); //VERDE
                canvas.drawCircle(cx_draw.get(i).floatValue(),
                        cy_draw.get(i).floatValue(),
                        r_draw.get(i).floatValue(),
                        paint);
            }else if (label_draw.get(i).equals("eucalyptus")){
                paint.setColor(Color.rgb(255,255,0)); //LARANJA
                canvas.drawCircle(cx_draw.get(i).floatValue(),
                        cy_draw.get(i).floatValue(),
                        r_draw.get(i).floatValue(),
                        paint);
            }


            //Paint para o texto
            textPaint.setTextSize(r_draw.get(i).floatValue());
            textPaint.setColor(Color.BLACK); //cor do texto

            //Paint para a borda do texto
            borderPaint.setStyle(Paint.Style.FILL);
            borderPaint.setColor(Color.WHITE);

            //Calcula as dimensões do texto
            Rect textBounds = new Rect();
            textPaint.getTextBounds(String.valueOf(count +1), 0, String.valueOf(count +1).length(), textBounds);
            int[] txtHW = {textBounds.height(), textBounds.width()};

            //Desenha a "borda"
            canvas.drawRect((float)(cx_draw.get(i)-0.6*txtHW[1]),
                    (float)(cy_draw.get(i)-0.7*txtHW[0]),
                    (float)(cx_draw.get(i)+0.7*txtHW[1]),
                    (float)(cy_draw.get(i)+0.7*txtHW[0]),
                    borderPaint);

            //Desenha o número da tora
            canvas.drawText(String.valueOf(count +1),
                    (float) (cx_draw.get(i)-0.5*txtHW[1]),
                    (float) (cy_draw.get(i)+0.5*txtHW[0]),
                    textPaint);


        }
    }



    private void requestWritePermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{WRITE_EXTERNAL_STORAGE},REQUEST_WRITE);
    }

    private void requestGPSpermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{ACCESS_FINE_LOCATION},REQUEST_GPS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode == REQUEST_GPS){
            FusedLocationProviderClient client = LocationServices
                    .getFusedLocationProviderClient(DetectionActivity.this);

            if (ActivityCompat.checkSelfPermission(
                    DetectionActivity.this, ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) requestGPSpermission();
            else client.getLastLocation().addOnSuccessListener(DetectionActivity.this,
                    new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null){
                                getCSV();
                                openDQPL(img_dt, new double[]{location.getLatitude(), location.getLongitude()});
                            } else{
                                getCSV();
                                openDQPL(img_dt, new double[]{0.0, 0.0});
                            }
                        }
                    });
        }else if (requestCode == REQUEST_WRITE){
            if (ActivityCompat.checkSelfPermission(
                    DetectionActivity.this,WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) requestWritePermission();
            else {
                LayoutInflater layoutInflater = LayoutInflater.from(DetectionActivity.this);
                View promptsView = layoutInflater.inflate(R.layout.newname, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DetectionActivity.this);
                alertDialogBuilder.setView(promptsView);

                final AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setCancelable(false);

                TextView title = promptsView.findViewById(R.id.newJobName);
                final EditText value = promptsView.findViewById(R.id.newJobNameType);

                title.setText(translator.Destination());

                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String s = value.getText().toString();
                        if (!s.equals("")){
                            dialog.cancel();
                            destination = s;
                            saveImgs();
                            requestGPSpermission();
                        } else others.showToast(getApplicationContext(),translator.FillNewName());
                    }
                });

                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, translator.Cancel(),
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialog.show();
            }
        }
    }

    private void saveImgs() {
        if (getIntent().getStringExtra("fromGallery").equals("true")){

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dh = df.format(Calendar.getInstance().getTime());

            String a = dh.substring(0,4),
                    me = dh.substring(5,7),
                    d = dh.substring(8,10),
                    h = dh.substring(11,13),
                    mi = dh.substring(14,16),
                    s = dh.substring(17,19);

            datahora[0] = a+"-"+me+"-"+d;
            datahora[1] = h+":"+mi+":"+s;
            String newImgName = a+me+d+"_"+h+mi+s;
            String pasta_nome = getIntent().getStringExtra("correctPath");


            File pasta = new File(getExternalFilesDir(null)+"/"+pasta_nome);
            //File pasta = new File("/storage/emulated/0/android/media/com.pixlog"+"/"+"detection");


            boolean mkdirs;
            if (!pasta.exists()) {
                mkdirs = pasta.mkdirs();
            } else mkdirs = true;

            img_dt = pasta.toString()+"/"+newImgName+"_dt.jpg";

            if (mkdirs) {
                try{
                    //Salva a imagem com as medições
                    plotLogs();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 30,
                            new FileOutputStream(new File(img_dt)));

                    Log.i("Saving","Images saved successfully");
                } catch (FileNotFoundException e) {
                    Log.e("Saving","files not found, output: "+e.getMessage());
                }
            } else Log.e("Saving","error creating new directory");

            //Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            //startActivity(intent);

        } else {
            try {
                //Salva a imagem com as medições
                plotLogs();
                img_dt = img.substring(0, img.length()-4) + "_dt.jpg";
                bitmap.compress(Bitmap.CompressFormat.JPEG, 30,
                        new FileOutputStream(new File(img_dt)));

//            //Desconta uma unidade dos créditos disponíveis
//            UserDAO userDAO = new UserDAO(getApplicationContext());
//            List<User> userList = userDAO.get();
//            int creditos = Integer.parseInt(userList.get(0).getCredits());
//            creditos = creditos-1;
//
//            //Atualiza o valor dos créditos no banco de dados
//            User user = new User();
//            user.setCredits(String.valueOf(creditos));
//            user.setUuid(userDAO.get().get(0).getUuid());
//            userDAO.update(user);

                Log.i("Saving","Images saved successfully");
            } catch (FileNotFoundException e) {
                Log.e("Saving","files not found, output: "+e.getMessage());
            }
        }
    }

    public Rect getScreenSize() {
        Rect displayRectangle = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(displayRectangle);
        return displayRectangle;
    }

    private void getCSV() {
        String csvName = "";
        if (img_dt.substring(img_dt.length()-6).equals("dt.jpg") &&
                !img_dt.substring(img_dt.length()-14).equals("mosaico_dt.jpg"))
            csvName = img_dt.substring(0,img_dt.length()-7)+".csv";
        else csvName = img_dt.substring(0,img_dt.length()-15)+".csv";

        CSV csv = new CSV(translator,
                calculos,
                csvName,
                new String[]{diameterUnit,lengthUnit,volumeUnit},
                pixelsFactor,
                logsView.getDiametro_draw(),
                logsView.getVolume_draw());

        csv.delegate = this;
        csv.execute();
    }

    private void openDQPL(String img_dt, double[] coordinates) {
        DebenuPDFLibraryCPAndroidJava1711 mDQPL = new DebenuPDFLibraryCPAndroidJava1711();
        String key = "jg3tj5k93pb65n6f534t3ut3y";
        mUnlocked = mDQPL.UnlockKey(key);

        if (mUnlocked != 0){
            getLogsReport(mDQPL, img_dt, coordinates);
            Log.i("DQPL", "unlocked: " + mUnlocked);
        } else {
            others.showToast(getApplicationContext(),"ERROR: Could not create PDF");
            Log.i("DQPL", "ERROR: Could not open DQPL");
        }
    }

    private void closeDQPL() {

    }

    private void getLogsReport(DebenuPDFLibraryCPAndroidJava1711 mDQPL, String img_dt,
                               double[] coordinates) {

        String relatorioNome;
        if (img_dt.substring(img_dt.length()-6).equals("dt.jpg") &&
                !img_dt.substring(img_dt.length()-8).equals("s_dt.jpg"))
            relatorioNome = img_dt.substring(0,img_dt.length()-7)+".pdf";
        else relatorioNome = img_dt.substring(0,img_dt.length()-9)+".pdf";

        //Substitui pelos dados da imagem capturada se for o caso
        if (!getIntent().getStringExtra("fromGallery").equals("true")){
            datahora[0] = getIntent().getStringExtra("data");
            datahora[1] = getIntent().getStringExtra("hora");
        }

        UserDAO userDAO = new UserDAO(getApplicationContext());

        //REPORT VARIABLES
        Report report = new Report(translator,
                datahora,
                coordinates,
                pixelsFactor,
                new String[]{diameterUnit, lengthUnit, volumeUnit},
                mDQPL,
                relatorioNome,
                img_dt,
                logsView.getDiametro_draw(),
                logsView.getVolume_draw(),
                volumeFormula,
                logsLength,
                logsView.getLabel_draw(),
                destination,
                spatialRef,
                userDAO.get().get(0));

        buttonNext.setImageResource(R.drawable.ic_save_on);

        report.delegate = this;
        report.execute();

        Log.i("Report","Generating report");
    }

    @Override
    public void onDetectFinish(List<Classifier.Recognition> output) {
        logs = output;
    }

    @Override
    public void onCSVfinish(String output) {
        if (output.equals("success"))Log.i("CSV", " successfully generated");
        else Log.i("CSV", " "+output);
    }

    @Override
    public void onReportFinish(String output) {
        if (output.equals("success")){
            others.showToast(getApplicationContext(),translator.Finished());
            startActivity(new Intent(getApplicationContext(), MenuActivity.class));
        }
    }
}
