package com.example.materialyou.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.materialyou.MainActivity
import com.example.materialyou.databinding.ActivitySplashLayoutBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashLayoutBinding
    private val handler = Handler(Looper.getMainLooper())
    private val splashDelay = 4000L

    private val scaleIVValue = 0.9f
    private val scaleTVValue = 1.1f
    private val rotationValue = 10f
    private val interpolatorDuration = 5000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.splashIv.animate().apply {
            scaleX(scaleIVValue)
                .setInterpolator(LinearInterpolator()).duration = interpolatorDuration
            scaleY(scaleIVValue)
                .setInterpolator(LinearInterpolator()).duration = interpolatorDuration
            rotationBy(rotationValue)
                .setInterpolator(LinearInterpolator()).duration = interpolatorDuration
        }

        binding.splashTv.animate().apply {
            scaleX(scaleTVValue)
                .setInterpolator(LinearInterpolator()).duration = interpolatorDuration
            scaleY(scaleTVValue)
                .setInterpolator(LinearInterpolator()).duration = interpolatorDuration
            rotationBy(-rotationValue)
                .setInterpolator(LinearInterpolator()).duration = interpolatorDuration
        }

        handler.postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, splashDelay)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}