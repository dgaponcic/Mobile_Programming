package com.project.lab1.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.project.lab1.databinding.ActivityAuthBinding
import com.project.lab1.presentation.menu.NavigationActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class AuthActivity: AuthInput, AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    private val presenter: AuthOutput by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginButton: Button = binding.loginButton

        loginButton.setOnClickListener {
            presenter.auth(binding.userLogin.text.toString(), binding.userPassword.text.toString())
        }
}

    override fun updateUI(token: String) {
        val pref = getSharedPreferences("tokens", MODE_PRIVATE)
        with(pref.edit()) {
            putString("auth", token)
            apply()
        }

        val intent = Intent(this, NavigationActivity::class.java)
        startActivity(intent)
    }
}
