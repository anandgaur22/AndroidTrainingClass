package com.android.androidtrainingclass

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var textView: TextView
    private lateinit var buttonStartTask: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        textView = findViewById(R.id.textView)
        buttonStartTask = findViewById(R.id.buttonStartTask)

        // Set button click listener
        buttonStartTask.setOnClickListener {
            // Start the AsyncTask
            DownloadTask().execute("https://example.com/data")
        }

    }

    // AsyncTask class to simulate downloading data
    private inner class DownloadTask : AsyncTask<String, Int, String>() {

        // Method that runs before the background task starts (UI thread)
        override fun onPreExecute() {
            super.onPreExecute()
            // Update UI to show that the task is starting
            textView.text = "Starting download..."
        }

        // Method to run the background task (background thread)
        override fun doInBackground(vararg params: String?): String {
            // Simulate a time-consuming task (e.g., downloading)
            for (i in 1..100) {
                // Update progress every 1%
                publishProgress(i)
                Thread.sleep(50) // Sleep for 50ms to simulate work
            }

            // Return result after the background task completes
            return "Download Complete"
        }

        // Method to update the progress (UI thread)
        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            // Update TextView to show current progress
            textView.text = "Progress: ${values[0]}%"
        }

        // Method to handle the result after the background task completes (UI thread)
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            // Display the result in the TextView
            textView.text = result
        }
    }
}