package com.example.materialyou.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.materialyou.databinding.ViewPagerActivityBinding

class ViewPagerActivity : AppCompatActivity() {
    private lateinit var binding: ViewPagerActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewPagerActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}