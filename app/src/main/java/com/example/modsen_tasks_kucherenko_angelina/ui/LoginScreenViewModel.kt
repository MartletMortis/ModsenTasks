package com.example.modsen_tasks_kucherenko_angelina.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modsen_tasks_kucherenko_angelina.domain.LoginEvent
import com.example.modsen_tasks_kucherenko_angelina.domain.LoginIntent
import com.example.modsen_tasks_kucherenko_angelina.domain.LoginUseCase
import com.example.modsen_tasks_kucherenko_angelina.domain.SingleFlowEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginScreenViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> =_uiState.asStateFlow()
    private val _event = SingleFlowEvent<LoginEvent>(viewModelScope)
    val event: Flow<LoginEvent> = _event.flow

    fun login(){
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true, error = null)
            }
            val success = loginUseCase.invoke(_uiState.value.login, _uiState.value.password)
            _uiState.update {
                it.copy(isLoading = false)
            }
            if(success){
                _event.emit(LoginEvent.NavigateToScreen)
            } else{
                _event.emit(LoginEvent.ShowError("Invalid user data"))
            }
        }
    }

    fun onIntent(intent: LoginIntent){
        when(intent){
            is LoginIntent.UpdateLogin ->{
                _uiState.update { it.copy(login = intent.login, error = null) }
            }
            is LoginIntent.UpdatePassword ->{
                _uiState.update { it.copy(password = intent.password, error = null) }
            }
            LoginIntent.Submit ->{
                login()
            }
        }
    }

}