package com.finanteq.exercise.ui.presentation.add_new_task

import androidx.lifecycle.ViewModel
import com.finanteq.exercise.models.Task
import com.finanteq.exercise.repositories.TaskRepository

class AddNewTaskViewModel(private val repository: TaskRepository) : ViewModel() {
    fun insertTask(task: Task) {
        repository.insertTask(task)
    }
}