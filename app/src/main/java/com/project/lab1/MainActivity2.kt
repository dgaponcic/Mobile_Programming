package com.project.lab1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent: Intent = getIntent();
        val theme = intent.getStringExtra("theme").toString()
        val name = intent.getStringExtra("name").toString()

        val welcome_txt: TextView = findViewById(R.id.welcome_msg)
        welcome_txt.setText("Hey ${name} I hope you like jokes. Here is one :)")

        val text: TextView = findViewById(R.id.joke2)
        if (theme == "Concurrency") {
            text.setText("Knock Knock. \nRace condition. \nWho's there?")
        } else if (theme == "Hardcore") {
            text.setText("There are two hard things in computer science:\ncache invalidation,\nnaming things,\nand off-by-one errors.")
        } else if (theme == "Garbage collector") {
            text.setText("Garbage collectors: *make money by collecting trash\n\nGarbage collector in Java:\nYou guys are getting paid???")
        }

        val button: Button = findViewById(R.id.button2)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name.toUpperCase());
            startActivity(intent)
        }
    }
}
