package com.health.covid19Track.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.health.covid19Track.R
import com.letssee.covid19.model.Table
import kotlinx.android.synthetic.main.row_list.view.*

class ListAdapter(private val dataList: List<Table>, private val listener: Listener) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    interface Listener {
        fun onItemClick(android: Table)
    }

    private val colors: Array<String> =
        arrayOf("#FBE9E9", "#F7FCE8", "#5C6BC0", "#42A5F5")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position], listener, position)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_list, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(
            table: Table,
            listener: Listener,
            position: Int
        ) {
            if (table.country?.length!! > 11 && table.country?.contains(" ")!!)
                itemView.tv_name.text = table.country?.replaceFirst(" ", "\n")
            else
                itemView.tv_name.text = table.country?.trim()
            itemView.tv_today_case.text = " " + table.newCases?.trim()
            itemView.tv_totalcases.text = table.totalCases?.trim()
            itemView.tv_deaths.text = table.totalDeaths?.trim()
            itemView.tv_today_deaths.text = " " + table.newDeaths?.trim()
            if(!table.totalRecovered.equals("N/A"))
            itemView.tv_recovered.text = table.totalRecovered?.trim()
            itemView.setOnClickListener { listener.onItemClick(table) }
        }
    }
}