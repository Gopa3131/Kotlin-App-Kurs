package com.example.kusovaya.fragments.rates

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kusovaya.R
import com.example.kusovaya.activities.addCounter.AddCounterActivity
import com.example.kusovaya.activities.addRate.AddRateActivity
import com.example.kusovaya.dataBase.entities.Rate
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
class RateFragment : Fragment() {
    //private lateinit var viewModel: RatesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setHasOptionsMenu(true)

        //viewModel = ViewModelProvider(this).get(RatesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val rate : Rate = viewModel.rate
        val view = inflater.inflate(R.layout.fragment_rate, container, false)

        //val hotTxt : TextView = view.findViewById(R.id.fragment_rate_hotWaterTxt)
        //hotTxt.text = rate.HotWaterRate.toString()
        //val coldTxt : TextView = view.findViewById(R.id.fragment_rate_coldWaterTxt)
        //coldTxt.text = rate.ColdWaterRate.toString()
        //val gasTxt : TextView = view.findViewById(R.id.fragment_rate_gasTxt)
        //gasTxt.text = rate.GasRate.toString()
        //val electricityTxt : TextView = view.findViewById(R.id.fragment_rate_electricityTxt)
        //electricityTxt.text = rate.electricityRate.toString()

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.rates_actionbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_addRates -> {
                val intent: Intent = Intent(activity, AddRateActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}