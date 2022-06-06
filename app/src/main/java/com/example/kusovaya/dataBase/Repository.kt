package com.example.kusovaya.dataBase

import androidx.lifecycle.LiveData
import com.example.kusovaya.dataBase.entities.*

//repository allows to access multiple data sources from one place
class Repository(private val myDao: MyDao) {

    val readAllCounters : LiveData<List<Counter>> = myDao.readAllCounters()

    suspend fun addCounter(counter: Counter){
        myDao.addCounter(counter)
    }

    suspend fun addColdWaterRecord(coldWaterRecord: ColdWaterRecord){
        myDao.addColdWaterRecord(coldWaterRecord)
    }

    suspend fun addHotWaterRecord(hotWaterRecord: HotWaterRecord){
        myDao.addHotWaterRecord(hotWaterRecord)
    }

    suspend fun addGasRecord(gasRecord: GasRecord){
        myDao.addGasRecord(gasRecord)
    }

    suspend fun addElectricityRecord(electricityRecord: ElectricityRecord){
        myDao.addElectricityRecord(electricityRecord)
    }

}