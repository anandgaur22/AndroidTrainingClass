package com.android.androidtrainingclass

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d("TAG", "onCreate: Activity")

        // Add FirstFragment when activity is created
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FirstFragment(), "firstFragment")
                .commit()
        }



    }

    override fun onStart() {
        super.onStart()


        // Prepare the UI to be visible to the user

        Log.d("A onStart", "A onStart started")
    }

    override fun onResume() {
        super.onResume()



        // Activity is now in the foreground and interactive

        Log.d("A onResume", "A onResume started")
    }

    override fun onPause() {
        super.onPause()


        // Pause or save ongoing tasks (stop animations, etc.)


        Log.d("A onPause", "A onPause started")
       // Log.i("onResume", "onResume running")
    }

    override fun onStop() {
        super.onStop()


        // Release resources that are not needed while the activity is stopped


        Log.d("A onStop", "A onStop started")
    }

    override fun onRestart() {
        super.onRestart()

        // Perform any necessary updates when activity restarts

        Log.d("A onRestart", "A onRestart started")
    }

    override fun onDestroy() {
        super.onDestroy()

        // Clean up resources and finalize actions before the activity is destroyed

        Log.d("A onDestroy", "A onDestroy started")
    }

}