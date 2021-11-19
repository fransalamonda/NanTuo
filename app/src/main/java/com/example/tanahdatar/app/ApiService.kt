package com.example.tanahdatar.app

import com.example.tanahdatar.model.ResponModel
import com.example.tanahdatar.model.ResponModelNagari
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

//    @FormUrlEncoded
//    @POST("api/loginStaff")
//    fun login(
//        @Field("userid") userid: String,
//        @Field("password") password: String
//    ): Call<ResponModel>


     @GET("v5/desa/search?limit=500&kota=Tanah%20Datar")
    fun getWilNagari1(): Call<ResponModel>

     @GET("api/g_indi?idmap=12")
     //@GET("nagari.json")
     fun getWilNagari(): Call<ResponModel>

    @GET("v5/desa/detil_anggaran")
    fun getListNagari(
        @Query("tahun") tahun: String,
        @Query("kode") kode: String
    ): Call<ResponModelNagari>

//    @GET("api/getWilayahProv")
//    @GET("api/g_wilayah_p")
//    fun getWilPro(
//        @Query("userid") user: String
//    ): Call<ResponModel>
//    //provinsi
//    @GET("api/g_indi")
//    fun getListAspek(
//        @Query("idmap") idmap: String
//    ): Call<ResponModel>
//
//
//    @GET("api/getWilKabupaten")
//    fun getWilKab(
//        @Query("userid") user: String
//    ): Call<ResponModel>
//
//    @GET("api/getWilayahProv")
//     fun getWilProv(): Call<ResponModel>
//
//    @GET("api/getAspek")
//    fun getMAspekH(): Call<ResponModel>
//
//    @GET("api/getAspekP")
//    fun getMAspek(
//        @Query("userid") user: String,
//        @Query("provid") provid: String
//    ): Call<ResponModel>
//
//
//
//    @GET("api/getKriteria")
//    fun getMKriteria(
//        @Query("userid") user: String,
//        @Query("aspekr") aspekr: String,
//        @Query("provid") provid: String
//    ): Call<ResponModel>
//
//    @GET("api/getSubIndikator")
//    fun getMSubIndikator(
//        @Query("userid") user: String,
//        //@Query("aspekr") aspekr: String,
//        @Query("provid") provid: String,
//        @Query("kritid") kritid: String
//    ): Call<ResponModel>
//
//    @GET("api/getIndikatorNilai")
//    fun getIndikatorNilai(
//        @Query("userid") user: String,
//        @Query("provid") provid: String,
//        @Query("indiid") indiid: String
//    ): Call<ResponModel>
//
//    @GET("api/save_score")
//    fun savescore(
//        @Query("userid") userid: String,
//        @Query("provid") provid: String,
//        @Query("iditemindi") nomortlp: String
//    ): Call<ResponModel>
//
//    //kota
//    @GET("api_kota/g_wilayah")
//    fun getWilKota(
//        @Query("userid") user: String
//    ): Call<ResponModel>
//    @GET("api_kota/g_indi")
//    fun getIndi(
//        @Query("idmap") idmap: String
//    ): Call<ResponModel>
//
//
////dokumen
//    @GET("dokumen/getDokumenProv")
//    fun getDokProv(
//        @Query("group") group: String,
//        @Query("provid") provid: String
//    ): Call<ResponModel>
}