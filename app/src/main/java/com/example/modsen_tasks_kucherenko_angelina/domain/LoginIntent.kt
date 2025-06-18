package com.example.modsen_tasks_kucherenko_angelina.domain

sealed interface LoginIntent {
    data class UpdateLogin(val login : String) : LoginIntent        //запрос пользователя на изменение полей
    data class UpdatePassword(val password : String) : LoginIntent
    object Submit : LoginIntent                                     //запрос пользователя на логин

}