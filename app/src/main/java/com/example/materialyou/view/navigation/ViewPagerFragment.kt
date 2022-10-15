package com.example.materialyou.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.materialyou.databinding.ViewPagerFragmentBinding

class ViewPagerFragment :AppCompatActivity() {
    private lateinit var binding: ViewPagerFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewPagerFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(this)
    }
}