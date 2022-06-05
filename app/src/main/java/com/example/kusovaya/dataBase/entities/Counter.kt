package com.example.kusovaya.dataBase.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import java.sql.Date

@Parcelize
@Entity(tableName = "counter_table")
data class Counter(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val name: String,
        val type: Int,
        val place: String,
        val serialNumber: String,

        // TODO: 30.05.2022 add date thing
        //val installDate : Date,
        //val checkDate : Date
) : Parcelable
