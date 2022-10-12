package com.example.materialyou

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.materialyou.databinding.ActivityMainBinding
import com.example.materialyou.view.PODFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PODFragment.newInstance())
                .commit()
        }
    }
}