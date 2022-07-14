package com.example.tanahdatar.menudananagari

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tanahdatar.R
import com.example.tanahdatar.app.ApiConfigLocal
import com.example.tanahdatar.helper.Helper
import com.example.tanahdatar.menudananagari.adapter.AdapterDNagari
import com.example.tanahdatar.model.nagari.DataNamaNagari
import com.example.tanahdatar.model.nagari.ResponMNagari
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_dana_desa.*
import kotlinx.android.synthetic.main.activity_dana_desa.pb
import kotlinx.android.synthetic.main.activity_dana_nagari.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList



class DanaNagariActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dana_nagari)
        Helper().setToolbar(this, toolbar, "Luhak Nan Tuo")
    }

    fun getNagari(){
        pb.visibility = View.VISIBLE
        ApiConfigLocal.instanceRetrofit.getNagariDesa().enqueue(object : Callback<ResponMNagari> {
            override fun onResponse(call: Call<ResponMNagari>, response: Response<ResponMNagari>) {
                val res = response.body()!!
                if(res.success == true ){
                     Toast.makeText(this@DanaNagariActivity, "Sucses ", Toast.LENGTH_SHORT).show()
                    displayNagari(res.data.result)
                    pb.visibility = View.GONE
                } else{
                    Toast.makeText(this@DanaNagariActivity, "Data Error 1", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponMNagari>, t: Throwable) {
                pb.visibility = View.GONE
                Toast.makeText(this@DanaNagariActivity, "Data Error 2", Toast.LENGTH_SHORT).show()
            }

        })
    }
    fun displayNagari(nmNagari: ArrayList<DataNamaNagari>){
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_list_nama.adapter = AdapterDNagari(nmNagari, object : AdapterDNagari.Listeners{
            override fun onClicked(data: DataNamaNagari) {
                val json = Gson().toJson(data, DataNamaNagari::class.java)
                val intent = Intent(this@DanaNagariActivity, DetailDanaNagariActivity::class.java)
                intent.putExtra("data", json)
                startActivity(intent)
            }

        })
        rv_list_nama.layoutManager =layoutManager
    }

    override fun onResume() {
        getNagari()
        super.onResume()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}

