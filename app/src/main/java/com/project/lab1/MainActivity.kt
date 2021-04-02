package com.project.lab1

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiConfiguration.AuthAlgorithm.SHARED
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.project.lab1.databinding.ActivityMainBinding
import com.project.lab1.menu.Menu
import com.project.lab1.menu.NavigationActivity
import com.project.lab1.network.APICommunication
import com.project.lab1.network.models.AuthToken
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiService: APICommunication

    private fun auth(login: String, password: String) {
        GlobalScope.launch {
            kotlin.runCatching {
                apiService.auth(login, password)
            }.onSuccess {
                handleAPIData(it)
            }.onFailure {
                print(it)
            }
        }
    }

    private fun handleAPIData(data: AuthToken) {
        val token = data.access_token
        if (token != "") {
            val pref = getSharedPreferences("tokens", MODE_PRIVATE)
            with(pref.edit()) {
                putString("auth", token)
                apply()
            }

            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        apiService = APICommunication()
        val loginButton: Button = binding.loginButton
        loginButton.setOnClickListener {
            auth(binding.userLogin.text.toString(), binding.userPassword.text.toString())
        }
    }
}


