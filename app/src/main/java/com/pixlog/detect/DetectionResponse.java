package com.pixlog.detect;

import com.pixlog.detect.tflite.Classifier;

import java.util.List;

public interface DetectionResponse {
    void onDetectFinish(List<Classifier.Recognition> output);
}