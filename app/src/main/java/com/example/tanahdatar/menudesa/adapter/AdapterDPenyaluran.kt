package com.example.tanahdatar.menudesa.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tanahdatar.R
import com.example.tanahdatar.helper.Helper
import com.example.tanahdatar.model.ResponPenyaluran

//import kotlin.collections.ArrayList

class AdapterDPenyaluran(var data: Map<Int, ResponPenyaluran>, var listener: Listeners) : RecyclerView.Adapter<AdapterDPenyaluran.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama    = view.findViewById<TextView>(R.id.tv_nama)
        val tvTanggal   = view.findViewById<TextView>(R.id.tv_tanggal)
//        val btnDetail = view.findViewById<TextView>(R.id.btn_detail)
        val layout    = view.findViewById<CardView>(R.id.layout)
    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_penyaluran, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        if (a != null) {
            holder.tvNama.text = Helper().gantiRupiah(a.realisasi.toString())
            holder.tvTanggal.text = a.tanggal_realisasi
        }
        //System.out.println(data[position])

        holder.layout.setOnClickListener {
            if (a != null) {
                listener.onClicked(a)
            }
        }
    }




    interface Listeners {
        fun onClicked(data: ResponPenyaluran)
    }

}