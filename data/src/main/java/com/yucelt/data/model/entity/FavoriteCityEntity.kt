package com.yucelt.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yucelt.common.util.Constant

@Entity(tableName = Constant.FAVORITE_CITY_TABLE_NAME)
data class FavoriteCityEntity(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "name") val name: String?
)