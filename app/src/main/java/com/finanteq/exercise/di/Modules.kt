package com.finanteq.exercise.di

import com.finanteq.exercise.persistence.TaskDao
import com.finanteq.exercise.repositories.TaskRepository
import com.finanteq.exercise.repositories.TaskRepositoryImpl
import com.finanteq.exercise.ui.presentation.add_new_task.AddNewTaskViewModel
import com.finanteq.exercise.ui.presentation.task_details.TaskDetailsViewModel
import com.finanteq.exercise.ui.presentation.task_list.TaskListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object Modules {
    val taskListModule: Module = module {
        single<TaskRepository> { TaskRepositoryImpl(get()) }
        viewModel { TaskListViewModel(get()) }
    }

    val taskDetailsModule: Module = module {
        single<TaskRepository> { TaskRepositoryImpl(get()) }
        viewModel { TaskDetailsViewModel(get()) }
    }

    val addTaskModule: Module = module {
        single<TaskRepository> { TaskRepositoryImpl(get()) }
        viewModel { AddNewTaskViewModel(get()) }
    }

    val repositoryModule: Module = module {
        single { TaskRepositoryImpl(androidContext()) }
    }
}