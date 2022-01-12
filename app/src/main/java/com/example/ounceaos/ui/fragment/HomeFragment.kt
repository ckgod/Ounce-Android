package com.example.ounceaos.ui.fragment

import com.example.ounceaos.R
import com.example.ounceaos.base.BaseKotlinFragment
import com.example.ounceaos.databinding.FragmentHomeBinding
import com.example.ounceaos.databinding.FragmentTmpBinding

class HomeFragment() : BaseKotlinFragment<FragmentHomeBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_home

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "HomeFragment"
    }
}