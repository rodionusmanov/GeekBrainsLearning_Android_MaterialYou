package com.example.materialyou.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.materialyou.databinding.PodFragmentBinding
import com.example.materialyou.viewmodel.PODViewModel
import com.example.materialyou.viewmodel.PODViewModelAppState

class PODFragment : Fragment() {

    companion object {
        fun newInstance() = PODFragment()

    }

    private var _binding: PodFragmentBinding? = null
    private val binding: PodFragmentBinding
        get() {
            return _binding!!
        }

    private val viewModel by lazy {
        ViewModelProvider(this).get(PODViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PodFragmentBinding.inflate(inflater)
        return binding.podFragment
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPictureHD()
        viewModel.getLiveData().observe(viewLifecycleOwner) {
            renderData(it)
        }

    }

    private fun renderData(podViewModelAppState: PODViewModelAppState?) {

        when (podViewModelAppState) {
            is PODViewModelAppState.Error -> {}
            PODViewModelAppState.Loading -> {}
            is PODViewModelAppState.Success -> {
                with(binding) {
                    podImageView.load(podViewModelAppState.hdurl)
                }
            }
            null -> {
            }
        }
    }
}