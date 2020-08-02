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

public class RegisterActivity3 extends AppCompatActivity {
    private TextInputLayout mEmail;
    private TextInputLayout mPassword;
    private Button mNext2;
    private DatabaseReference mEnrollDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);

        mEmail = (TextInputLayout) findViewById(R.id.user_email);
        mPassword = (TextInputLayout) findViewById(R.id.user_password);
        mNext2 = (Button) findViewById(R.id.next2);
        mAuth = FirebaseAuth.getInstance();
        mNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getEditText().getText().toString();
                String password = mPassword.getEditText().getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity3.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                } else {
                    register_user2(email, password);
                }
            }
        });
    }
    private void register_user2(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();
                            String uid = current_user.getUid();

                            mEnrollDatabase = FirebaseDatabase.getInstance().getReference().child("Users2").child(uid);
                            HashMap<String, String> userMap = new HashMap<>();
                            userMap.put("user", "Successfully added");

                            mEnrollDatabase.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Intent mainIntent = new Intent(RegisterActivity3.this, RegisterActivity.class);
                                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }
                    });
                }
    }





