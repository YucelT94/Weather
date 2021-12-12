package com.yucelt.weather.ui.first

import com.yucelt.base.ui.fragment.BaseFragment
import com.yucelt.weather.R
import com.yucelt.weather.databinding.FirstFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : BaseFragment<FirstFragmentBinding, FirstViewModel>() {
    companion object {
        val TAG = FirstFragment::class.java.simpleName
        private const val LAYOUT_RES_ID = R.layout.first_fragment

        fun newInstance() = FirstFragment()
    }

    override fun provideViewModel() = FirstViewModel::class.java

    override fun provideLayoutId() = LAYOUT_RES_ID

    override fun bindViewModel(binding: FirstFragmentBinding?) {
        binding?.viewModel = viewModel
        viewModel?.getWeatherByCityName("Burhaniye")
    }
}