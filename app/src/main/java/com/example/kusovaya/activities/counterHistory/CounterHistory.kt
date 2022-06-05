package com.example.kusovaya.activities.counterHistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kusovaya.R
import com.example.kusovaya.activities.addRecord.AddRecordActivity
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class CounterHistory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter_history)
        val counterId = intent.getIntExtra("counterId", 5)
        val counterType = intent.getIntExtra("counterType", 5)

        val addRecordBtn : Button = findViewById(R.id.activity_counter_history_addRecordBtn)

        addRecordBtn.setOnClickListener{
            val intent : Intent = Intent(this, AddRecordActivity::class.java)
            intent.putExtra("counterId", counterId)
            intent.putExtra("counterType", counterType)
            startActivity(intent)
        }
    }
}