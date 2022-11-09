package com.example.materialyou.view.layouts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.materialyou.databinding.WikiSearchDialogBinding
import com.example.materialyou.utils.wikiRequest

class WikiSearchFragment : DialogFragment() {

    private var _binding: WikiSearchDialogBinding? = null
    private val binding: WikiSearchDialogBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = WikiSearchDialogBinding.inflate(inflater)
        return binding.wikiSearchDialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.wikiDialogInputText.setText(wikiRequest)
        binding.wikiDialogInputLayout.setEndIconOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW).apply {
                    data =
                        Uri.parse("https://en.wikipedia.org/wiki/${binding.wikiDialogInputText.text.toString()}")
                })
            dismiss()
        }
    }
}