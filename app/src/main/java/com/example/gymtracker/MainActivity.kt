package com.example.gymtracker

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymtracker.entities.Training
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = TrainingDatabase.getInstance(this).trainingDao
        val btnAdd = findViewById<Button>(R.id.btn_dodaj)
        val btnDelete = findViewById<Button>(R.id.btn_delete)
        val session = InputTraining(dao)
        session.newTraining()
        session.delTraining(btnDelete)
        btnAdd.setOnClickListener {
            Intent(this, TrainingAdd::class.java).also {
                startActivity(it)
            }
        }
    }
    inner class InputTraining(private val dao: TrainingDao){
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        fun newTraining(){
            lifecycleScope.launch {
                val date = dao.getDate()
                val lista = mutableListOf<Training>()
                for (i in date.indices) {
                    val listTraining = dao.getDateWithTraining(date[i])
                    for (x in listTraining[0].Training.indices){
                        lista.add(listTraining[0].Training[x])
                    }
                }
                val adapter = TrainingAdapter(lista)
                recycler.adapter = adapter
                recycler.layoutManager = LinearLayoutManager(this@MainActivity)
            }
            }
        fun delTraining(btn:Button){
            btn.setOnClickListener {
                lifecycleScope.launch {
                        dao.deleteD()
                    dao.deleteT()
                }
            }
        }
    }

}