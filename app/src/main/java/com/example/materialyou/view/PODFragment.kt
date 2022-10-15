package com.example.materialyou.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.materialyou.MainActivity
import com.example.materialyou.R
import com.example.materialyou.databinding.PodFragmentBinding
import com.example.materialyou.utils.themeState
import com.example.materialyou.viewmodel.PODViewModel
import com.example.materialyou.viewmodel.PODViewModelAppState
import com.google.android.material.bottomsheet.BottomSheetBehavior

class PODFragment : Fragment() {
    companion object {
        fun newInstance() = PODFragment()
    }

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private var _binding: PodFragmentBinding? = null
    private val binding: PodFragmentBinding
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
        when (themeState) {
            "default_theme" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                requireActivity().setTheme(R.style.Theme_MaterialYou)
            }
            "default_dark_theme" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                requireActivity().setTheme(R.style.Theme_MaterialYou)
            }
            "monochrome_theme" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                requireActivity().setTheme(R.style.MonoTheme)
            }
            "monochrome_dark_theme" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                requireActivity().setTheme(R.style.MonoTheme)
            }
            "amazon_green_theme" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                requireActivity().setTheme(R.style.GreenTheme)
            }
            "amazon_green_dark_theme" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                requireActivity().setTheme(R.style.GreenTheme)
            }
            else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                requireActivity().setTheme(R.style.Theme_MaterialYou)
            }
        }
        _binding = PodFragmentBinding.inflate(inflater)
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
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBottomSheetBehavior(view.findViewById(R.id.bottom_sheet_container))
        binding.podFragment.setOnClickListener {
            viewModel.getInfoFromServer()
            viewModel.getLiveData().observe(viewLifecycleOwner) {
                renderData(it)
            }
        }
        binding.wikiInputLayout.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data =
                    Uri.parse("https://en.wikipedia.org/wiki/${binding.wikiInputText.text.toString()}")
            })
        }
        setBottomAppBar(view)

//        binding.
    }

    private fun renderData(podViewModelAppState: PODViewModelAppState?) {
        val loadingScreen = requireActivity().findViewById<FrameLayout>(R.id.loading_screen)
        val bsHeader =
            requireActivity().findViewById<TextView>(R.id.bottom_sheet_description_header)
        val bsDescription = requireActivity().findViewById<TextView>(R.id.bottom_sheet_description)
        when (podViewModelAppState) {
            is PODViewModelAppState.Error -> {
                loadingScreen.visibility = View.GONE
                Toast.makeText(requireContext(), "сломался, не отработал", Toast.LENGTH_SHORT)
                    .show()
            }
            PODViewModelAppState.Loading -> {
                loadingScreen.visibility = View.VISIBLE
            }
            is PODViewModelAppState.Success -> {
                loadingScreen.visibility = View.GONE
                with(binding) {
                    podImageView.load(podViewModelAppState.podDataTransferObject.hdurl) {
                        error(android.R.drawable.ic_delete)
                        placeholder(android.R.drawable.ic_menu_rotate)
                        crossfade(true)
                    }
                }
                bsHeader.text = podViewModelAppState.podDataTransferObject.title
                bsDescription.text = podViewModelAppState.podDataTransferObject.explanation
            }
            null -> {}
        }
    }

    private fun setBottomSheetBehavior(bottomSheet: ConstraintLayout) {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    private fun setBottomAppBar(view: View) {
        val context = activity as MainActivity
        context.setSupportActionBar(view.findViewById(R.id.pod_bottom_app_bar))
        setHasOptionsMenu(true)
    }
}