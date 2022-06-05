package com.example.kusovaya.fragments.counters

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kusovaya.dataBase.AppDatabase
import com.example.kusovaya.dataBase.entities.Counter
import com.example.kusovaya.dataBase.Repository
import kotlinx.coroutines.InternalCoroutinesApi

//difference between ViewModel and AndroidViewModel is AndroidViewModel can use Application context
@InternalCoroutinesApi
class CountersViewModel(application: Application) : AndroidViewModel(application) {

    val readAllCounters: LiveData<List<Counter>>
    private val repository : Repository

    init {
        val myDao = AppDatabase.getDatabase(application).getMyDao()
        repository = Repository(myDao)
        readAllCounters = repository.readAllCounters
    }

}