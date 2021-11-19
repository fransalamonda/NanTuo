package com.example.tanahdatar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class HalamanUtamaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_utama)
        val fragmentDashboard = DashboardFragment()
        setFragment(fragmentDashboard)
    }
    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransacion = fragmentManager.beginTransaction()
        fragmentTransacion.replace(R.id.layout_frame, fragment)
        fragmentTransacion.commit()
    }
}