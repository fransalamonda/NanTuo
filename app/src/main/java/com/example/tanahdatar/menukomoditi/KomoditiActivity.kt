package com.example.tanahdatar.menukomoditi

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tanahdatar.R
import com.example.tanahdatar.helper.Helper
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*

import com.example.tanahdatar.BuildConfig.APPLICATION_ID
import com.example.tanahdatar.app.ApiConfigLocal
import com.example.tanahdatar.menukomoditi.adapter.AdapterLKomoditi
import com.example.tanahdatar.model.komoditi.DataListKomoditi
import com.example.tanahdatar.model.komoditi.ResponMKomoditi
import com.google.android.gms.ads.AdRequest
import java.util.Locale
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import kotlinx.android.synthetic.main.activity_dana_desa.*
import kotlinx.android.synthetic.main.activity_komoditi.*
import kotlinx.android.synthetic.main.activity_komoditi.pb
import retrofit2.Call
import retrofit2.Response

class KomoditiActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 34

    /**
     * Provides the entry point to the Fused Location Provider API.
     */
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var longitudeAla: TextView
    private lateinit var pasarnama: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_komoditi)
        Helper().setToolbar(this, toolbar, "Info Harga Komoditi Pertanian Tanah Datar")

        MobileAds.initialize(this) {}

        longitudeAla = findViewById(R.id.tv_lokasi)
        pasarnama = findViewById(R.id.id_pasar)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Set your test devices. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("ABCDEF012345"))
        // to get test ads on this device."
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("ABCDEF012345"))
                .build()
        )
// Create an ad request.
        val adRequest = AdRequest.Builder().build()

        // Start loading the ad in the background.
        ad_view.loadAd(adRequest)
    }

    fun getKomoditas(){
        pb.visibility = View.VISIBLE
        ApiConfigLocal.instanceRetrofit.getKomoditas().enqueue(object :
            retrofit2.Callback<ResponMKomoditi> {
            override fun onResponse(call: Call<ResponMKomoditi>, response: Response<ResponMKomoditi>) {
                val res = response.body()!!
                if(res.success == true ){
                    Toast.makeText(this@KomoditiActivity, "Sucses ", Toast.LENGTH_SHORT).show()
                    displayKomoditas(res.data.result)
                    pb.visibility = View.GONE
                } else{
                    Toast.makeText(this@KomoditiActivity, "Data Error 1", Toast.LENGTH_SHORT).show()
                }
            }


            override fun onFailure(call: Call<ResponMKomoditi>, t: Throwable) {
                pb.visibility = View.GONE
                Toast.makeText(this@KomoditiActivity, "Data Error 2", Toast.LENGTH_SHORT).show()
            }

        })
    }
    fun displayKomoditas(nmKomoditi: ArrayList<DataListKomoditi>){
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_list_komoditi.adapter = AdapterLKomoditi(nmKomoditi, object : AdapterLKomoditi.Listeners{
            override fun onClicked(data: DataListKomoditi) {
                TODO("Not yet implemented")
            }
        })
        rv_list_komoditi.layoutManager =layoutManager
    }

    fun getKomoditas1(lat: String, lon: String){
        pb.visibility = View.VISIBLE
        ApiConfigLocal.instanceRetrofit.getKomoditas1(lat,lon).enqueue(object :
            retrofit2.Callback<ResponMKomoditi> {
            override fun onResponse(call: Call<ResponMKomoditi>, response: Response<ResponMKomoditi>) {
                val res = response.body()!!
                if(res.success == true ){
                    Toast.makeText(this@KomoditiActivity, "Sucses ", Toast.LENGTH_SHORT).show()
                    displayKomoditas(res.data.result)
                    pasarnama.text = res.data.pasar
                    pb.visibility = View.GONE
                } else{
                    Toast.makeText(this@KomoditiActivity, "Data Error 1", Toast.LENGTH_SHORT).show()
                }
            }


            override fun onFailure(call: Call<ResponMKomoditi>, t: Throwable) {
                pb.visibility = View.GONE
                Toast.makeText(this@KomoditiActivity, "Data Error 2", Toast.LENGTH_SHORT).show()
            }

        })
    }

    // Called when leaving the activity
    public override fun onPause() {
        ad_view.pause()
        super.onPause()
    }
    // Called when returning to the activity
    public override fun onResume() {

        super.onResume()
        ad_view.resume()
    }
    // Called before the activity is destroyed
    public override fun onDestroy() {
        ad_view.destroy()
        super.onDestroy()
    }


    override fun onStart() {
        super.onStart()

        if (!checkPermissions()) {
            requestPermissions()
        } else {
            getLastLocation()
        }
    }

            /**
     * Provides a simple way of getting a device's location and is well suited for
     * applications that do not require a fine-grained location and that do not need location
     * updates. Gets the best and most recent location currently available, which may be null
     * in rare cases when a location is not available.
     *
     * Note: this method should be called after location permission has been granted.
     */

    /**
     * Provides a simple way of getting a device's location and is well suited for
     * applications that do not require a fine-grained location and that do not need location
     * updates. Gets the best and most recent location currently available, which may be null
     * in rare cases when a location is not available.
     *
     * Note: this method should be called after location permission has been granted.
     */
    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        fusedLocationClient.lastLocation
            .addOnCompleteListener { taskLocation ->
                if (taskLocation.isSuccessful && taskLocation.result != null) {

                    val location = taskLocation.result

//                    latitudeText.text = resources.getString(R.string.latitude_label, location?.latitude)
//                    longitudeText.text = resources.getString(R.string.longitude_label, location?.longitude)

                    //var geocoder: Geocoder
                    //var addresses: List<Address?>
                    var latitude = location?.latitude
                    var longitude = location?.longitude
                    var namaJalan = ""

                    val geocoder: Geocoder
                    val addresses: List<Address>
                    geocoder = Geocoder(this, Locale.getDefault())

                    addresses = geocoder.getFromLocation(
                        latitude!!,
                        longitude!!,
                        1
                    ) // Here 1 represent max location result to returned, by documents it recommended 1 to 5


                    val address =
                        addresses[0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()

                    val city = addresses[0].locality
                    val state = addresses[0].adminArea
                    val country = addresses[0].countryName
                    val postalCode = addresses[0].postalCode
                    val knownName = addresses[0].featureName

                    longitudeAla.text = address
                    //getKomoditas()
                    getKomoditas1(latitude.toString(), longitude.toString())

                } else {
                    Log.w(TAG, "getLastLocation:exception", taskLocation.exception)
                    showSnackbar(R.string.no_location_detected)
                }
            }
    }

            /**
     * Shows a [Snackbar].
     *
     * @param snackStrId The id for the string resource for the Snackbar text.
     * @param actionStrId The text of the action item.
     * @param listener The listener associated with the Snackbar action.
     */

    /**
     * Shows a [Snackbar].
     *
     * @param snackStrId The id for the string resource for the Snackbar text.
     * @param actionStrId The text of the action item.
     * @param listener The listener associated with the Snackbar action.
     */
    private fun showSnackbar(
        snackStrId: Int,
        actionStrId: Int = 0,
        listener: View.OnClickListener? = null
    ) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content), getString(snackStrId),
            Snackbar.LENGTH_INDEFINITE
        )
        if (actionStrId != 0 && listener != null) {
            snackbar.setAction(getString(actionStrId), listener)
        }
        snackbar.show()
    }
            /**
     * Return the current state of the permissions needed.
     */
    /**
     * Return the current state of the permissions needed.
     */
    private fun checkPermissions() =
        ActivityCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    private fun startLocationPermissionRequest() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
            REQUEST_PERMISSIONS_REQUEST_CODE)
    }
    private fun requestPermissions() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )) {
            // Provide an additional rationale to the user. This would happen if the user denied the
            // request previously, but didn't check the "Don't ask again" checkbox.
            Log.i(TAG, "Displaying permission rationale to provide additional context.")
            showSnackbar(R.string.permission_rationale, android.R.string.ok, View.OnClickListener {
                // Request permission
                startLocationPermissionRequest()
            })

        } else {
            // Request permission. It's possible this can be auto answered if device policy
            // sets the permission in a given state or the user denied the permission
            // previously and checked "Never ask again".
            Log.i(TAG, "Requesting permission")
            startLocationPermissionRequest()
        }
    }
                /**
     * Callback received when a permissions request has been completed.
     */
    /**
     * Callback received when a permissions request has been completed.
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        Log.i(TAG, "onRequestPermissionResult")
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            when {
                // If user interaction was interrupted, the permission request is cancelled and you
                // receive empty arrays.
                grantResults.isEmpty() -> Log.i(TAG, "User interaction was cancelled.")

                // Permission granted.
                (grantResults[0] == PackageManager.PERMISSION_GRANTED) -> getLastLocation()

                // Permission denied.

                // Notify the user via a SnackBar that they have rejected a core permission for the
                // app, which makes the Activity useless. In a real app, core permissions would
                // typically be best requested during a welcome-screen flow.

                // Additionally, it is important to remember that a permission might have been
                // rejected without asking the user for permission (device policy or "Never ask
                // again" prompts). Therefore, a user interface affordance is typically implemented
                // when permissions are denied. Otherwise, your app could appear unresponsive to
                // touches or interactions which have required permissions.
                else -> {
                    showSnackbar(R.string.permission_denied_explanation, R.string.settings,
                        View.OnClickListener {
                            // Build intent that displays the App settings screen.
                            val intent = Intent().apply {
                                action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                                data = Uri.fromParts("package", APPLICATION_ID, null)
                                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            }
                            startActivity(intent)
                        })
                }
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}