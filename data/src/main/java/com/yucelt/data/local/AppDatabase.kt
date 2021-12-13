package com.yucelt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yucelt.data.local.dao.FavoriteCityDao
import com.yucelt.data.model.entity.FavoriteCityEntity

@Database(
    entities = [FavoriteCityEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteCityDao(): FavoriteCityDao
}
