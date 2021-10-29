package com.pixlog.detect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;

import java.util.ArrayList;

public class LogsView
        extends AppCompatImageView
        implements View.OnTouchListener {



    public LogsView(Context context, AttributeSet attr) {
        super(context, attr);
        this.mContext = context;
        initialize();
    }

    public LogsView(Context context) {
        super(context);
        this.mContext = context;
        initialize();
    }

    public LogsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }



    /*
    IMAGE ZOOM IN AND OUT
     */
    private PointF zoomPos;
    private boolean zooming = false;
    private Matrix matrix;
    private BitmapShader shader;
    private Bitmap bitmap;
    private boolean comecou = false;



    private float lastTouchX, lastTouchY,
            MAX_SCALE = 2f, mScale, mMinScale,
            STROKE_WIDTH = 10f;

    private Context mContext;

    private Matrix mMatrix;
    private final float[] mMatrixValues = new float[9];

    private int mWidth, mHeight, // Display width and height
            mIntrinsicWidth, mIntrinsicHeight, //Image original width and height
            mPrevMoveX, mPrevMoveY;

    public int imageheight, imagewidth;

    private double mPrevDistance;
    private boolean isScaling;

    private GestureDetector mDetector;

    Paint paint = new Paint();
    public static Path path = new Path();

    /*
    LOGS DRAWING
     */
    private boolean showLogs = false;
    private Integer totalRange, formulaVolume;
    private Double comprimentoToras, volumeRange, fatorPixels; //converte de pixels para metros ou pés
    private ArrayList<Double> cx = new ArrayList<>(),
            cy = new ArrayList<>(),
            r = new ArrayList<>(),
            conf = new ArrayList<>();
    private ArrayList<String> label = new ArrayList<>();
    private ArrayList<Double> cx_draw = new ArrayList<>(),
            cy_draw =  new ArrayList<>(),
            r_draw = new ArrayList<>(),
            conf_draw = new ArrayList<>(),
            diametro_draw = new ArrayList<>(),
            volume_draw = new ArrayList<>();
    private ArrayList<String> label_draw = new ArrayList<>();
    private ArrayList<Boolean> inside = new ArrayList<>();
    private Paint logPaint = new Paint(),
            textPaint = new Paint(),
            invPaint = new Paint(),
            borderPaint = new Paint();
    private Calculos calculos = new Calculos();

    public Integer getTotalRange() {
        return totalRange+1;
    }

    public Double getVolumeRange() {
        return volumeRange;
    }

    public void setShowLogs(boolean showLogs) {
        this.showLogs = showLogs;

        logPaint.setStyle(Paint.Style.STROKE); //apenas a circunferência
        logPaint.setStrokeWidth(4); //espessura do traço
        logPaint.setColor(Color.GREEN); //cor da tora detectada
    }

    public ArrayList<Double> getCx() {
        return cx;
    }

    public void setCx(ArrayList<Double> cx) {
        this.cx = cx;
    }

    public ArrayList<Double> getCy() {
        return cy;
    }

    public void setCy(ArrayList<Double> cy) {
        this.cy = cy;
    }

    public ArrayList<Double> getR() {
        return r;
    }

    public void setR(ArrayList<Double> r) {
        this.r = r;
    }

    public ArrayList<Boolean> getInside() {
        return inside;
    }

    public void setInside(ArrayList<Boolean> inside) {
        this.inside = inside;
    }

    public ArrayList<Double> getConf() {
        return conf;
    }

    public void setConf(ArrayList<Double> conf) {
        this.conf = conf;
    }

    public ArrayList<String> getLabel() {
        return label;
    }

    public void setLabel(ArrayList<String> label) {
        this.label = label;
    }

    public ArrayList<Double> getCx_draw() {
        return cx_draw;
    }

    public ArrayList<Double> getCy_draw() {
        return cy_draw;
    }

    public ArrayList<Double> getR_draw() {
        return r_draw;
    }

    public ArrayList<String> getLabel_draw() {
        return label_draw;
    }

    public ArrayList<Double> getDiametro_draw() {
        return diametro_draw;
    }

    public ArrayList<Double> getVolume_draw() {
        return volume_draw;
    }

    public void setComprimentoToras(Double comprimentoToras) {
        this.comprimentoToras = comprimentoToras;
    }

    public void setFatorPixels(Double fatorPixels) {
        this.fatorPixels = fatorPixels;
    }

    public void setFormulaVolume(Integer formulaVolume) {
        this.formulaVolume = formulaVolume;
    }

    /*
        SPATIAL REFERENCE TOOL
     */
    private boolean spatial = false;
    private float[] startXY = new float[2], endXY = new float[2];
    private Paint circlePaint = new Paint(), linePaint = new Paint();
    private float toolRadius = 180;

    public void setSpatial(boolean spatial) {
        this.spatial = spatial;

        Drawable d = getDrawable();
        if (d != null){
            float w = d.getIntrinsicWidth(), h = d.getIntrinsicHeight();

            startXY = new float[]{w/2,h/4};
            endXY = new float[]{w/2,3*h/4};
        }

        circlePaint.setColor(getContext().getResources().getColor(android.R.color.holo_green_light));
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(8);

        linePaint.setColor(getContext().getResources().getColor(android.R.color.holo_green_light));
        linePaint.setStrokeWidth(8);
    }

    public boolean isComecou() {
        return comecou;
    }

    public boolean isSpatial() {
        return spatial;
    }

    public float[] getStartXY() {
        return startXY;
    }

    public float[] getEndXY() {
        return endXY;
    }

    /*
    REGION OF INTEREST
     */
    private boolean roi = false;
    private ArrayList<double[]> hullPoints = new ArrayList<>();
    private Paint vertexPaint = new Paint(), outlinePaint = new Paint();
    private float vertexRadius = 40;

    public boolean isRoi() {
        return roi;
    }

    public void setRoi(boolean roi) {
        this.roi = roi;

        vertexPaint.setColor(Color.WHITE);
        vertexPaint.setStyle(Paint.Style.STROKE);
        vertexPaint.setStrokeWidth(8f);

        outlinePaint.setColor(Color.GREEN);
        outlinePaint.setStyle(Paint.Style.STROKE);
        outlinePaint.setStrokeWidth(8f);
    }

    public void setHullPoints(ArrayList<double[]> hullPoints) {
        this.hullPoints = hullPoints;
    }

    /*
    EDIT LOGS
     */
    private boolean editing = false, isAdding = false, isRemoving = false;
    private float[] xy_cc = new float[2];
    private float editRadius = 180;
    private Paint newLogPaint = new Paint();

    public boolean isAdding() {
        return isAdding;
    }

    public void setAdding(boolean adding) {
        isAdding = adding;
    }

    public boolean isRemoving() {
        return isRemoving;
    }

    public void setRemoving(boolean removing) {
        isRemoving = removing;
    }

    public boolean isEditing() {
        return editing;
    }

    public float[] getXY_cc() {
        return xy_cc;
    }

    public void setXY_cc(float[] xy_cc) {
        this.xy_cc = xy_cc;
    }

    public float getEditRadius() {
        return editRadius/getScale();
    }

    public void setEditing(boolean editing) {
        this.editing = editing;

        Drawable d = getDrawable();
        if (d != null){
            float w = d.getIntrinsicWidth()/2;
            float h = d.getIntrinsicHeight()/2;
            xy_cc = new float[]{w,h};
        }

        newLogPaint.setColor(Color.GREEN);
        newLogPaint.setStyle(Paint.Style.STROKE);
        newLogPaint.setStrokeWidth(5);
        newLogPaint.setPathEffect(new DashPathEffect(new float[] {20,40}, 0));
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        this.initialize();
    }


    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        this.initialize();
    }

    private void initialize() {
        this.setScaleType(ScaleType.MATRIX);
        this.mMatrix = new Matrix();
        zoomPos = new PointF(0, 0);
        matrix = new Matrix();
        Drawable d = getDrawable();

        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(STROKE_WIDTH);

        if (d != null) {
            mIntrinsicWidth = d.getIntrinsicWidth();
            mIntrinsicHeight = d.getIntrinsicHeight();
            setOnTouchListener(this);
        }

        mDetector = new GestureDetector(mContext,
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onDoubleTap(MotionEvent e) {
                        maxZoomTo((int) e.getX(), (int) e.getY());
                        cutting();
                        return super.onDoubleTap(e);
                    }
                });
    }

    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        mWidth = r - l;
        mHeight = b - t;


        mMatrix.reset();

        int r_norm = r - l;
        mScale = (float) r_norm / (float) mIntrinsicWidth;

        int paddingHeight = 0;
        int paddingWidth = 0;

        if (mScale * mIntrinsicHeight > mHeight) { // scaling vertical
            mScale = (float) mHeight / (float) mIntrinsicHeight;

            mMatrix.postScale(mScale, mScale);

            paddingWidth = (r - mWidth) / 2;
            paddingHeight = 0;

        } else { // scaling horizontal
            mMatrix.postScale(mScale, mScale);

            paddingHeight = (b - mHeight) / 2;
            paddingWidth = 0;
        }
        mMatrix.postTranslate(paddingWidth, paddingHeight);

        setImageMatrix(mMatrix);
        mMinScale = mScale;
        zoomTo(mScale, mWidth / 2, mHeight / 2);
        cutting();

        return super.setFrame(l, t, r, b);
    }

    protected float getValue(Matrix matrix, int whichValue) {
        matrix.getValues(mMatrixValues);
        return mMatrixValues[whichValue];
    }

    protected float getScale() {
        return getValue(mMatrix, Matrix.MSCALE_X);
    }

    public float getTranslateX() {
        return getValue(mMatrix, Matrix.MTRANS_X);
    }

    protected float getTranslateY() {
        return getValue(mMatrix, Matrix.MTRANS_Y);
    }

    protected void maxZoomTo(int x, int y) {
        if (mMinScale != getScale() && (getScale() - mMinScale) > 0.1f) {
            // threshold 0.1f
            float scale = mMinScale / getScale();
            zoomTo(scale, x, y);
        } else {
            float scale = MAX_SCALE / getScale();
            zoomTo(scale, x, y);
        }
    }

    public void zoomTo(float scale, int x, int y) {
        if (getScale() * scale < mMinScale) {
            return;
        }
        if (scale >= 1 && getScale() * scale > MAX_SCALE) {
            return;
        }
        mMatrix.postScale(scale, scale);

        // move to center
        mMatrix.postTranslate(-(mWidth * scale - mWidth) / 2,
                -(mHeight * scale - mHeight) / 2);

        // move x and y distance
        mMatrix.postTranslate(-(x - (mWidth / 2)) * scale, 0);
        mMatrix.postTranslate(0, -(y - (mHeight / 2)) * scale);
        setImageMatrix(mMatrix);
    }

    public void cutting() {
        int width = (int) (mIntrinsicWidth * getScale()),
                height = (int) (mIntrinsicHeight * getScale());

        imagewidth = width;
        imageheight = height;

        if (getTranslateX() < -(width - mWidth))
            mMatrix.postTranslate(-(getTranslateX() + width - mWidth), 0);
        if (getTranslateX() > 0)
            mMatrix.postTranslate(-getTranslateX(), 0);
        if (getTranslateY() < -(height - mHeight))
            mMatrix.postTranslate(0, -(getTranslateY() + height - mHeight));
        if (getTranslateY() > 0)
            mMatrix.postTranslate(0, -getTranslateY());
        if (width < mWidth)
            mMatrix.postTranslate((mWidth - width) / 2, 0);
        if (height < mHeight)
            mMatrix.postTranslate(0, (mHeight - height) / 2);

        setImageMatrix(mMatrix);
    }

    private double distance(float x0, float x1, float y0, float y1) {
        float x = x0 - x1;
        float y = y0 - y1;
        return Math.sqrt(x * x + y * y);
    }

    private double dispDistance() {
        return Math.sqrt(mWidth * mWidth + mHeight * mHeight);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mDetector.onTouchEvent(event)) return true;

        int touchCount = event.getPointerCount();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_1_DOWN:
            case MotionEvent.ACTION_POINTER_2_DOWN:

                if (touchCount >= 2) {
                    double distance = distance(event.getX(0), event.getX(1),
                            event.getY(0), event.getY(1));
                    mPrevDistance = distance;
                    isScaling = true;
                } else {
                    mPrevMoveX = (int) event.getX();
                    mPrevMoveY = (int) event.getY();
                }

            case MotionEvent.ACTION_MOVE:

                if (touchCount >= 2 && isScaling) { //zoom na imagem
                    double dist = distance(event.getX(0),
                            event.getX(1),
                            event.getY(0),
                            event.getY(1));
                    double scale = (dist - mPrevDistance)/dispDistance();
                    mPrevDistance = dist;
                    scale += 1;
                    scale = scale * scale;
                    zoomTo((float) scale, mWidth / 2, mHeight / 2);
                    cutting();
                } else if (!isScaling) { //translações

                    int distanceX = mPrevMoveX - (int) event.getX(),
                            distanceY = mPrevMoveY - (int) event.getY();
                    mPrevMoveX = (int) event.getX();
                    mPrevMoveY = (int) event.getY();

                    if (spatial && insideSpatialReference(event.getX(), event.getY())) {
                        //translação na ferramenta espacial
                        Log.i("Spatial reference", "Moving it");
                    } else if (roi && insidePolygonVertex(event.getX(), event.getY())){
                        //translação no polígono envoltório
                        Log.i("Convex hull", "moving it");
                    } else if (editing && insideEditionCircle(event.getX(), event.getY())){
                        //translação no circulo de add ou remove
                        Log.i("Edition circle", "moving it");
                    } else {
                        //translação na imagem
                        mMatrix.postTranslate(-distanceX, -distanceY);
                        cutting();
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_POINTER_2_UP:
                if (event.getPointerCount() <= 1) isScaling = false;
                break;
        }

        return true;
    }

    private boolean insideSpatialReference(float x, float y) {
        boolean isInside = false;

        float newX = (x-getTranslateX())/getScale(),
                newY = (y-getTranslateY())/getScale(),
                newR = toolRadius/getScale();

        if (Math.pow(newX-startXY[0],2) + Math.pow(newY-startXY[1],2) <= Math.pow(newR,2)) {
            isInside = true;
            startXY = new float[]{newX, newY};
            invalidate();
        }
        else if (Math.pow(newX-endXY[0],2) + Math.pow(newY-endXY[1],2) <= Math.pow(newR,2)) {
            isInside = true;
            endXY = new float[]{newX, newY};
            invalidate();
        }

        return isInside;
    }

    private boolean insidePolygonVertex(float x, float y) {
        boolean isInside = false;

        float newX = (x-getTranslateX())/getScale(),
                newY = (y-getTranslateY())/getScale(),
                newR = vertexRadius/getScale();

        for (int i = 0; i < hullPoints.size(); i++){
            if (Math.pow(newX-hullPoints.get(i)[0],2) + Math.pow(newY-hullPoints.get(i)[1],2) <= Math.pow(newR,2)){
                isInside = true;
                hullPoints.set(i,new double[]{newX, newY});
                invalidate();
                break;
            }
        }

        return isInside;
    }

    private boolean insideEditionCircle(float x, float y) {
        boolean isInside = false;

        float newX = (x-getTranslateX())/getScale(),
                newY = (y-getTranslateY())/getScale(),
                newR = editRadius/getScale();

        if (isAdding){
            if (Math.pow(newX-xy_cc[0],2)+Math.pow(newY-xy_cc[1],2) <= Math.pow(newR,2)){
                isInside = true;
                xy_cc = new float[]{newX, newY};
                isAdding = true;
                invalidate();
            }
        }else if (isRemoving){
            for (int i = 0; i < r.size(); i++){
                if (Math.pow(newX-cx.get(i),2)+Math.pow(newY-cy.get(i),2) <= Math.pow(r.get(i),2)){
                    isInside = true;
                    xy_cc = new float[]{cx.get(i).floatValue(),cy.get(i).floatValue()};
                    editRadius = r.get(i).floatValue();
                    cx.remove(i);
                    cy.remove(i);
                    r.remove(i);
                    inside.remove(i);
                    conf.remove(i);
                    label.remove(i);
                    isRemoving = false;
                    isAdding = true;
                    invalidate();
                    break;
                }
            }
        }

        return isInside;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (showLogs) drawCircles(canvas);

        if (spatial) drawSpatialTool(canvas);
        else if (roi) drawRoiPolygon(canvas);
        else if (editing) drawOrRemoveLogs(canvas);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return super.onTouchEvent(event);
    }



    private void drawSpatialTool(Canvas canvas) {
        canvas.drawCircle(startXY[0]*getScale()+getTranslateX(),
                startXY[1]*getScale()+getTranslateY(),
                toolRadius*getScale(),
                circlePaint);
        canvas.drawLine(startXY[0]*getScale()+getTranslateX(),
                startXY[1]*getScale()+getTranslateY(),
                endXY[0]*getScale()+getTranslateX(),
                endXY[1]*getScale()+getTranslateY(),
                linePaint);
        canvas.drawCircle(endXY[0]*getScale()+getTranslateX(),
                endXY[1]*getScale()+getTranslateY(),
                toolRadius*getScale(),
                circlePaint);
    }

    private void drawRoiPolygon(Canvas canvas) {

        for (int i = 0; i < hullPoints.size(); i++) {
            float x0 = (float) hullPoints.get(i)[0],
                    y0 = (float) hullPoints.get(i)[1];

            if ((i + 1) == hullPoints.size()) {
                float x1 = (float) hullPoints.get(0)[0],
                        y1 = (float) hullPoints.get(0)[1];
                canvas.drawLine(x0*getScale()+getTranslateX(),
                        y0*getScale()+getTranslateY(),
                        x1*getScale()+getTranslateX(),
                        y1*getScale()+getTranslateY(),
                        outlinePaint);
            } else {
                float x1 = (float) hullPoints.get(i + 1)[0],
                        y1 = (float) hullPoints.get(i + 1)[1];
                canvas.drawLine(x0*getScale()+getTranslateX(),
                        y0*getScale()+getTranslateY(),
                        x1*getScale()+getTranslateX(),
                        y1*getScale()+getTranslateY(),
                        outlinePaint);
            }
            canvas.drawCircle(x0*getScale()+getTranslateX(),
                    y0*getScale()+getTranslateY(),
                    vertexRadius*getScale(),
                    vertexPaint);
        }
    }

    private void drawOrRemoveLogs(Canvas canvas) {
        if (isAdding)
            canvas.drawCircle(xy_cc[0]*getScale()+getTranslateX(),
                xy_cc[1]*getScale()+getTranslateY(),
                editRadius,
                newLogPaint);
    }

    private void drawCircles(Canvas canvas) {

        cx_draw = new ArrayList<>();
        cy_draw = new ArrayList<>();
        r_draw = new ArrayList<>();
        conf_draw = new ArrayList<>();
        label_draw = new ArrayList<>();

        for(int number = 0, count = 0; number < r.size(); number++){

            if (inside.get(number)
                    && isInsideHull(cx.get(number), cy.get(number), r.get(number))){

                cx_draw.add(cx.get(number));
                cy_draw.add(cy.get(number));
                r_draw.add(r.get(number));
                conf_draw.add(conf.get(number));
                label_draw.add(label.get(number));

                //Paint para o texto
                textPaint.setTextSize(r.get(number).floatValue());
                textPaint.setColor(Color.BLACK); //cor do texto

                //Paint para a borda do texto
                borderPaint.setStyle(Paint.Style.FILL);
                borderPaint.setColor(Color.WHITE);




//                //Calcula as dimensões do texto
//                Rect textBounds = new Rect();
//                textPaint.getTextBounds(String.valueOf(count +1), 0, String.valueOf(count +1).length(), textBounds);
//                int[] txtHW = {textBounds.height(), textBounds.width()};
//
//                //Desenha a "borda"
//                canvas.drawRect((float)(cx_list.get(number)-0.6*txtHW[1]),
//                        (float)(cy_list.get(number)-0.7*txtHW[0]),
//                        (float)(cx_list.get(number)+0.7*txtHW[1]),
//                        (float)(cy_list.get(number)+0.7*txtHW[0]),
//                        borderPaint);
//
//                //Desenha o número da tora
//                canvas.drawText(String.valueOf(count +1),
//                        (float) (cx_list.get(number)-0.5*txtHW[1]),
//                        (float) (cy_list.get(number)+0.5*txtHW[0]),
//                        textPaint);



                if (label.get(number).equals("pinus"))
                    if (isRemoving){
                        canvas.drawCircle(cx.get(number).floatValue()*getScale()+getTranslateX(),
                                cy.get(number).floatValue()*getScale()+getTranslateY(),
                                r.get(number).floatValue()*getScale(),
                                newLogPaint);
                    }else {
                        canvas.drawCircle(cx.get(number).floatValue()*getScale()+getTranslateX(),
                                cy.get(number).floatValue()*getScale()+getTranslateY(),
                                r.get(number).floatValue()*getScale(),
                                logPaint);
                    }
                else if (label.get(number).equals("eucalyptus")) {
                    if (isRemoving){
                        newLogPaint.setColor(Color.RED);
                        canvas.drawCircle(cx.get(number).floatValue() * getScale() + getTranslateX(),
                                cy.get(number).floatValue() * getScale() + getTranslateY(),
                                r.get(number).floatValue() * getScale(),
                                newLogPaint);
                    }else {
                        logPaint.setColor(Color.rgb(255,255,0)); //LARANJA
                        canvas.drawCircle(cx.get(number).floatValue() * getScale() + getTranslateX(),
                                cy.get(number).floatValue() * getScale() + getTranslateY(),
                                r.get(number).floatValue() * getScale(),
                                logPaint);
                    }
                }
                count++;
            }

            totalRange = count;
        }

        diametro_draw = calculos.diamCalc(r_draw);
        volume_draw = calculos.volCalc(r_draw,comprimentoToras,fatorPixels,formulaVolume);

        volumeRange = sumArrayElements(volume_draw);
    }

    private boolean isInsideHull(Double cx, Double cy, Double r) {
        return calculos.polyCircle(hullPoints,cx,cy,r);
    }

    private Double sumArrayElements(ArrayList<Double> data) {
        double result = 0.0;
        for (int i = 0; i < data.size(); i++)
            result += data.get(i);
        return result;
    }

}
