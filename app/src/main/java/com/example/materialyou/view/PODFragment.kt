package com.example.materialyou.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.materialyou.R
import com.example.materialyou.databinding.PodFragmentBinding
import com.example.materialyou.view.navigation.BottomNavigationViewActivity
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
        R.id.app_bar_view_pager -> {
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
}