package com.example.tanahdatar.menupendidikan.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tanahdatar.R
import com.example.tanahdatar.app.ApiConfig
import com.example.tanahdatar.menupendidikan.Adapter.AdapterSma
import com.example.tanahdatar.model.sekolah.ListSekolah
import com.example.tanahdatar.model.sekolah.ResponSekolah
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_pendidikan.*
import kotlinx.android.synthetic.main.fragment_s_m_a.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SMAFragment : Fragment() {
    lateinit var rvSMA: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_s_m_a, container, false)
        init(view)
        getSma()
        return view
    }
    fun displaySekolah(lprov: java.util.ArrayList<ListSekolah>) {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvSMA.adapter = AdapterSma(requireActivity(), lprov)
        rvSMA.layoutManager = layoutManager
    }

    private var listSma: ArrayList<ListSekolah> = ArrayList()
    fun getSma() {

        ApiConfig.instanceRetrofit.getSekolahSMA().enqueue(object : Callback<ResponSekolah> {
            override fun onResponse(call: Call<ResponSekolah>, response: Response<ResponSekolah>) {
                val res = response.body()!!
                if(res.success == true ){
                    val arraySma = ArrayList<ListSekolah>()
                    listSma = arraySma
                    displaySekolah(res.data.result)
                    //pb.visibility = View.GONE
                }
                //pb.visibility = View.GONE
            }

            override fun onFailure(call: Call<ResponSekolah>, t: Throwable) {
               // Toast.makeText(this@SMAFragment, "Data Error 2", Toast.LENGTH_SHORT).show()
            }

        })
    }
    fun init(view: View) {
        rvSMA = view.findViewById(R.id.rv_sma)
    }


}