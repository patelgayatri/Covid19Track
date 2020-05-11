package com.health.covid19Track.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.health.covid19Track.R
import com.health.covid19Track.ui.adapters.ListAdapter
import com.health.covid19Track.model.Country
import com.health.covid19Track.viewModels.ListViewModel
import com.letssee.covid19.model.Table


class ListFragment : Fragment(), ListAdapter.Listener {
    private var mAdapter: ListAdapter? = null
    private lateinit var recyclerView: RecyclerView
    lateinit var dialog: AlertDialog

    private var listViewModel: ListViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        listViewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_list, container, false)

        initRecyclerView(root)

        loadJSON()
        return root
    }

    private fun initRecyclerView(root: View) {

        recyclerView = root.findViewById<View>(R.id.rv_android_list) as RecyclerView
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.isNestedScrollingEnabled = true

        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setCancelable(false)
        builder.setView(R.layout.progress_dailogue)
        dialog = builder.create()
        dialog.show()
    }

    private fun loadJSON() {
        listViewModel?.cases?.observe(viewLifecycleOwner, Observer { s ->
            if (s != null)
                handleResponse(s)
            else {
                handleError()
            }
        })
    }

    private fun handleError() {
        dialog.dismiss()
        Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
    }

    private fun handleResponse(results: Country) {
        dialog.dismiss()

        mAdapter = results.reports?.get(0)?.table?.get(0)?.let {
            ListAdapter(
                it,
                this
            )
        }
        recyclerView.adapter = mAdapter
    }


    override fun onItemClick(android: Table) {
        Toast.makeText(activity, "${android.country} Clicked !", Toast.LENGTH_SHORT).show()
    }

}