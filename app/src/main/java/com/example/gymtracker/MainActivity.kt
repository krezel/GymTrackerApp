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
        tvEx.text = intent.getStringExtra("EXTRA_EXERCISE")
        tvData.text = intent.getStringExtra("EXTRA_DATE")
        tvKg.text = intent.getStringExtra("EXTRA_WEIGHT")
        btnAdd.setOnClickListener {
            Intent(this, TrainingAdd::class.java).also {
                startActivity(it)
            }
        }
    }
}