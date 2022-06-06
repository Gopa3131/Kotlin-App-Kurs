@file:OptIn(InternalCoroutinesApi::class)

package com.example.kusovaya.fragments.counters

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kusovaya.activities.addCounter.AddCounterActivity
import com.example.kusovaya.R
import kotlinx.coroutines.InternalCoroutinesApi


class CounterFragment : Fragment() {

    lateinit var viewModel: CountersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setHasOptionsMenu(true)

        viewModel = ViewModelProvider(this).get(CountersViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View =  inflater.inflate(R.layout.fragment_counter, container, false)



        val recycler : RecyclerView = view.findViewById(R.id.fragment_counter_Recycler)
        val adapter = CountersRecyclerAdapter(requireActivity())
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)

        viewModel.readAllCounters.observe(viewLifecycleOwner, Observer { counters ->  adapter.setData(counters)})

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.actionbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_addCounter -> {
                val intent : Intent = Intent(activity, AddCounterActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}