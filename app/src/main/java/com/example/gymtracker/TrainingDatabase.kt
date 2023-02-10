package com.example.gymtracker

import android.content.Context
import androidx.room.*
import com.example.gymtracker.entities.Date
import com.example.gymtracker.entities.Training

@Database(entities = [
    Training::class,
    Date::class
],
    version = 1
)
@TypeConverters(Converters::class)
abstract class TrainingDatabase : RoomDatabase(){
    abstract val trainingDao: TrainingDao
    companion object{
        @Volatile
        private var INSTANCE:TrainingDatabase?=null

        fun getInstance(context:Context): TrainingDatabase {
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    TrainingDatabase::class.java,
                    "training_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
