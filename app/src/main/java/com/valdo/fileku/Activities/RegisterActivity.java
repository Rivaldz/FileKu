package com.valdo.fileku.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.valdo.fileku.R;
import com.valdo.fileku.models.RegisterModel;

import static android.text.TextUtils.isEmpty;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, email;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Button regiterBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.usernameDaftar);
        password = findViewById(R.id.passDaftar);
        email = findViewById(R.id.emailDaftar);
        regiterBut = findViewById(R.id.buttonDaftar);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("users");



        regiterBut.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                final String emailString = email.getText().toString();
                final String passString = password.getText().toString();
                if (!isEmpty(emailString) && !isEmpty(passString)){
                    regiterMethod();

                }

            }
        });


    }
    private void regiterMethod(){
        final String emailString = email.getText().toString();
        final String passString = password.getText().toString();
        final String usernameString = username.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(emailString,passString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getBaseContext(), "Selamat Registrasi anda berhasil", Toast.LENGTH_LONG).show();
                    RegisterModel registerModel = new RegisterModel(usernameString, emailString,passString);
                    databaseReference.child(usernameString).setValue(registerModel);
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
                else {

                    Toast.makeText(getBaseContext(), "Registrasi Anda Gagal Silahkan Isi atau cek kolom yang ada", Toast.LENGTH_LONG).show();
                }

            }

        });




    }
}
