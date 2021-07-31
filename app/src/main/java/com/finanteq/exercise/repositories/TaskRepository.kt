package com.finanteq.exercise.repositories

import androidx.lifecycle.LiveData
import com.finanteq.exercise.models.Task

interface TaskRepository {
    fun getTasks(): LiveData<List<Task>>
    fun addTask()
}