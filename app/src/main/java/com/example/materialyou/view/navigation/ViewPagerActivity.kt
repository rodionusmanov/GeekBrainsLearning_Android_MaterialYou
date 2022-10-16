package com.example.materialyou.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.materialyou.R
import com.example.materialyou.databinding.ViewPagerActivityBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity() {
    private lateinit var binding: ViewPagerActivityBinding
    private val tabTitles = arrayOf("Earth", "Mars", "Solar system")
    private val tabIcons = arrayOf(R.drawable.earth_icon, R.drawable.mars_icon, R.drawable.solar_system_icon)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewPagerActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
            tab.icon = ContextCompat.getDrawable(this@ViewPagerActivity, tabIcons[position])
        }.attach()
    }
}