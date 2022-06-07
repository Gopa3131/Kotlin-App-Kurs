package com.example.kusovaya.dataBase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "hot_water_records_table",
    foreignKeys = [ForeignKey(entity = Counter::class, parentColumns = arrayOf("id"),
        childColumns = arrayOf(("counterId")), onDelete = ForeignKey.NO_ACTION)]
)
data class HotWaterRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(index = true)
    val counterId:Int,
    val date: String,
    val indication: Int
    //val difference : Int
)
