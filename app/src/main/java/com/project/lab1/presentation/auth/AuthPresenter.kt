package com.project.lab1.presentation.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.project.lab1.network.APIService
import com.project.lab1.network.models.AuthToken
import com.project.lab1.presentation.APIClient
import com.project.lab1.presentation.menu.NavigationActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.MainScope

class AuthPresenter(val view: AuthInput, val apiService: APIClient): AuthOutput {
    override fun auth(login: String, password: String) {
        GlobalScope.launch {
            kotlin.runCatching {
                apiService.auth(login, password)
            }.onSuccess {
                handleAPIData(it)
            }.onFailure {
                print(it)
                handleAPIDataError(it)
            }
        }
    }

    private fun handleAPIData(data: AuthToken) {
        val token = data.access_token
        if (token != "") {
            view.updateUI(token)
        }
    }

    private fun handleAPIDataError(error: Throwable) {
        MainScope().launch {
            view.showErrorAlert("An error occurred.")
        }
    }
}