package com.app.retrofitcoroutine.model

data class SearchNagari(
    val kode_PUM: String?,
    val provinsi: String?,
    val kabupaten_kota: String?,
    val kecamatan: String?,
    val desa_kelurahan: String?,
    val pagu: String?,
    val total_penyaluran: String?,
    //val `penyaluran`: Data?
)
//{
//    data class Data(
//        val realisasi: Int?,
//        val items: List<Item?>?,
//        val q: String?,
//        val spelling_alternatives: SpellingAlternatives?,
//        val start: Int?,
//        val total_count: Int?
//    ) {
//        data class Item(
//            val checksum: Checksum?,
//            val dataset_citation: String?,
//            val dataset_id: String?,
//            val dataset_name: String?,
//            val dataset_persistent_id: String?,
//            val file_content_type: String?,
//            val file_id: String?,
//            val file_type: String?,
//            val md5: String?,
//            val name: String?,
//            val published_at: String?,
//            val size_in_bytes: Int?,
//            val type: String?,
//            val url: String?
//        ) {
//            data class Checksum(
//                val type: String?,
//                val value: String?
//            )
//        }
//
//        class SpellingAlternatives(
//        )
//    }
//}