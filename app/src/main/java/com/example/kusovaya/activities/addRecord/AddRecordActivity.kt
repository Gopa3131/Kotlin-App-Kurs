package com.example.kusovaya.activities.addRecord

import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.kusovaya.R
import com.example.kusovaya.dataBase.entities.ColdWaterRecord
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class AddRecordActivity : AppCompatActivity() {

    lateinit var viewModel : AddRecordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_record)

        val counterId = intent.getIntExtra("counterId", 5 )
        val counterType = intent.getIntExtra("counterType", 5)

        val calendar : DatePicker = findViewById(R.id.addRecordActivity_datePicker)
        val dateEdText : EditText = findViewById(R.id.addRecordActivity_date_edText)
        val indicationEdText : EditText = findViewById(R.id.addRecordActivity_indication_edText)
        val addRecordBtn : Button = findViewById(R.id.addRecordActivity_addRecordButton)

        viewModel = ViewModelProvider(this).get(AddRecordViewModel::class.java)

        addRecordBtn.setOnClickListener {
            val indication : String = indicationEdText.text.toString()
            if (inputCheck(indication)){
                if (counterType == 0){

                }
                else if (counterType == 1) {

                }
                else if (counterType == 2) {
                    addColdWaterRecord(counterId, indication.toInt())
                }
                else {

                }
                Toast.makeText(this, "Запись добавлена", Toast.LENGTH_SHORT).show()
                finish()
            }
            else {
                Toast.makeText(this, "Заполните пустые поля", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addColdWaterRecord(counterId : Int, indication: Int) {
        val coldWaterRecord: ColdWaterRecord = ColdWaterRecord(0,counterId,indication)
        viewModel.addColdWaterRecord(coldWaterRecord)
    }

    private fun inputCheck(indication: String): Boolean {
        return !(TextUtils.isEmpty(indication))
    }
}