package com.health.covid19Track.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.health.covid19Track.R
import com.health.covid19Track.model.Country
import com.health.covid19Track.model.ReportC
import com.letssee.covid19.model.Table
import kotlinx.android.synthetic.main.row_list.view.*

class ListAdapter(private val dataList: List<ReportC>, private val listener: Listener) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    interface Listener {
        fun onItemClick(android: Table)
    }


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
            table: ReportC,
            listener: Listener,
            position: Int
        ) {
            if (table.countryText?.length!! > 11 && table.countryText?.contains(" ")!!)
                itemView.tv_name.text = table.countryText?.replaceFirst(" ", "\n")
            else
                itemView.tv_name.text = table.countryText?.trim()
            itemView.tv_today_case.text = " " + table.newCasesText?.trim()
            itemView.tv_totalcases.text = table.totalCasesText?.trim()
            itemView.tv_deaths.text = table.totalCasesText?.trim()
            itemView.tv_today_deaths.text = " " + table.newDeathsText?.trim()
            if (!table.totalRecoveredText.equals("N/A"))
                itemView.tv_recovered.text = table.totalRecoveredText?.trim()
//            itemView.setOnClickListener { listener.onItemClick(table)

        }
    }
}