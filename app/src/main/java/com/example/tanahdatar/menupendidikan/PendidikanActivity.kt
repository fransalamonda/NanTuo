package com.example.tanahdatar.menupendidikan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tanahdatar.DashboardFragment
import com.example.tanahdatar.R
import com.example.tanahdatar.helper.Helper
import com.example.tanahdatar.menupendidikan.Fragment.SDFragment
import com.example.tanahdatar.menupendidikan.Fragment.SMAFragment
import com.example.tanahdatar.menupendidikan.Fragment.SMPFragment
import kotlinx.android.synthetic.main.activity_dana_desa.*
import kotlinx.android.synthetic.main.activity_pendidikan.*
import kotlinx.android.synthetic.main.activity_pendidikan.pb
import kotlinx.android.synthetic.main.toolbar.*

class PendidikanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pendidikan)
        Helper().setToolbar(this, toolbar, "Luhak Nan Tuo")
        pb.visibility = View.VISIBLE
        mainButton()
        val fragmentSMA = SMAFragment()
        setFragment(fragmentSMA)

    }
    private fun setFragment(fragment: Fragment) {
        //pb.visibility = View.VISIBLE
        val fragmentManager = supportFragmentManager
        val fragmentTransacion = fragmentManager.beginTransaction()
        fragmentTransacion.replace(R.id.layout_frame, fragment)
        fragmentTransacion.commit()
        //pb.visibility = View.GONE
    }
   private fun mainButton() {
       //pb.visibility = View.VISIBLE
       btn_sd.setOnClickListener{
           val fragmentSD = SDFragment()
           setFragment(fragmentSD)
           //pb.visibility = View.GONE
       }
       btn_smp.setOnClickListener {
           val fragmentSMP = SMPFragment()
           setFragment(fragmentSMP)
           //pb.visibility = View.GONE
       }
       btn_sma.setOnClickListener {
           val fragmentSMA = SMAFragment()
           setFragment(fragmentSMA)
           //pb.visibility = View.GONE
       }
       //pb.visibility = View.GONE
   }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}