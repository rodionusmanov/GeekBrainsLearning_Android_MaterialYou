package com.example.materialyou.view.layouts

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.Fade
import androidx.transition.TransitionManager
import com.example.materialyou.databinding.AnimationLayoutBinding
import com.example.materialyou.utils.*

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
            TransitionManager.beginDelayedTransition(binding.root, fade)
            if (isFlag) {
                trueAnimation()
            } else {
                falseAnimation()
            }
        }
    }

    private fun trueAnimation() {
        ObjectAnimator.ofFloat(
            binding.plusImageview,
            View.ROTATION,
            startRotationPosition,
            finishRotationPositionAnimationPODFragment
        )
            .setDuration(longDuration).start()
        ObjectAnimator.ofFloat(binding.optionOneContainer, View.TRANSLATION_Y, activePositionContainerOneY)
            .setDuration(longDuration).start()
        ObjectAnimator.ofFloat(binding.optionTwoContainer, View.TRANSLATION_Y, activePositionContainerTwoY)
            .setDuration(longDuration).start()
        binding.optionOneContainer.visibility = View.VISIBLE
        binding.optionTwoContainer.visibility = View.VISIBLE
    }

    private fun falseAnimation() {
        ObjectAnimator.ofFloat(
            binding.plusImageview,
            View.ROTATION,
            finishRotationPositionAnimationPODFragment,
            startRotationPosition
        )
            .setDuration(longDuration).start()
        ObjectAnimator.ofFloat(binding.optionOneContainer, View.TRANSLATION_Y, startPositionY)
            .setDuration(longDuration).start()
        ObjectAnimator.ofFloat(binding.optionTwoContainer, View.TRANSLATION_Y, startPositionY)
            .setDuration(longDuration).start()
        binding.optionOneContainer.visibility = View.INVISIBLE
        binding.optionTwoContainer.visibility = View.INVISIBLE
    }
}