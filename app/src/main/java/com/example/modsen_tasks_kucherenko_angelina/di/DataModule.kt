package com.example.modsen_tasks_kucherenko_angelina.di

import com.example.modsen_tasks_kucherenko_angelina.data.LoginData
import org.koin.dsl.module

val dataModule = module {
    single { LoginData }
}