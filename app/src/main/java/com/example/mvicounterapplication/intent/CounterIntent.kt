package com.example.mvicounterapplication.intent

sealed class CounterIntent {
    object Increment : CounterIntent()
    object Decrement : CounterIntent()
}