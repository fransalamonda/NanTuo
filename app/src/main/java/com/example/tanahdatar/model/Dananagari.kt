package com.example.tanahdatar.model

import com.google.gson.annotations.Expose
//import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import java.util.ArrayList

data class Dananagari (
    val kode_PUM : String?,
    val provinsi : String?,
    val kabupaten_kota : String?,
    val kecamatan : String?,
    val desa_kelurahan : String?,
    val pagu : String,
    val total_penyaluran : String,
    val penyaluran: Map<Int, ResponPenyaluran> = mapOf(),
//    val penyerapan: MutableMap<Int, Responpenyerapan> = mutableMapOf()
    //val penyerapan : Responpenyerapan
    )
data class ResponPenyaluran(
    val realisasi : Int?,
    val tanggal_realisasi : String?,
    )
data class Responpenyerapan(
    val realisasi : Int?,
    val kegiatan : String?,
)
//class Dananagari{
//
//    var kode_PUM = ""
//    var provinsi = ""
//    var kabupaten_kota = ""
//    var kecamatan = ""
//    var desa_kelurahan = ""
//    var pagu = ""
//    var total_penyaluran = ""
//
//
//    var penyaluran = DataPenyaluran()
//    class DataPenyaluran(){
//        var realisasi = 0
//        var tanggal_realisasi = ""
//    }
//    val penyerapan = DataPenyerapan()
//    class DataPenyerapan{
//        var nama = ""
//        var kegiatan = ArrayList<DataKegiatan>()
//    }
//    class DataKegiatan{
//        var nama = ""
//        var uraian = ""
//    }
//}

