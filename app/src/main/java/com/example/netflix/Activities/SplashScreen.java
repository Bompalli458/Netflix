package com.example.netflix.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.netflix.R;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;


@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    ProgressBar progressBar;
static int counter=0;
static int duration=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Objects.requireNonNull(getSupportActionBar()).hide();
        progressBar=findViewById(R.id.progressbar);
        progress();
        start();
    }
    public void progress() {
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBar.setProgress(counter);
                if (counter == 5000) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask, 0, 100);
    }
        public void start(){
            new Handler().postDelayed(() -> {
                startActivity(new Intent(SplashScreen.this,SignInActivity.class));
                finish();
            },duration);

    }
}