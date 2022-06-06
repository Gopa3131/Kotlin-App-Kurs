package com.example.kusovaya.activities.counterHistory

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kusovaya.R
import com.example.kusovaya.dataBase.entities.ColdWaterRecord
import com.example.kusovaya.dataBase.entities.ElectricityRecord
import com.example.kusovaya.dataBase.entities.GasRecord
import com.example.kusovaya.dataBase.entities.HotWaterRecord

class CounterHistoryRecyclerAdapter(private val counterType : Int) : RecyclerView.Adapter<CounterHistoryRecyclerAdapter.MyViewHolder>() {

    private var coldWaterRecords = emptyList<ColdWaterRecord>()
    private var hotWaterRecords = emptyList<HotWaterRecord>()
    private var gasRecords = emptyList<GasRecord>()
    private var electricityRecords = emptyList<ElectricityRecord>()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val recordDate : TextView = itemView.findViewById(R.id.counter_history_item_date)
        val recordIndication : TextView = itemView.findViewById(R.id.counter_history_item_indication)
        val recordDifference : TextView = itemView.findViewById(R.id.counter_history_item_difference)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        when (counterType) {
            0 -> {
                holder.recordIndication.text = gasRecords[position].indication.toString()
            }
            1 -> {
                holder.recordIndication.text = electricityRecords[position].indication.toString()
            }
            2 -> {
                holder.recordIndication.text = coldWaterRecords[position].indication.toString()
            }
            else -> {
                holder.recordIndication.text = hotWaterRecords[position].indication.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return when (counterType) {
            0 -> {
                gasRecords.size
            }
            1 -> {
                electricityRecords.size
            }
            2 -> {
                coldWaterRecords.size
            }
            else -> hotWaterRecords.size
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return CounterHistoryRecyclerAdapter.MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.counter_history_item, parent, false))
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(records: List<ColdWaterRecord>?) {
        if (records != null) {
            this.coldWaterRecords = records
        }
        notifyDataSetChanged()
    }

}
