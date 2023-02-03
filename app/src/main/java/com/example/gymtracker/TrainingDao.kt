package com.example.gymtracker

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.gymtracker.entities.Training

@Dao
interface TrainingDao {

    @Insert
    suspend fun insertTraining(training: Training)
    @Delete
    suspend fun deleteTraining(training: Training)
    @Query
        ("DELETE FROM Training")
    suspend fun deleteAll()
    @Query
        ("SELECT * FROM Training")
    fun getAll() : List<Training>
}