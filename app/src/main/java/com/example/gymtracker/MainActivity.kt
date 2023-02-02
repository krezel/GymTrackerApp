package com.example.gymtracker

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.gymtracker.entities.Training
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAdd = findViewById<Button>(R.id.btn_dodaj)
        val btnDelete = findViewById<Button>(R.id.btn_delete)
        newTraining(btnDelete)
        btnAdd.setOnClickListener {
            Intent(this, TrainingAdd::class.java).also {
                startActivity(it)
            }
        }
    }
    private fun newTraining(btn:Button){
        val dao = TrainingDatabase.getInstance(this).trainingDao
        val addToList = findViewById<LinearLayout>(R.id.scroll_layout)
        val listaEx = intent.getStringArrayListExtra("EXTRA_EXERCISE")
        val listaKg = intent.getStringArrayListExtra("EXTRA_WEIGHT")
        val date = intent.getStringExtra("EXTRA_DATE")
        val dateBox = layoutInflater.inflate(R.layout.date_box,null)
        if (listaEx != null && listaKg != null && date != null) {
            dateBox.findViewById<TextView>(R.id.tv_dateBOX).text = date
            addToList.addView(dateBox)
            for (i in listaEx.indices){
                val trainingBox = layoutInflater.inflate(R.layout.training_box,null)
                trainingBox.findViewById<TextView>(R.id.tv_exerciseBOX).text = listaEx[i]
                trainingBox.findViewById<TextView>(R.id.tv_kgBOX).text = listaKg[i]
                addToList.addView(trainingBox)
            }
        }
        btn.setOnClickListener {
            lifecycleScope.launch {
                if (listaEx != null && listaKg != null && date != null)
                    dao.deleteTraining(Training(listaEx,listaKg,date))
            }
        }
    }
}