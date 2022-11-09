package com.example.materialyou.splash

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.materialyou.MainActivity
import com.example.materialyou.databinding.ActivitySplashLayoutBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashLayoutBinding

    private val scaleIVValue = 0.9f
    private val scaleTVValue = 1.1f
    private val rotationValue = 10f
    private val interpolatorDuration = 4000L

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
        }.setListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {
//                nothing to do
            }

            override fun onAnimationEnd(p0: Animator?) {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }

            override fun onAnimationCancel(p0: Animator?) {
//                nothing to do
            }

            override fun onAnimationRepeat(p0: Animator?) {
//                nothing to do
            }
        })

        binding.splashTv.animate().apply {
            scaleX(scaleTVValue)
                .setInterpolator(LinearInterpolator()).duration = interpolatorDuration
            scaleY(scaleTVValue)
                .setInterpolator(LinearInterpolator()).duration = interpolatorDuration
            rotationBy(-rotationValue)
                .setInterpolator(LinearInterpolator()).duration = interpolatorDuration
        }
    }
}