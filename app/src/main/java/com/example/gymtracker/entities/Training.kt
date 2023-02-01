package com.example.gymtracker.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Training (
        @PrimaryKey
        val exercise:ArrayList<String>,
        val kg:ArrayList<String>,
        val date:String
        )