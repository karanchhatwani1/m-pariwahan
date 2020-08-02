package com.example.android.m_pariwahan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity2 extends AppCompatActivity {
    private TextInputLayout mRegNo;
    private TextInputLayout mLicIssueDate;
    private TextInputLayout mLicValidity;
    private Button mLogin;
    private FirebaseAuth mAuth;
    private DatabaseReference mLoginDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        mRegNo = (TextInputLayout) findViewById(R.id.reg_no);
        mLicIssueDate = (TextInputLayout) findViewById(R.id.lic_issue_date);
        mLicValidity = (TextInputLayout) findViewById(R.id.lic_validity);
        mLogin = (Button) findViewById(R.id.signup_button);
        mAuth = FirebaseAuth.getInstance();

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String registeredNo = mRegNo.getEditText().getText().toString();
                String licenceIssueDate = mLicIssueDate.getEditText().getText().toString();
                String licenceValidity = mLicValidity.getEditText().getText().toString();

                if (TextUtils.isEmpty(registeredNo) || TextUtils.isEmpty(licenceIssueDate) || TextUtils.isEmpty(licenceValidity)) {
                    Toast.makeText(RegisterActivity2.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                } else {
                    register_user3(registeredNo, licenceIssueDate, licenceValidity);
                }
            }
        });
    }


    private void register_user3(final String registeredNo, String licenceIssueDate, String licenceValidity) {

        FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = current_user.getUid();

        mLoginDatabase = FirebaseDatabase.getInstance().getReference().child("Users3").child(uid);
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("vehicle_number", registeredNo);
        userMap.put("issue_date", licenceIssueDate);
        userMap.put("validity_date", licenceValidity);

        mLoginDatabase.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                    // Sign in success, update UI with the signed-in user's information
                    Intent mainIntent = new Intent(RegisterActivity2.this, MainActivity.class);
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(mainIntent);
                    finish();



                }
            }
        });

    }
}
