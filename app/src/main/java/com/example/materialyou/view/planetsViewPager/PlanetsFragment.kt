package com.example.materialyou.view.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.materialyou.R
import com.example.materialyou.databinding.PlanetsFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class PlanetsFragment : Fragment() {
    private val tabTitles = arrayOf(
        "Sun",
        "Mercury",
        "Venus",
        "Earth",
        "Mars",
        "Asteroid belt",
        "Jupiter",
        "Saturn",
        "Uranus",
        "Neptune",
        "Pluto",
        "Kuiper belt"
    )
    private val tabIcons = arrayOf(
        R.drawable.sun_icon,
        R.drawable.mercury_icon,
        R.drawable.venus_icon,
        R.drawable.earth_icon,
        R.drawable.mars_icon,
        R.drawable.asteroid_belt_icon,
        R.drawable.jupiter_icon,
        R.drawable.saturn_icon,
        R.drawable.uranus_icon,
        R.drawable.neptune_icon,
        R.drawable.pluto_icon,
        R.drawable.asteroid_belt_icon
    )

    private var _binding: PlanetsFragmentBinding? = null
    private val binding: PlanetsFragmentBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PlanetsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = ViewPagerAdapter(requireActivity())
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
            tab.icon = ContextCompat.getDrawable(requireContext(), tabIcons[position])
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}