package com.example.ounceaos.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.ounceaos.R

abstract class BaseKotlinFragment<T : ViewDataBinding> : Fragment() {
    var progress: ProgressDialog? = null

    var databinding: T? = null
    lateinit var binding: T

    /**
     * setContentView로 호출할 Layout의 리소스 Id.
     * ex) R.layout.activity_sbs_main
     */
    abstract val layoutResourceId: Int
    open val showBottomSheetFlag = true

    /**
     * 레이아웃을 띄운 직후 호출.
     * 뷰나 액티비티의 속성 등을 초기화.
     * ex) 리사이클러뷰, 툴바, 드로어뷰..
     */
    abstract fun initStartView()

    /**
     * 두번째로 호출.
     * 데이터 바인딩 및 rxjava 설정.
     * ex) rxjava observe, databinding observe..
     */
    abstract fun initDataBinding()

    /**
     * 바인딩 이후에 할 일을 여기에 구현.
     * 그 외에 설정할 것이 있으면 이곳에서 설정.
     * 클릭 리스너도 이곳에서 설정.
     */
    abstract fun initAfterBinding()

    /**
     * 초기설정 이외, onResume 됬을때의 View Update 를 위한 함수
     * Observing 형식의 데이터만 아닌 경우에만 해당
     */
    abstract fun reLoadUI()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!(::binding.isInitialized)) {
            binding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
            binding.lifecycleOwner = viewLifecycleOwner
            initStartView()
            initDataBinding()
            initAfterBinding()
        }
//        (requireActivity() as? MainActivity)?.setBottomNavVisible(showBottomSheetFlag)
        reLoadUI()
        return binding.root
    }

    fun showCustomToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun showNetworkError() {
        Toast.makeText(context, getString(R.string.network_error), Toast.LENGTH_LONG).show()
    }

    fun showProgress() {
        if (progress == null) {
            progress = ProgressDialog(requireContext())
        }
        if (progress?.isShowing == true) {
            progress?.dismiss()
        }
        progress?.show()
    }

    fun hideProgress() {
        progress?.dismiss()
    }


}