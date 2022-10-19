package com.example.materialyou.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.materialyou.R
import com.example.materialyou.databinding.BottomNavigationViewActivityBinding
import com.example.materialyou.utils.bottomNavigationViewState
import com.example.materialyou.utils.themeState
import com.example.materialyou.view.PODFragment
import com.example.materialyou.view.ThemeChangeFragment
import com.example.materialyou.view.layouts.MotionScenesFragment
import com.example.materialyou.view.planetsViewPager.PlanetsFragment

class BottomNavigationViewActivity : AppCompatActivity() {
    private lateinit var binding: BottomNavigationViewActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (themeState) {
            "default_theme" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                setTheme(R.style.Theme_MaterialYou)
            }
            "default_dark_theme" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                setTheme(R.style.Theme_MaterialYou)
            }
            "monochrome_theme" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                setTheme(R.style.MonoTheme)
            }
            "monochrome_dark_theme" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                setTheme(R.style.MonoTheme)
            }
            "amazon_green_theme" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                setTheme(R.style.GreenTheme)
            }
            "amazon_green_dark_theme" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                setTheme(R.style.GreenTheme)
            }
            else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                setTheme(R.style.Theme_MaterialYou)
            }
        }
        binding = BottomNavigationViewActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigateTo(bottomNavigationViewState)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_planets -> {
                    navigateTo(PlanetsFragment())
                    true
                }
                R.id.bottom_POD -> {
                    navigateTo(PODFragment())
                    true
                }
                R.id.bottom_change_theme -> {
                    navigateTo(ThemeChangeFragment())
                    false
                }
                R.id.motion_scenes -> {
                    navigateTo(MotionScenesFragment())
                    false
                }
                else -> true
            }
            true
        }
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}