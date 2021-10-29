package com.example.regentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class ActivitySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        new CountDownTimer(3000, 1000) {
            @Override
            public void onFinish() {
                Intent intent = new Intent(getBaseContext(), ActivityLogin.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();
    }
}