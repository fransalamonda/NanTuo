package com.example.tanahdatar.app


import com.example.tanahdatar.model.komoditi.ResponMKomoditi
import com.example.tanahdatar.model.nagari.ResponMNagari
import com.example.tanahdatar.model.nagari.ResponModelNagari
import retrofit2.Call
import retrofit2.http.*

interface ApiServiceLocal {




    @GET("public/DataApi/g_nagari")
    fun getNagariDesa(): Call<ResponMNagari>
@GET("https://fransalamonda.com/mf/public/DataApi/g_new")
fun getKomoditas(): Call<ResponMKomoditi>

    @GET("public/DataApi/g_komoditi")
    fun getKomoditas1(
        @Query("lat") lat: String,
        @Query("lon") lon: String
    ): Call<ResponMKomoditi>

}