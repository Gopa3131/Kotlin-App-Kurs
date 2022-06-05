package com.example.kusovaya.fragments.counters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.kusovaya.activities.counterHistory.CounterHistory
import com.example.kusovaya.R
import com.example.kusovaya.dataBase.entities.Counter
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class CountersRecyclerAdapter(private val context: Context) : RecyclerView.Adapter<CountersRecyclerAdapter.MyViewHolder>() {

    private var counterList = emptyList<Counter>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtName: TextView = itemView.findViewById(R.id.counterItem_Name)
        val txtPlace: TextView = itemView.findViewById(R.id.counterItem_Place)
        val wholeItem : ConstraintLayout = itemView.findViewById(R.id.counterItem_counterItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.counters_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentCounter = counterList[position]
        holder.txtName.text = currentCounter.name
        holder.txtPlace.text = currentCounter.place

        holder.wholeItem.setOnClickListener {
            val intent : Intent = Intent(context, CounterHistory::class.java)
            intent.putExtra("counterId", currentCounter.id)
            intent.putExtra("counterType", currentCounter.type)
            context.startActivity(intent)
        }
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
