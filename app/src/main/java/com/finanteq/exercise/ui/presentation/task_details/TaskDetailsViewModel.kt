package com.finanteq.exercise.ui.presentation.task_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.finanteq.exercise.models.Task
import com.finanteq.exercise.repositories.TaskRepository

class TaskDetailsViewModel(private val repository: TaskRepository) : ViewModel() {

    fun getTasks(): LiveData<List<Task>> {
        return repository.getTasks()
    }
}