package com.example.mvicounterapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvicounterapplication.intent.CounterIntent
import com.example.mvicounterapplication.model.CounterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {
    private val _state = MutableStateFlow(CounterState(0))
    val state: StateFlow<CounterState> get() = _state

    fun handleIntent(intent: CounterIntent) {
        when (intent) {
            is CounterIntent.Increment -> increment()
            is CounterIntent.Decrement -> decrement()
        }
    }

    private fun increment() {
        _state.value = _state.value.copy(count = _state.value.count + 1)
    }

    private fun decrement() {
        _state.value = _state.value.copy(count = _state.value.count - 1)
    }
}
