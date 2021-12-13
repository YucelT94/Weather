package com.yucelt.data.di

import android.app.Application
import androidx.room.Room
import com.yucelt.common.util.Constant
import com.yucelt.data.BuildConfig
import com.yucelt.data.local.AppDatabase
import com.yucelt.data.local.dao.FavoriteCityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        val dbName = if (BuildConfig.DEBUG) Constant.DB_NAME_BETA else Constant.DB_NAME
        return Room.databaseBuilder(
            application, AppDatabase::class.java, dbName
        ).allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideFavoriteCityDao(appDatabase: AppDatabase): FavoriteCityDao {
        return appDatabase.favoriteCityDao()
    }
}