package com.example.tanahdatar.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tanahdatar.R
import com.example.tanahdatar.model.Dananagari
import com.example.tanahdatar.model.Danapenyaluran
import com.example.tanahdatar.model.Danapenyerapan
import com.example.tanahdatar.model.ResponPenyaluran

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.util.*
//import kotlin.collections.ArrayList

class AdapterDPenyaluran(var data: ArrayList<Dananagari>, var listener: Listeners) : RecyclerView.Adapter<AdapterDPenyaluran.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama    = view.findViewById<TextView>(R.id.tv_nama)
        val tvBobot   = view.findViewById<TextView>(R.id.tv_bobot)
        val btnDetail = view.findViewById<TextView>(R.id.btn_detail)

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
        val b = a.penyaluran
        //val c = a.penyerapan.realisasi
//        val c = a.penyerapan
        for (i in 1..3) {
            System.out.println(b[i].tanggal_realisasi)
        }
        //System.out.println(c)
//        holder.tvNama.text = b[1].tanggal_realisasi
//            holder.tvBobot.text = data[position].penyaluran.tanggal_realisasi
//        holder.tvBobot.text = data[position].penyerapan.penyerapan[0].kegiatan

        holder.btnDetail.setOnClickListener {
            listener.onClicked(a)
        }
    }


    interface Listeners {
        fun onClicked(data: Dananagari)
    }

}