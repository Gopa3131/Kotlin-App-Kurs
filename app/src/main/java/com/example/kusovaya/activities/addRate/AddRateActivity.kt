package com.example.kusovaya.activities.addRate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.kusovaya.R
import com.example.kusovaya.dataBase.entities.Rate
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class AddRateActivity : AppCompatActivity() {
    private lateinit var viewModel: AddRateActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_rate)

        viewModel = ViewModelProvider(this).get(AddRateActivityViewModel::class.java)

        val gas : EditText = findViewById(R.id.addRateActivity_gas)
        val cold : EditText = findViewById(R.id.addRateActivity_coldWater)
        val hot : EditText = findViewById(R.id.addRateActivity_hotWater)
        val electricity : EditText = findViewById(R.id.addRateActivity_electricity)



        val btn : Button = findViewById(R.id.addRateActivity_addRatesBtn)
        btn.setOnClickListener{
            val gasRate = gas.text.toString().toFloat()
            val coldRate = cold.text.toString().toFloat()
            val hotRate = hot.text.toString().toFloat()
            val electricityRate = electricity.text.toString().toFloat()
            val rate : Rate = Rate(0, coldRate, hotRate, gasRate, electricityRate)
            viewModel.addRate(rate)
            Toast.makeText(this, "Тарифы добавлены", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}