package com.example.gymtracker

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class TrainingAdd : AppCompatActivity() {
    private var dataText: TextView? = null
    lateinit var wybranaData:String
    lateinit var exercise:String
    private val listaEx = arrayListOf<String>()
    private val listaKg = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training_add)
        val btnZapisz = findViewById<Button>(R.id.btn_dodaj_submit)
        val btnEx = findViewById<Button>(R.id.btn_ex)
        val btnDate = findViewById<Button>(R.id.btn_dodaj_date)
        dataText = findViewById(R.id.tv_date_dodaj)
        val addLayout = findViewById<LinearLayout>(R.id.add_layout)
        btnDate.setOnClickListener {
            klikDatePicker()
        }
            newInput(addLayout,btnEx,btnZapisz)
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
            if (position>0){
                exercise = (adapterView?.getItemAtPosition(position).toString())
                listaEx.add(exercise)
            }
        }
        override fun onNothingSelected(p0: AdapterView<*>?) {
        }
    }
}
    private fun newInput(LL:LinearLayout, btn:Button,btn2:Button){
        val list = arrayListOf<EditText>()
        btn.setOnClickListener {
            val inputLayout = layoutInflater.inflate(R.layout.input_layout,null)
            spin(inputLayout.findViewById(R.id.spinnerADD))
            val editText = inputLayout.findViewById<EditText>(R.id.et_kg_dodajADD)
            list.add(editText)
            LL.addView(inputLayout)
        }
        btn2.setOnClickListener {
            for(item in list){
                listaKg.add(item.text.toString())
            }
            Intent(this, MainActivity::class.java).also {
                it.putStringArrayListExtra("EXTRA_EXERCISE",listaEx)
                it.putStringArrayListExtra("EXTRA_WEIGHT",listaKg)
                it.putExtra("EXTRA_DATE",wybranaData)
                startActivity(it)
            }
        }
    }
}

