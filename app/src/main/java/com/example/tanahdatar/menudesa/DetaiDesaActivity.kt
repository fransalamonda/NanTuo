package com.example.tanahdatar.menudesa

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tanahdatar.R
import com.example.tanahdatar.adapter.AdapterDPenyaluran
import com.example.tanahdatar.app.ApiConfig
import com.example.tanahdatar.helper.Helper
import com.example.tanahdatar.model.*
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detai_desa.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


var naga = Datanagari()
class DetaiDesaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detai_desa)
        Helper().setToolbar(this, toolbar, "Luhak Nan Tuo")
        val jsonP = intent.getStringExtra("data")
        naga = Gson().fromJson(jsonP, Datanagari::class.java)

    }
    fun setData(n: Datanagari){
        tv_nagari.text = n.nama
        tv_kec.text = n.kecamatan
    }
    fun getDetail(){
        pb.visibility = View.VISIBLE
        val jsonP = intent.getStringExtra("data")
        naga = Gson().fromJson(jsonP, Datanagari::class.java)
        val idmap = naga.id
        val sdf = SimpleDateFormat("yyyy")
        val tahun = sdf.format(Date())

        ApiConfig.instanceRetrofit.getListNagari(tahun,idmap).enqueue(object : Callback<ResponModelNagari>{
            override fun onResponse(
                call: Call<ResponModelNagari>,
                response: Response<ResponModelNagari>
            ) {
                val res = response.body()!!
                if (res.success == true){
                    displayPenyaluran(res.data.result)
                    displayNagari(res.data.result)
                }
            }

            override fun onFailure(call: Call<ResponModelNagari>, t: Throwable) {
                Toast.makeText(this@DetaiDesaActivity, "Data Error 2", Toast.LENGTH_SHORT).show()
                pb.visibility = View.GONE
            }

        })
    }

        fun displayPenyaluran(lpemyaluran: ArrayList<Dananagari>){
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_list_penyaluran.adapter = AdapterDPenyaluran(lpemyaluran, object : AdapterDPenyaluran.Listeners{
            override fun onClicked(data: Dananagari) {
                TODO("Not yet implemented")
            }


        })
        rv_list_penyaluran.layoutManager =layoutManager
    }

    fun displayNagari(lnagari: ArrayList<Dananagari>){
        tv_pagu.text = Helper().gantiRupiah(lnagari[0].pagu)
        tv_penyaluran.text = Helper().gantiRupiah(lnagari[0].total_penyaluran)
        pb.visibility = View.GONE
    }


    fun setSepiner() {
        val sdf = SimpleDateFormat("yyyy")
        val currentDate = sdf.format(Date())

        val arryString = ArrayList<String>()
        arryString.add(currentDate)
        //arryString.add("2021")
        arryString.add("2020")
        arryString.add("2019")
        arryString.add("2018")
        val adapter =ArrayAdapter<Any>(this, R.layout.item_spinner, arryString.toTypedArray())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_tahun.adapter = adapter
        spinner_tahun.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != 0) {
                    getDetail1(spinner_tahun.selectedItem.toString())
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
    fun getDetail1(tahun: String){
        pb.visibility = View.VISIBLE
        val jsonP = intent.getStringExtra("data")
        naga = Gson().fromJson(jsonP, Datanagari::class.java)
        val idmap = naga.id
//        val sdf = SimpleDateFormat("yyyy")
//        val tahun = sdf.format(Date())

        ApiConfig.instanceRetrofit.getListNagari(tahun,idmap).enqueue(object : Callback<ResponModelNagari>{
            override fun onResponse(
                call: Call<ResponModelNagari>,
                response: Response<ResponModelNagari>
            ) {
                val res = response.body()!!
                if (res.success == true){
                    displayPenyaluran(res.data.result)
                    displayNagari(res.data.result)
                }
            }

            override fun onFailure(call: Call<ResponModelNagari>, t: Throwable) {
                Toast.makeText(this@DetaiDesaActivity, "Data Error 2", Toast.LENGTH_SHORT).show()
                pb.visibility = View.GONE
            }

        })
    }
    override fun onResume() {
        getDetail()
        setData(naga)
        setSepiner()
        super.onResume()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}