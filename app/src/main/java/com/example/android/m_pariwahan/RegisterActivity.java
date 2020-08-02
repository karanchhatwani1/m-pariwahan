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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout mName;
    private TextInputLayout mAddress;
    private TextInputLayout mDOB;
    private Button mNext;
    private FirebaseAuth mAuth;
    private DatabaseReference mUserDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mName = (TextInputLayout) findViewById(R.id.user_name);
        mAddress = (TextInputLayout) findViewById(R.id.user_address);
        mDOB = (TextInputLayout) findViewById(R.id.user_dob);
        mNext = (Button) findViewById(R.id.next1);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getEditText().getText().toString();
                String address = mAddress.getEditText().getText().toString();
                String dob = mDOB.getEditText().getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(address) || TextUtils.isEmpty(dob)) {
                    Toast.makeText(RegisterActivity.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                } else {
                    register_user(name, address, dob);
                }
            }
        });

    }
    private void register_user(final String name, String address, String dob) {

        FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = current_user.getUid();

        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("name", name);
        userMap.put("address", address);
        userMap.put("dob", dob);

        mUserDatabase.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                    // Sign in success, update UI with the signed-in user's information
                    Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(mainIntent);
                    finish();



                }
            }
        });

    }
}
