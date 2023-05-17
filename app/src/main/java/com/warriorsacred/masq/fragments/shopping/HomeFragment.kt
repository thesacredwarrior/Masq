package com.warriorsacred.masq.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.warriorsacred.masq.R
import com.warriorsacred.masq.adapters.HomeViewpagerAdapter
import com.warriorsacred.masq.databinding.FragmentHomeBinding
import com.warriorsacred.masq.fragments.categories.*

class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            MainCategoryFragment(),
            BootsFragment(),
            JeansFragment(),
            ShirtsFragment(),
            AccessoryFragment()
        )

        val viewPager2Adapter = HomeViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewpagerHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewpagerHome) { tab, position ->
            when (position) {
                0 -> tab.text = "Главная"
                1 -> tab.text = "Обувь"
                2 -> tab.text = "Джинсы"
                3 -> tab.text = "Футболки"
                4 -> tab.text = "Аксессуары"
            }
        }.attach()
    }
}