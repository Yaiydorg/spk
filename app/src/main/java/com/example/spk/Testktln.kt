package com.example.spk

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.toColorInt
import androidx.core.view.marginEnd
import java.util.Vector

class Testktln : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testktln)


        val muallaf: ImageView  = findViewById(R.id.muallafimage)
        val muallaftext: TextView = findViewById(R.id.muallahirtext)
        val muallfslc: TextView = findViewById(R.id.muallafselect)
        val lahir: ImageView  = findViewById(R.id.lahirimage)
        val lahirtext: TextView = findViewById(R.id.muallahirtext)
        val lahirselected: TextView = findViewById(R.id.lahirselect)
        val removelahir: TextView = findViewById(R.id.lahirselect)
        val berkwin: ImageView  = findViewById(R.id.berkawinimage)
        val barkawntext: TextView = findViewById(R.id.berkawintext)
        val barkwnselect: TextView = findViewById(R.id.berkawinselect)
        val removeberkwin: TextView = findViewById(R.id.berkawinselect)
        val wargams: ImageView  = findViewById(R.id.wargamasimage)
        val wargmstxt: TextView = findViewById(R.id.wargamastext)
        val wargamaselect: TextView = findViewById(R.id.wargamasselect)
        val removewargamas: TextView = findViewById(R.id.wargamasselect)
        val ibutungl: ImageView  = findViewById(R.id.ibutingalimage)
        val ibutngaltext: TextView = findViewById(R.id.berkawintext)
        val ibutunglselect: TextView = findViewById(R.id.ibutungalselect)
        val removeibu: TextView = findViewById(R.id.ibutungalselect)
        val bapatngal: ImageView  = findViewById(R.id.bapatungalimage)
        val bapatngaltext: TextView = findViewById(R.id.berkawintext)
        val bapatngalselect: TextView = findViewById(R.id.bapatungalselect)
        val removebapa: TextView = findViewById(R.id.bapatungalselect)
        val balu: ImageView  = findViewById(R.id.baluimage)
        val balutxt: TextView = findViewById(R.id.badalutext)
        val baluslect: TextView = findViewById(R.id.baluselect)
        val remvebalu: TextView = findViewById(R.id.baluselect)
        val duda: ImageView  = findViewById(R.id.dudaimage)
        val dudatxt: TextView = findViewById(R.id.badalutext)
        val dudaselct: TextView = findViewById(R.id.dudaselect)
        val remveduda: TextView = findViewById(R.id.dudaselect)
        val oku: ImageView  = findViewById(R.id.okuimage)
        val okutxt: TextView = findViewById(R.id.okutext)
        val okuslect: TextView = findViewById(R.id.okuselect)
        val remveoku: TextView = findViewById(R.id.okuselect)
        val familyhead: ImageView  = findViewById(R.id.famhead)
        val familyheadtxt: TextView = findViewById(R.id.familyheadtext)
        val famlyheadselect: TextView = findViewById(R.id.familyhdselect)
        val remvefamilyhd: TextView = findViewById(R.id.familyhdselect)
        val dependant: ImageView  = findViewById(R.id.dependentimage)
        val dependnttext: TextView = findViewById(R.id.dependenttext)
        val dependentselect: TextView = findViewById(R.id.dependentilselect)
        val remvedependent: TextView = findViewById(R.id.dependentilselect)
        val outputText: TextView = findViewById(R.id.readstatus)
        val Add: Button = findViewById(R.id.lahirIslam)
        val mullahir: TextView = findViewById(R.id.muallahirtext)
        val baldalu: TextView = findViewById(R.id.badalutext)


        dependant.setOnClickListener {
            val Val20: String = "TANGGUNGAN KRITIKAL".toString()
            dependnttext.text = Val20
            val Val30: String = "X".toString()
            dependentselect.text = Val30
            Toast.makeText(this, "TANGGUNGAN SAKIT KRITIKAL TERPILIH", Toast.LENGTH_SHORT).show()

        }

        remvedependent.setOnClickListener{
            val Val45: String = "".toString()
            dependnttext.text = Val45
            dependentselect.text = "TANGGUNGAN SAKIT KRITIKAL"

            Toast.makeText(this, "DIBUANG TANGGUNGAN SAKIT KRITIKAL", Toast.LENGTH_SHORT).show()


        }

        familyhead.setOnClickListener {
            val Val20: String = "KETUA KELUARGA SAKIT KRITIKAL".toString()
            familyheadtxt.text = Val20
            val Val30: String = "X".toString()
            famlyheadselect.text = Val30
            Toast.makeText(this, "KETUA KELUARGA SAKIT KRITIKAL TERPILIH", Toast.LENGTH_SHORT).show()

        }

        remvefamilyhd.setOnClickListener{
            val Val45: String = "".toString()
            familyheadtxt.text = Val45
            famlyheadselect.text = Val45
            Toast.makeText(this, "Dibuang KETUA KELUARGA SAKIT KRITIKAL", Toast.LENGTH_SHORT).show()


        }

        oku.setOnClickListener {
            val Val20: String = "Oku".toString()
            okutxt.text = Val20
            val Val30: String = "X".toString()
            okuslect.text = Val30
            Toast.makeText(this, "Oku Terpilih", Toast.LENGTH_SHORT).show()

        }

        remveoku.setOnClickListener{
            val Val45: String = "".toString()
            okutxt.text = Val45
            okuslect.text = Val45
            Toast.makeText(this, "Dibuang Oku", Toast.LENGTH_SHORT).show()


        }

        duda.setOnClickListener {
            val Val20: String = "Duda".toString()
            dudatxt.text = Val20
            val Val30: String = "X".toString()
            dudaselct.text = Val30
            val Val11: String = "".toString()
            baluslect.text = Val11
            Toast.makeText(this, "Duda Terpilih", Toast.LENGTH_SHORT).show()

        }

        remveduda.setOnClickListener{
            val Val45: String = "".toString()
            dudatxt.text = Val45
            dudaselct.text = Val45
            Toast.makeText(this, "Dibuang Duda", Toast.LENGTH_SHORT).show()


        }

        balu.setOnClickListener {
            val Val20: String = "Balu".toString()
            balutxt.text = Val20
            val Val30: String = "X".toString()
            baluslect.text = Val30
            val Val11: String = "".toString()
            dudaselct.text = Val11
            barkawntext.text = Val11
            Toast.makeText(this, "Balu Terpilih", Toast.LENGTH_SHORT).show()

        }

        remvebalu.setOnClickListener{
            val Val45: String = "".toString()
            balutxt.text = Val45
            baluslect.text = Val45
            Toast.makeText(this, "Dibuang Balu", Toast.LENGTH_SHORT).show()


        }

        bapatngal.setOnClickListener {
            val Val20: String = "Bapa Tungal".toString()
            bapatngaltext.text = Val20
            val Val30: String = "X".toString()
            bapatngalselect.text = Val30
            val Val11: String = "".toString()
            ibutunglselect.text = Val11
            barkwnselect.text = Val11
            Toast.makeText(this, "Bapa Tungal Terpilih", Toast.LENGTH_SHORT).show()

        }

        removebapa.setOnClickListener{
            val Val45: String = "".toString()
            bapatngaltext.text = Val45
            bapatngalselect.text = Val45
            Toast.makeText(this, "Dibuang Bapa Tungal", Toast.LENGTH_SHORT).show()


        }

        ibutungl.setOnClickListener {
            val Val20: String = "Ibu Tungal".toString()
            ibutngaltext.text = Val20
            val Val30: String = "X".toString()
            ibutunglselect.text = Val30
            val Val11: String = "".toString()
            bapatngalselect.text = Val11
            barkwnselect.text = Val11
            Toast.makeText(this, "Ibu Tungal Terpilih", Toast.LENGTH_SHORT).show()

        }

        removeibu.setOnClickListener{
            val Val45: String = "".toString()
            ibutunglselect.text = Val45
            ibutngaltext.text = Val45
            Toast.makeText(this, "Dibuang Ibu Tungal", Toast.LENGTH_SHORT).show()


        }

        wargams.setOnClickListener {
            val Val20: String = "Wargamas".toString()
            wargmstxt.text = Val20
            val Val30: String = "X".toString()
            wargamaselect.text = Val30
            Toast.makeText(this, "Wargamas Terpilih", Toast.LENGTH_SHORT).show()

        }

        removewargamas.setOnClickListener{
            val Val45: String = "".toString()
            wargamaselect.text = Val45
            wargmstxt.text = Val45
            Toast.makeText(this, "Dibuang Wargamas", Toast.LENGTH_SHORT).show()


        }


        berkwin.setOnClickListener {
            val Val20: String = "Berkawin".toString()
            barkawntext.text = Val20
            val Val30: String = "X".toString()
            barkwnselect.text = Val30
            val Val12: String = "".toString()
            bapatngalselect.text = Val12
            ibutunglselect.text = Val12
            baldalu.text = Val12
            Toast.makeText(this, "Berkawin Terpilih", Toast.LENGTH_SHORT).show()

        }

        removeberkwin.setOnClickListener{
            val Val45: String = "".toString()
            barkwnselect.text = Val45
            barkawntext.text = Val45
            Toast.makeText(this, "Dibuang Berkawin", Toast.LENGTH_SHORT).show()


        }

        lahir.setOnClickListener {
            val Val2: String = "Lahir Islam".toString()
            lahirtext.text = Val2
            val Val3: String = "X".toString()
            lahirselected.text = Val3
            val Val0: String = "".toString()
            muallfslc.text = Val0
            Toast.makeText(this, "Muallaf Terpilih", Toast.LENGTH_SHORT).show()

        }

        removelahir.setOnClickListener{
            val Val5: String = "".toString()
            lahirselected.text = Val5
            lahirtext.text = Val5
            Toast.makeText(this, "Dibuang Muallaf", Toast.LENGTH_SHORT).show()


        }


        muallaf.setOnClickListener {
            val Val8: String = "Muallaf".toString()
            muallaftext.text = Val8
            val Val9: String = "X".toString()
            muallfslc.text = Val9
            val Val10: String = "".toString()
            lahirselected.text = Val10

            Toast.makeText(this, "Muallaf Terpilih", Toast.LENGTH_SHORT).show()

        }
        muallfslc.setOnClickListener{
            val Val12: String = "".toString()
            muallfslc.text = Val12
            muallaftext.text = Val12
            Toast.makeText(this, "Dibuang Muallaf", Toast.LENGTH_SHORT).show()


        }


        Add.setOnClickListener {
            val intent = Intent(this, GetuserLocation::class.java)
            val Val13: String = mullahir.text.toString()
            val Val14: String = barkawntext.text.toString()
            val Val15: String = baldalu.text.toString()
            val Val17: String = wargmstxt.text.toString()
            val Val18: String = okutxt.text.toString()
            val Val19: String = familyheadtxt.text.toString()
            val Val20: String = dependnttext.text.toString()


            intent.putExtra("data2", Val13)
            intent.putExtra("data3", Val14)
            intent.putExtra("data4", Val15)
            intent.putExtra("data5", Val17)
            intent.putExtra("data6", Val18)
            intent.putExtra("data7", Val19)
            intent.putExtra("data8", Val20)




            startActivity(intent)



        }



    }
}