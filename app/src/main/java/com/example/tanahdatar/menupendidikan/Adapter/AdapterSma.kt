package com.example.tanahdatar.menupendidikan.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tanahdatar.R
import com.example.tanahdatar.menupendidikan.AdapterSekolah
import com.example.tanahdatar.menupendidikan.DetailSekolahActivity
import com.example.tanahdatar.model.sekolah.ListSekolah
import com.google.gson.Gson

class AdapterSma(var activity: Activity, var data: ArrayList<ListSekolah>) : RecyclerView.Adapter<AdapterSma.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvSekolah = view.findViewById<TextView>(R.id.tv_nama_n)
        val layoutNag = view.findViewById<CardView>(R.id.layout_p)
    }
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_sma, parent, false)
        context = parent.context
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val b = data[position]
        holder.tvSekolah.text = b.nama

        holder.layoutNag.setOnClickListener {
            val activiti = Intent(activity, DetailSekolahActivity::class.java)
            val str = Gson().toJson(data[position], ListSekolah::class.java)
            activiti.putExtra("data", str)
            activity.startActivity(activiti)
        }

    }

}