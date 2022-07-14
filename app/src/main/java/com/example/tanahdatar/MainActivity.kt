package com.example.tanahdatar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.android.gms.ads.MobileAds


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this) {}

        var handler =  Handler()

        handler.postDelayed({
            var intent = Intent(this@MainActivity, HalamanUtamaActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}