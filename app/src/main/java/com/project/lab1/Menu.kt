package com.project.lab1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.project.lab1.R
import com.project.lab1.databinding.ActivityMainBinding
import com.project.lab1.databinding.ActivityMenuBinding
import com.project.lab1.feed.FeedActivity
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val token = intent.getSerializableExtra("token")
        Log.d("hhh", token.toString())
        binding.recyclerListExampleButton.setOnClickListener {
                val intent = Intent(this, FeedActivity::class.java)
                intent.putExtra("token", token);
                startActivity(intent)
            }
//    }
    }
}