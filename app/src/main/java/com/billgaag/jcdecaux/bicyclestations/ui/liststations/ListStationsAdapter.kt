package com.billgaag.jcdecaux.bicyclestations.ui.liststations

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bill_gaag.jcdecaux.bicyclestations.R
import com.billgaag.jcdecaux.bicyclestations.models.Station

/**
 * Created by bill_gaag on 31/08/2018.
 */
class ListStationsAdapter(private val context: Context, private val list: MutableList<Station>,
                          fragment: Fragment) : RecyclerView.Adapter<ListStationsAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ListStationsAdapter.ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var station = list[position]

        // holder!!.bind(post)
        holder!!.title!!.setText(station.name)
        holder.address!!.setText(station.address)

        holder.layout!!.setOnClickListener {
            listener.itemDetail(station!!)
        }
    }

    private val listener: ListStationsAdapter.onItemClickListener

    init {
        this.listener = fragment as ListStationsAdapter.onItemClickListener
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layout = itemView.findViewById<ConstraintLayout>(R.id.item_layout)
        val title = itemView.findViewById<TextView>(R.id.item_name)
        val address = itemView.findViewById<TextView>(R.id.item_address)

    }

    interface onItemClickListener {
        fun itemDetail(station: Station)
    }
}