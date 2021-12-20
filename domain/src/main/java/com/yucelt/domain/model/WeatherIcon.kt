package com.yucelt.domain.model

import androidx.annotation.DrawableRes
import com.yucelt.domain.R

enum class WeatherIcon(val iconName: String, @DrawableRes val iconId: Int) {
    CLEAR_SKY("01d", R.drawable.ic_clear),
    CLEAR_SKY_NIGHT("01n", R.drawable.ic_clear_night),
    FEW_CLOUDS("02d", R.drawable.ic_partlycloudy),
    FEW_CLOUDS_NIGHT("02m", R.drawable.ic_partlycloudy_night),
    SCATTERED_CLOUDS("03d", R.drawable.ic_mostlycloudy),
    SCATTERED_CLOUD_NIGHT("03n", R.drawable.ic_mostlycloudy_night),
    BROKEN_CLOUDS("04d", R.drawable.ic_cloudy),
    BROKEN_CLOUDS_NIGHT("04n", R.drawable.ic_cloudy_night),
    SHOWER_RAIN("09d", R.drawable.ic_sleet),
    SHOWER_RAIN_NIGHT("09n", R.drawable.ic_sleet_night),
    RAIN("10d", R.drawable.ic_rain),
    RAIN_NIGHT("10n", R.drawable.ic_rain_night),
    THUNDERSTORM("11d", R.drawable.ic_tstorms),
    THUNDERSTORM_NIGHT("11n", R.drawable.ic_tstorms_night),
    SNOW("13d", R.drawable.ic_snow),
    SNOW_NIGHT("13n", R.drawable.ic_snow_night),
    MIST("50d", R.drawable.ic_fog),
    MIST_NIGHT("50d", R.drawable.ic_fog_night);

    companion object {
        fun getIconId(iconName: String?): Int {
            return when (iconName) {
                CLEAR_SKY.iconName -> CLEAR_SKY.iconId
                CLEAR_SKY_NIGHT.iconName -> CLEAR_SKY_NIGHT.iconId
                FEW_CLOUDS.iconName -> FEW_CLOUDS.iconId
                FEW_CLOUDS_NIGHT.iconName -> FEW_CLOUDS_NIGHT.iconId
                SCATTERED_CLOUDS.iconName -> SCATTERED_CLOUDS.iconId
                SCATTERED_CLOUD_NIGHT.iconName -> SCATTERED_CLOUD_NIGHT.iconId
                BROKEN_CLOUDS.iconName -> BROKEN_CLOUDS.iconId
                BROKEN_CLOUDS_NIGHT.iconName -> BROKEN_CLOUDS_NIGHT.iconId
                SHOWER_RAIN.iconName -> SHOWER_RAIN.iconId
                SHOWER_RAIN_NIGHT.iconName -> SHOWER_RAIN_NIGHT.iconId
                RAIN.iconName -> RAIN.iconId
                RAIN_NIGHT.iconName -> RAIN_NIGHT.iconId
                THUNDERSTORM.iconName -> THUNDERSTORM.iconId
                THUNDERSTORM_NIGHT.iconName -> THUNDERSTORM_NIGHT.iconId
                SNOW.iconName -> SNOW.iconId
                SNOW_NIGHT.iconName -> SNOW_NIGHT.iconId
                MIST.iconName -> MIST.iconId
                MIST_NIGHT.iconName -> MIST_NIGHT.iconId
                else -> -1
            }
        }
    }
}