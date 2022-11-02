package com.example.materialyou.view.layouts

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.materialyou.databinding.PodDescriptionDialogFragmentBinding
import com.example.materialyou.utils.descriptionBody
import com.example.materialyou.utils.descriptionHeader

class PODDescriptionFragment : DialogFragment() {
    companion object {
        fun newInstance() = PODDescriptionFragment()
    }

    private var _binding: PodDescriptionDialogFragmentBinding? = null
    private val binding: PodDescriptionDialogFragmentBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PodDescriptionDialogFragmentBinding.inflate(inflater)

        return binding.podDescriptionDialogContainer
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            podDescriptionHeader.apply {
                text = descriptionHeader
                typeface =
                    Typeface.createFromAsset(
                        requireActivity().assets,
                        "folderFont/fontPODDescription/Quicksand_Bold.otf"
                    )
            }
            podDescriptionBody.apply {
                text = descriptionBody
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