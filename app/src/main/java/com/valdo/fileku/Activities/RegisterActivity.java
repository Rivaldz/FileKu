package com.valdo.fileku.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.valdo.fileku.R;

import static android.text.TextUtils.isEmpty;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, email;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.usernameDaftar);
        password = findViewById(R.id.passDaftar);
        email = findViewById(R.id.emailDaftar);
        firebaseAuth = FirebaseAuth.getInstance();

        String emailString = email.getText().toString();
        String passString = password.getText().toString();
        if (!isEmpty(emailString) && !isEmpty(passString)){
            firebaseAuth.createUserWithEmailAndPassword(emailString,passString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Toast.makeText(getBaseContext(), "Selamat Registrasi anda berhasil", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
            });
        }


    }
}
