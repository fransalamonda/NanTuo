package com.example.tanahdatar.menudananagari

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tanahdatar.R
import com.example.tanahdatar.helper.Helper
import com.example.tanahdatar.model.nagari.DataNamaNagari
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail_dana_nagari.*
import kotlinx.android.synthetic.main.toolbar.*

var nagari = DataNamaNagari()
class DetailDanaNagariActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_dana_nagari)
        Helper().setToolbar(this, toolbar, "Luhak Nan Tuo")
        val jsonP = intent.getStringExtra("data")
        nagari = Gson().fromJson(jsonP, DataNamaNagari::class.java)

    }
    fun setData(n: DataNamaNagari){
        tv_nmnagari.text = n.nama
        tv_kecamatan.text = n.kecamatan
    }
    override fun onResume() {
        setData(nagari)

        super.onResume()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}