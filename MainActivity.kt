package com.example.astrologygodlikechat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Reference to the input fields
        val nameField = findViewById<EditText>(R.id.et_name)
        val dobField = findViewById<EditText>(R.id.et_dob)
        val tobField = findViewById<EditText>(R.id.et_tob)
        val birthplaceField = findViewById<EditText>(R.id.et_birthplace)
        val generateKundliButton = findViewById<Button>(R.id.btn_generate_kundli)

        // Set click listener for the button
        generateKundliButton.setOnClickListener {
            val name = nameField.text.toString().trim()
            val dob = dobField.text.toString().trim()
            val tob = tobField.text.toString().trim()
            val birthplace = birthplaceField.text.toString().trim()

            if (name.isEmpty() || dob.isEmpty() || tob.isEmpty() || birthplace.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (!dob.matches("\\d{2}/\\d{2}/\\d{4}".toRegex())) {
                Toast.makeText(this, "Please enter DOB in format DD/MM/YYYY", Toast.LENGTH_SHORT).show()
            } else if (!tob.matches("\\d{2}:\\d{2}".toRegex())) {
                Toast.makeText(this, "Please enter TOB in format HH:MM", Toast.LENGTH_SHORT).show()
            } else {
                // Navigate to KundliDisplayActivity
                val intent = Intent(this, KundliDisplayActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("dob", dob)
                intent.putExtra("tob", tob)
                intent.putExtra("birthplace", birthplace)
                startActivity(intent)
            }
        }
    }
}
