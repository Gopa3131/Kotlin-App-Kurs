package com.example.kusovaya.activities.counterHistory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.InternalCoroutinesApi
import java.lang.IllegalArgumentException

@InternalCoroutinesApi
class CounterHistoryViewModelFactory(private val application: Application, private var counterId: Int, private var counterType: Int) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CounterHistoryViewModel::class.java)){
            return CounterHistoryViewModel(application, counterId, counterType) as T
        }
        throw IllegalArgumentException("i don't know what that means")
    }
}