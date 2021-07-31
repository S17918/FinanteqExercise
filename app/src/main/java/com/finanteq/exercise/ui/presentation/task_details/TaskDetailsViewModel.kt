package com.finanteq.exercise.ui.presentation.task_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.finanteq.exercise.models.Task
import com.finanteq.exercise.repositories.TaskRepository

class TaskDetailsViewModel(private val repository: TaskRepository) : ViewModel() {

    private var task: MutableLiveData<Task> = MutableLiveData()

    fun setTask(task: Task){
        this.task.value = task
    }

    fun getTask(): LiveData<Task> {
        return task
    }
}