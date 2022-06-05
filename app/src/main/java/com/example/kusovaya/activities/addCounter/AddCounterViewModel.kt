package com.example.kusovaya.activities.addCounter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kusovaya.dataBase.AppDatabase
import com.example.kusovaya.dataBase.entities.Counter
import com.example.kusovaya.dataBase.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class AddCounterViewModel(application: Application) : AndroidViewModel(application)
{
    private val repository : Repository

    init {
        val myDao = AppDatabase.getDatabase(application).getMyDao()
        repository = Repository(myDao)
    }

    fun addCounter(counter: Counter){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCounter(counter)
        }
    }
}