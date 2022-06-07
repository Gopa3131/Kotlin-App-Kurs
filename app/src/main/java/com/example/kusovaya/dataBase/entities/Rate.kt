package com.example.kusovaya.dataBase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rates")
data class Rate(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val ColdWaterRate: Float,
    val HotWaterRate: Float,
    val GasRate: Float,
    val electricityRate: Float
)
