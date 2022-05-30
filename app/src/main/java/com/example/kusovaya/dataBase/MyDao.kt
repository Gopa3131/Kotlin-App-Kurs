package com.example.kusovaya.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCounter(counter : Counter) //suspend for coroutines

    @Query("SELECT * FROM counter_table")
    fun readAllCounters(): LiveData<List<Counter>>

}