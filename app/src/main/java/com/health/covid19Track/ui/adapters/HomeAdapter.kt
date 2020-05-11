package com.health.covid19Track.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.health.covid19Track.R
import com.health.covid19Track.model.HomeModel
import com.health.covid19Track.ui.fragments.HomeFragment
import kotlinx.android.synthetic.main.row_home.view.*

class HomeAdapter(val dataList: ArrayList<HomeModel>, private val listener: HomeFragment) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

//    interface Listener {
//
//        fun onItemClick(android: Table)
//    }

    private val colors: Array<String> =
        arrayOf("#FBE9E9", "#F7FCE8", "#5C6BC0", "#42A5F5")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(dataList[position], listener, colors, position)
    }

    override fun getItemCount(): Int=dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_home, parent, false)

        return ViewHolder(view)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: HomeModel, listener: HomeFragment, colors: Array<String>, position: Int) {

            itemView.home_title.text = data.title
            itemView.home_value.text = data.value
            itemView.home_title.setBackgroundColor(Color.parseColor(data.color))

            //itemView.setOnClickListener { listener.onItemClick(table) }
        }
    }
}