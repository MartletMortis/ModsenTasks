package com.example.modsen_tasks_kucherenko_angelina.di

import com.example.modsen_tasks_kucherenko_angelina.data.LoginData
import com.example.modsen_tasks_kucherenko_angelina.data.LoginRepository
import com.example.modsen_tasks_kucherenko_angelina.data.LoginRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single { LoginData }
    single<LoginRepository> { LoginRepositoryImpl( get() )  }
}