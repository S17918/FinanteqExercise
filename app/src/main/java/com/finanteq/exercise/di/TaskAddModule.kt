package com.finanteq.exercise.di

import com.finanteq.exercise.repositories.TaskRepository
import com.finanteq.exercise.repositories.TaskRepositoryImpl
import com.finanteq.exercise.ui.presentation.add_new_task.AddNewTaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object TaskAddModule {
    val taskAddModule: Module = module {
        single<TaskRepository> { TaskRepositoryImpl() }
        viewModel { AddNewTaskViewModel(get()) }
    }
}