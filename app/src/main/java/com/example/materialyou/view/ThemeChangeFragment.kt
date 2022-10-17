package com.example.materialyou.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.DialogFragment
import com.example.materialyou.R
import com.example.materialyou.utils.bottomNavigationViewState
import com.google.android.material.chip.Chip

class ThemeChangeFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.change_theme_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Chip>(R.id.default_theme_chip).setOnClickListener {
            bottomNavigationViewState = ThemeChangeFragment()
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            requireActivity().setTheme(R.style.Theme_MaterialYou)
            requireActivity().recreate()
            dismiss()
        }

        view.findViewById<Chip>(R.id.default_dark_theme_chip).setOnClickListener {
            bottomNavigationViewState = ThemeChangeFragment()
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            requireActivity().setTheme(R.style.Theme_MaterialYou)
            requireActivity().recreate()
            dismiss()
        }

        view.findViewById<Chip>(R.id.monochrome_theme_chip).setOnClickListener {
            bottomNavigationViewState = ThemeChangeFragment()
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            requireActivity().setTheme(R.style.MonoTheme)
            requireActivity().recreate()
            dismiss()
        }

        view.findViewById<Chip>(R.id.monochrome_dark_theme_chip).setOnClickListener {
            bottomNavigationViewState = ThemeChangeFragment()
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            requireActivity().setTheme(R.style.MonoTheme)
            requireActivity().recreate()
            dismiss()
        }

        view.findViewById<Chip>(R.id.green_theme_chip).setOnClickListener {
            bottomNavigationViewState = ThemeChangeFragment()
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            requireActivity().setTheme(R.style.GreenTheme)
            requireActivity().recreate()
            dismiss()
        }

        view.findViewById<Chip>(R.id.green_dark_theme_chip).setOnClickListener {
            bottomNavigationViewState = ThemeChangeFragment()
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            requireActivity().setTheme(R.style.GreenTheme)
            requireActivity().recreate()
            dismiss()
        }
    }

}