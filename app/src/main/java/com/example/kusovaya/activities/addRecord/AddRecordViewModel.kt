package com.example.kusovaya.activities.addRecord

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kusovaya.dataBase.AppDatabase
import com.example.kusovaya.dataBase.Repository
import com.example.kusovaya.dataBase.entities.ColdWaterRecord
import com.example.kusovaya.dataBase.entities.Counter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class AddRecordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : Repository

    init {
        val myDao = AppDatabase.getDatabase(application).getMyDao()
        repository = Repository(myDao)
    }

    fun addColdWaterRecord(coldWaterRecord: ColdWaterRecord){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addColdWaterRecord(coldWaterRecord)
        }
    }
}
