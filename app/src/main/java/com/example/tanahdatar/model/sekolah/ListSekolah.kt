package com.example.tanahdatar.model

class Dananagaria {
    var kode_PUM = ""
    var provinsi = ""
    var kabupaten_kota = ""
    var kecamatan = ""
    var desa_kelurahan = ""
    var pagu = ""
    var total_penyaluran = ""
    val penyaluran = DataPenyaluran()
    class DataPenyaluran{
        var realisasi = 0
        var tanggal_realisasi = ""
    }
    //val penyerapan = DataPenyerapan()
//    val penyerapan = ArrayList<DataPenyerapan>()
    class DataPenyerapan{
        var nama = ""
        var kegiatan=""
    }

}

//data class Dananagari(
//    var kode_PUM : String?,
//    var provinsi : String?,
//    var kabupaten_kota : String?,
//    var kecamatan : String?,
//    var desa_kelurahan : String?,
//    var pagu : String,
//    var total_penyaluran : String,
//    val penyaluran : List<DataPenyaluran>?,
//){
//    data class DataPenyaluran(
//        var realisasi : Int,
//        var tanggal_realisasi : String
//    )
//}