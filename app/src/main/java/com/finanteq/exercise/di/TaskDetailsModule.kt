package com.finanteq.exercise.di

import com.finanteq.exercise.repositories.TaskRepository
import com.finanteq.exercise.repositories.TaskRepositoryImpl
import com.finanteq.exercise.ui.presentation.task_details.TaskDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object TaskDetailsModule {
    val taskDetailsViewModelModule: Module = module {
        single<TaskRepository> { TaskRepositoryImpl() }
        viewModel { TaskDetailsViewModel(get()) }
    }
}