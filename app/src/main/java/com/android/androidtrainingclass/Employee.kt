package com.android.androidtrainingclass

import com.google.gson.annotations.SerializedName

data class EmployeeResponse(
    val status: Int,
    val message: String,
    val data: List<Employee>
)

data class Employee(
    @SerializedName("employee_id") val employeeId: String,
    @SerializedName("full_name") val fullName: String,
    val email: String,
    @SerializedName("contact_no") val contactNo: String,
    @SerializedName("profile_pic") val profilePic: String
)

data class UserIdRequest(
    @SerializedName("user_id") val userId: String
)