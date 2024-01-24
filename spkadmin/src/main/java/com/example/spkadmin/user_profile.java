package com.example.spkadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class user_profile extends AppCompatActivity {


    private DatabaseReference NoApplicats;

    private String applicantsIc;
    private int countapplicats = 0;
    private int countapprvals = 0;

    private TextView applicants;
    private TextView approvls;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        applicants = (TextView) findViewById(R.id.user_Label);
        approvls = (TextView) findViewById(R.id.approvals);







        NoApplicats = FirebaseDatabase.getInstance().getReference("applications Data");
    NoApplicats.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {


            if (dataSnapshot.exists())
            {
                countapplicats = (int) dataSnapshot.getChildrenCount();
                applicants.setText(Integer.toString(countapplicats)+"");

            }else {
                applicants.setText("0 Approvals");


            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });

    NoApplicats = FirebaseDatabase.getInstance().getReference("approvedApplications");
    NoApplicats.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            if (dataSnapshot.exists())
            {
                countapprvals = (int) dataSnapshot.getChildrenCount();
                approvls.setText(Integer.toString(countapprvals)+"");

            }else {
                approvls.setText("0 Approvals");


            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
    }




}