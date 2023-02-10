package com.example.gymtracker.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Training (
        @PrimaryKey(autoGenerate = false)
        var exercise:String,
        var kg:String,
        var date:String
        )