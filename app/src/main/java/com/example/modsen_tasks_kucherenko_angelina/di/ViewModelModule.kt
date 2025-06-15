package com.example.modsen_tasks_kucherenko_angelina.di

import com.example.modsen_tasks_kucherenko_angelina.ui.LoginScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginScreenViewModel(get()) }
}