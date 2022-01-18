package com.example.ounceaos.ui.fragment

import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ounceaos.R
import com.example.ounceaos.base.BaseKotlinFragment
import com.example.ounceaos.databinding.FragmentHomeBinding
import com.example.ounceaos.databinding.FragmentTmpBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment() : BaseKotlinFragment<FragmentHomeBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_home

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun initStartView() {
        viewPagerAdapter = ViewPagerAdapter(this).apply {
            addFragment(AdvertiseFragment(ContextCompat.getDrawable(requireContext(), R.drawable.tmp_img1)))
            addFragment(AdvertiseFragment(ContextCompat.getDrawable(requireContext(), R.drawable.tmp_img2)))
            addFragment(AdvertiseFragment(ContextCompat.getDrawable(requireContext(), R.drawable.tmp_img3)))
            addFragment(AdvertiseFragment(ContextCompat.getDrawable(requireContext(), R.drawable.tmp_img4)))
        }
        binding.vpPager.isSaveEnabled = false
        binding.vpPager.offscreenPageLimit = 4
        binding.vpPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tlIndicator, binding.vpPager) { tab, position ->
        }.attach()
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {

    }

    private inner class ViewPagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
        var fragments : MutableList<Fragment> = mutableListOf()

        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }

        fun addFragment(fragment: Fragment) {
            fragments.add(fragment)
            notifyItemInserted(fragments.size - 1)
        }
    }

    companion object {
        const val TAG = "HomeFragment"
    }
}