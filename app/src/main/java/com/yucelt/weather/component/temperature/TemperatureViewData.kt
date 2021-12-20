package com.yucelt.weather.component.temperature

import androidx.annotation.StringRes

data class TemperatureViewData(
    @StringRes val title: Int?,
    val temperature: String?
)