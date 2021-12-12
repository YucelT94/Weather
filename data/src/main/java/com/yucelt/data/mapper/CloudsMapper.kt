package com.yucelt.data.mapper

import com.yucelt.data.dto.CloudsDto
import com.yucelt.domain.model.Clouds

fun CloudsDto?.mapDtoToModel() = Clouds(all = this?.all)