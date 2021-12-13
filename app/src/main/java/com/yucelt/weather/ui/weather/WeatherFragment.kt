package com.yucelt.weather.ui.weather

import com.yucelt.base.ui.fragment.BaseFragment
import com.yucelt.weather.R
import com.yucelt.weather.databinding.WeatherFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : BaseFragment<WeatherFragmentBinding, WeatherViewModel>() {
    companion object {
        val TAG = WeatherFragment::class.java.simpleName
        private const val LAYOUT_RES_ID = R.layout.weather_fragment

        fun newInstance() = WeatherFragment()
    }

    override fun provideViewModel() = WeatherViewModel::class.java

    override fun provideLayoutId() = LAYOUT_RES_ID

    override fun bindViewModel(binding: WeatherFragmentBinding?) {
        binding?.viewModel = viewModel
        viewModel?.getWeatherByCityName("İstanbul")
    }
}