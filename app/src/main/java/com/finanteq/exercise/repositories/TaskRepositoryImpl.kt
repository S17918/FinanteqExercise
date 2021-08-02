package com.finanteq.exercise.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.finanteq.exercise.models.Task
import com.finanteq.exercise.persistence.TaskDao
import com.finanteq.exercise.persistence.TaskDatabase

class TaskRepositoryImpl(context: Context): TaskRepository{

    private val roomDatabase: TaskDatabase = TaskDatabase.getInstance(context)

    override fun getTasks(): LiveData<List<Task>> {
        return roomDatabase.roomTaskDao().getTasks()
    }

    override fun insertTask(task: Task) {
        roomDatabase.roomTaskDao().insertTask(task)
    }
}