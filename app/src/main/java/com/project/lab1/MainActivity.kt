package com.project.lab1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val picker1: NumberPicker = findViewById(R.id.joke_picker);
        picker1.setMaxValue(2);
        picker1.setMinValue(0);
        val pickerVals: Array<String>
        pickerVals = arrayOf("Concurrency", "Hardcore", "Garbage collector")
        picker1.setDisplayedValues(pickerVals);

        val button: Button = findViewById(R.id.button1)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.setAction(Intent.ACTION_SEND)
            intent.setType("text/plain");
            Log.d("mess2", picker1.value.toString())

            intent.putExtra("theme", pickerVals[picker1.value]);
//            intent.putExtra("joke,  R.string.joke);

            startActivity(intent)
        }
    }
}