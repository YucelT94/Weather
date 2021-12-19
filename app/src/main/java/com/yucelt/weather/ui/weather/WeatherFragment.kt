package com.yucelt.weather.ui.weather

import com.yucelt.base.ui.fragment.BaseFragment
import com.yucelt.domain.model.FavoriteCity
import com.yucelt.weather.R
import com.yucelt.weather.databinding.WeatherFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : BaseFragment<WeatherFragmentBinding, WeatherViewModel>() {
    companion object {
        val TAG = WeatherFragment::class.java.simpleName
        private const val LAYOUT_RES_ID = R.layout.weather_fragment
        private const val DEFAULT_CITY_NAME = "İstanbul"
    }

    override fun provideViewModel() = WeatherViewModel::class.java

    override fun provideLayoutId() = LAYOUT_RES_ID

    override fun bindViewModel(binding: WeatherFragmentBinding?) {
        binding?.viewModel = viewModel
        viewModel?.getWeatherByCityName(DEFAULT_CITY_NAME)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        dataBinding?.run {
            citySearchView.setOnQueryTextListener(searchListener)
            addFavoriteFab.setOnClickListener { addFavoriteClicked() }
        }
    }

    private val searchListener = object :
        androidx.appcompat.widget.SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            query?.trim()?.let { viewModel?.getWeatherByCityName(it) }
            return true
        }

        override fun onQueryTextChange(newText: String?) = false
    }

    private fun addFavoriteClicked() {
        viewModel?.cityWeatherLiveData?.value?.run {
            val request = FavoriteCity((id ?: 0), name)
            viewModel?.saveFavoriteCity(request)
        }
    }
}