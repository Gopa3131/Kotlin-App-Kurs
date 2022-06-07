package com.example.kusovaya.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kusovaya.dataBase.entities.*

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCounter(counter : Counter) //suspend for coroutines

    @Query("SELECT * FROM counter_table")
    fun readAllCounters(): LiveData<List<Counter>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addColdWaterRecord(coldWaterRecord: ColdWaterRecord)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHotWaterRecord(hotWaterRecord: HotWaterRecord)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addGasRecord(gasRecord: GasRecord)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addElectricityRecord(electricityRecord: ElectricityRecord)

    @Query("SELECT * FROM cold_water_records_table WHERE counterId = :counterId")
    fun readColdWaterRecordsByCounter(counterId : Int): LiveData<List<ColdWaterRecord>>

    @Query("SELECT * FROM hot_water_records_table WHERE counterId = :counterId ")
    fun readHotWaterRecordsByCounter(counterId : Int): LiveData<List<HotWaterRecord>>

    @Query("SELECT * FROM gas_records_table WHERE counterId = :counterId ")
    fun readGasRecordsByCounter(counterId : Int): LiveData<List<GasRecord>>

    @Query("SELECT * FROM electricity_records_table WHERE counterId = :counterId ")
    fun readElectricityRecordsByCounter(counterId : Int): LiveData<List<ElectricityRecord>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRates(rate: Rate)

    @Query("SELECT * FROM rates ORDER BY id DESC LIMIT 1")
    fun getRates():Rate
}