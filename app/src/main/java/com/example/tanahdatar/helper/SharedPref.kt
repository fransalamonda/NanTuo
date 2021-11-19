package com.example.tanahdatar.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
//import com.inyongtisto.tokoonline.model.User

class SharedPref(activity: Activity) {

    val login = "login"
    val nama = "name"
    val user = "user"

    val mypref = "MAIN_PRF"
    val sp: SharedPreferences

    init {
        sp = activity.getSharedPreferences(mypref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status: Boolean) {
        sp.edit().putBoolean(login, status).apply()
    }

    fun getStatusLogin(): Boolean {
        return sp.getBoolean(login, false)
    }




    fun setString(key: String, vlaue: String) {
        sp.edit().putString(key, vlaue).apply()
    }



    fun getString(key: String): String {
        return sp.getString(key, "")!!
    }
    fun clear(){
        sp.edit().clear().apply()
    }
}