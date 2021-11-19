package com.example.tanahdatar.menudesa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tanahdatar.R
import com.example.tanahdatar.adapter.AdapterNagari
import com.example.tanahdatar.app.ApiConfig
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_dana_desa.*
import kotlinx.android.synthetic.main.activity_dana_desa.pb

import com.example.tanahdatar.helper.Helper
import com.example.tanahdatar.model.Datanagari
import com.example.tanahdatar.model.ResponModel
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class DanaDesaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dana_desa)
        Helper().setToolbar(this, toolbar, "Luhak Nan Tuo")
    }
    fun getNagari(){
        pb.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.getWilNagari1().enqueue(object : Callback<ResponModel> {

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val res = response.body()!!
                if(res.success == true ){
                    // Toast.makeText(this@DanaDesaActivity, "sssss ", Toast.LENGTH_SHORT).show()
                    displayNagari(res.data.result)
                    pb.visibility = View.GONE
                } else{
                    Toast.makeText(this@DanaDesaActivity, "Data Error 1", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Toast.makeText(this@DanaDesaActivity, "Data Error 2", Toast.LENGTH_SHORT).show()
            }

        })
    }
    fun displayNagari(lprov: ArrayList<Datanagari>){
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_list_nagari.adapter = AdapterNagari(lprov, object : AdapterNagari.Listeners{
            override fun onClicked(data: Datanagari) {
                val json = Gson().toJson(data,Datanagari::class.java)
                val intent = Intent(this@DanaDesaActivity, DetaiDesaActivity::class.java)
                intent.putExtra("data", json)
                startActivity(intent)
            }
        })
        rv_list_nagari.layoutManager =layoutManager

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


