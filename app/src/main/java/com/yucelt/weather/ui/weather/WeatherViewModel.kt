package com.yucelt.weather.ui.weather

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yucelt.base.domain.Resource
import com.yucelt.base.ui.fragment.BaseViewModel
import com.yucelt.domain.model.CityWeather
import com.yucelt.domain.model.FavoriteCity
import com.yucelt.domain.usecase.GetWeatherByCityNameUseCase
import com.yucelt.domain.usecase.SaveFavoriteCityUseCase
import com.yucelt.weather.R
import com.yucelt.weather.component.temperature.TemperatureViewData
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

    val tempViewObserver = ObservableField<TemperatureViewData>()
    val feelsLikeViewObserver = ObservableField<TemperatureViewData>()
    val tempMinViewObserver = ObservableField<TemperatureViewData>()
    val tempMaxViewObserver = ObservableField<TemperatureViewData>()

    fun getWeatherByCityName(cityName: String) {
        viewModelScope.launch {
            getWeatherByCityNameUseCase.invoke(cityName).collect {
                _resource.postValue(it)
                it.data?.let { data ->
                    _cityWeather.postValue(data)
                    tempViewObserver.set(TemperatureViewData(R.string.temp, data.main?.prettyTemp))
                    feelsLikeViewObserver.set(TemperatureViewData(R.string.feels_like, data.main?.prettyFeelsLike))
                    tempMinViewObserver.set(TemperatureViewData(R.string.temp_min, data.main?.prettyTempMin))
                    tempMaxViewObserver.set(TemperatureViewData(R.string.temp_max, data.main?.prettyTempMax))
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