package com.yucelt.weather.ui.weather

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yucelt.base.domain.Resource
import com.yucelt.base.domain.ResourceState
import com.yucelt.base.ui.fragment.BaseViewModel
import com.yucelt.domain.usecase.GetWeatherByCityNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherByCityNameUseCase: GetWeatherByCityNameUseCase,
    application: Application
) : BaseViewModel(application) {
    override val resourceLiveData: MutableLiveData<Resource<*>>
        get() = _resource

    private val _resource = MutableLiveData<Resource<*>>()

    private var lastKnownCityId = 0
    private var lastKnownCityName = ""

    fun getWeatherByCityName(cityName: String) {
        viewModelScope.launch {
            val response = getWeatherByCityNameUseCase.execute(cityName)
            _resource.postValue(response)
            if (response.status == ResourceState.SUCCESS) {
                response.data?.let { data ->
                    lastKnownCityId = data.id ?: 0
                    lastKnownCityName = data.name ?: ""
                }
            }
        }
    }
}