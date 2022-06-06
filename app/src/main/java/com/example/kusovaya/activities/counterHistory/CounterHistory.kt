package com.example.kusovaya.activities.counterHistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kusovaya.R
import com.example.kusovaya.activities.addRecord.AddRecordActivity
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class CounterHistory : AppCompatActivity(){

    lateinit var viewModel : CounterHistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter_history)

        val counterId = intent.getIntExtra("counterId", 5)
        val counterType = intent.getIntExtra("counterType", 5)

        val recycler : RecyclerView = findViewById(R.id.activity_counter_history_recycler)
        val adapter = CounterHistoryRecyclerAdapter(counterType)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        val viewModelFactory = CounterHistoryViewModelFactory(application, counterId, counterType)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CounterHistoryViewModel::class.java)
        when (counterType) {
            0 -> {
            }
            1 -> {
            }
            2 -> {
                viewModel.readColdWaterRecord.observe(this, Observer { records ->  adapter.setData(records)})
            }
            else -> {
            }
        }


        val addRecordBtn : Button = findViewById(R.id.activity_counter_history_addRecordBtn)
        addRecordBtn.setOnClickListener{
            val intent : Intent = Intent(this, AddRecordActivity::class.java)
            intent.putExtra("counterId", counterId)
            intent.putExtra("counterType", counterType)
            startActivity(intent)
        }
    }
}