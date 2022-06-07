package com.example.kusovaya.activities.addRate

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kusovaya.dataBase.AppDatabase
import com.example.kusovaya.dataBase.Repository
import com.example.kusovaya.dataBase.entities.Rate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class AddRateActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository

    init {
        val myDao = AppDatabase.getDatabase(application).getMyDao()
        repository = Repository(myDao)
    }

    fun addRate(rate:Rate){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRate(rate);
        }
    }

}