package com.example.tanahdatar.menupendidikan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tanahdatar.R
import com.example.tanahdatar.model.Datanagari
import com.example.tanahdatar.model.sekolah.ListSekolah
import java.util.*

class AdapterSekolah(var data: ArrayList<ListSekolah>, var listener: Listeners) : RecyclerView.Adapter<AdapterSekolah.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNamaNagari = view.findViewById<TextView>(R.id.tv_nama_n)
        val tvNamaKec    = view.findViewById<TextView>(R.id.tv_nama_kec)
        val layoutNag = view.findViewById<CardView>(R.id.layout_p)
    }
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_sekolah, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder:Holder, position: Int) {
        val b = data[position]

        holder.tvNamaNagari.text = b.nama
        //holder.tvNamaKec.text = b.kecamatan

        holder.layoutNag.setOnClickListener {
            listener.onClicked(b)
        }
    }

    interface Listeners {
        fun onClicked(data: ListSekolah)
    }



}