package com.project.lab1.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.project.lab1.R
import com.project.lab1.databinding.ActivityAuthBinding
import com.project.lab1.databinding.ActivityImagePostBinding
import com.project.lab1.databinding.ActivityMainBinding
import com.project.lab1.network.APICommunication
import com.project.lab1.presentation.feedImage.ImageInput
import com.project.lab1.presentation.feedImage.ImagePresenter
import com.project.lab1.presentation.feedImage.models.FeedImage
import com.project.lab1.presentation.menu.NavigationActivity
import com.squareup.picasso.Picasso

class AuthActivity: AuthInput, AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
//    private val pref = getSharedPreferences("tokens", MODE_PRIVATE)

    private var presenter = AuthPresenter(this, APICommunication())

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
