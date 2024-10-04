package com.android.androidtrainingclass

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_b)

        Log.d("B onCreate", "B onCreate started")

        val msg= intent.getStringExtra("msg")

        val txtView:TextView=findViewById(R.id.msg)

        txtView.text=msg

    }

    override fun onStart() {
        super.onStart()


        // Prepare the UI to be visible to the user

        Log.d("B onStart", "B onStart started")
    }

    override fun onResume() {
        super.onResume()



        // Activity is now in the foreground and interactive

        Log.d("B onResume", "B onResume started")
    }

    override fun onPause() {
        super.onPause()


        // Pause or save ongoing tasks (stop animations, etc.)


        Log.d("B onPause", "B onPause started")
        // Log.i("onResume", "onResume running")
    }

    override fun onStop() {
        super.onStop()


        // Release resources that are not needed while the activity is stopped


        Log.d("B onStop", "B onStop started")
    }

    override fun onRestart() {
        super.onRestart()

        // Perform any necessary updates when activity restarts

        Log.d("B onRestart", "B onRestart started")
    }

    override fun onDestroy() {
        super.onDestroy()

        // Clean up resources and finalize actions before the activity is destroyed

        Log.d("B onDestroy", "B onDestroy started")
    }
}