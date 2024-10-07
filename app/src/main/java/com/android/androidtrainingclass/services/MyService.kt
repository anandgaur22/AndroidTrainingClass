package com.android.androidtrainingclass.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Handler
import android.util.Log
import android.widget.Toast


class MyService : Service() {

    private val TAG = "MyService"
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Service Created")
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show()

        // Handler and Runnable to simulate background task
        handler = Handler()
        runnable = Runnable {
            Log.d(TAG, "Service is running...")
            handler.postDelayed(runnable, 5000) // Repeat every 5 seconds
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service Started")
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()

        // Start the task
        handler.post(runnable)

        // Keep the service running until explicitly stopped
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Service Destroyed")
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show()

        // Stop the background task
        handler.removeCallbacks(runnable)
    }

    override fun onBind(intent: Intent?): IBinder? {
        // We won’t use binding in this example, so return null
        return null
    }
}