package com.example.materialyou.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.materialyou.R
import com.example.materialyou.utils.themeState
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
            themeState = "default_theme"
            requireActivity().recreate()
            dismiss()
        }

        view.findViewById<Chip>(R.id.monochrome_theme_chip).setOnClickListener {
            themeState = "monochrome_theme"
            requireActivity().recreate()
            dismiss()
        }
    }

}