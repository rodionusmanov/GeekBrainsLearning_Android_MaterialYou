package com.example.materialyou.view.layouts

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.transition.*
import com.example.materialyou.databinding.AnimationLayoutBinding

class AnimationFragment : Fragment() {

    private var isFlag = false
    private var _binding: AnimationLayoutBinding? = null
    private val binding: AnimationLayoutBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AnimationLayoutBinding.inflate(inflater)
        return binding.animationContainer
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            isFlag = !isFlag
            val fade = Fade()
            TransitionManager.beginDelayedTransition(binding.root,fade)
            if (isFlag) {
                ObjectAnimator.ofFloat(binding.plusImageview, View.ROTATION, 0f, -600f)
                    .setDuration(1000L).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer, View.TRANSLATION_Y, -225f)
                    .setDuration(1000L).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer, View.TRANSLATION_Y, -130f)
                    .setDuration(1000L).start()
                binding.optionOneContainer.visibility = View.VISIBLE
                binding.optionTwoContainer.visibility = View.VISIBLE
            } else {
                ObjectAnimator.ofFloat(binding.plusImageview, View.ROTATION, -600f, 0f)
                    .setDuration(1000L).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer, View.TRANSLATION_Y, 0f)
                    .setDuration(1000L).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer, View.TRANSLATION_Y, 0f)
                    .setDuration(1000L).start()
                binding.optionOneContainer.visibility = View.INVISIBLE
                binding.optionTwoContainer.visibility = View.INVISIBLE
            }
        }
    }
}