package com.example.spk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Landinjava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landinjava);

        final TextView Berkawin = findViewById(R.id.test);
        final TextView Lahir = findViewById(R.id.test2);
        final TextView outputText = findViewById(R.id.readstatus);
        final TextView outputText2 = findViewById(R.id.output);
        Button Add = findViewById(R.id.lahirIslam);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Value = Berkawin.getText().toString();
                outputText.setText(Value);

            }
        });

    }

}