package com.example.gymtracker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAdd = findViewById<Button>(R.id.btn_dodaj)
        val tvData = findViewById<TextView>(R.id.tv_date)
        val tvEx = findViewById<TextView>(R.id.tv_exercise)
        val tvKg = findViewById<TextView>(R.id.tv_kg)
        val training = intent.getSerializableExtra("EXTRA_TRAINING") as? Training
        tvData.text = training?.date
        tvEx.text = training?.name
        tvKg.text = training?.weight
        btnAdd.setOnClickListener {
            Intent(this, TrainingAdd::class.java).also {
                startActivity(it)
            }
        }
    }
}