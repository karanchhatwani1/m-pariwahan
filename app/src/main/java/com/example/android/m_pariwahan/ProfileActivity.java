package com.example.android.m_pariwahan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.android.m_pariwahan.R.string.*;

public class ProfileActivity extends AppCompatActivity {

    private String pName,pReg,D,F;
    private TextView dName,dReg,dSInsurance,dEInsurance,dSFitness,dEFitness,dInfo;
    private DatabaseReference mName;
    private Button searchMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        getSupportActionBar().hide();

        pName = getIntent().getExtras().get("visit_user_name").toString();
        pReg = getIntent().getExtras().get("visit_user_reg").toString();
        mName = FirebaseDatabase.getInstance().getReference();

        dName = (TextView) findViewById(R.id.dname);
        dReg = (TextView) findViewById(R.id.dreg);
        dSInsurance = (TextView) findViewById(R.id.dsinsurence);
        dEInsurance = (TextView) findViewById(R.id.deinsurance);
        dSFitness = (TextView) findViewById(R.id.dsfitness);
        dEFitness = (TextView) findViewById(R.id.defitness);
        dInfo = (TextView) findViewById(R.id.Info);
        searchMore = (Button) findViewById(R.id.smore);

        searchMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(startIntent);
                finish();
            }
        });

        if(TextUtils.isEmpty(pReg)) {

            dName.setText(pName);
            mName.child(pName).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String userReg = snapshot.child("reg1").getValue().toString();
                        String usInsurance = snapshot.child("is1").getValue().toString();
                        String ueInsurance = snapshot.child("ie1").getValue().toString();
                        String usFitness = snapshot.child("fs1").getValue().toString();
                        String ueFitness = snapshot.child("fe1").getValue().toString();
                        String userInfo = snapshot.child("info").getValue().toString();

                        dReg.setText(userReg);
                        dSInsurance.setText(usInsurance);
                        dEInsurance.setText(ueInsurance);
                        dSFitness.setText(usFitness);
                        dEFitness.setText(ueFitness);
                        dInfo.setText(userInfo);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else if(TextUtils.isEmpty(pName)){
            dName.setText(pReg);
            mName.child(pReg).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String userReg = snapshot.child("reg1").getValue().toString();
                        String usInsurance = snapshot.child("is1").getValue().toString();
                        String ueInsurance = snapshot.child("ie1").getValue().toString();
                        String usFitness = snapshot.child("fs1").getValue().toString();
                        String ueFitness = snapshot.child("fe1").getValue().toString();
                        String userInfo = snapshot.child("info").getValue().toString();

                        dReg.setText(userReg);
                        dSInsurance.setText(usInsurance);
                        dEInsurance.setText(ueInsurance);
                        dSFitness.setText(usFitness);
                        dEFitness.setText(ueFitness);
                        dInfo.setText(userInfo);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else {
            dName.setText(pName);
            mName.child(pName).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String userReg = snapshot.child("reg1").getValue().toString();
                        String usInsurance = snapshot.child("is1").getValue().toString();
                        String ueInsurance = snapshot.child("ie1").getValue().toString();
                        String usFitness = snapshot.child("fs1").getValue().toString();
                        String ueFitness = snapshot.child("fe1").getValue().toString();
                        String userInfo = snapshot.child("info").getValue().toString();

                        dReg.setText(userReg);
                        dSInsurance.setText(usInsurance);
                        dEInsurance.setText(ueInsurance);
                        dSFitness.setText(usFitness);
                        dEFitness.setText(ueFitness);
                        dInfo.setText(userInfo);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

    }
}
