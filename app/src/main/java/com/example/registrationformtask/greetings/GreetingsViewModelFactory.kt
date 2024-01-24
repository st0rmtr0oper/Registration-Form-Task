package com.example.registrationformtask.greetings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GreetingsViewModelFactory(private val username: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GreetingsViewModel::class.java)) {
            return GreetingsViewModel(username) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}