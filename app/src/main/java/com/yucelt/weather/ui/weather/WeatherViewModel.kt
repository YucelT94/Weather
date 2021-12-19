package com.yucelt.weather.ui.weather

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yucelt.base.domain.Resource
import com.yucelt.base.ui.fragment.BaseViewModel
import com.yucelt.domain.model.CityWeather
import com.yucelt.domain.model.FavoriteCity
import com.yucelt.domain.usecase.GetWeatherByCityNameUseCase
import com.yucelt.domain.usecase.SaveFavoriteCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherByCityNameUseCase: GetWeatherByCityNameUseCase,
    private val saveFavoriteCityUseCase: SaveFavoriteCityUseCase,
    application: Application
) : BaseViewModel(application) {
    override val resourceLiveData: MutableLiveData<Resource<*>>
        get() = _resource

    private val _resource = MutableLiveData<Resource<*>>()

    val cityWeatherLiveData: MutableLiveData<CityWeather>
        get() = _cityWeather

    private val _cityWeather = MutableLiveData<CityWeather>()

    fun getWeatherByCityName(cityName: String) {
        viewModelScope.launch {
            getWeatherByCityNameUseCase.invoke(cityName).collect {
                _resource.postValue(it)
                it.data?.let { data ->
                    _cityWeather.postValue(data)
                }
            }
        }
    }

    fun saveFavoriteCity(favoriteCity: FavoriteCity) {
        viewModelScope.launch {
            saveFavoriteCityUseCase.invoke(favoriteCity).collect {
                _resource.postValue(it)
            }
        }
    }
}