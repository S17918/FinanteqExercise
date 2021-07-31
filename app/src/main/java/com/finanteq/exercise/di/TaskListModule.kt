package com.finanteq.exercise.di

import com.finanteq.exercise.repositories.TaskRepository
import com.finanteq.exercise.repositories.TaskRepositoryImpl
import com.finanteq.exercise.ui.presentation.task_details.TaskDetailsViewModel
import com.finanteq.exercise.ui.presentation.task_list.TaskListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object TaskListModule {
    val taskListViewModelModule: Module = module {
        single<TaskRepository> { TaskRepositoryImpl() }
        viewModel { TaskListViewModel(get()) }
    }
}