package com.example.spkadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button callSignUp, login_btn;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        callSignUp = findViewById(R.id.signup_screen);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);

            }
        });
    }

    private Boolean validateUserName() {

        String val = username.getEditText().getText().toString();

        if (val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;

        } else if (val.length() >= 15) {
            username.setError("Username too long");
            return false;

        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validatePassword() {

        String val = password.getEditText().getText().toString();


        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;


        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }

    }

    public void loginUser(View view) {

        //Validate Login Info
        if (!validateUserName() | !validatePassword()) {
            return;
        } else {
            isUser();
        }
    }

    private void isUser() {
        String userEnteredUsername = username.getEditText().toString().trim();
        String userEnteredPassword = password.getEditText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users1");

        Query checkUser = reference.orderByChild("username").equalTo(userEnteredPassword);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    username.setError(null);
                    username.setErrorEnabled(false);
                }
                String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);

                if (passwordFromDB.equals(userEnteredPassword)) {

                    String namedFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                    String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                    String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                    String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);

                    Intent intent = new Intent(getApplicationContext(), user_profile.class);

                    intent.putExtra("name", namedFromDB);
                    intent.putExtra("username", usernameFromDB);
                    intent.putExtra("email", emailFromDB);
                    intent.putExtra("phone", phoneNoFromDB);
                    intent.putExtra("password", passwordFromDB);

                    startActivity(intent);


                }   else {
                    password.setError("Wrong User Name or Password");
                    password.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}