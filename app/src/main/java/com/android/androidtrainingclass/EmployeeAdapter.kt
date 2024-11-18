package com.android.androidtrainingclass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class EmployeeAdapter(private val employees: List<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employees[position]
        holder.fullName.text = employee.fullName
        holder.email.text = employee.email
        holder.contactNo.text = employee.contactNo
        Picasso.get()
            .load(employee.profilePic)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(holder.profilePic)
    }

    override fun getItemCount(): Int = employees.size

    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fullName: TextView = view.findViewById(R.id.nameTextView)
        val email: TextView = view.findViewById(R.id.emailTextView)
        val contactNo: TextView = view.findViewById(R.id.contactTextView)
        val profilePic: ImageView = view.findViewById(R.id.profileImageView)
    }
}