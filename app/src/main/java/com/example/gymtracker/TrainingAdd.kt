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
    lateinit var wybranaData:String
    lateinit var exercise:String
    lateinit var waga:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training_add)
        val btnZapisz = findViewById<Button>(R.id.btn_dodaj_submit)
        val btnEx = findViewById<Button>(R.id.btn_ex)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val btnDate = findViewById<Button>(R.id.btn_dodaj_date)
        val kgInput = findViewById<EditText>(R.id.et_kg_dodaj)
        dataText = findViewById(R.id.tv_date_dodaj)
        val addLayout = findViewById<LinearLayout>(R.id.add_layout)
        var i = 1
        btnEx.setOnClickListener {
                val inputLayout = layoutInflater.inflate(R.layout.input_layout,null)
                inputLayout.id = i++
                addLayout.addView(inputLayout)
        }
        spin(spinner)
        btnDate.setOnClickListener {
            klikDatePicker()
        }
        btnZapisz.setOnClickListener {
            waga = kgInput.text.toString()
            val training = Training(exercise,waga,wybranaData)
            Intent(this, MainActivity::class.java).also {
                it.putExtra("EXTRA_TRAINING",training)
                startActivity(it)
            }
        }
    }
    private fun klikDatePicker() {
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
    }
    private fun spin(spinner:Spinner){
    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(
            adapterView: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            exercise = (adapterView?.getItemAtPosition(position).toString())
        }
        override fun onNothingSelected(p0: AdapterView<*>?) {
        }
    }
}
}

