package com.example.tanahdatar.model


data class Dananagari(
    val kode_PUM: String?,
    val provinsi: String?,
    val kabupaten_kota: String?,
    val kecamatan: String?,
    val desa_kelurahan: String?,
    val pagu: String,
    val total_penyaluran: String,
    val penyaluran: Map<Int, ResponPenyaluran> = mapOf(),
    var penyerapan: Responpenyerapan? = null
    //var penyerapan: ArrayList<Timing>?

    )
data class ResponPenyaluran(
    val realisasi : Int?,
    val tanggal_realisasi : String?,
    )
data class Responpenyerapan(
  //  val routes: List<Timing>
    val nomor: Map<Int, List<Timing>>
    )

data class Timing(
    //val routes: List<Timing>
    val nama : String?,
//    val kegiatan : ArrayList<Responkegiatan>?
)

data class Responkegiatan(
    val nama : String?
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

