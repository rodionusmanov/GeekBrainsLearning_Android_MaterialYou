package com.example.materialyou.view.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    val fragments = arrayOf(
        FragmentSun(),
        FragmentMercury(),
        FragmentVenus(),
        FragmentEarth(),
        FragmentMars(),
        FragmentAsteroidBelt(),
        FragmentJupiter(),
        FragmentSaturn(),
        FragmentUranus(),
        FragmentNeptune(),
        FragmentPluto(),
        FragmentKuiperBelt()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}