package com.example.kusovaya.activities.addCounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.example.kusovaya.R
import com.example.kusovaya.dataBase.entities.Counter
import kotlinx.coroutines.InternalCoroutinesApi

class AddCounterActivity : AppCompatActivity() {

    @InternalCoroutinesApi
    private lateinit var viewModel : AddCounterViewModel



    @OptIn(InternalCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_counter)


        viewModel = ViewModelProvider(this).get(AddCounterViewModel::class.java)

        val addCounterButton : Button = findViewById(R.id.addCounterActivity_addCounterButton)
        val counterTypeSpinner : Spinner = findViewById(R.id.addCounterActivity_spinner)

        val counterTypeList : Array<String> = resources.getStringArray(R.array.counter_types)
        val adapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, counterTypeList)
        counterTypeSpinner.adapter = adapter

        addCounterButton.setOnClickListener {
            insertToDatabase()
        }
    }


    @InternalCoroutinesApi
    private fun insertToDatabase() {

        val nameEditText : EditText = findViewById(R.id.addCounterActivity_addName)
        val placeEditText : EditText = findViewById(R.id.addCounterActivity_addPlace)
        val serNumEditText : EditText = findViewById(R.id.addCounterActivity_addSerNumber)
        val counterTypeSpinner : Spinner = findViewById(R.id.addCounterActivity_spinner)

        val name : String = nameEditText.text.toString()
        val place : String = placeEditText.text.toString()
        val serNum : String = serNumEditText.text.toString()
        //val counterType : String = counterTypeSpinner.selectedItem.toString()
        val counterType : Int = when (counterTypeSpinner.selectedItem.toString()){
            "Газ" -> 0
            "Электричество" -> 1
            "Холодное водоснабжение" -> 2
            "Горячее водоснабжение" -> 3
            else -> {4} // для горячего
        }
        println("countertype - $counterType")

        if (inputCheck(name, place, serNum)) {
            val counter : Counter = Counter(0, name, counterType, place, serNum)
            viewModel.addCounter(counter)

            Toast.makeText(this, "Счетчик добавлен", Toast.LENGTH_LONG).show()

            finish()
        }
        else {
            Toast.makeText(this, "Заполните пустые поля", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(name: String, place: String, serNum: String): Boolean {
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(place) || TextUtils.isEmpty(serNum))
    }
}