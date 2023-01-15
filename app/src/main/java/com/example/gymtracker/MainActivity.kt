package com.example.gymtracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAdd = findViewById<Button>(R.id.btn_dodaj)
        val tvData = findViewById<TextView>(R.id.tv_date)
        val tvEx = findViewById<TextView>(R.id.tv_exercise)
        val tvKg = findViewById<TextView>(R.id.tv_kg)
        btnAdd.setOnClickListener {
            newActivity()
        }
        val listaCwiczen = intent.getStringArrayListExtra("cwiczenie")
        tvEx.text = listaCwiczen?.get(6)
        tvData.text = intent.getStringExtra("data")
        tvKg.text = intent.getStringExtra("ciezar")
    }
    private fun newActivity(){
        val intent1 = Intent(this, TrainingAdd::class.java)
        startActivity(intent1)
    }
}