package com.example.tanahdatar.model.nagari

import com.example.tanahdatar.model.Dananagari
import java.util.*

class ResponModelNagari {
    var success : Boolean  = true
    var message = ""
    val data = NagariD()

    class NagariD{
        val total_record = ""
        val total_page = ""
        val result = ArrayList<Dananagari>()
    }




}