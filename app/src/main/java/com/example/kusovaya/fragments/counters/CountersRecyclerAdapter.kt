package com.example.kusovaya.fragments.counters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kusovaya.R
import com.example.kusovaya.dataBase.Counter

class CountersRecyclerAdapter : RecyclerView.Adapter<CountersRecyclerAdapter.MyViewHolder>() {

    private var counterList = emptyList<Counter>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtName: TextView = itemView.findViewById(R.id.counterItem_Name)
        val txtPlace: TextView = itemView.findViewById(R.id.counterItem_Place)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.counters_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentCounter = counterList[position]
        holder.txtName.text = currentCounter.name
        holder.txtPlace.text = currentCounter.place
    }

    override fun getItemCount(): Int {
        return counterList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(counters: List<Counter>) {
        this.counterList = counters
        notifyDataSetChanged()
    }
}
