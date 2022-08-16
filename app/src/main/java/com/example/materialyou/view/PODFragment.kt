package com.example.materialyou.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.materialyou.R
import com.example.materialyou.viewmodel.PODViewModel

class PODFragment : Fragment() {

    companion object {
        fun newInstance() = PODFragment()
    }

    private lateinit var viewModel: PODViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PODViewModel::class.java)
        // TODO: Use the ViewModel
    }

}