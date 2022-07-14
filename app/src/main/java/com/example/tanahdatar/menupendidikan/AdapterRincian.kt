package com.example.tanahdatar.menupendidikan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tanahdatar.R
import com.example.tanahdatar.helper.Helper
import com.example.tanahdatar.model.Datanagari
import com.example.tanahdatar.model.sekolah.DanaSekolah
import com.example.tanahdatar.model.sekolah.ListSekolah
import java.util.*

class AdapterRincian(var data: ArrayList<DanaSekolah>, var listener: Listeners) : RecyclerView.Adapter<AdapterRincian.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvJmlDana = view.findViewById<TextView>(R.id.tv_jml_dana)
        val tvJmlCair = view.findViewById<TextView>(R.id.tv_jml_cair)
        val tvTri = view.findViewById<TextView>(R.id.tv_tri)
        val tvJmlSP = view.findViewById<TextView>(R.id.tv_jml_siswa_p)
        val tvTglCair = view.findViewById<TextView>(R.id.tv_tgl_cair)

        val tvNmpengguna = view.findViewById<TextView>(R.id.tv_nmpengguna)
        val tvNmpengguna2 = view.findViewById<TextView>(R.id.tv_nmpengguna2)
        val tvNmpengguna3 = view.findViewById<TextView>(R.id.tv_nmpengguna3)
        val tvNmpengguna4 = view.findViewById<TextView>(R.id.tv_nmpengguna4)
        val tvNmpengguna5 = view.findViewById<TextView>(R.id.tv_nmpengguna5)
        val tvNmpengguna6 = view.findViewById<TextView>(R.id.tv_nmpengguna6)
        val tvNmpengguna7 = view.findViewById<TextView>(R.id.tv_nmpengguna7)
        val tvNmpengguna8 = view.findViewById<TextView>(R.id.tv_nmpengguna8)
        val tvNmpengguna9 = view.findViewById<TextView>(R.id.tv_nmpengguna9)
        val tvNmpengguna10 = view.findViewById<TextView>(R.id.tv_nmpengguna10)
        val tvNmpengguna11 = view.findViewById<TextView>(R.id.tv_nmpengguna11)
        val tvNmpengguna12 = view.findViewById<TextView>(R.id.tv_nmpengguna12)

        val tvTotalDana = view.findViewById<TextView>(R.id.tv_total_dana)
        val tvTotalDana2 = view.findViewById<TextView>(R.id.tv_total_dana2)
        val tvTotalDana3 = view.findViewById<TextView>(R.id.tv_total_dana3)
        val tvTotalDana4 = view.findViewById<TextView>(R.id.tv_total_dana4)
        val tvTotalDana5 = view.findViewById<TextView>(R.id.tv_total_dana5)
        val tvTotalDana6 = view.findViewById<TextView>(R.id.tv_total_dana6)
        val tvTotalDana7 = view.findViewById<TextView>(R.id.tv_total_dana7)
        val tvTotalDana8 = view.findViewById<TextView>(R.id.tv_total_dana8)
        val tvTotalDana9 = view.findViewById<TextView>(R.id.tv_total_dana9)
        val tvTotalDana10 = view.findViewById<TextView>(R.id.tv_total_dana10)
        val tvTotalDana11 = view.findViewById<TextView>(R.id.tv_total_dana11)
        val tvTotalDana12 = view.findViewById<TextView>(R.id.tv_total_dana12)


        val layoutNag = view.findViewById<CardView>(R.id.layout_p)
    }
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_sekolah_rincian, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder:Holder, position: Int) {
        val b = data[position]
        //val tdti = b.total_dana_tahap_ini.toString()
        //val tdti1: Double? = tdti.toDouble()
        //System.out.println(tdti1)

//        holder.tvJmlDana.text = Helper().gantiRupiah(b.total_dana_tahap_ini)

        if (b.total_dana_tahap_ini != null){
            val total = b.total_dana_tahap_ini.toDouble().toInt()
            holder.tvJmlDana.text = Helper().gantiRupiah(total)
        }else{
            holder.tvJmlDana.text = b.total_dana_tahap_ini
        }

        if (b.dana_dari_provinsi != null){
            val dari = b.dana_dari_provinsi.toDouble().toInt()
            holder.tvJmlCair.text = Helper().gantiRupiah(dari)
        }else{
            holder.tvJmlCair.text = b.dana_dari_provinsi
        }
        holder.tvTri.text = b.triwulan
        holder.tvJmlSP.text = b.jumlah_siswa.toString()
        holder.tvTglCair.text = b.tanggal_cair

        holder.tvNmpengguna.text = b.komponen_1_nama
        holder.tvNmpengguna2.text = b.komponen_2_nama
        holder.tvNmpengguna3.text = b.komponen_3_nama
        holder.tvNmpengguna4.text = b.komponen_4_nama
        holder.tvNmpengguna5.text = b.komponen_5_nama
        holder.tvNmpengguna6.text = b.komponen_6_nama
        holder.tvNmpengguna7.text = b.komponen_7_nama
        holder.tvNmpengguna8.text = b.komponen_8_nama
        holder.tvNmpengguna9.text = b.komponen_9_nama
        holder.tvNmpengguna10.text = b.komponen_10_nama
        holder.tvNmpengguna11.text = b.komponen_11_nama
        holder.tvNmpengguna12.text = b.komponen_12_nama
//        holder.tvTotalDana.text = Helper().gantiRupiah(b.komponen_1)
        val str = b.komponen_1.toDouble().toInt()
        holder.tvTotalDana.text = Helper().gantiRupiah(str)
        val str2 = b.komponen_2.toDouble().toInt()
        holder.tvTotalDana2.text = Helper().gantiRupiah(str2)
        val str3 = b.komponen_3.toDouble().toInt()
        holder.tvTotalDana3.text = Helper().gantiRupiah(str3)
        val str4 = b.komponen_4.toDouble().toInt()
        holder.tvTotalDana4.text = Helper().gantiRupiah(str4)
        val str5 = b.komponen_5.toDouble().toInt()
        holder.tvTotalDana5.text = Helper().gantiRupiah(str5)
        val str6 = b.komponen_6.toDouble().toInt()
        holder.tvTotalDana6.text = Helper().gantiRupiah(str6)
        val str7 = b.komponen_7.toDouble().toInt()
        holder.tvTotalDana7.text = Helper().gantiRupiah(str7)
        val str8 = b.komponen_8.toDouble().toInt()
        holder.tvTotalDana8.text = Helper().gantiRupiah(str8)
        val str9 = b.komponen_9.toDouble().toInt()
        holder.tvTotalDana9.text = Helper().gantiRupiah(str9)
        val str10 = b.komponen_10.toDouble().toInt()
        holder.tvTotalDana10.text = Helper().gantiRupiah(str10)
        val str11 = b.komponen_11.toDouble().toInt()
        holder.tvTotalDana11.text = Helper().gantiRupiah(str11)
        val str12 = b.komponen_12.toDouble().toInt()
        holder.tvTotalDana12.text = Helper().gantiRupiah(str12)

        //holder.tvNamaNagari.text = b.total_dana_tahap_ini
        //holder.tvNamaKec.text = b.kecamatan

        holder.layoutNag.setOnClickListener {
            //listener.onClicked(b)
        }
    }

    interface Listeners {
        fun onClicked(data: DanaSekolah)
    }



}