package com.example.tanahdatar.menukomoditi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tanahdatar.R
import com.example.tanahdatar.helper.Helper
import com.example.tanahdatar.model.komoditi.DataListKomoditi
import com.example.tanahdatar.model.nagari.DataNamaNagari
import java.util.*

class AdapterLKomoditi(var data: ArrayList<DataListKomoditi>, var listener: Listeners) : RecyclerView.Adapter<AdapterLKomoditi.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNamaKomoditi = view.findViewById<TextView>(R.id.tv_nama_k)
        val tvHarga1    = view.findViewById<TextView>(R.id.tv_hargaAsli)
        val tvHarga2    = view.findViewById<TextView>(R.id.tv_harga2)
        val tvTgl    = view.findViewById<TextView>(R.id.tv_tgl)
        val tvPasar    = view.findViewById<TextView>(R.id.tv_pasar)
        val layoutNag    = view.findViewById<CardView>(R.id.layout_p)
    }
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_komoditi, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val b = data[position]

        holder.tvNamaKomoditi.text = b.namaitem
        holder.tvHarga1.text = Helper().gantiRupiah(b.harga)
        holder.tvHarga2.text = Helper().gantiRupiah(b.harga2)
        holder.tvTgl.text = b.tanggal
        holder.tvPasar.text = b.namapasr
        holder.layoutNag.setOnClickListener {
            listener.onClicked(b)
        }
    }

    interface Listeners {
        fun onClicked(data: DataListKomoditi)
    }



}