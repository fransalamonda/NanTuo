package com.example.tanahdatar.model

import java.util.*

class ResponModel {
    //lateinit var success : String

    var success : Boolean  = true
    val data = NagariT()
    class NagariT{
        val result = ArrayList<Datanagari>()
    }

    var status = 0
    lateinit var message: String
    var listmodalaspek:ArrayList<MAspek>            = ArrayList()


}