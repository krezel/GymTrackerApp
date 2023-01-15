package com.example.gymtracker

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class TrainingAdd : AppCompatActivity() {
    private var dataText: TextView? = null
    var wybranaData:String? = null
    var listExercise:String? = null
    var listWeight:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training_add)
        val btnZapisz = findViewById<Button>(R.id.btn_dodaj_submit)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val btnDate = findViewById<Button>(R.id.btn_dodaj_date)
        val kgInput = findViewById<EditText>(R.id.et_kg_dodaj)
        dataText = findViewById(R.id.tv_date_dodaj)
        ArrayAdapter.createFromResource(
            this,
            R.array.exercise_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                listExercise = adapterView?.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        btnDate.setOnClickListener {
            klikDatePicker()
        }
        btnZapisz.setOnClickListener {
            listWeight = kgInput.text.toString()
            oldActivity()
        }
    }
    private fun oldActivity(){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("cwiczenie",listExercise)
        intent.putExtra("ciezar",listWeight)
        intent.putExtra("data",wybranaData)
        startActivity(intent)
    }
    private fun klikDatePicker(): CharSequence? {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(
            this, { _, wybranyRok, wybranyMiesiac, wybranyDzien ->
                wybranaData = "${wybranyDzien}/${wybranyMiesiac + 1}/${wybranyRok}"
                dataText?.text = wybranaData
            }, year, month, day
        )
        dpd.show()
        return dataText?.text
    }
}
