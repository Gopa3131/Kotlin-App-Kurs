package com.example.kusovaya.dataBase

import androidx.lifecycle.LiveData

//repository allows to access multiple data sources from one place
class Repository(private val myDao: MyDao) {

    val readAllCounters : LiveData<List<Counter>> = myDao.readAllCounters()

    suspend fun addCounter(counter: Counter){
        myDao.addCounter(counter)
    }

}