package com.yucelt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yucelt.data.local.converter.CityWeatherConverters
import com.yucelt.data.local.dao.AppDao
import com.yucelt.data.model.entity.CityWeatherEntity
import com.yucelt.data.model.entity.FavoriteCityEntity

@Database(
    entities = [FavoriteCityEntity::class, CityWeatherEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(CityWeatherConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteCityDao(): AppDao
}
