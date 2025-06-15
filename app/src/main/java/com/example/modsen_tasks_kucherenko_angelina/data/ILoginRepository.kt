package com.example.modsen_tasks_kucherenko_angelina.data

import kotlinx.coroutines.delay

interface LoginRepository{
    suspend fun login(login: String, password: String): Boolean
}

class LoginRepositoryImpl(private val loginData: LoginData) : LoginRepository {
    override suspend fun login(login: String, password: String) : Boolean {
        delay(1500)                                                     //делей теперь обрабатывает дата-слой
        return loginData.users.contains(login to password)
    }
}