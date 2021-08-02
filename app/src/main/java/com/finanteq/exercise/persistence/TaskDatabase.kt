package com.finanteq.exercise.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.finanteq.exercise.models.Converters
import com.finanteq.exercise.models.Task

@Database(entities = [Task::class], version = 1)
@TypeConverters(Converters::class)
abstract class TaskDatabase: RoomDatabase() {

    abstract fun roomTaskDao(): TaskDao

    companion object {
        private const val DATABASE = "tasks_db"

        @Volatile
        private var instance: TaskDatabase? = null

        fun getInstance(context: Context): TaskDatabase{
            return instance ?: synchronized(this){
                instance ?: buildDatabse(context).also { instance = it }
            }
        }

        private fun buildDatabse(context: Context): TaskDatabase {
            return Room.databaseBuilder(context, TaskDatabase::class.java, DATABASE).build()
        }
    }


}