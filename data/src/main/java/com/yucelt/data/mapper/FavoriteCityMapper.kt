package com.yucelt.data.mapper

import com.yucelt.data.model.entity.FavoriteCityEntity
import com.yucelt.domain.model.FavoriteCity

fun List<FavoriteCityEntity>?.mapListEntityToListModel() = this?.map { it.mapEntityToModel() }

fun FavoriteCityEntity?.mapEntityToModel() = FavoriteCity(
    id = this?.id ?: 0,
    name = this?.name
)

fun List<FavoriteCity>?.mapListModelToListEntity() = this?.map { it.mapModelToEntity() }

fun FavoriteCity?.mapModelToEntity() = FavoriteCityEntity(
    id = this?.id ?: 0,
    name = this?.name
)