package com.yucelt.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yucelt.common.util.Constant
import com.yucelt.data.model.entity.CityWeatherEntity
import com.yucelt.data.model.entity.FavoriteCityEntity

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavoriteCity(favoriteCityEntity: FavoriteCityEntity?): Long?

    @Query("SELECT * FROM ${Constant.FAVORITE_CITY_TABLE_NAME}")
    suspend fun getAllFavoriteCities(): List<FavoriteCityEntity>?

    @Query("DELETE FROM ${Constant.FAVORITE_CITY_TABLE_NAME} WHERE id = :id")
    suspend fun deleteFavoriteCity(id: Int?): Int?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWeatherByCityName(cityWeatherEntity: CityWeatherEntity?): Long?

    @Query("SELECT * FROM ${Constant.CITY_WEATHER_TABLE_NAME} WHERE name = :cityName")
    suspend fun getWeatherByCityName(cityName: String?): CityWeatherEntity?
}