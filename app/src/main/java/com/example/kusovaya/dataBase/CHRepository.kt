package com.example.kusovaya.dataBase

import androidx.lifecycle.LiveData
import com.example.kusovaya.dataBase.entities.ColdWaterRecord
import com.example.kusovaya.dataBase.entities.ElectricityRecord
import com.example.kusovaya.dataBase.entities.GasRecord
import com.example.kusovaya.dataBase.entities.HotWaterRecord

class CHRepository(private val myDao: MyDao, private val counterId : Int) {

    val readColdWaterRecords: LiveData<List<ColdWaterRecord>> by lazy {
        myDao.readColdWaterRecordsByCounter(counterId)
    }

    val readHotWaterRecords: LiveData<List<HotWaterRecord>> by lazy {
        myDao.readHotWaterRecordsByCounter(counterId)
    }

    val readGasRecords: LiveData<List<GasRecord>> by lazy {
        myDao.readGasRecordsByCounter(counterId)
    }

    val readElectricityRecords: LiveData<List<ElectricityRecord>> by lazy {
        myDao.readElectricityRecordsByCounter(counterId)
    }

}