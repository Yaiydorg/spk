package com.example.spkadmin;

import static com.example.spkadmin.R.id.address;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ApplicationDetails extends AppCompatActivity {

    TextView name, adress, icnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_details);

        name = findViewById(R.id.name);
        adress = findViewById(R.id.adress);
        icnumber = findViewById(R.id.icnumber);

        name.setText(getIntent().getStringExtra("CName"));
        adress.setText(getIntent().getStringExtra("AAge"));
        icnumber.setText(getIntent().getStringExtra("ICNumber"));

    }
}