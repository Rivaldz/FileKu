package com.valdo.fileku.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.valdo.fileku.Fragments.UploadFragment;
import com.valdo.fileku.MainActivity;
import com.valdo.fileku.R;
import com.valdo.fileku.models.UploadModel;

public class LoginActivity extends AppCompatActivity {
    private TextView daftar;
    private EditText email, pass;
    private Button loginBut;
    private FirebaseAuth firebaseAuth;

    public String emailUsername = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        daftar = findViewById(R.id.registerLoginView);
        email = findViewById(R.id.emailLogin);
        pass = findViewById(R.id.passLogin);
        loginBut = findViewById(R.id.buttonLogin);
        firebaseAuth = FirebaseAuth.getInstance();


        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = new MainActivity();
                mainActivity.usernameUpload = email.getText().toString();
                loginFirebase();
            }
        });
    }

    private void loginFirebase(){
        String emailSt = email.getText().toString();
        String passSt = pass.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(emailSt, passSt).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Toast.makeText(LoginActivity.this, "Selamat Login Berhasil", Toast.LENGTH_LONG).show();
                }
                else {

                    Toast.makeText(LoginActivity.this, "Gagal Login Cek Username dan Password", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
