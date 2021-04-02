package com.project.lab1.feed

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.project.lab1.R
import com.project.lab1.databinding.ActivityImagePostBinding
import com.project.lab1.network.APICommunication
import com.project.lab1.network.models.Image
import com.squareup.picasso.Picasso
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class ImagePost : AppCompatActivity() {

    private lateinit var binding: ActivityImagePostBinding
    private lateinit var apiService: APICommunication
    private lateinit var link: String;

    private fun getImage(token: String, id: String) {
        MainScope().launch {
            kotlin.runCatching {
                apiService.getImage(token, id)
            }.onSuccess {
                handleAPIData(it)
                link = it.urls.small
            }.onFailure {
                print(it)
            }
        }
    }


    private fun addNote(token: String, link: String) {
        MainScope().launch {
            kotlin.runCatching {
                apiService.addNote(token, link)
            }.onSuccess {
            }.onFailure {
                print(it)
            }
        }
    }


    private fun handleAPIData(data: Image) {
        binding.imageId.setText(data.user.username)
        binding.imageDescription.setText(data.alt_description)
        Picasso.get()
            .load(data.urls.small)
            .error(R.drawable.placeholder)
            .fit()
            .into(binding.image)
        this.setVisible(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagePostBinding.inflate(layoutInflater)
        this.setVisible(false)
        setContentView(binding.root)
        val id = intent.getSerializableExtra("id") as String

        apiService = APICommunication()

        val addButton: Button = binding.addNote
        val pref = getSharedPreferences("tokens", MODE_PRIVATE)
        val token = pref.getString("auth", "")

        if (token != null) {
            getImage(token, id)
        }

        addButton.setOnClickListener {
            if (token != null) {
                addNote(token, link)
            }
        }

    }
}
