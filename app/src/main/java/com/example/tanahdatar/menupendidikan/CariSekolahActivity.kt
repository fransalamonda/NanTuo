package com.example.tanahdatar.menupendidikan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tanahdatar.R
import com.example.tanahdatar.app.ApiConfig
import com.example.tanahdatar.helper.Helper
import com.example.tanahdatar.model.sekolah.ListSekolah
import com.example.tanahdatar.model.sekolah.ResponSekolah
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_dana_desa.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class CariSekolahActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cari_sekolah)
        Helper().setToolbar(this, toolbar, "Luhak Nan Tuo")
    }
    fun getSekolah(){
        pb.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.getSekolahSD().enqueue(object : Callback<ResponSekolah> {
            override fun onResponse(call: Call<ResponSekolah>, response: Response<ResponSekolah>) {
                val res = response.body()!!
                if(res.success == true ){
                    displaySekolah(res.data.result)
                    pb.visibility = View.GONE
                } else{
                    Toast.makeText(this@CariSekolahActivity, "Data Error 1", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponSekolah>, t: Throwable) {
                Toast.makeText(this@CariSekolahActivity, "Data Error 2", Toast.LENGTH_SHORT).show()
            }

        })

    }

    fun displaySekolah(lprov: ArrayList<ListSekolah>){
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_list_nagari.adapter = AdapterSekolah(lprov, object : AdapterSekolah.Listeners{
            override fun onClicked(data: ListSekolah) {
                val json = Gson().toJson(data,ListSekolah::class.java)
                val intent = Intent(this@CariSekolahActivity, DetailSekolahActivity::class.java)
                intent.putExtra("data", json)
                startActivity(intent)
            }
        })
        rv_list_nagari.layoutManager =layoutManager

    }

    override fun onResume() {
        getSekolah()
        super.onResume()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}