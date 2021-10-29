package com.pixlog.camera

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.pixlog.*
import com.pixlog.R
import com.pixlog.R.drawable.*
import com.pixlog.detect.DetectionActivity
import com.quickbirdstudios.yuv2mat.Yuv
import kotlinx.android.synthetic.main.activity_xcamera.*
import org.bytedeco.javacpp.opencv_core
import org.bytedeco.javacpp.opencv_imgcodecs
import org.bytedeco.javacpp.opencv_imgproc
import org.bytedeco.javacpp.opencv_stitching
import org.opencv.android.BaseLoaderCallback
import org.opencv.android.LoaderCallbackInterface
import org.opencv.android.OpenCVLoader
import org.opencv.android.Utils
import org.opencv.calib3d.Calib3d
import org.opencv.core.*
import org.opencv.features2d.FlannBasedMatcher
import org.opencv.features2d.SIFT
import org.opencv.imgproc.Imgproc
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.collections.ArrayList


//typealias LumaListener = (luma: Double) -> Unit


class XCamera : AppCompatActivity(), SensorEventListener {


    //MOSAICO VARIABLES
    private lateinit var baseLoaderCallback: BaseLoaderCallback
//    private lateinit var orb: ORB
    private val fileUtil: FileUtil? = null
    private lateinit var orb: SIFT
    private var isOrb = false
    private var insideXY = false
    private var press = false
    private var press2 = false
    private var isFirst = true
    private var press_single = false
    private var imgBlackOk = false
    private var hasStarted = false
    private var counterStitch = 0
    private var counter = 0
    private var hasImg = false
    private lateinit var btm: Bitmap
    private val datahora = arrayOfNulls<String>(2)
    private var img_dt: String = ""
    private lateinit var keypoints1: MatOfKeyPoint
    private lateinit var keypoints2: MatOfKeyPoint
    private lateinit var keypointsLeft: MatOfKeyPoint
    private lateinit var keypointsRight: MatOfKeyPoint
    private lateinit var bf: FlannBasedMatcher
//    private lateinit var bf: BFMatcher
    private lateinit var descriptors1: Mat
    private lateinit var descriptors2: Mat
    private lateinit var inputMat: Mat
    private lateinit var descriptorsLeft: Mat
    private lateinit var descriptorsRight: Mat
    private var initialSize = 0
    private var img1: Mat? = null
    private var img2: Mat? = null
    private var X: Mat? = null
    private var img1CropLeft: Mat? = null
    private var img1CropRight: Mat? = null
    private lateinit var img1_color: Mat
    private lateinit var img2_color: Mat
    private lateinit var mat1CropLeft: Mat
    private lateinit var mat1CropRight: Mat
    private lateinit var H: Mat
    private lateinit var I: Mat
    private lateinit var Homog: Mat
    private lateinit var cropped_image: Mat
    private lateinit var cropped_image_color: Mat
    private lateinit var bitmap: Bitmap
    private lateinit var inputBitmap: Bitmap
    private lateinit var bitmap_color: Bitmap
    private lateinit var output: Bitmap
    private var cols: Int = 0
    private var rows: Int = 0
    private var x: Int = 0
    private var y: Int = 0
//    private var uri_imagens_finais = ArrayList<Uri>()


    private var imageCapture: ImageCapture? = null


    private lateinit var animation: Animation
    private val imagens = ArrayList<String>()
    private val imagensAux = ArrayList<String>()
    private var SINGLE_IMG = true
    private var IMG_STITCHING = false
    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService
    private val others = Others()
    private var translator = Translator()
    private var RESULT_LOAD_IMG = 103
    private lateinit var dataEnviar: String
    private lateinit var horaEnviar: String
    private lateinit var sensorManager: SensorManager

    private var upDown: Float = 0.0f



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContentView(R.layout.activity_xcamera)

        translator = others.setLang(Preferences(applicationContext))
        animation = AlphaAnimation(1.0f, 0.0f)



        baseLoaderCallback = object : BaseLoaderCallback(this) {
            override fun onManagerConnected(status: Int) {
                super.onManagerConnected(status)
                when (status) {
                    SUCCESS -> Log.i("success", "success")
                    else -> super.onManagerConnected(status)
                }
            }
        }


        // Request camera permissions
        if (allPermissionsGranted()) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
        }





        // Set up the listener for buttons
        singleImg.setOnClickListener{
            SINGLE_IMG = true
            IMG_STITCHING = false
            go2Stitching.visibility = View.INVISIBLE
            singleImg.setImageResource(ic_singleimg_on)
            imgStitching.setImageResource(ic_imgstitching_off)
            others.showToast(this , translator.SingleImgeOn())}

        imgStitching.setOnClickListener{
            SINGLE_IMG = false
            IMG_STITCHING = true
            go2Stitching.visibility = VISIBLE
            singleImg.setImageResource(ic_singleimg_off)
            imgStitching.setImageResource(ic_imgstitching_on)
            others.showToast(this, translator.ImgStitchingOn())
        }

        go2Stitching.setOnClickListener {
            if (!SINGLE_IMG && IMG_STITCHING) {
                if(counter > 1) {
                    Log.d("tamanhostitch","tamanhostitch: "+ imagens.size)

                    val intent = Intent(this, ImgStitchingActivity::class.java)
                    intent.putExtra("mosaico", "true")
                    intent.putStringArrayListExtra("lista_imagens_finais", imagens)
                    startActivity(intent)

                    //BITMAP COMPRESS
        //                press2 = true
                } else others.showToast(this, translator.PicsNotEnough())
            }
        }

        galleryImg.setOnClickListener{ startGallery("") }

        camera_capture_button.setOnClickListener {
//            if(hasStarted){
//                press = false
//            }
            if(upDown <= 2 && upDown > -1){
                if(SINGLE_IMG){
                    press_single = true
                }else if(IMG_STITCHING) {
                    if(img1 == null){
                        press = true
                    } else if(insideXY){
                        press = true
                    } else others.showToast(this, "Fora da area")

//                    enableAnimations(camera_capture_button)

                }

            } else others.showToast(this, translator.inclinacao())
        }

        back2Menu.setOnClickListener{ back2Menu() }

        outputDirectory = getOutputDirectory()
        createPileDir()
        cameraExecutor = Executors.newSingleThreadExecutor()
    }



    private fun getFoldersName(): String? {
        return intent.getStringExtra("folder")
    }

    private fun startGallery(path: String?) {
        if (path != "") {
            val foldersName = intent.getStringExtra("folder")

            val intent = Intent(this, DetectionActivity::class.java)
            intent.putExtra("imagem_unica", path)
            intent.putExtra("fromGallery", "true")
            intent.putExtra("correctPath", foldersName)
            startActivity(intent)


        } else {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, RESULT_LOAD_IMG)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (!(requestCode != RESULT_LOAD_IMG || resultCode != RESULT_OK || null == data)) {
            others.showToast(this, translator.OneMoment())

            // Get the Image from data
            val selectedImage = data.data


            val filePathColumn = Array(1) { MediaStore.Images.Media.DATA }


            // Get the cursor
            val cursor = selectedImage?.let { applicationContext.contentResolver.query(it, filePathColumn, null, null, null) }


            cursor?.moveToFirst()

            val columnIndex = cursor?.getColumnIndex(filePathColumn[0])
            val imgPath = columnIndex?.let { cursor.getString(it) }


            val foldersName = intent.getStringExtra("folder")

            if (null != imgPath) {
                val intent = Intent(this, DetectionActivity::class.java)
                intent.putExtra("imagem_unica",imgPath)
                intent.putExtra("fromGallery","true")
                intent.putExtra("correctPath",foldersName)
                startActivity(intent)
                cursor.close()


            }else others.showToast(this,translator.ErrorPickingImg())

        } else others.showToast(this,translator.NoImgPicked())
    }



    private fun takePhoto(matrix: Mat = Mat(), srcMatrix: Mat = Mat()) {
        // Get a stable reference of the modifiable image capture use case
        val imageCapture = imageCapture ?: return

        val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val dataHora = df.format(Calendar.getInstance().time)

        val a = dataHora.substring(0, 4)
        val me = dataHora.substring(5, 7)
        val d = dataHora.substring(8, 10)
        val h = dataHora.substring(11, 13)
        val mi = dataHora.substring(14, 16)
        val s = dataHora.substring(17, 19)

        dataEnviar = dataHora.substring(0, 10)
        horaEnviar = dataHora.substring(11, 19)

        val imgNome_final = a + me + d + "_" + h + mi + s


//        val photoFile = File(
//            outputDirectory,
//            SimpleDateFormat(FILENAME_FORMAT, Locale.US
//            ).format(System.currentTimeMillis()) + ".jpg")

        val photoFile = File(outputDirectory, "$imgNome_final.jpg")

        // Create output options object which contains file + metadata
        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

        // Set up image capture listener, which is triggered after photo has
        // been taken
        imageCapture.takePicture(
            outputOptions, ContextCompat.getMainExecutor(this), object : ImageCapture.OnImageSavedCallback {
                override fun onError(exc: ImageCaptureException) {
                    Log.e(TAG, "Photo capture failed: ${exc.message}", exc)
                }

                override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                    val savedUri = Uri.fromFile(photoFile)
                    val msg = "Photo capture succeeded"
//                    Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
                    Log.d(TAG, msg)
                    if (SINGLE_IMG && !IMG_STITCHING){ startGallery(photoFile.toString()) }
                    else if (!SINGLE_IMG && IMG_STITCHING){
                        if(isFirst){
                            isFirst = false
                            imagens.add(photoFile.toString())
                            imagensAux.add(photoFile.toString())
                            others.showToast(applicationContext,counter.toString() + " " + translator.Pics1() + " " + translator.Added(false))
                        }
                        else{

                            imagensAux.add(photoFile.toString())


                            val status = stitchImg()

                            if(status == 0){
                                imagens.add(photoFile.toString())
                                imagensAux.removeAt(0)
                                counter++
                                detectComputeKP(matrix, srcMatrix)
                                others.showToast(applicationContext, counter.toString() + " " + translator.Pics2() + " " + translator.Added(true))
                            } else {
                                imagensAux.removeAt(1)
                                others.showToast(applicationContext, "Errou")
                            }

                        }

                    }
                }
            })
    }


    @SuppressLint("UnsafeOptInUsageError")
    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener(Runnable {
            // Used to bind the lifecycle of cameras to the lifecycle owner
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            // Preview
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(viewFinder.surfaceProvider)
                }

            imageCapture = ImageCapture.Builder()
                .build()

            // Select back camera as a default
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            // Image Analysis
            val imageAnalysis = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()




//            imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(this), ImageAnalysis.Analyzer { image ->
            imageAnalysis.setAnalyzer(cameraExecutor, ImageAnalysis.Analyzer { image ->


                if(press_single){
                    press_single = false
                    takePhoto()
                }


                else if(IMG_STITCHING){

                    val totalWidth = viewFinder.width
                    Log.d("totalWidth","totalWidth: "+ totalWidth)

//                    orb = ORB.create() //250
                    orb = SIFT.create() //250

                    val frame: Mat = Yuv.rgb(image.image!!)

                    Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGBA2GRAY)



                    if (press && !hasImg) {
//                        hasStarted = true
                        press = false
                        hasImg = true


                        detectComputeKP(frame, Yuv.rgb(image.image!!))
                        counter++
                        takePhoto()
                        Log.d("numPics","numPics: "+ counter)


                    }


                    if (img1 != null && hasImg) {

                        //ORB DETECT AND COMPUTE 2
                        keypoints2 = MatOfKeyPoint()
                        descriptors2 = Mat()


                        val rows = frame.rows() //Calculates number of rows
                        val cols = frame.cols() //Calculates number of columns
//                        val rectCrop = Rect(0, 0, (cols/2 - cols/10), rows)
                        val rectCrop = Rect(0, 0, cols/3, rows)

                        val cropped = Mat(frame, rectCrop)


                        orb.detect(cropped, keypoints2)
                        orb.compute(cropped, keypoints2, descriptors2)



//                        bf = BFMatcher()
                        bf = FlannBasedMatcher()



                        val matches: List<MatOfDMatch> = ArrayList()


                        try {

                            bf.knnMatch(descriptors1, descriptors2, matches, 2)

                            val good_matches = LinkedList<DMatch>()


                            for (match in matches) {
                                if (match.toArray()[0].distance < 0.6 * match.toArray()[1].distance) {
                                    good_matches.add(match.toArray()[0])
                                }
                            }



                            val pts1: MutableList<Point> = ArrayList()
                            val pts2: MutableList<Point> = ArrayList()
                            for (i in good_matches.indices) {
                                pts1.add(keypoints1.toList()[good_matches[i].queryIdx].pt)
                                pts2.add(keypoints2.toList()[good_matches[i].trainIdx].pt)
                            }


                            val outputMask = Mat()
                            val pts1Mat = MatOfPoint2f()
                            pts1Mat.fromList(pts1)
                            val pts2Mat = MatOfPoint2f()
                            pts2Mat.fromList(pts2)


                            //ESQUERDA PARA A DIREITA
                            H = Calib3d.findHomography(pts2Mat, pts1Mat, Calib3d.RANSAC, 1.0, outputMask)
//                            H = Calib3d.findHomography(pts2Mat, pts1Mat, Calib3d.RANSAC,15.0, outputMask,2000,0.995)


                            val better_matches = LinkedList<DMatch>()

                            for (i in good_matches.indices) {
                                if (outputMask[i, 0][0] != 0.0) {
                                    better_matches.add(good_matches[i])
                                }
                            }


                            Log.d("matchez", "matchez: " + better_matches.size)

                            if(better_matches.size >= 15) {

                                insideXY = true

                                val ptsX: MutableList<Double> = ArrayList()
                                val ptsY: MutableList<Double> = ArrayList()
                                for (i in better_matches.indices) {
                                    ptsX.add(keypoints2.toList()[better_matches[i].trainIdx].pt.x)
                                    ptsY.add(keypoints2.toList()[better_matches[i].trainIdx].pt.y)
                                }


                                var sumX = 0.0
                                var sumY = 0.0

                                for (i in ptsX){
                                    sumX += i
                                }

                                for (i in ptsY){
                                    sumY += i
                                }

                                val totalX = sumX/ptsX.size
                                val totalY = sumY/ptsY.size
                                val newValue = (((totalX - 0) * (totalWidth - 0)) / (cropped.width() - 0)) + 0


                                if(!totalX.isNaN() && !totalY.isNaN()) {
                                    runOnUiThread { imageView2.visibility = VISIBLE }
                                    imageView2.x = newValue.toFloat()
                                    imageView2.y = totalY.toFloat()

                                    if(press){
                                        press = false
                                        takePhoto(frame, Yuv.rgb(image.image!!))
                                    }
                                }

                            } else {
                                runOnUiThread { imageView2.visibility = INVISIBLE }
                                insideXY = false
                            }


                        } catch (e: Exception) { }

                    }

                }


                image.close()



            })

            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()

                // Bind use cases to camera
                cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageCapture, imageAnalysis)

            } catch(exc: Exception) {
                Log.e(TAG, "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(this))
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, getFoldersName()).apply { mkdirs() } }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else filesDir
    }

    private fun createPileDir() {
        val folder = getExternalFilesDir(null).toString()  + "/" + getFoldersName()
        val f = File(folder)
        if(!f.exists()){
            f.mkdirs()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
        sensorManager.unregisterListener(this)
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults:
        IntArray) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera()
            } else { others.showToast(this, translator.noPermissions())
                finish()
                back2Menu()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        back2Menu()
    }

    private fun back2Menu(){
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }

    companion object {
        private const val TAG = "CameraXBasic"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
    }



    override fun onResume() {
        super.onResume()

        if (!OpenCVLoader.initDebug()) {
            Toast.makeText(applicationContext, "There's a problem, yo!", Toast.LENGTH_SHORT).show()
        } else {
            baseLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS)
        }


        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager


        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also{
            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_NORMAL,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }



    }


    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }


    override fun onSensorChanged(event: SensorEvent?) {

        arrow_down.visibility = View.INVISIBLE
        inclination_right.visibility = View.INVISIBLE
        arrow_up.visibility = View.INVISIBLE

        if(event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
            upDown = event.values[2]
            if(upDown > 2){

                enableAnimations(arrow_up)
                disableAnimations(arrow_down)

            } else if(upDown <= 2 && upDown > -1){
                inclination_right.visibility = VISIBLE
                disableAnimations(arrow_up)
                disableAnimations(arrow_down)

            } else if(upDown < -1){
                enableAnimations(arrow_down)
                disableAnimations(arrow_up)

            }

        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }


    private fun detectComputeKP(matrix: Mat, src_matrix: Mat) {

        //IMG 1 GRAY
        img1 = Mat()
        bitmap = Bitmap.createBitmap(matrix.cols(), matrix.rows(), Bitmap.Config.RGB_565)
        Utils.matToBitmap(matrix, bitmap)
        Utils.bitmapToMat(bitmap, img1)

        //IMG 1 RGB
        img1_color = Mat()
        bitmap_color = Bitmap.createBitmap(src_matrix.cols(), src_matrix.rows(), Bitmap.Config.RGB_565)
        Utils.matToBitmap(src_matrix, bitmap_color)
        Utils.bitmapToMat(bitmap_color, img1_color)


        val rows = matrix.rows() //Calculates number of rows
        val cols = matrix.cols() //Calculates number of columns
//        val rectCrop = Rect(cols - (cols/2 - cols/10), 0, (cols/2 - cols/10), rows)
        val rectCrop = Rect(cols/3, 0, cols/3, rows)

        val cropped = Mat(matrix, rectCrop)




        //ORB DETECT AND COMPUTE 1
        keypoints1 = MatOfKeyPoint()
        descriptors1 = Mat()
        orb.detect(cropped, keypoints1)
        orb.compute(cropped, keypoints1, descriptors1)

    }



    private fun stitchImg() :Int {
        val result = opencv_core.Mat()
        val stitcher = opencv_stitching.Stitcher.create(1) //panorama = 0

        val uri_imagens_finais = ArrayList<Uri>()
        for (i in imagensAux) {
            uri_imagens_finais.add(Uri.fromFile(File(i)))
        }


        val files = ArrayList<File>(uri_imagens_finais.size)
        for (uri in uri_imagens_finais) {
            files.add(File(uri.path.toString()))
        }

        val vector = filesToMatVector(files)
        val status = stitcher.stitch(vector, result)


        return status
    }


    private fun filesToMatVector(files: List<File>): opencv_core.MatVector {
        val images = opencv_core.MatVector(files.size.toLong())
        for (i in files.indices) {
            val img = opencv_imgcodecs.imread(files[i].absolutePath)
            val imgResized = opencv_core.Mat()
            opencv_imgproc.resize(img, imgResized, opencv_core.Size(), 0.5,0.5, opencv_imgproc.INTER_LINEAR_EXACT)
            images.put(i.toLong(), imgResized)
        }
        return images
    }



    private fun enableAnimations(imageView: ImageView) {
        animation.duration = 1000 //1 second duration for each animation cycle
        animation.interpolator = LinearInterpolator()
        animation.repeatCount = Animation.INFINITE //repeating indefinitely
        animation.repeatMode = Animation.REVERSE //animation will start from end point once ended

        imageView.animation = animation
    }

    private fun disableAnimations(imageView: ImageView) {
        imageView.clearAnimation()

    }


}

