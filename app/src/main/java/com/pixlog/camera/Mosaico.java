
package com.pixlog.camera;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.pixlog.R;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.calib3d.Calib3d;
import org.opencv.core.DMatch;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.features2d.BFMatcher;
import org.opencv.features2d.ORB;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Mosaico extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2, SensorEventListener {

    CameraBridgeViewBase cameraBridgeViewBase;
    BaseLoaderCallback baseLoaderCallback;
    ORB orb;
    private boolean isOrb = false;
    private static final int REQUEST_PERMISSION = 100;

    MatOfKeyPoint keypoints1,keypoints2;
    BFMatcher bf;
    Mat descriptors1,descriptors2, img1, img2, img1_color, img2_color, cropped_image, cropped_image_color, H, Homog;
    private boolean press = false;
    private boolean press2 = false;
    private Bitmap bitmap, bitmap_color, output;
    private ImageView imageView;
    private int counter = 0;
    private int cols, rows, colsDiv, rowsDiv;
    Scalar RED = new Scalar(255, 0, 0);
    Scalar GREEN = new Scalar(0, 255, 0);
    private SensorManager sensorManager;
    private Sensor sensor;
    float prev = 0, novo = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_mosaico);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION);
        }


        imageView = findViewById(R.id.imageView);
        cameraBridgeViewBase = findViewById(R.id.CameraView);
        cameraBridgeViewBase.setVisibility(SurfaceView.VISIBLE);
        cameraBridgeViewBase.setCvCameraViewListener(this);

        baseLoaderCallback = new BaseLoaderCallback(this) {
            @Override
            public void onManagerConnected(int status) {
                super.onManagerConnected(status);

                switch(status){

                    case BaseLoaderCallback.SUCCESS:
                        cameraBridgeViewBase.enableView();
                        break;
                    default:
                        super.onManagerConnected(status);
                        break;
                }
            }
        };


        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press = true;
                counter++;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press2 = true;
            }
        });


    }


    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        if(!isOrb){
            orb = ORB.create();
            isOrb = true;
        }


        Mat frame = inputFrame.rgba();
        Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGBA2GRAY);



        if(press && counter == 1)
        {
            press = false;
            detectComputeKP(frame, inputFrame.rgba());
        }





        if(img1 != null && counter != 0)
        {

            //ORB DETECT AND COMPUTE 2
            keypoints2 = new MatOfKeyPoint();
            descriptors2 = new Mat();


            orb.detect(frame, keypoints2);
            orb.compute(frame, keypoints2, descriptors2);

            bf = new BFMatcher();

            List<MatOfDMatch> matches = new ArrayList<>();



            try{
                bf.knnMatch(descriptors1, descriptors2, matches, 2);
            }catch (Exception e){
                return frame;
            }





            LinkedList<DMatch> good_matches = new LinkedList<>();


            for (MatOfDMatch match : matches ) {
                try{
                    if(match.toArray()[0].distance < 0.9 * match.toArray()[1].distance){
                        good_matches.add(match.toArray()[0]);
                    }
                }catch(Exception e){
                        return frame;
                }
            }



            List<Point> pts1 = new ArrayList<>();
            List<Point> pts2 = new ArrayList<>();
            for(int i = 0; i<good_matches.size(); i++){
                pts1.add(keypoints1.toList().get(good_matches.get(i).queryIdx).pt);
                pts2.add(keypoints2.toList().get(good_matches.get(i).trainIdx).pt);
            }



            Mat outputMask = new Mat();
            MatOfPoint2f pts1Mat = new MatOfPoint2f();
            pts1Mat.fromList(pts1);
            MatOfPoint2f pts2Mat = new MatOfPoint2f();
            pts2Mat.fromList(pts2);


            //ESQUERDA PARA A DIREITA
            try{
                H = Calib3d.findHomography(pts2Mat, pts1Mat, Calib3d.RANSAC, 15, outputMask, 2000, 0.995);
            }catch(Exception e){
                return frame;
            }

            //H = Calib3d.findHomography(pts2Mat, pts1Mat, Calib3d.RANSAC, 1);

            //DIREITA PARA A ESQUERDA
            //Homog = Calib3d.findHomography(pts1Mat, pts2Mat, Calib3d.RANSAC, 15, outputMask, 2000, 0.995);



            LinkedList<DMatch> better_matches = new LinkedList<>();
            for (int i = 0; i < good_matches.size(); i++) {
                if (outputMask.get(i, 0)[0] != 0.0) {
                    better_matches.add(good_matches.get(i));
                }
            }


            Log.d("matchez","matchez: "+ better_matches.size());



            if(press && counter > 1 && better_matches.size() > 30){

                press = false;

                //IMG 2 GRAY
                img2 = new Mat();
                bitmap = Bitmap.createBitmap(frame.cols(), frame.rows(), Bitmap.Config.RGB_565);
                Utils.matToBitmap(frame, bitmap);
                Utils.bitmapToMat(bitmap, img2);

                //IMG 2 RGB
                img2_color = new Mat();
                bitmap_color = Bitmap.createBitmap(inputFrame.rgba().cols(), inputFrame.rgba().rows(), Bitmap.Config.RGB_565);
                Utils.matToBitmap(inputFrame.rgba(), bitmap_color);
                Utils.bitmapToMat(bitmap_color, img2_color);

                Mat outputImg = new Mat();
                Mat outputImg_color = new Mat();


//                MatOfDMatch better_matches_mat = new MatOfDMatch();
//                better_matches_mat.fromList(better_matches);

                //MatOfByte drawnMatches = new MatOfByte();

                //Features2d.drawMatches(img1, keypoints1, img2, keypoints2, better_matches_mat, outputImg, GREEN, RED, drawnMatches, Features2d.DrawMatchesFlags_NOT_DRAW_SINGLE_POINTS);


               //ESQUERDA PARA A DIREITA
                Imgproc.warpPerspective(img2_color, outputImg_color, H, new Size(img1_color.cols() + img2_color.cols(), img2_color.rows()));
                Mat half_color = new Mat(outputImg_color, new Rect(0, 0, img1_color.cols(), img1_color.rows()));
                img1_color.copyTo(half_color);

                Imgproc.warpPerspective(img2, outputImg, H, new Size(img1.cols() + img2.cols(), img2.rows()));
                Mat half = new Mat(outputImg, new Rect(0, 0, img1.cols(), img1.rows()));
                img1.copyTo(half);



//                DIREITA PARA A ESQUERDA
//                Imgproc.warpPerspective(img1_color, outputImg_color, Homog, new Size(img2_color.cols() + img1_color.cols(), img1_color.rows()));
//                Mat half = new Mat(outputImg_color, new Rect(0, 0, img2_color.cols(), img2_color.rows()));
//                img2_color.copyTo(half);

//                Imgproc.warpPerspective(img1, outputImg, Homog, new Size(img2.cols() + img1.cols(), img1.rows()));
//                Mat half = new Mat(outputImg, new Rect(0, 0, img2.cols(), img2.rows()));
//                img2.copyTo(half);




                cropped_image = cropImage(outputImg, outputImg_color)[0];
                cropped_image_color = cropImage(outputImg, outputImg_color)[1];

                detectComputeKP(cropped_image, cropped_image_color);


                output = Bitmap.createBitmap(cols, rows, Bitmap.Config.RGB_565);
                Utils.matToBitmap(cropped_image_color, output);


            }

        }


        if(press2) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageBitmap(output);
                }
            });
        }


        return frame;


    }



    @Override
    public void onCameraViewStarted(int width, int height) {
    }

    @Override
    public void onCameraViewStopped() {
    }


    @Override
    protected void onResume() {
        super.onResume();

        if (!OpenCVLoader.initDebug()){
            Toast.makeText(getApplicationContext(),"There's a problem, yo!", Toast.LENGTH_SHORT).show();
        }

        else
        {
            baseLoaderCallback.onManagerConnected(baseLoaderCallback.SUCCESS);
        }

        if (sensor != null) {
            sensorManager.registerListener(this, sensor,
                    SensorManager.SENSOR_DELAY_FASTEST);
        }



    }

    @Override
    protected void onPause() {
        super.onPause();
        if(cameraBridgeViewBase!=null){
            cameraBridgeViewBase.disableView();
        }
        sensorManager.unregisterListener(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cameraBridgeViewBase!=null){
            cameraBridgeViewBase.disableView();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        float value0 = event.values[0]; //y
        float value1 = event.values[1]; //x
        float value2 = event.values[2]; //z

        if (sensorType == Sensor.TYPE_LINEAR_ACCELERATION) {

//            prev = value;
//            novo = novo + prev;


            Log.d("movimentacao","movimentacao: "+ value0 + "    " + value1 + "     " + value2);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private void detectComputeKP(Mat matrix, Mat src_matrix){


        //ORB DETECT AND COMPUTE 1
        keypoints1 = new MatOfKeyPoint();
        descriptors1 = new Mat();
        orb.detect(matrix, keypoints1);
        orb.compute(matrix, keypoints1, descriptors1);


        //IMG 1 GRAY
        img1 = new Mat();
        bitmap = Bitmap.createBitmap(matrix.cols(), matrix.rows(), Bitmap.Config.RGB_565);
        Utils.matToBitmap(matrix, bitmap);
        Utils.bitmapToMat(bitmap, img1);

        //IMG 1 RGB
        img1_color = new Mat();
        bitmap_color = Bitmap.createBitmap(src_matrix.cols(), src_matrix.rows(), Bitmap.Config.RGB_565);
        Utils.matToBitmap(src_matrix, bitmap_color);
        Utils.bitmapToMat(bitmap_color, img1_color);

    }



    private Mat[] cropImage(Mat matrix, Mat color_matrix){


        rows = color_matrix.rows(); //Calculates number of rows
        cols = color_matrix.cols(); //Calculates number of columns
        rowsDiv = rows/2;
        colsDiv = cols/2;
        int ch = color_matrix.channels(); //Calculates number of channels (Grayscale: 1, RGB: 3, etc.)

        for (int i=colsDiv; i<cols; i++)
        {
            int counter = 0;

            for (int j=rowsDiv; j<rows; j++)
            {

                double[] data = color_matrix.get(j, i); //Stores element in an array

                for (int k = 0; k < ch; k++) //Runs for the available number of channels
                {
                    if(data[k] == 0){
                        counter++;
                    }
                    else{
                        counter = 0;
                    }
                }
            }

            if(counter > color_matrix.height()/8){
                cols = i;
                Rect rectCrop = new Rect(0, 0, cols, rows);
                cropped_image_color = new Mat(color_matrix, rectCrop);
                cropped_image = new Mat(matrix, rectCrop);
                break;
            }

        }

        Mat[] matList;
        matList = new Mat[]{cropped_image, cropped_image_color};



        return matList;

    }





}