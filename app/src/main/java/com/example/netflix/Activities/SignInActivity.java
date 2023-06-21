package com.example.netflix.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.netflix.MainScreen.Main_Screen;
import com.example.netflix.R;

import java.util.Timer;
import java.util.TimerTask;

public class SignInActivity extends AppCompatActivity {

    TextView newregisterTextview,forgotpasswordTextview;
    Button signinButton;
    ProgressBar progressBarSignin;
  static int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
        newregisterTextview=findViewById(R.id.newRegistertextview);
        forgotpasswordTextview=findViewById(R.id.forgotpasswordtextview);
        signinButton=findViewById(R.id.signinButton);
        progressBarSignin=findViewById(R.id.progressbarSignin);
        progressBarSignin.setVisibility(View.GONE);
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignInActivity.this, Main_Screen.class);
                startActivity(i);
            }
        });
        newregisterTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignInActivity.this, Swipe_Screen.class);
                startActivity(i);
                finish();
            }
        });
        forgotpasswordTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignInActivity.this, "password reseted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void progress() {
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBarSignin.setProgress(counter);
                if (counter == 5000) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask, 0, 100);
    }
}