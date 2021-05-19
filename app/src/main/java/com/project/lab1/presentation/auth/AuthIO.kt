package com.project.lab1.presentation.auth


interface AuthInput {
    fun updateUI(token: String)
    fun showErrorAlert(message: String)
}

interface AuthOutput {
    fun auth(username: String, password: String)
}
