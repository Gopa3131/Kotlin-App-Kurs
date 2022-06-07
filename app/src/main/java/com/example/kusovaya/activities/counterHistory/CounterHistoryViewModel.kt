package com.example.kusovaya.activities.counterHistory

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kusovaya.dataBase.AppDatabase
import com.example.kusovaya.dataBase.CHRepository
import com.example.kusovaya.dataBase.entities.ColdWaterRecord
import com.example.kusovaya.dataBase.entities.ElectricityRecord
import com.example.kusovaya.dataBase.entities.GasRecord
import com.example.kusovaya.dataBase.entities.HotWaterRecord
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class CounterHistoryViewModel(application: Application, counterId : Int, counterType: Int) : AndroidViewModel(application) {

    private val repository: CHRepository
    lateinit var readHotWaterRecord : LiveData<List<HotWaterRecord>>
    lateinit var readColdWaterRecord : LiveData<List<ColdWaterRecord>>
    lateinit var readGasRecord: LiveData<List<GasRecord>>
    lateinit var readElectricityRecord: LiveData<List<ElectricityRecord>>



    init {
        val myDao = AppDatabase.getDatabase(application).getMyDao()
        repository = CHRepository(myDao, counterId)

        if (counterType == 0){
            readGasRecord = repository.readGasRecords
        }
        else if (counterType == 1){
            readElectricityRecord = repository.readElectricityRecords
        }
        else if (counterType == 2){
            readColdWaterRecord = repository.readColdWaterRecords
        }
        else {
            readHotWaterRecord = repository.readHotWaterRecords
        }
    }

}
