package com.example.tanahdatar.model.sekolah

import com.example.tanahdatar.model.Dananagari
import java.util.ArrayList

class ResponSekolah {
    var success : Boolean  = true
    val data = SekolahID()

    class SekolahID{
        val total_record = ""
        val total_page = ""
        val result = ArrayList<ListSekolah>()
    }
}