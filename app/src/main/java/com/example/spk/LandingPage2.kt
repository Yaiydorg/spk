package com.example.spk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LandingPage2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page2)



        val dataTodisplay:
                String = intent.getStringExtra("data2") ?:"No Data"


        val textView: TextView = findViewById(R.id.dt)
        textView.text = dataTodisplay


        val button: Button = findViewById(R.id.bERKAWIN)




        button.setOnClickListener {



            val intent = Intent(this, LandingPage3::class.java)

            intent.putExtra("data3", "Muallaf")
            intent.putExtra("data4","Berkawin")



            startActivity(intent)




        }
        val button2: Button = findViewById(R.id.bUJANG)
        button2.setOnClickListener {
            val intent = Intent(this, LandingPage::class.java)




            intent.putExtra("data3", "Muallaf")
            intent.putExtra("data3", "BUJANG")

            startActivity(intent)


        }


    }

}