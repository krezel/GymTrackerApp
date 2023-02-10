package com.example.gymtracker.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Date(
    @PrimaryKey(autoGenerate = false)
    var date:String
)
