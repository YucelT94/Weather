package com.yucelt.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yucelt.common.util.Constant
import com.yucelt.data.model.entity.FavoriteCityEntity

@Dao
interface FavoriteCityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavoriteCity(user: FavoriteCityEntity)

    @Query("SELECT * FROM ${Constant.FAVORITE_CITY_TABLE_NAME}")
    suspend fun getAllFavoriteCities(): List<FavoriteCityEntity>?

    @Query("DELETE FROM ${Constant.FAVORITE_CITY_TABLE_NAME} WHERE id = :id")
    suspend fun deleteFavoriteCity(id: Int)
}