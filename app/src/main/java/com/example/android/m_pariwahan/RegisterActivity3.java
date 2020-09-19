package com.example.android.m_pariwahan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
    private TextInputLayout mPassword,mConfirmPass;
    private Button mNext2;
    private DatabaseReference mEnrollDatabase,mN1Database,mN2Database,mN3Database,mN4Database,mN5Database
            ,mN6Database,mN7Database,mN8Database,mN9Database,mN10Database,mN11Database,mN12Database,mN13Database,mN14Database,mN15Database,mN16Database,mN17Database,mN22Database,mN21Database,mN20Database,mN19Database,mN18Database
            ,mN23Database,mN24Database,mN25Database,mN26Database,mN27Database,mN28Database,mN29Database,mN30Database,mN31Database,mN32Database,mN33Database,mN34Database;
    private FirebaseAuth mAuth;
    private ProgressDialog mRegProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);
        mRegProgress = new ProgressDialog(this);


        mEmail = (TextInputLayout) findViewById(R.id.user_email);
        mPassword = (TextInputLayout) findViewById(R.id.user_password);
        mConfirmPass = (TextInputLayout) findViewById(R.id.confirm_password);

        mNext2 = (Button) findViewById(R.id.next2);
        mAuth = FirebaseAuth.getInstance();
        mNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getEditText().getText().toString();
                String password = mPassword.getEditText().getText().toString();
                String confirmPassword = mConfirmPass.getEditText().getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(RegisterActivity3.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                } else {
                    mRegProgress.setTitle("Registering");
                    mRegProgress.setMessage("Please wait");
                    mRegProgress.setCanceledOnTouchOutside(false);
                    mRegProgress.show();

                    register_user3(email, password);
                }
            }
        });
    }
    private void register_user3(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                            String uid = mFirebaseUser.getUid();

                            mEnrollDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
                            HashMap<String, String> userMap = new HashMap<>();
                            userMap.put("user", "Successfully added");


                            mEnrollDatabase.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                            mN1Database = FirebaseDatabase.getInstance().getReference().child("Dharendra Yogi");
                            HashMap<String, String> userMap1 = new HashMap<>();
                            userMap1.put("reg1" , "  RJ 09GB 0677  ");
                            userMap1.put("is1" , "  31/8/2020  ");
                            userMap1.put("ie1" , "  30/12/2020  ");
                            userMap1.put("fs1" , "  31/8/2020  ");
                            userMap1.put("fe1","  28/2/2021  ");
                            userMap1.put("info" , "Information of Required User");

                            mN1Database.setValue(userMap1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN2Database = FirebaseDatabase.getInstance().getReference().child("Anil Kumar");
                            HashMap<String, String> userMap2 = new HashMap<>();
                            userMap2.put("reg1" , "RJ 09GB 0677");
                            userMap2.put("is1" , "31/8/2020");
                            userMap2.put("ie1" , "30/12/2020");
                            userMap2.put("fs1" , "31/8/2020");
                            userMap2.put("fe1","28/2/2021");
                            userMap2.put("info" , "Information of Required User");

                            mN2Database.setValue(userMap2).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN3Database = FirebaseDatabase.getInstance().getReference().child("Faruk");
                            HashMap<String, String> userMap3 = new HashMap<>();
                            userMap3.put("reg1" , "RJ 14GD 2534");
                            userMap3.put("is1" , "31/8/2020");
                            userMap3.put("ie1" , "30/12/2020");
                            userMap3.put("fs1" , "31/8/2020");
                            userMap3.put("fe1","28/2/2021");
                            userMap3.put("info" , "Information of Required User");

                            mN3Database.setValue(userMap3).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN4Database = FirebaseDatabase.getInstance().getReference().child("Firoz Khan");
                            HashMap<String, String> userMap4 = new HashMap<>();
                            userMap4.put("reg1" , "RJ 14GD 2534");
                            userMap4.put("is1" , "31/8/2020");
                            userMap4.put("ie1" , "30/12/2020");
                            userMap4.put("fs1" , "31/8/2020");
                            userMap4.put("fe1","28/2/2021");
                            userMap4.put("info" , "Information of Required User");

                            mN4Database.setValue(userMap4).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN5Database = FirebaseDatabase.getInstance().getReference().child("Raees Khan");
                            HashMap<String, String> userMap5 = new HashMap<>();
                            userMap5.put("reg1" , "RJ 14GD 2538");
                            userMap5.put("is1" , "31/8/2020");
                            userMap5.put("ie1" , "30/8/2021");
                            userMap5.put("fs1" , "31/8/2020");
                            userMap5.put("fe1" , "30/11/2021");
                            userMap5.put("info" , "Information of Required User");

                            mN5Database.setValue(userMap5).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN6Database = FirebaseDatabase.getInstance().getReference().child("Iqbal Ali");
                            HashMap<String, String> userMap6 = new HashMap<>();
                            userMap6.put("reg1" , "RJ 14GD 2538");
                            userMap6.put("is1" , "31/8/2020");
                            userMap6.put("ie1" , "30/8/2021");
                            userMap6.put("fs1" , "31/8/2020");
                            userMap6.put("fe1" , "30/11/2021");
                            userMap6.put("info" , "Information of Required User");

                            mN6Database.setValue(userMap6).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN7Database = FirebaseDatabase.getInstance().getReference().child("Ram Singh");
                            HashMap<String, String> userMap7 = new HashMap<>();
                            userMap7.put("reg1" , "RJ 14GD 4211");
                            userMap7.put("is1" , "31/8/2020");
                            userMap7.put("ie1" , "30/8/2021");
                            userMap7.put("fs1" , "31/8/2020");
                            userMap7.put("fe1" , "28/2/2021");
                            userMap7.put("info" , "Information of Required User");

                            mN7Database.setValue(userMap7).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                            mN8Database = FirebaseDatabase.getInstance().getReference().child("Irfan Khan");
                            HashMap<String, String> userMap8 = new HashMap<>();
                            userMap8.put("reg1" , "RJ 14GD 4211");
                            userMap8.put("is1" , "31/8/2020");
                            userMap8.put("ie1" , "30/8/2021");
                            userMap8.put("fs1" , "31/8/2020");
                            userMap8.put("fe1" , "28/2/2021");
                            userMap8.put("info" , "Information of Required User");

                            mN8Database.setValue(userMap8).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN9Database = FirebaseDatabase.getInstance().getReference().child("Ram Niwas");
                            HashMap<String, String> userMap9 = new HashMap<>();
                            userMap9.put("reg1" , "RJ 14GD 4212");
                            userMap9.put("is1" , "31/8/2020");
                            userMap9.put("ie1" , "30/8/2021");
                            userMap9.put("fs1" , "31/8/2020");
                            userMap9.put("fe1" , "28/2/2021");
                            userMap9.put("info" , "Information of Required User");

                            mN9Database.setValue(userMap9).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            mN10Database = FirebaseDatabase.getInstance().getReference().child("Deepak Shah");
                            HashMap<String, String> userMap10 = new HashMap<>();
                            userMap10.put("reg1" , "RJ 14GD 4212");
                            userMap10.put("is1" , "31/8/2020");
                            userMap10.put("ie1" , "30/8/2021");
                            userMap10.put("fs1" , "31/8/2020");
                            userMap10.put("fe1" , "28/2/2021");
                            userMap10.put("info" , "Information of Required User");

                            mN10Database.setValue(userMap10).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                            mN11Database = FirebaseDatabase.getInstance().getReference().child("Mohd Khan");
                            HashMap<String, String> userMap11 = new HashMap<>();
                            userMap11.put("reg1" , "RJ 14GD 4264");
                            userMap11.put("is1" , "31/8/2020");
                            userMap11.put("ie1" , "30/8/2021");
                            userMap11.put("fs1" , "31/8/2020");
                            userMap11.put("fe1" , "30/11/2021");
                            userMap11.put("info" , "Information of Required User");

                            mN11Database.setValue(userMap11).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                            mN12Database = FirebaseDatabase.getInstance().getReference().child("Hari Lal");
                            HashMap<String, String> userMap12 = new HashMap<>();
                            userMap12.put("reg1" , "RJ 14GD 4264");
                            userMap12.put("is1" , "31/8/2020");
                            userMap12.put("ie1" , "30/8/2021");
                            userMap12.put("fs1" , "31/8/2020");
                            userMap12.put("fe1" , "30/11/2021");
                            userMap12.put("info" , "Information of Required User");

                            mN12Database.setValue(userMap12).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            mN13Database = FirebaseDatabase.getInstance().getReference().child("Charan Gurjar");
                            HashMap<String, String> userMap13 = new HashMap<>();
                            userMap13.put("reg1" , "RJ 14GD 4266");
                            userMap13.put("is1" , "31/8/2020");
                            userMap13.put("ie1" , "30/12/2020");
                            userMap13.put("fs1" , "31/8/2020");
                            userMap13.put("fe1" , "30/11/2021");
                            userMap13.put("info" , "Information of Required User");

                            mN13Database.setValue(userMap13).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            mN14Database = FirebaseDatabase.getInstance().getReference().child("Hariram");
                            HashMap<String, String> userMap14 = new HashMap<>();
                            userMap14.put("reg1" , "RJ 14GD 4266");
                            userMap14.put("is1" , "31/8/2020");
                            userMap14.put("ie1" , "30/12/2020");
                            userMap14.put("fs1" , "31/8/2020");
                            userMap14.put("fe1","30/11/2021");
                            userMap14.put("info" , "Information of Required User");

                            mN14Database.setValue(userMap14).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN15Database = FirebaseDatabase.getInstance().getReference().child("Banwari Lal");
                            HashMap<String, String> userMap15 = new HashMap<>();
                            userMap15.put("reg1" , "RJ 14GD 4268");
                            userMap15.put("is1" , "31/8/2020");
                            userMap15.put("ie1" , "30/8/2021");
                            userMap15.put("fs1" , "31/8/2020");
                            userMap15.put("fe1","29/2/2021");
                            userMap15.put("info" , "Information of Required User");

                            mN15Database.setValue(userMap15).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                            mN16Database = FirebaseDatabase.getInstance().getReference().child("Aslam Khan");
                            HashMap<String, String> userMap16 = new HashMap<>();
                            userMap16.put("reg1" , "RJ 14GD 4268");
                            userMap16.put("is1" , "31/8/2020");
                            userMap16.put("ie1" , "30/8/2021");
                            userMap16.put("fs1" , "31/8/2020");
                            userMap16.put("fe1","29/2/2021");
                            userMap16.put("info" , "Information of Required User");

                            mN16Database.setValue(userMap16).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            mN17Database = FirebaseDatabase.getInstance().getReference().child("Munit Khan");
                            HashMap<String, String> userMap17 = new HashMap<>();
                            userMap17.put("reg1" , "RJ 14GD 4270");
                            userMap17.put("is1" , "31/8/2020");
                            userMap17.put("ie1" , "30/12/2020");
                            userMap17.put("fs1" , "31/8/2020");
                            userMap17.put("fe1" , "28/2/2021");
                            userMap17.put("info" , "Information of Required User");

                            mN17Database.setValue(userMap17).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN34Database = FirebaseDatabase.getInstance().getReference().child("Dharendra yogi");
                            HashMap<String, String> userMap34 = new HashMap<>();
                            userMap34.put("reg1" , "RJ 09GB 0677");
                            userMap34.put("is1" , "31/8/2020");
                            userMap34.put("ie1" , "30/12/2020");
                            userMap34.put("fs1" , "31/8/2020");
                            userMap34.put("fe1","28/2/2021");
                            userMap34.put("info" , "Information of Required User");

                            mN34Database.setValue(userMap34).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN33Database = FirebaseDatabase.getInstance().getReference().child("Anil kumar");
                            HashMap<String, String> userMap33 = new HashMap<>();
                            userMap33.put("reg1" , "RJ 09GB 0677");
                            userMap33.put("is1" , "31/8/2020");
                            userMap33.put("ie1" , "30/12/2020");
                            userMap33.put("fs1" , "31/8/2020");
                            userMap33.put("fe1","28/2/2021");
                            userMap33.put("info" , "Information of Required User");

                            mN33Database.setValue(userMap33).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN32Database = FirebaseDatabase.getInstance().getReference().child("faruk");
                            HashMap<String, String> userMap32 = new HashMap<>();
                            userMap32.put("reg1" , "RJ 14GD 2534");
                            userMap32.put("is1" , "31/8/2020");
                            userMap32.put("ie1" , "30/12/2020");
                            userMap32.put("fs1" , "31/8/2020");
                            userMap32.put("fe1","28/2/2021");
                            userMap32.put("info" , "Information of Required User");

                            mN32Database.setValue(userMap32).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN31Database = FirebaseDatabase.getInstance().getReference().child("Firoz khan");
                            HashMap<String, String> userMap31 = new HashMap<>();
                            userMap31.put("reg1" , "RJ 14GD 2534");
                            userMap31.put("is1" , "31/8/2020");
                            userMap31.put("ie1" , "30/12/2020");
                            userMap31.put("fs1" , "31/8/2020");
                            userMap31.put("fe1","28/2/2021");
                            userMap31.put("info" , "Information of Required User");

                            mN31Database.setValue(userMap31).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN30Database = FirebaseDatabase.getInstance().getReference().child("Raees khan");
                            HashMap<String, String> userMap30 = new HashMap<>();
                            userMap30.put("reg1" , "RJ 14GD 2538");
                            userMap30.put("is1" , "31/8/2020");
                            userMap30.put("ie1" , "30/8/2021");
                            userMap30.put("fs1" , "31/8/2020");
                            userMap30.put("fe1" , "30/11/2021");
                            userMap30.put("info" , "Information of Required User");

                            mN30Database.setValue(userMap30).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN29Database = FirebaseDatabase.getInstance().getReference().child("Iqbal ali");
                            HashMap<String, String> userMap29 = new HashMap<>();
                            userMap29.put("reg1" , "RJ 14GD 2538");
                            userMap29.put("is1" , "31/8/2020");
                            userMap29.put("ie1" , "30/8/2021");
                            userMap29.put("fs1" , "31/8/2020");
                            userMap29.put("fe1" , "30/11/2021");
                            userMap29.put("info" , "Information of Required User");

                            mN29Database.setValue(userMap29).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN28Database = FirebaseDatabase.getInstance().getReference().child("Ram singh");
                            HashMap<String, String> userMap28 = new HashMap<>();
                            userMap28.put("reg1" , "RJ 14GD 4211");
                            userMap28.put("is1" , "31/8/2020");
                            userMap28.put("ie1" , "30/8/2021");
                            userMap28.put("fs1" , "31/8/2020");
                            userMap28.put("fe1" , "28/2/2021");
                            userMap28.put("info" , "Information of Required User");

                            mN28Database.setValue(userMap28).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                            mN27Database = FirebaseDatabase.getInstance().getReference().child("Irfan khan");
                            HashMap<String, String> userMap27 = new HashMap<>();
                            userMap27.put("reg1" , "RJ 14GD 4211");
                            userMap27.put("is1" , "31/8/2020");
                            userMap27.put("ie1" , "30/8/2021");
                            userMap27.put("fs1" , "31/8/2020");
                            userMap27.put("fe1" , "28/2/2021");
                            userMap27.put("info" , "Information of Required User");

                            mN27Database.setValue(userMap27).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN26Database = FirebaseDatabase.getInstance().getReference().child("Ram niwas");
                            HashMap<String, String> userMap26 = new HashMap<>();
                            userMap26.put("reg1" , "RJ 14GD 4212");
                            userMap26.put("is1" , "31/8/2020");
                            userMap26.put("ie1" , "30/8/2021");
                            userMap26.put("fs1" , "31/8/2020");
                            userMap26.put("fe1" , "28/2/2021");
                            userMap26.put("info" , "Information of Required User");

                            mN26Database.setValue(userMap26).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            mN25Database = FirebaseDatabase.getInstance().getReference().child("Deepak shah");
                            HashMap<String, String> userMap25 = new HashMap<>();
                            userMap25.put("reg1" , "RJ 14GD 4212");
                            userMap25.put("is1" , "31/8/2020");
                            userMap25.put("ie1" , "30/8/2021");
                            userMap25.put("fs1" , "31/8/2020");
                            userMap25.put("fe1" , "28/2/2021");
                            userMap25.put("info" , "Information of Required User");

                            mN25Database.setValue(userMap25).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                            mN24Database = FirebaseDatabase.getInstance().getReference().child("Mohd khan");
                            HashMap<String, String> userMap24 = new HashMap<>();
                            userMap24.put("reg1" , "RJ 14GD 4264");
                            userMap24.put("is1" , "31/8/2020");
                            userMap24.put("ie1" , "30/8/2021");
                            userMap24.put("fs1" , "31/8/2020");
                            userMap24.put("fe1" , "30/11/2021");
                            userMap24.put("info" , "Information of Required User");

                            mN24Database.setValue(userMap24).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                            mN23Database = FirebaseDatabase.getInstance().getReference().child("Hari lal");
                            HashMap<String, String> userMap23 = new HashMap<>();
                            userMap23.put("reg1" , "RJ 14GD 4264");
                            userMap23.put("is1" , "31/8/2020");
                            userMap23.put("ie1" , "30/8/2021");
                            userMap23.put("fs1" , "31/8/2020");
                            userMap23.put("fe1" , "30/11/2021");
                            userMap23.put("info" , "Information of Required User");

                            mN23Database.setValue(userMap23).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            mN22Database = FirebaseDatabase.getInstance().getReference().child("Charan gurjar");
                            HashMap<String, String> userMap22 = new HashMap<>();
                            userMap22.put("reg1" , "RJ 14GD 4266");
                            userMap22.put("is1" , "31/8/2020");
                            userMap22.put("ie1" , "30/12/2020");
                            userMap22.put("fs1" , "31/8/2020");
                            userMap22.put("fe1" , "30/11/2021");
                            userMap22.put("info" , "Information of Required User");

                            mN22Database.setValue(userMap22).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            mN21Database = FirebaseDatabase.getInstance().getReference().child("hariram");
                            HashMap<String, String> userMap21 = new HashMap<>();
                            userMap21.put("reg1" , "RJ 14GD 4266");
                            userMap21.put("is1" , "31/8/2020");
                            userMap21.put("ie1" , "30/12/2020");
                            userMap21.put("fs1" , "31/8/2020");
                            userMap21.put("fe1","30/11/2021");
                            userMap21.put("info" , "Information of Required User");

                            mN21Database.setValue(userMap21).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            mN20Database = FirebaseDatabase.getInstance().getReference().child("Banwari lal");
                            HashMap<String, String> userMap20 = new HashMap<>();
                            userMap20.put("reg1" , "RJ 14GD 4268");
                            userMap20.put("is1" , "31/8/2020");
                            userMap20.put("ie1" , "30/8/2021");
                            userMap20.put("fs1" , "31/8/2020");
                            userMap20.put("fe1","29/2/2021");
                            userMap20.put("info" , "Information of Required User");

                            mN20Database.setValue(userMap20).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                            mN19Database = FirebaseDatabase.getInstance().getReference().child("Aslam khan");
                            HashMap<String, String> userMap19 = new HashMap<>();
                            userMap19.put("reg1" , "RJ 14GD 4268");
                            userMap19.put("is1" , "31/8/2020");
                            userMap19.put("ie1" , "30/8/2021");
                            userMap19.put("fs1" , "31/8/2020");
                            userMap19.put("fe1","29/2/2021");
                            userMap19.put("info" , "Information of Required User");

                            mN19Database.setValue(userMap19).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            mN18Database = FirebaseDatabase.getInstance().getReference().child("Munit khan");
                            HashMap<String, String> userMap18 = new HashMap<>();
                            userMap18.put("reg1" , "RJ 14GD 4270");
                            userMap18.put("is1" , "31/8/2020");
                            userMap18.put("ie1" , "30/12/2020");
                            userMap18.put("fs1" , "31/8/2020");
                            userMap18.put("fe1" , "28/2/2021");
                            userMap18.put("info" , "Information of Required User");

                            mN18Database.setValue(userMap18).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        mRegProgress.dismiss();
                                        Intent mainIntent = new Intent(RegisterActivity3.this, MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else{
                                        mRegProgress.hide();
                                        Toast.makeText(RegisterActivity3.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });




                        }
                    }
                    });
                }
    }





