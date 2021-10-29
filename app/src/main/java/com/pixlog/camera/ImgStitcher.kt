package com.pixlog.camera

import android.net.Uri
import android.util.Log

import org.bytedeco.javacpp.opencv_core.Mat
import org.bytedeco.javacpp.opencv_core.MatVector
import org.bytedeco.javacpp.opencv_core.Size
import org.bytedeco.javacpp.opencv_imgproc.resize
import org.bytedeco.javacpp.opencv_imgproc.INTER_LINEAR_EXACT
import org.bytedeco.javacpp.opencv_imgcodecs.imread
import org.bytedeco.javacpp.opencv_imgcodecs.imwrite
import org.bytedeco.javacpp.opencv_stitching.Stitcher
import org.bytedeco.javacpp.opencv_stitching.Stitcher.ERR_CAMERA_PARAMS_ADJUST_FAIL
import org.bytedeco.javacpp.opencv_stitching.Stitcher.ERR_HOMOGRAPHY_EST_FAIL
import org.bytedeco.javacpp.opencv_stitching.Stitcher.ERR_NEED_MORE_IMGS

import java.io.File

import io.reactivex.Single

import java.lang.Exception
import java.util.ArrayList

class StitcherInput(val uris: List<Uri>, val stitchMode: Int)

sealed class StitcherOutput {
    class Success(val file: File) : StitcherOutput()
    class Failure(val e: Exception) : StitcherOutput()
}

class ImageStitcher(private val fileUtil: FileUtil) {

    private val imagens = ArrayList<String>()

    fun stitchImages(input: StitcherInput): Single<StitcherOutput> {

        return Single.fromCallable {
            val files = fileUtil.urisToFiles(input.uris)
            var c = 0
            while (c < files.size){
                imagens.add(files[c].toString())
                c++
            }
            val vector = filesToMatVector(files)
            stitch(vector, input.stitchMode)
        }
    }

    private fun stitch(vector: MatVector, stitchMode: Int): StitcherOutput {
        val result = Mat()
        val stitcher = Stitcher.create(stitchMode)
        val status = stitcher.stitch(vector, result)

        return if (status == Stitcher.OK) {
            val resultFile = imagens[0].substring(0, imagens[0].length-4)+"_s.jpg"
            imwrite(resultFile, result)
            StitcherOutput.Success(File(resultFile))
        } else {
            val e = RuntimeException("IMAGE STITCHING ERROR: " + getStatusDescription(status))
            StitcherOutput.Failure(e)
        }
    }

    @Suppress("SpellCheckingInspection")
    private fun getStatusDescription(status: Int): String {
        return when (status) {
            ERR_NEED_MORE_IMGS -> "ERR_NEED_MORE_IMGS"
            ERR_HOMOGRAPHY_EST_FAIL -> "ERR_HOMOGRAPHY_EST_FAIL"
            ERR_CAMERA_PARAMS_ADJUST_FAIL -> "ERR_CAMERA_PARAMS_ADJUST_FAIL"
            else -> "UNKNOWN"
        }
    }

    private fun filesToMatVector(files: List<File>): MatVector {
        val images = MatVector(files.size.toLong())
        for (i in files.indices) {
            val img = imread(files[i].absolutePath)
            val imgResized = Mat()
            resize(img, imgResized, Size(),0.5,0.5, INTER_LINEAR_EXACT)
            images.put(i.toLong(), imgResized)
        }
        return images
    }
}
