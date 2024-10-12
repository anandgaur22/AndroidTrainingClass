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
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var etInputData: EditText
    private lateinit var btnSave: Button
    private lateinit var btnRead: Button
    private lateinit var tvOutput: TextView

    private val fileName = "abc.txt"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // Initialize the views
        etInputData = findViewById(R.id.etInputData)
        btnSave = findViewById(R.id.btnSave)
        btnRead = findViewById(R.id.btnRead)
        tvOutput = findViewById(R.id.tvOutput)


        // Save button click listener
        btnSave.setOnClickListener {
            val data = etInputData.text.toString()
            if (data.isNotEmpty()) {
                saveToInternalStorage(data)
            } else {
                Toast.makeText(this, "Please enter some data", Toast.LENGTH_SHORT).show()
            }
        }

        // Read button click listener
        btnRead.setOnClickListener {
            val data = readFromInternalStorage()
            if (data != null) {
                tvOutput.text = data
            } else {
                tvOutput.text = "No data found!"
            }
        }

    }


    // Function to save data to internal storage
    private fun saveToInternalStorage(data: String) {
        var fos: FileOutputStream? = null
        try {
            fos = openFileOutput(fileName, Context.MODE_PRIVATE)
            fos.write(data.toByteArray())
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            fos?.close()
        }
    }

    // Function to read data from internal storage
    private fun readFromInternalStorage(): String? {
        var fis: FileInputStream? = null
        return try {
            fis = openFileInput(fileName)
            val fileContent = fis.readBytes().toString(Charsets.UTF_8)
            fileContent
        } catch (e: IOException) {
            e.printStackTrace()
            null
        } finally {
            fis?.close()
        }
    }

}