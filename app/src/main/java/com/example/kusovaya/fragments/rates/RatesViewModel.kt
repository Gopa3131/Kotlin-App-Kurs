package com.example.kusovaya.fragments.rates

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kusovaya.dataBase.AppDatabase
import com.example.kusovaya.dataBase.Repository
import com.example.kusovaya.dataBase.entities.Rate
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class RatesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : Repository
    //lateinit var rate : Rate


    init {
        val myDao = AppDatabase.getDatabase(application).getMyDao()
        repository = Repository(myDao)
      //  rate = repository.getRate()

    }

}
