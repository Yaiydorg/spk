package com.example.spk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LandingPage3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page3)

        val dataTodisplay:
                String = intent.getStringExtra("data3") ?:"tidak berkaitan"


        val textView: TextView = findViewById(R.id.l3islam)
        textView.text = dataTodisplay

        val dataTodisplay2:
                String = intent.getStringExtra("data4") ?:"tidak berkaitan"


        val textView1: TextView = findViewById(R.id.bj3)
        textView1.text = dataTodisplay2


    }
}