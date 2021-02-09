package com.project.lab1

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name = intent.getStringExtra("name")
        val nameDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        val addName = EditText(this)
        val nextButton: Button = findViewById(R.id.button1)
        val themesPicker: NumberPicker = findViewById(R.id.joke_picker);
        var welcomeMsg: TextView = findViewById(R.id.username)
        val themes: Array<String>
        val layoutName = LinearLayout(this)

        nameDialog.setTitle(" What is your name?")
        nameDialog.setView(addName)
        layoutName.orientation = LinearLayout.VERTICAL
        layoutName.addView(addName)
        nameDialog.setView(layoutName)
        nameDialog.setCancelable(false);
        nameDialog.setPositiveButton("Continue", object: DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface, whichButton:Int) {
                name = addName.getText().toString().toLowerCase();
                welcomeMsg.setText("Hello ${name}")
            }
        })

        if (name.isNullOrEmpty()) {
            nameDialog.show()
            welcomeMsg.text = "Hello";
        } else {
            welcomeMsg.text = "Hello ${name}";
        }

        themes = arrayOf("Concurrency", "Hardcore", "Garbage collector")
        themesPicker.maxValue = 2;
        themesPicker.minValue = 0;
        themesPicker.displayedValues = themes;

        nextButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.setAction(Intent.ACTION_SEND)
            intent.setType("text/plain");

            intent.putExtra("theme", themes[themesPicker.value]);
            intent.putExtra("name", name);
            startActivity(intent)
        }
    }
}
