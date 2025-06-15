package com.example.modsen_tasks_kucherenko_angelina.di

import com.example.modsen_tasks_kucherenko_angelina.domain.LoginUseCase
import org.koin.dsl.module

val domainModule = module {
    single { LoginUseCase(get()) }
}