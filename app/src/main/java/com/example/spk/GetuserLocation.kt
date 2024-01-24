package com.example.spk

import android.Manifest
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import com.example.spk.databinding.ActivityGetuserLocationBinding
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsStatusCodes
import java.io.IOException
import java.util.Locale

class GetuserLocation : AppCompatActivity() {
    lateinit var binding: ActivityGetuserLocationBinding
    public final lateinit var locationRequest: LocationRequest
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetuserLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val dataTodisplay:
                String =  intent.getStringExtra("data2") ?:"Tidak Berktn"
        val textview: TextView = findViewById(R.id.muallahir)
        textview.text= dataTodisplay
        val dataTodisplay1:
                String =  intent.getStringExtra("data6") ?:"Tidak Berktn"
        val textview1: TextView = findViewById(R.id.oku)
        textview1.text= dataTodisplay1
        val dataTodisplay2:
                String =  intent.getStringExtra("data5") ?:"Tidak Berktn"
        val textview2: TextView = findViewById(R.id.wargamas)
        textview2.text= dataTodisplay2

        val dataTodisplay3:
                String =  intent.getStringExtra("data3") ?:"Tidak Berktn"
        val textview3: TextView = findViewById(R.id.berkawin)
        textview3.text= dataTodisplay3

        val dataTodisplay4:
                String =  intent.getStringExtra("data4") ?:"Tidak Berktn"
        val textview4: TextView = findViewById(R.id.baldal)
        textview4.text= dataTodisplay4

        val dataTodisplay5:
                String =  intent.getStringExtra("data7") ?:"Tidak Berktn"
        val textview5: TextView = findViewById(R.id.familyhead)
        textview5.text= dataTodisplay5

        val dataTodisplay6:
                String =  intent.getStringExtra("data8") ?:"Tidak Berktn"
        val textview6: TextView = findViewById(R.id.dependent)
        textview6.text= dataTodisplay6




        val Add = findViewById<Button>(R.id.savelocation)
        val mullahir = findViewById<TextView>(R.id.muallahir)
        val barkawntext = findViewById<TextView>(R.id.berkawin)
        val baldalu = findViewById<TextView>(R.id.baldal)
        val wargmstxt = findViewById<TextView>(R.id.wargamas)
        val okutxt = findViewById<TextView>(R.id.oku)
        val familyheadtxt = findViewById<TextView>(R.id.familyhead)
        val dependnttext = findViewById<TextView>(R.id.dependent)
        val locdata = findViewById<TextView>(R.id.locationtext)


        Add.setOnClickListener {
            val intent = Intent(this, ApplicationPage::class.java)
            val Val13: String = mullahir.text.toString()
            val Val14: String = barkawntext.text.toString()
            val Val15: String = baldalu.text.toString()
            val Val17: String = wargmstxt.text.toString()
            val Val18: String = okutxt.text.toString()
            val Val19: String = familyheadtxt.text.toString()
            val Val20: String = dependnttext.text.toString()
            val Val99: String = locdata.text.toString()


            intent.putExtra("data2", Val13)
            intent.putExtra("data3", Val14)
            intent.putExtra("data4", Val15)
            intent.putExtra("data5", Val17)
            intent.putExtra("data6", Val18)
            intent.putExtra("data7", Val19)
            intent.putExtra("data8", Val20)
            intent.putExtra("data9", Val99)




            startActivity(intent)



        }



        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        binding.getLocation.setOnClickListener(){

            //step 1 is check self permission

            checkLocationPermission()



        }
    }

    private fun checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
            ){

            // when permission is already granted

            checkGPS()



        }

        else{

            //when permission is denied

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),100)
        }
    }

    private fun checkGPS() {

        locationRequest = LocationRequest.create()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 5000
        locationRequest.fastestInterval = 2000

        val builder = LocationSettingsRequest.Builder()
            .addAllLocationRequests(listOf(locationRequest))

        builder.setAlwaysShow(true)

        val result = LocationServices.getSettingsClient(
            this.applicationContext
        )

            .checkLocationSettings(builder.build())

        result.addOnCompleteListener {task->

            try {
                // when GPS is on

                val response = task.getResult(
                    ApiException::class.java
                )

                getUserLocation()

            }catch (e : ApiException){
                // When GPS is off

                e.printStackTrace()

                when(e.statusCode){

                    LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> try {

                        // here we send the request for enabling GPS

                        val resolveApiException = e as ResolvableApiException
                        resolveApiException.startResolutionForResult(this,200)


                    }catch (SendIntentException: IntentSender.SendIntentException) {

                    }
                    LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                        // when the setting is unavailable

                    }
                }
            }

        }


    }

    private fun getUserLocation() {

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationProviderClient.lastLocation.addOnCompleteListener { task ->

            val location = task.getResult()

            if (location != null){

                try {

                    val geocoder = Geocoder(this, Locale.getDefault())

                    val address = geocoder.getFromLocation(location.latitude, location.longitude, 1)

                    // here we set the address in text view

                    val  address_line = address?.get(0)?.getAddressLine(0)
                    binding.locationtext.setText(address_line)

                    val address_location = address?.get(0)?.getAddressLine(0)

                    openLocation(address_line.toString())

                }catch (e: IOException){

                }
            }

        }

    }

    private fun openLocation(location: String) {

        // here we open this location in google map



        //lets set on button click
        binding.locationtext.setOnClickListener(){
            if(binding.locationtext.text.isEmpty()){
                //when the location is not empty


            }
            val uri = Uri.parse("geo:0, 0?q=$location")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }




    }


}




