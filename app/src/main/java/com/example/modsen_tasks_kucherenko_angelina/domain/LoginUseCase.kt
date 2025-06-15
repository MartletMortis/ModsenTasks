package com.example.modsen_tasks_kucherenko_angelina.domain

import com.example.modsen_tasks_kucherenko_angelina.data.LoginData

class LoginUseCase(private val loginData: LoginData){

    fun isValid(login: String, pass: String): Boolean{
        return loginData.users.contains(login to pass)
    }
}