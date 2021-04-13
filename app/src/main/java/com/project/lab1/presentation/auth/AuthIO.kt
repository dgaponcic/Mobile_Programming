package com.project.lab1.presentation.auth


interface AuthInput {
    fun updateUI(token: String)
}

interface AuthOutput {
    fun auth(username: String, password: String)
}
