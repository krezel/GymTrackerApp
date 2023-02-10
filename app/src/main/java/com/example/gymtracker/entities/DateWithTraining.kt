package com.example.gymtracker.entities

import androidx.room.Embedded
import androidx.room.Relation

data class DateWithTraining (
    @Embedded var date:Date,
    @Relation(
        parentColumn = "date",
        entityColumn = "date"
    )
    var Training : List<Training>
        )
