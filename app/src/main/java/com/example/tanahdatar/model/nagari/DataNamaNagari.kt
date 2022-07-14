package com.example.tanahdatar.model.nagari

class Datanagari {
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

