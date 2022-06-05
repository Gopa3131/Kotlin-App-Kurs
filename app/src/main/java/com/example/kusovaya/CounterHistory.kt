package com.example.kusovaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kusovaya.dataBase.entities.Counter

class CounterHistory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter_history)
        val myIntent = intent
        val counter = myIntent.getIntExtra("counterId", 0)
        println(counter)
    }
}