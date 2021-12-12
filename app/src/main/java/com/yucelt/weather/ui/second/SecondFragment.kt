package com.yucelt.weather.ui.second

import com.yucelt.base.ui.fragment.BaseFragment
import com.yucelt.weather.R
import com.yucelt.weather.databinding.SecondFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment<SecondFragmentBinding, SecondViewModel>() {
    companion object {
        val TAG = SecondFragment::class.java.simpleName
        private const val LAYOUT_RES_ID = R.layout.second_fragment

        fun newInstance() = SecondFragment()
    }

    override fun provideViewModel() = SecondViewModel::class.java

    override fun provideLayoutId() = LAYOUT_RES_ID

    override fun bindViewModel(binding: SecondFragmentBinding?) {
        binding?.viewModel = viewModel
    }
}