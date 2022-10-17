package com.example.materialyou.view.layouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialyou.databinding.PodMotionStartBinding

class MotionScenesFragment : Fragment() {

    private var _binding: PodMotionStartBinding? = null
    private val binding: PodMotionStartBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PodMotionStartBinding.inflate(inflater, container,  false)
        return binding.root
    }
}