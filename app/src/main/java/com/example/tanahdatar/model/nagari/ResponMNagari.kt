package com.example.tanahdatar.model.nagari

import com.example.tanahdatar.model.Dananagari
import com.example.tanahdatar.model.Datanagari
import com.example.tanahdatar.model.sekolah.DanaSekolah
import java.util.*

class ResponMNagari {
    var success : Boolean  = true
    var pesan = ""
    val data = NagariData()

    class NagariData{
        val result = ArrayList<DataNamaNagari>()
        //val result = ArrayList<Datanagari>()
    }

}