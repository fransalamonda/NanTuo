package com.example.tanahdatar.menupendidikan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tanahdatar.R
import com.example.tanahdatar.app.ApiConfig
import com.example.tanahdatar.helper.Helper
import com.example.tanahdatar.model.sekolah.DanaSekolah
import com.example.tanahdatar.model.sekolah.ListSekolah
import com.example.tanahdatar.model.sekolah.ResponModelSekolah
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_dana_desa.*
import kotlinx.android.synthetic.main.activity_detai_desa.*
import kotlinx.android.synthetic.main.activity_detai_desa.pb
import kotlinx.android.synthetic.main.activity_detail_sekolah.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var naga = ListSekolah()
class DetailSekolahActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_sekolah)
        Helper().setToolbar(this, toolbar, "Luhak Nan Tuo")
        val jsonP = intent.getStringExtra("data")
        naga = Gson().fromJson(jsonP, ListSekolah::class.java)
    }
    fun setData(s: ListSekolah){
        tv_sekolah.text = s.nama
        tv_kep.text = s.kepsek
        tv_nomor.text = s.npsn
    }
    fun displayPenyaluran(){
        pb.visibility = View.VISIBLE
        val jsonP = intent.getStringExtra("data")
        naga = Gson().fromJson(jsonP, ListSekolah::class.java)
        val npsn = naga.npsn
        val tahun = "2020"

        ApiConfig.instanceRetrofit.getListSekolah(tahun,npsn).enqueue(object : Callback<ResponModelSekolah> {
            override fun onResponse(
                call: Call<ResponModelSekolah>,
                response: Response<ResponModelSekolah>
            ) {
                val res = response.body()!!
                if (res.success == true){
                    //k_1_nama.text = res.data.result[0].komponen_1_nama
                    //k_satu.text = res.data.result[0].komponen_1
                    displayRincian(res.data.result)
                    pb.visibility = View.GONE
                }
                else{
                    Toast.makeText(this@DetailSekolahActivity, "Data Error 2", Toast.LENGTH_SHORT).show()
                    pb.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<ResponModelSekolah>, t: Throwable) {
                Toast.makeText(this@DetailSekolahActivity, "Data Error 2", Toast.LENGTH_SHORT).show()
                pb.visibility = View.GONE
            }

        })
    }
    fun displayRincian(lPenyaluran: ArrayList<DanaSekolah>){
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        rv_list_rincian.adapter = AdapterRincian(lPenyaluran, object : AdapterRincian.Listeners{
            override fun onClicked(data: DanaSekolah) {
                TODO("Not yet implemented")
            }

        })
        rv_list_rincian.layoutManager =layoutManager
    }

    override fun onResume() {
        setData(naga)
        displayPenyaluran()
        super.onResume()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}