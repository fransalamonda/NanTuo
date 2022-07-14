package com.example.tanahdatar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_halaman_utama.*

class HalamanUtamaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_utama)
        val fragmentDashboard = DashboardFragment()
        val fragmentLogin = LoginFragment()
        setFragment(fragmentDashboard)

        iv_menu1.setOnClickListener {
            setFragment(fragmentDashboard)
//            changeIcon(iv_menu1, R.drawable.ic_home_active)
//            changeIcon(iv_menu2, R.drawable.ic_tiket)
//            changeIcon(iv_menu3, R.drawable.ic_profile)
        }
        iv_menu2.setOnClickListener {
            //var intent = Intent(this@HalamanUtamaActivity, LoginActivity::class.java)
            //startActivity(intent)
            //finish()
            setFragment(fragmentLogin)
//            changeIcon(iv_menu1, R.drawable.ic_home)
//            changeIcon(iv_menu2, R.drawable.ic_tiket_active)
//            changeIcon(iv_menu3, R.drawable.ic_profile)

        }
    }
    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransacion = fragmentManager.beginTransaction()
        fragmentTransacion.replace(R.id.layout_frame, fragment)
        fragmentTransacion.commit()


    }
}