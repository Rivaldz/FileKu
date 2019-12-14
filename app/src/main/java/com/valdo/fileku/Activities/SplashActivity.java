package com.valdo.fileku.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.valdo.fileku.MainActivity;
import com.valdo.fileku.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e) {
            setContentView(R.layout.activity_splash);
        }
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

//                getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        },1500);
        setContentView(R.layout.activity_splash);
    }
}
