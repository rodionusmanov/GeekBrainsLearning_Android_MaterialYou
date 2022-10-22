package com.example.materialyou.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.transition.Fade
import androidx.transition.TransitionManager
import coil.load
import com.example.materialyou.R
import com.example.materialyou.databinding.PodFragmentCoordinatorLayoutBinding
import com.example.materialyou.utils.descriptionBody
import com.example.materialyou.utils.descriptionHeader
import com.example.materialyou.utils.wikiRequest
import com.example.materialyou.view.layouts.PODDescriptionFragment
import com.example.materialyou.view.layouts.WikiSearchFragment
import com.example.materialyou.viewmodel.PODViewModel
import com.example.materialyou.viewmodel.PODViewModelAppState

class PODFragment : Fragment() {
    companion object {
        fun newInstance() = PODFragment()
    }

    private var isFlag = false
    private var _binding: PodFragmentCoordinatorLayoutBinding? = null
    private val binding: PodFragmentCoordinatorLayoutBinding
        get() {
            return _binding!!
        }

    private val viewModel by lazy {
        ViewModelProvider(this)[PODViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PodFragmentCoordinatorLayoutBinding.inflate(inflater)
        return binding.podFragment
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.app_bar_theme_change -> {
            val dialog = ThemeChangeFragment()
            dialog.show(requireActivity().supportFragmentManager, "change theme")
            true
        }
        R.id.app_bar_view_pager -> {
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.podScreen.setOnClickListener {
            viewModel.getInfoFromServer()
            viewModel.getLiveData().observe(viewLifecycleOwner) {
                renderData(it)
            }
        }

        binding.podFab.setOnClickListener {
            isFlag = !isFlag
            val fade = Fade()
            TransitionManager.beginDelayedTransition(binding.root, fade)
            if (isFlag) {
                ObjectAnimator.ofFloat(binding.podFab, View.ROTATION, 0F, -135f).setDuration(1000L)
                    .start()
                ObjectAnimator.ofFloat(binding.wikiContainer, View.TRANSLATION_Y, 140f)
                    .setDuration(500L).start()
                ObjectAnimator.ofFloat(binding.descriptionContainer, View.TRANSLATION_Y, 120f)
                    .setDuration(500L).start()
                ObjectAnimator.ofFloat(binding.alphaBackground, View.ALPHA, 0.8F).setDuration(500L).start()
                binding.wikiContainer.animate().alpha(1.0f).setDuration(500L).setListener(
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            binding.wikiContainer.isClickable = true
                        }
                    }
                )
                binding.descriptionContainer.animate().alpha(1.0f).setDuration(500L).setListener(
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            binding.descriptionContainer.isClickable = true
                        }
                    }
                )
                binding.wikiContainer.setOnClickListener{
                    val dialog = WikiSearchFragment()
                    dialog.show(requireActivity().supportFragmentManager, "wiki request")
                }
                binding.descriptionContainer.setOnClickListener{
                    val dialog = PODDescriptionFragment()
                    dialog.show(requireActivity().supportFragmentManager, "description request")
                }
            } else {
                ObjectAnimator.ofFloat(binding.podFab, View.ROTATION, -135f, 0f)
                    .setDuration(1000L).start()
                ObjectAnimator.ofFloat(binding.wikiContainer, View.TRANSLATION_Y, 0f)
                    .setDuration(500L).start()
                ObjectAnimator.ofFloat(binding.descriptionContainer, View.TRANSLATION_Y, 0f)
                    .setDuration(500L).start()
                ObjectAnimator.ofFloat(binding.alphaBackground, View.ALPHA, 0.0F).setDuration(500L).start()
                binding.wikiContainer.animate().alpha(0.0f).setDuration(500L).setListener(
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            binding.wikiContainer.isClickable = false
                        }
                    }
                )
                binding.descriptionContainer.animate().alpha(0.0f).setDuration(500L).setListener(
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            binding.descriptionContainer.isClickable = false
                        }
                    }
                )
            }
        }
    }

    private fun renderData(podViewModelAppState: PODViewModelAppState?) {
        binding.podImageView.visibility = View.VISIBLE
        when (podViewModelAppState) {
            is PODViewModelAppState.Error -> {
                binding.podImageView.setImageResource(android.R.drawable.ic_delete)
                Toast.makeText(requireContext(), "сломался, не отработал", Toast.LENGTH_SHORT)
                    .show()
            }
            PODViewModelAppState.Loading -> {
                binding.podImageView.setImageResource(android.R.drawable.ic_menu_rotate)
            }
            is PODViewModelAppState.Success -> {
                with(binding) {
                    podImageView.load(podViewModelAppState.podDataTransferObject.hdurl) {
                        error(android.R.drawable.ic_delete)
                        placeholder(android.R.drawable.ic_menu_rotate)
                        crossfade(true)
                    }
                }
                binding.clickHereTv.text = podViewModelAppState.podDataTransferObject.title
                wikiRequest = podViewModelAppState.podDataTransferObject.title
                descriptionHeader = podViewModelAppState.podDataTransferObject.title
                descriptionBody = podViewModelAppState.podDataTransferObject.explanation
            }
            null -> {}
        }
    }
}