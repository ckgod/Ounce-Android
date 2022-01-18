package com.example.ounceaos.ui.fragment

import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.ounceaos.R
import com.example.ounceaos.base.BaseKotlinFragment
import com.example.ounceaos.databinding.FragmentAdvertiseBinding
import com.example.ounceaos.databinding.FragmentTmpBinding

class AdvertiseFragment(private var drawble : Drawable?) : BaseKotlinFragment<FragmentAdvertiseBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_advertise

    override fun initStartView() {
        drawble.let {
            binding.iv.setImageDrawable(it)
        }
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {
    }

    companion object {
        const val TAG = "AdvertiseFragment"
    }
}