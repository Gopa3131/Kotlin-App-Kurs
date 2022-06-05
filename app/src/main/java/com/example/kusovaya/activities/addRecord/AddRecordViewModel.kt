package com.example.kusovaya.activities.addRecord

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kusovaya.dataBase.AppDatabase
import com.example.kusovaya.dataBase.Repository
import com.example.kusovaya.dataBase.entities.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class AddRecordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository

    init {
        val myDao = AppDatabase.getDatabase(application).getMyDao()
        repository = Repository(myDao)
    }

    fun addColdWaterRecord(coldWaterRecord: ColdWaterRecord) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addColdWaterRecord(coldWaterRecord)
        }
    }

    fun addHotWaterRecord(hotWaterRecord: HotWaterRecord) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addHotWaterRecord(hotWaterRecord)
        }
    }

    fun addGasRecord(gasRecord: GasRecord) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGasRecord(gasRecord)
        }
    }

    fun addElectricityRecord(electricityRecord: ElectricityRecord) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addElectricityRecord(electricityRecord)
        }
    }
}

