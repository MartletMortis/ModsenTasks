package com.example.modsen_tasks_kucherenko_angelina.domain

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class SingleFlowEvent<T> {
    private val _events = MutableSharedFlow<T>(replay = 0, extraBufferCapacity = 1)
    val events: SharedFlow<T> = _events

    suspend fun emit(event: T) {
        _events.emit(event)
    }
}