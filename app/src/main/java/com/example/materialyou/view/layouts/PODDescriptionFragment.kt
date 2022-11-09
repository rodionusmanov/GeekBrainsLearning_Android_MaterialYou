package com.example.materialyou.view.layouts

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.DialogFragment
import com.example.materialyou.R
import com.example.materialyou.databinding.PodDescriptionDialogFragmentBinding
import com.example.materialyou.utils.descriptionBody
import com.example.materialyou.utils.descriptionHeader
import com.example.materialyou.utils.rainbowIdColor

class PODDescriptionFragment : DialogFragment() {

    private var _binding: PodDescriptionDialogFragmentBinding? = null
    private val binding: PodDescriptionDialogFragmentBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PodDescriptionDialogFragmentBinding.inflate(inflater)

        return binding.podDescriptionDialogContainer
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bitmapEarth =
            ContextCompat.getDrawable(requireContext(), R.drawable.earth_svg)!!.toBitmap()
        val spannableStringBody: SpannableString
        val spannableStringBuilderHeader: SpannableStringBuilder

        spannableStringBody = SpannableString(descriptionBody)
        spannableStringBuilderHeader = SpannableStringBuilder(descriptionHeader)

        spannableStringBuilderHeader.insert(0,"_")
        spannableStringBuilderHeader.setSpan(ImageSpan(bitmapEarth), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        for (i in descriptionBody.indices) {
            spannableStringBody.setSpan(
                ForegroundColorSpan(
                    ContextCompat.getColor(requireContext(), rainbowIdColor[i % rainbowIdColor.size])
                ), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        binding.apply {
            podDescriptionHeader.apply {
                text = spannableStringBuilderHeader
                typeface =
                    Typeface.createFromAsset(
                        requireActivity().assets,
                        "folderFont/fontPODDescription/Quicksand_Bold.otf"
                    )
            }
            podDescriptionBody.apply {
                text = spannableStringBody
                typeface =
                    Typeface.createFromAsset(
                        requireActivity().assets,
                        "folderFont/fontPODDescription/Quicksand_Book.otf"
                    )
            }
            podDescriptionDialogContainer.setOnClickListener {
                dismiss()
            }
        }
    }
}