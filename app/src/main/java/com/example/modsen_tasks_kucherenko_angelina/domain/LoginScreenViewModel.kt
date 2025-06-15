package com.example.modsen_tasks_kucherenko_angelina.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

sealed class UIEvent {

    object NavigateToTask1EmptyScreen : UIEvent()  // переход на пустой экран
    object ShowError : UIEvent()  // ошибка и тост
}

class LoginScreenViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiEvent = SingleFlowEvent<UIEvent>()
    val uiEvent = _uiEvent.events

    var log by mutableStateOf("")
        private set

    var pswd by mutableStateOf("")
        private set

    fun updateLogin(log: String){ //изменение стейта полей для логина и пароля
        this.log =log
    }

    fun updatePassword(pswd: String){
        this.pswd = pswd
    }

    fun onButtonClick() {
        viewModelScope.launch {
            if (loginUseCase.isValid(log, pswd)) {
                delay(1500)
                _uiEvent.emit(UIEvent.NavigateToTask1EmptyScreen)
            } else {
                _uiEvent.emit(UIEvent.ShowError)
            }
        }
    }
}