package com.example.kusovaya.dataBase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

//difference between ViewModel and AndroidViewModel is AndroidViewModel can use Application context
@InternalCoroutinesApi
class CountersViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllCounters: LiveData<List<Counter>>
    private val repository : Repository

    init {
        val myDao = AppDatabase.getDatabase(application).getMyDao()
        repository = Repository(myDao)
        readAllCounters = repository.readAllCounters
    }

    fun addCounter(counter: Counter){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCounter(counter)
        }
    }

}