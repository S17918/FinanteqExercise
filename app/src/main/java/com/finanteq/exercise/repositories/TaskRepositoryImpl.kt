package com.finanteq.exercise.repositories

import androidx.lifecycle.LiveData
import com.finanteq.exercise.models.Task

class TaskRepositoryImpl : TaskRepository{
    override fun getTasks(): LiveData<List<Task>> {
        TODO("Not yet implemented")
    }

    override fun addTask() {
        TODO("Not yet implemented")
    }
}