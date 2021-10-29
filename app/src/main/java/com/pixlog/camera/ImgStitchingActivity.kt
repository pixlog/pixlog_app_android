package com.pixlog.camera

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.pixlog.Others
import com.pixlog.Preferences
import com.pixlog.R
import com.pixlog.Translator
import com.pixlog.detect.DetectionActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.bytedeco.javacpp.opencv_stitching
import java.io.File

class ImgStitchingActivity : AppCompatActivity() {

    private lateinit var idioma: Translator
    private val others = Others()
    private var arrayList_imagens_finais = ArrayList<String>()
    private var uri_imagens_finais = ArrayList<Uri>()

    private lateinit var stitchProgress: ProgressBar
    private lateinit var stitchProcessing: TextView
    private lateinit var animation: Animation

    private lateinit var imageStitcher: ImageStitcher
    private lateinit var disposable: Disposable

    private val stitcherInputRelay = PublishSubject.create<StitcherInput>()

    override fun onStart() {
        super.onStart()
        //Bloqueia os prints de tela
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_img_stitching)

        idioma = others.setLang(Preferences(applicationContext))

        //Recupera os nomes das imagens
        arrayList_imagens_finais = intent.getStringArrayListExtra("lista_imagens_finais")!!

        var i = 0
        while (i < arrayList_imagens_finais.size) {
            uri_imagens_finais.add(Uri.fromFile(File(arrayList_imagens_finais[i])))
            i++
        }

        stitchProgress = findViewById(R.id.stitchProgress)
        stitchProcessing = findViewById(R.id.stitchProcessing)
        animation = AlphaAnimation(1.0f, 0.0f)


        setUpStitcher()
        processImages(uri_imagens_finais)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

    private fun enableAnimations() {
        animation.duration = 1000 //1 second duration for each animation cycle
        animation.interpolator = LinearInterpolator()
        animation.repeatCount = Animation.INFINITE //repeating indefinitely
        animation.repeatMode = Animation.REVERSE //animation will start from end point once ended

        stitchProgress.visibility = View.VISIBLE
        stitchProcessing.text = idioma.Processing() + "..."
        stitchProcessing.animation = animation
    }

    private fun disableAnimations() {
        stitchProgress.visibility = View.GONE
        stitchProgress.clearAnimation()

        stitchProcessing.clearAnimation()
        stitchProcessing.text = ""
    }

    private fun setUpStitcher() {

        imageStitcher = ImageStitcher(FileUtil(applicationContext))


        disposable = stitcherInputRelay.switchMapSingle {
            imageStitcher.stitchImages(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { enableAnimations() }
                    .doOnSuccess { disableAnimations() }
        }.subscribe({ processResult(it) }, { processError(it) })


    }

    private fun processImages(uris: List<Uri>) {
        //val stitchMode = opencv_stitching.Stitcher.PANORAMA
        val stitchMode = opencv_stitching.Stitcher.SCANS //Stitcher.PANORAMA
        stitcherInputRelay.onNext(StitcherInput(uris, stitchMode))
    }

    private fun processResult(output: StitcherOutput) {
        when (output) {
            is StitcherOutput.Success -> go2DetectionActivity(output.file)
            is StitcherOutput.Failure -> processError(output.e)
        }
    }

    private fun go2DetectionActivity(file: File) {
        val intent = Intent(this, DetectionActivity::class.java)
        Log.i("Image Stitching", file.toString())
        intent.putExtra("mosaico", file.toString())
        startActivity(intent)

    }

    private fun processError(e: Throwable) {
        Log.e("Image Stitching", "", e)
        Toast.makeText(this, e.message + "", Toast.LENGTH_LONG).show()
        startActivity(Intent(this,CameraActivity::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
