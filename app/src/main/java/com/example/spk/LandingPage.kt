package com.example.spk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LandingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)



        val button: Button = findViewById(R.id.Muallaf)

        button.setOnClickListener {
            val intent = Intent(this, Landinjava::class.java)

            startActivity(intent)




        }
        val button2: Button = findViewById(R.id.lahirIslam)
        button2.setOnClickListener {
            val intent = Intent(this, LandingPage3::class.java)

            intent.putExtra("data2", "Lahir Islam")

            startActivity(intent)



        }

    }
}