package com.example.spk

import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.location.Geocoder
import android.location.LocationRequest
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.spk.databinding.ActivityApplicationPageBinding
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsStatusCodes
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.IOException
import java.util.Locale

class ApplicationPage : AppCompatActivity() {
    private lateinit var binding: ActivityApplicationPageBinding
    private lateinit var locationRequest: LocationRequest
    private lateinit var databaseReference: DatabaseReference
    private lateinit var imgCamera: ImageView
    private val CAMERA_REQ_CODE =100
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApplicationPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)




        imgCamera = findViewById(R.id.usrimg)
        val btnCamera = findViewById<ImageView>(R.id.camerabtn)
        btnCamera.setOnClickListener{
            val  iCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(iCamera, CAMERA_REQ_CODE)
        }
        
        binding.regBtn.setOnClickListener{

            val loccdata: String = binding.locationpasstext.text.toString()
            val laHir: String = binding.muallahir.text.toString()
            val oKu: String = binding.oku.text.toString()
            val warGamas: String = binding.wargamas.text.toString()
            val berKawin: String = binding.berkawin.text.toString()
            val baluDalu: String = binding.baldal.text.toString()
            val dependentHealth: String = binding.dependent.text.toString()
            val familyHeadHealth: String = binding.familyhead.text.toString()
            val lainLain: String = binding.lainlain.editText?.text.toString()
            val aplicant: String = binding.applicant.editText?.text.toString()
            val icNumber: String = binding.icnumber.editText?.text.toString()
            val alamat: String = binding.alamat.editText?.text.toString()
            val perkarjaan: String = binding.perkerjaan.editText?.text.toString()
            val regPhone: String = binding.regPhoneNo.editText?.text.toString()
            val regUmur: String = binding.regUmur.editText?.text.toString()
            val regsyarikat: String = binding.regSyarikat.editText?.text.toString()
            val reggaji: String = binding.regGaji.editText?.text.toString()
            val regPhonesyarikat: String = binding.regphoneSyarikat1.editText?.text.toString()
            val isteri: String = binding.istr.editText?.text.toString()
            val ibumertug: String = binding.ibumertua.editText?.text.toString()
            val ayamertug: String = binding.ayamertua.editText?.text.toString()
            val tahun6: String = binding.tahun6.editText?.text.toString()
            val tahun7: String = binding.tahun7.editText?.text.toString()
            val tahun13: String = binding.tahun13.editText?.text.toString()
            val anakyang: String = binding.tahun13.editText?.text.toString()
            val pasangan: String = binding.tahun13.editText?.text.toString()
            val namapasangan: String = binding.namapasangan.editText?.text.toString()
            val regPhnepasang: String = binding.regPhoneNoPasangan.editText?.text.toString()
            val regUmurP: String = binding.regUmurP.editText?.text.toString()
            val rePerkerjanP: String = binding.regPEKERJAANP.editText?.text.toString()
            val regSyarikatP: String = binding.regSyarikatP.editText?.text.toString()
            val reggajiP: String = binding.regGajip.editText?.text.toString()
            val regPhoneSyarikatP: String = binding.regphoneSyarikatp.editText?.text.toString()
            val regC: String = binding.regC.editText?.text.toString()
            val regD: String = binding.regD.editText?.text.toString()
            val contactName: String = binding.applicant.editText?.text.toString()
            val contactIC: String = binding.icnumber.editText?.text.toString()
            val contactAddress: String = binding.alamat.editText?.text.toString()
            val contactAge: String = binding.regUmur.editText?.text.toString()


            databaseReference = FirebaseDatabase.getInstance().getReference("applications Data")
            databaseReference = FirebaseDatabase.getInstance().getReference("contact")


            val applicationdata = ApplicationData(loccdata,laHir,oKu,warGamas,berKawin,baluDalu,dependentHealth,familyHeadHealth,lainLain,aplicant,
                icNumber,alamat,perkarjaan,regPhone,regUmur,regsyarikat,reggaji,regPhonesyarikat,isteri,ibumertug,ayamertug,tahun6,tahun7,
                tahun13,anakyang,pasangan,namapasangan,regPhnepasang,regUmurP,rePerkerjanP,regSyarikatP,reggajiP,regPhoneSyarikatP,regC,regD)
            databaseReference.child(icNumber).setValue(applicationdata).addOnSuccessListener {

                binding.locationpasstext.text.toString()
                binding.muallahir.text.toString()
                binding.oku.text.toString()
                binding.wargamas.text.toString()
                binding.berkawin.text.toString()
                binding.baldal.text.toString()
                binding.dependent.text.toString()
                binding.familyhead.text.toString()
                binding.lainlain.editText.toString()
                binding.applicant.editText.toString()
                binding.icnumber.editText.toString()
                binding.alamat.editText.toString()
                binding.perkerjaan.editText.toString()
                binding.regPhoneNo.editText.toString()
                binding.regUmur.editText.toString()
                binding.regSyarikat.editText.toString()
                binding.regGaji.editText.toString()
                binding.regphoneSyarikat1.editText.toString()
                binding.istr.editText.toString()
                binding.ibumertua.editText.toString()
                binding.ayamertua.editText.toString()
                binding.tahun6.editText.toString()
                binding.tahun7.editText.toString()
                binding.tahun13.editText.toString()
                binding.anakyang.editText.toString()
                binding.pasangan.editText.toString()
                binding.namapasangan.editText.toString()
                binding.regPhoneNoPasangan.editText.toString()
                binding.regUmurP.editText.toString()
                binding.regPEKERJAANP.editText.toString()
                binding.regSyarikatP.editText.toString()
                binding.regGajip.editText.toString()
                binding.regphoneSyarikatp.editText.toString()
                binding.regC.editText.toString()
                binding.regD.editText.toString()

                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()

            }
            val contactData = ContactData(contactName,contactIC,contactAddress,contactAge)
            databaseReference.child(contactIC).setValue(contactData).addOnSuccessListener {

                binding.applicant.editText.toString()
                binding.icnumber.editText.toString()
                binding.alamat.editText.toString()
                binding.regUmur.editText.toString()
                Toast.makeText(this, "Saved contact", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@ApplicationPage, Testktln::class.java)
                startActivity(intent)
                finish()

            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()

            }


        }

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

        val  dataTodisplay7:
                String = intent.getStringExtra("data9") ?:"no location data"
        val textView7: TextView = findViewById(R.id.locationpasstext)
        textView7.text= dataTodisplay7

        val locationlink = findViewById<ImageView>(R.id.getlocation)
        val resetlink = findViewById<ImageView>(R.id.reset)

        locationlink.setOnClickListener{
            val intent = Intent(this, GetuserLocation::class.java)
            startActivity(intent)
        }
        resetlink.setOnClickListener{
            val intent = Intent(this, Testktln::class.java)
            startActivity(intent)
        }














    }













    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_OK) {
            val img = data?.extras?.get("data") as Bitmap
            imgCamera.setImageBitmap(img)
        }
    }

}