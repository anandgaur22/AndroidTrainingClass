package com.android.androidtrainingclass

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etUserName: EditText
    private lateinit var btnSave: Button
    private lateinit var btnRetrieve: Button
    private lateinit var tvResult: TextView

    // Key name to store the data
    private val PREF_NAME = "MyPrefs"
    private val KEY_NAME = "name"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // Initialize the views
        etUserName = findViewById(R.id.etUserName)
        btnSave = findViewById(R.id.btnSave)
        btnRetrieve = findViewById(R.id.btnRetrieve)
        tvResult = findViewById(R.id.tvResult)

        // Save button click listener
        btnSave.setOnClickListener {
            val name = etUserName.text.toString()
            if (name.isNotEmpty()) {
                saveNameToPreferences(name)
            } else {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }

        // Retrieve button click listener
        btnRetrieve.setOnClickListener {
            val savedName = retrieveNameFromPreferences()
            if (savedName.isNotEmpty()) {
                tvResult.text = "Retrieved Name: $savedName"
            } else {
                tvResult.text = "No name saved yet!"
            }
        }


    }

    // Function to save the name to SharedPreferences
    private fun saveNameToPreferences(name: String) {
        val sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(KEY_NAME, name)
        editor.apply() // Save the changes asynchronously
        Toast.makeText(this, "Name saved successfully", Toast.LENGTH_SHORT).show()
    }

    // Function to retrieve the name from SharedPreferences
    private fun retrieveNameFromPreferences(): String {
        val sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(KEY_NAME, "") ?: ""
    }
}