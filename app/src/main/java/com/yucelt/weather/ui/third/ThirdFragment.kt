package com.yucelt.weather.ui.third

import com.yucelt.base.ui.fragment.BaseFragment
import com.yucelt.weather.R
import com.yucelt.weather.databinding.ThirdFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdFragment : BaseFragment<ThirdFragmentBinding, ThirdViewModel>() {
    companion object {
        val TAG = ThirdFragment::class.java.simpleName
        private const val LAYOUT_RES_ID = R.layout.third_fragment

        fun newInstance() = ThirdFragment()
    }

    override fun provideViewModel() = ThirdViewModel::class.java

    override fun provideLayoutId() = LAYOUT_RES_ID

    override fun bindViewModel(binding: ThirdFragmentBinding?) {
        binding?.viewModel = viewModel
    }
}