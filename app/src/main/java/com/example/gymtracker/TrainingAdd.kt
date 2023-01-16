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
    var listExercise = arrayListOf<String>()
    var listWeight = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training_add)
        val btnZapisz = findViewById<Button>(R.id.btn_dodaj_submit)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val spinner3 = findViewById<Spinner>(R.id.spinner3)
        val spinner4 = findViewById<Spinner>(R.id.spinner4)
        val spinner5 = findViewById<Spinner>(R.id.spinner5)
        val spinner6 = findViewById<Spinner>(R.id.spinner6)
        val btnDate = findViewById<Button>(R.id.btn_dodaj_date)
        val kgInput = findViewById<EditText>(R.id.et_kg_dodaj)
        val kgInput2 = findViewById<EditText>(R.id.et_kg_dodaj2)
        val kgInput3 = findViewById<EditText>(R.id.et_kg_dodaj3)
        val kgInput4 = findViewById<EditText>(R.id.et_kg_dodaj4)
        val kgInput5 = findViewById<EditText>(R.id.et_kg_dodaj5)
        val kgInput6 = findViewById<EditText>(R.id.et_kg_dodaj6)
        dataText = findViewById(R.id.tv_date_dodaj)
        spin(spinner)
        spin(spinner2)
        spin(spinner3)
        spin(spinner4)
        spin(spinner5)
        spin(spinner6)
        btnDate.setOnClickListener {
            klikDatePicker()
        }
        btnZapisz.setOnClickListener {
            listWeight.add(kgInput.text.toString())
            listWeight.add(kgInput2.text.toString())
            listWeight.add(kgInput3.text.toString())
            listWeight.add(kgInput4.text.toString())
            listWeight.add(kgInput5.text.toString())
            listWeight.add(kgInput6.text.toString())
            oldActivity()
        }
    }
    private fun oldActivity(){
        val intent = Intent(this, MainActivity::class.java)
        intent.putStringArrayListExtra("cwiczenie",listExercise)
        intent.putStringArrayListExtra("ciezar",listWeight)
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
    private fun spin(spinner:Spinner){
    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(
            adapterView: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            listExercise.add(adapterView?.getItemAtPosition(position).toString())
        }
        override fun onNothingSelected(p0: AdapterView<*>?) {
        }
    }
}
}

