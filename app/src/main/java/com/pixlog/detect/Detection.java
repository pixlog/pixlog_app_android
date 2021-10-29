package com.pixlog.detect;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import com.pixlog.detect.tflite.Classifier;

import java.util.List;

public class Detection
        extends AsyncTask<Void, Void, List<Classifier.Recognition>> {

    public DetectionResponse delegate = null;

    private Classifier detector;
    private Bitmap sbit;

    public Detection(Classifier detector, Bitmap sbit) {
        this.detector = detector;
        this.sbit = sbit;
    }

    @Override
    protected List<Classifier.Recognition> doInBackground(Void... voids) {
        List<Classifier.Recognition> results = detector.recognizeImage(sbit);
        return results;
    }

    @Override
    protected void onPostExecute(List<Classifier.Recognition> recognitions) {
        delegate.onDetectFinish(recognitions);
        Log.i("Detection", "Success!");
    }
}
