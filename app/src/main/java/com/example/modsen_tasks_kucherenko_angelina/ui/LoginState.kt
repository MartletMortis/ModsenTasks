package com.example.modsen_tasks_kucherenko_angelina.ui

//возвращает пользователю состояние объекта в зависимости от его интента
data class LoginState(
    val login: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
){
    val isButtonEnabled: Boolean                                            //теперь обрабатывается здесь, а не в юае
        get() = login.isNotBlank() && password.isNotBlank() && !isLoading
}