package com.example.kusovaya.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "counter_table")
data class Counter(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val name: String,
        val type: String,
        val place: String,
        val serialNumber: String,

        // TODO: 30.05.2022 add date thing
        //val installDate : Date,
        //val checkDate : Date
)
