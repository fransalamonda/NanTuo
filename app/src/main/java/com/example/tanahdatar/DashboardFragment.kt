package com.example.tanahdatar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.tanahdatar.menudananagari.DanaNagariActivity
import com.example.tanahdatar.menudesa.DanaDesaActivity
import com.example.tanahdatar.menukomoditi.KomoditiActivity
import com.example.tanahdatar.menupendidikan.PendidikanActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login2.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import java.util.prefs.Preferences
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {

    lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth

    lateinit var imDesa: ImageView
    lateinit var imPendidikan: ImageView
    lateinit var imProfil: ImageView
    lateinit var impasar: ImageView
    lateinit var imNagari: ImageView

    //private val TAG = "HalamanUtamaActivity"
    //private val REQUEST_PERMISSIONS_REQUEST_CODE = 34

    //private lateinit var fusedLocationClient: FusedLocationProviderClient

    //private lateinit var latitudeText: TextView
    //private lateinit var longitudeText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dashboard, container, false)
        init(view)
        mainButton()
        return view
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        //mGoogleSignInClient= GoogleSignIn.getClient(activity)

    }

    private fun init(view: View) {
        imDesa = view.findViewById(R.id.im_desa)
        imPendidikan = view.findViewById(R.id.im_pendidikan)
        imProfil = view.findViewById(R.id.iv_profile)
        impasar = view.findViewById(R.id.im_pasar)
        imNagari = view.findViewById(R.id.im_dnagari)

        //latitudeText = view.findViewById(R.id.latitude_text)
        //longitudeText = view.findViewById(R.id.longitude_text)
        //fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    fun mainButton() {
        imDesa.setOnClickListener {
            val intent = Intent(activity, DanaDesaActivity::class.java)
            startActivity(intent)
        }
        imPendidikan.setOnClickListener {
            val intent = Intent(activity, PendidikanActivity::class.java)
            startActivity(intent)
        }
        imProfil.setOnClickListener {
            var intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }
        impasar.setOnClickListener {
            var intent = Intent(activity, KomoditiActivity::class.java)
            startActivity(intent)
        }
        imNagari.setOnClickListener {
            var intent = Intent(activity, DanaNagariActivity::class.java)
            startActivity(intent)
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DashboardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashboardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}