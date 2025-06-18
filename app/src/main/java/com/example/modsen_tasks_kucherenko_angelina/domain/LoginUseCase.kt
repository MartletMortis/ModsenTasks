package com.example.modsen_tasks_kucherenko_angelina.domain

import com.example.modsen_tasks_kucherenko_angelina.data.LoginRepository

class LoginUseCase(private val repository: LoginRepository){                    //теперь принимает в себя репозиторий, а не дата класс
    suspend operator fun invoke(login : String, password : String): Boolean {
        return repository.login(login, password)
    }

}