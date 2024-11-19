package com.android.androidtrainingclass

import android.Manifest.permission.READ_CONTACTS
import android.Manifest.permission.WRITE_CONTACTS
import android.content.ContentProviderOperation
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.database.Cursor
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.androidtrainingclass.databinding.ActivityCameraBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.Calendar
import java.util.Date
import retrofit2.Response



class MainActivity : AppCompatActivity(){

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private lateinit var employeeAdapter: EmployeeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        recyclerView = findViewById(R.id.recyclerView)

        progressBar = findViewById(R.id.progressBar)


        recyclerView.layoutManager = LinearLayoutManager(this)


        fetchEmployees()

    }


    private fun fetchEmployees() {
        progressBar.visibility = View.VISIBLE
        val apiService = ApiService.create()

        // Update the API call to use the parameter as part of the form URL encoding
        val call = apiService.getEmployeeList(UserIdRequest("121"))
        call.enqueue(object : Callback<EmployeeResponse> {
            override fun onResponse(call: Call<EmployeeResponse>, response: Response<EmployeeResponse>) {
                progressBar.visibility = View.GONE
                if (response.isSuccessful && response.body() != null) {
                    val body = response.body()
                    Log.d("API Response", body.toString()) // Log entire response

                    if (body?.status == 1) {
                        val employees = body.data
                        Log.d("Employee List", employees.toString()) // Log employee list

                        if (employees.isNotEmpty()) {
                            employeeAdapter = EmployeeAdapter(employees)
                            recyclerView.adapter = employeeAdapter
                            recyclerView.visibility = View.VISIBLE
                        } else {
                            Toast.makeText(this@MainActivity, "No employees found", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this@MainActivity, body?.message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.e("API Error", "Response code: ${response.code()}, message: ${response.message()}")
                    Toast.makeText(this@MainActivity, "Failed to fetch employees", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                progressBar.visibility = View.GONE
                Log.e("API Failure", "Error: ${t.message}")
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

