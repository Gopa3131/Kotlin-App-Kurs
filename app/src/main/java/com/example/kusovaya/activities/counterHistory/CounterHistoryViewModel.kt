package com.example.kusovaya.activities.counterHistory

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kusovaya.dataBase.AppDatabase
import com.example.kusovaya.dataBase.CHRepository
import com.example.kusovaya.dataBase.entities.ColdWaterRecord
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class CounterHistoryViewModel(application: Application, counterId : Int, counterType: Int) : AndroidViewModel(application) {

    private val repository: CHRepository
    lateinit var readColdWaterRecord : LiveData<List<ColdWaterRecord>>


    init {
        val myDao = AppDatabase.getDatabase(application).getMyDao()
        repository = CHRepository(myDao, counterId)

        if (counterType == 2){
            readColdWaterRecord = repository.readColdWaterRecords
        }
    }

}
