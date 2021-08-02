package com.finanteq.exercise.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.finanteq.exercise.models.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks ORDER BY date ASC")
    fun getTasks(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task): Long

}