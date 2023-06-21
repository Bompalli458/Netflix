package com.example.netflix.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.netflix.R;

public class StepOne extends AppCompatActivity {

    TextView signintext,textView;
    Button seeyourPlansbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one);
        getSupportActionBar().hide();
        signintext = findViewById(R.id.signinStepOne);
        textView=findViewById(R.id.step1of3);
        seeyourPlansbutton = findViewById(R.id.see_your_plans_button);
        signintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StepOne.this, SignInActivity.class);
                startActivity(i);
            }
        });
        seeyourPlansbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StepOne.this, ChooseYourPlan.class);
                startActivity(i);
            }
        });
        SpannableString spannable=new SpannableString("Step 1 of 3") ;
        StyleSpan sp1=new StyleSpan(Typeface.BOLD);
        StyleSpan sp2=new StyleSpan(Typeface.BOLD);
        spannable.setSpan(sp1,5,6,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(sp2,10,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannable);
    }
}