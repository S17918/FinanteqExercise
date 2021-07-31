package com.finanteq.exercise.ui.presentation.task_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.finanteq.exercise.models.Task
import com.finanteq.exercise.repositories.TaskRepository

class TaskListViewModel(private val repository: TaskRepository) : ViewModel() {
    fun getTasks(): LiveData<List<Task>> {
        return repository.getTasks()
    }

    fun addTask() {
        TODO("Not yet implemented")
    }
}