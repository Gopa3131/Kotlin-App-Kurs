package com.example.kusovaya.dataBase

import androidx.lifecycle.LiveData
import com.example.kusovaya.dataBase.entities.ColdWaterRecord

class CHRepository(private val myDao: MyDao, private val counterId : Int) {

    val readColdWaterRecords: LiveData<List<ColdWaterRecord>> by lazy {
        myDao.readColdWaterRecordsByCounter(counterId)
    }

}