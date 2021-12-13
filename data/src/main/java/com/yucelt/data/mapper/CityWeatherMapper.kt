package com.yucelt.data.mapper

import com.yucelt.data.model.dto.CityWeatherDto
import com.yucelt.domain.model.CityWeather

fun CityWeatherDto?.mapDtoToModel() = CityWeather(
    coord = this?.coord?.mapDtoToModel(),
    weather = this?.weather?.mapListDtoToListModel(),
    base = this?.base,
    main = this?.main?.mapDtoToModel(),
    visibility = this?.visibility,
    wind = this?.wind?.mapDtoToModel(),
    rain = this?.rain?.mapDtoToModel(),
    clouds = this?.clouds?.mapDtoToModel(),
    dt = this?.dt,
    sys = this?.sys?.mapDtoToModel(),
    timezone = this?.timezone,
    id = this?.id,
    name = this?.name,
    cod = this?.cod
)
