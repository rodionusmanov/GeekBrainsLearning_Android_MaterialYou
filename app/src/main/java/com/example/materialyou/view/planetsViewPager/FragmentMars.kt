package com.example.materialyou.view.planetsViewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateOvershootInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.example.materialyou.R
import com.example.materialyou.databinding.FragmentMarsStartBinding

class FragmentMars : Fragment() {

    private var grown = false
    private lateinit var binding: FragmentMarsStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarsStartBinding.inflate(layoutInflater)

        val constraintSetStart = ConstraintSet()
        val constraintSetEnd = ConstraintSet()
        constraintSetStart.clone(requireContext(), R.layout.fragment_mars_start)
        constraintSetEnd.clone(requireContext(), R.layout.fragment_mars_end)

        binding.marsContainerStart.setOnClickListener {
            grown = !grown
            val changeBounds = ChangeBounds()
            changeBounds.duration = 2000L
            changeBounds.interpolator = AnticipateOvershootInterpolator(2.0f)
            TransitionManager.beginDelayedTransition(binding.marsContainerStart, changeBounds)
            if (grown){
                constraintSetEnd.applyTo(binding.marsContainerStart)
            }else{
                constraintSetStart.applyTo(binding.marsContainerStart)
            }
        }
        return binding.marsContainerStart
    }
}