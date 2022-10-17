package com.example.materialyou.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.materialyou.R
import com.example.materialyou.databinding.BottomNavigationViewActivityBinding
import com.example.materialyou.utils.bottomNavigationViewState
import com.example.materialyou.view.PODFragment
import com.example.materialyou.view.ThemeChangeFragment

class BottomNavigationViewActivity : AppCompatActivity() {
    private lateinit var binding: BottomNavigationViewActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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