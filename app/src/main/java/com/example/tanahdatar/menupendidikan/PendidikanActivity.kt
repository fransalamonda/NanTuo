package com.example.tanahdatar.menupendidikan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tanahdatar.R
import com.example.tanahdatar.helper.Helper
import kotlinx.android.synthetic.main.toolbar.*

class PendidikanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pendidikan)
        Helper().setToolbar(this, toolbar, "Luhak Nan Tuo")
    }
}