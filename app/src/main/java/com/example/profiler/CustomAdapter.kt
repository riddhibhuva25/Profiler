package com.example.profiler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private var userList: ArrayList<Model>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    public class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtName: TextView = view.findViewById(R.id.name)
        var txtGender: TextView = view.findViewById(R.id.Gender)
        var txtage: TextView = view.findViewById(R.id.age)
        var txtnumber: TextView = view.findViewById(R.id.number)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = userList[position]
        holder.txtName.text = item.name
        holder.txtGender.text = item.gender.toString()
        holder.txtage.text = item.age.toString()
        //holder.txtnumber.text = item.number.toString()
    }
    override fun getItemCount(): Int {
        return userList.size
    }
}
