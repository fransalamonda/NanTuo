package com.example.tanahdatar.model.komoditi

import com.example.tanahdatar.model.Dananagari
import com.example.tanahdatar.model.Datanagari
import com.example.tanahdatar.model.sekolah.DanaSekolah
import java.util.*

class ResponMKomoditi {
    var success : Boolean  = true
    var pesan = ""
    val data = KomoditiData()

    class KomoditiData{
        val result = ArrayList<DataListKomoditi>()
        val pasar = ""
        val idpasar = ""
    }

}