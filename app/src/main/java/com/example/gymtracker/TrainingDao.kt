package com.example.gymtracker

import androidx.room.*
import com.example.gymtracker.entities.Date
import com.example.gymtracker.entities.DateWithTraining
import com.example.gymtracker.entities.Training

@Dao
interface TrainingDao {

    @Insert
    suspend fun insertTraining(training: Training)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDate(date: Date)
    @Delete
    suspend fun deleteTraining(training: Training)
    @Query
        ("DELETE FROM Date")
    suspend fun deleteD()

    @Query
        ("DELETE FROM Training")
    suspend fun deleteT()
    @Query
        ("SELECT exercise FROM Training")
    suspend fun getExe() : List<String>
    @Query
        ("SELECT kg FROM Training")
    suspend fun getKg() : List<String>
    @Query
        ("SELECT date FROM Date")
    suspend fun getDate() : List<String>

    @Transaction
    @Query("SELECT * FROM Date WHERE date = :date")
    suspend fun getDateWithTraining(date: String) : List<DateWithTraining>
}