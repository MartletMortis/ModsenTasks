package com.example.modsen_tasks_kucherenko_angelina.domain

// обрабатывает ивенты
sealed interface LoginEvent {
    data class ShowError(val error: String) : LoginEvent //для показа тост-ошибок. хранит в себе стринг текста ошибки
    data object NavigateToScreen : LoginEvent //навигация на пустой экран при логине

}