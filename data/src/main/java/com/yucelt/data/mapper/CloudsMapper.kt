package com.yucelt.data.mapper

import com.yucelt.data.model.dto.CloudsDto
import com.yucelt.data.model.entity.CloudsEntity
import com.yucelt.domain.model.Clouds

fun CloudsDto?.mapDtoToModel() = Clouds(all = this?.all)

fun CloudsDto?.mapDtoToEntity() = CloudsEntity(all = this?.all)

fun CloudsEntity?.mapEntityToModel() = Clouds(all = this?.all)