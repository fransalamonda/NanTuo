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
import kotlinx.android.synthetic.main.activity_dana_desa.*
import kotlinx.android.synthetic.main.activity_pendidikan.*
import kotlinx.android.synthetic.main.activity_pendidikan.pb
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SMPFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SMPFragment : Fragment() {
    lateinit var rvSMP: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_s_m_p, container, false)
        init(view)
        getSmp()
        return view
    }
    fun displaySekolah(lprov: java.util.ArrayList<ListSekolah>) {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvSMP.adapter = AdapterSma(requireActivity(), lprov)
        rvSMP.layoutManager = layoutManager
    }
    fun getSmp() {
        //pb.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.getSekolahSMP().enqueue(object : Callback<ResponSekolah> {
            override fun onResponse(call: Call<ResponSekolah>, response: Response<ResponSekolah>) {
                val res = response.body()!!
                if(res.success == true ){
                    val arraySma = ArrayList<ListSekolah>()
                    displaySekolah(res.data.result)
                    //pb.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<ResponSekolah>, t: Throwable) {
                pb.visibility = View.GONE
                // Toast.makeText(this@SMAFragment, "Data Error 2", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun init(view: View) {
        rvSMP = view.findViewById(R.id.rv_smp)
    }
}