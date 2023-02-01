package com.example.gymtracker

import androidx.room.Dao
import androidx.room.Insert
import com.example.gymtracker.entities.Training

@Dao
interface TrainingDao {

    @Insert
    suspend fun insertTraining(training: Training)
}