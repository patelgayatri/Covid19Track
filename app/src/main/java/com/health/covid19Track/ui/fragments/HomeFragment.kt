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
import com.health.covid19Track.ui.adapters.HomeAdapter
import com.health.covid19Track.model.HomeModel
import com.health.covid19Track.model.HomeResult
import com.health.covid19Track.viewModels.HomeViewModel


class HomeFragment : Fragment()  {
    private var mAdapter: HomeAdapter? = null
    private lateinit var recyclerView: RecyclerView
    lateinit var dialog: AlertDialog
    private var homeViewModel: HomeViewModel? = null
    private lateinit var dataList:ArrayList<HomeModel>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
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
        homeViewModel?.data?.observe(viewLifecycleOwner, Observer { s ->
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

    private fun handleResponse(results: HomeResult) {
        dialog.dismiss()
        dataList= ArrayList<HomeModel>()
        dataList.add(HomeModel("Total Cases",results.data.totalCases,"#000000"))
        dataList.add(HomeModel("Total Recovered ",results.data.recoveredClosedCases,"#07A50E"))
        dataList?.add(HomeModel("Total Deaths",results.data.deathCases,"#FFF44336"))
        dataList.add(HomeModel("Active Cases",results.data.currentlyInfected,"#8C06A3"))


        mAdapter = HomeAdapter(dataList, listener = HomeFragment())
        recyclerView.adapter = mAdapter
    }


//    override fun onItemClick(android: Table) {
//        Toast.makeText(activity, "${android.country} Clicked !", Toast.LENGTH_SHORT).show()
//    }

    override fun onDestroy() {
        super.onDestroy()
    }
}