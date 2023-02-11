package com.example.gymtracker.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Training (
        @PrimaryKey(autoGenerate = true)
        val id:Int?,
        var exercise:String,
        var kg:String,
        var date:String
        )