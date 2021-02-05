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

        val intent: Intent = getIntent();
        var name = intent.getStringExtra("name")
        val alertName: AlertDialog.Builder = AlertDialog.Builder(this)
        val editTextName1 = EditText(this)
        val button: Button = findViewById(R.id.button1)
        val picker1: NumberPicker = findViewById(R.id.joke_picker);
        var username: TextView = findViewById(R.id.username)
        val pickerVals: Array<String>
        val layoutName = LinearLayout(this)

        pickerVals = arrayOf("Concurrency", "Hardcore", "Garbage collector")

        alertName.setTitle(" What is your name?")
        alertName.setView(editTextName1)
        layoutName.orientation = LinearLayout.VERTICAL
        layoutName.addView(editTextName1)

        alertName.setView(layoutName)
        alertName.setPositiveButton("Continue", object: DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface, whichButton:Int) {
                name = editTextName1.getText().toString().toLowerCase();
                username.setText("Hello ${name}")
            }
        })

        if (name.isNullOrEmpty()) {
            alertName.show()
            username.setText("Hello");
        } else {
            username.setText("Hello ${name}");
        }

        picker1.setMaxValue(2);
        picker1.setMinValue(0);
        picker1.setDisplayedValues(pickerVals);

        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.setAction(Intent.ACTION_SEND)
            intent.setType("text/plain");

            intent.putExtra("theme", pickerVals[picker1.value]);
            intent.putExtra("name", name);
            startActivity(intent)
        }
    }
}
