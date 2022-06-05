package com.example.kusovaya.dataBase.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "gas_records_table",
    foreignKeys = [ForeignKey(entity = Counter::class, parentColumns = arrayOf("id"),
        childColumns = arrayOf(("counterId")), onDelete = ForeignKey.NO_ACTION)]
)
data class GasRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val counterId:Int,
    //val date: Date,
    val indication: Int
    //val difference : Int
)