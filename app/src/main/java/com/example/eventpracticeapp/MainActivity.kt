package com.example.eventpracticeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get UI elements
        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Button click event
        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val ageText = etAge.text.toString().trim()

            // Validate inputs
            if (name.isEmpty() || ageText.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val age = ageText.toInt()
                "Hello, $name! You are $age years old.".also { tvResult.text = it }
            } catch (_: NumberFormatException) {
                Toast.makeText(this, "Invalid input: Age must be a number.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
