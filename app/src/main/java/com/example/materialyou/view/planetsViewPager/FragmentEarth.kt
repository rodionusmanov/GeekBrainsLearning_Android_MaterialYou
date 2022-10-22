package com.example.materialyou.view.planetsViewPager

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.transition.*
import com.example.materialyou.databinding.FragmentEarthBinding

class FragmentEarth() : Fragment() {

    private var grown = false
    private lateinit var binding: FragmentEarthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEarthBinding.inflate(layoutInflater)

        binding.earthIv.setOnClickListener{
            grown = !grown
            val params = it.layoutParams as ConstraintLayout.LayoutParams

            val transitionSet = TransitionSet()
            val changeImageTransform = ChangeImageTransform()
            val changeBounds = ChangeBounds()
            transitionSet.addTransition(changeImageTransform)
            transitionSet.addTransition(changeBounds)
            transitionSet.addTransition(Slide(Gravity.BOTTOM))
            transitionSet.duration = 2000L
            TransitionManager.beginDelayedTransition(binding.root,transitionSet)

            if (grown){
                params.width = ConstraintLayout.LayoutParams.MATCH_PARENT
                params.horizontalBias = 0.5F
                binding.moonIv.visibility = View.GONE
            } else {
                params.width = 0
                params.horizontalBias = 0.3F
                binding.moonIv.visibility = View.VISIBLE
            }
            it.layoutParams = params
        }
        return binding.fragmentEarth
    }
}