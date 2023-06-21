package com.example.netflix.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.netflix.Adapters.ViewPagerAdapter;
import com.example.netflix.R;

public class Swipe_Screen extends AppCompatActivity {
    TextView signin,help,privacy;
    Button getStarted;
    ViewPager viewPagerSwipe;
    LinearLayout sliderdots;
    public int dotcount;
    public ImageView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_screen);

        getSupportActionBar().hide();
        help=findViewById(R.id.helptextView);
        signin=findViewById(R.id.signintextView);
        privacy=findViewById(R.id.privacytextView);
        getStarted=findViewById(R.id.getStarted);
        sliderdots=findViewById(R.id.sliderdots);
        viewPagerSwipe=findViewById(R.id.viewpagerSwipescreen);

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this);
        viewPagerSwipe.setAdapter(viewPagerAdapter);

        dotcount=viewPagerAdapter.getCount();
        dots=new ImageView[dotcount];
        for(int i=0;i<dotcount;i++) {
            dots[i]= new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.inactivedots));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(4, 0, 4, 0);

            sliderdots.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.activedots));
            viewPagerSwipe.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                    for(int i=0;i<dotcount;i++){
                        dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.inactivedots));
                    }
                    dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.activedots));
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });


        help.setOnClickListener(view -> {
            Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://help.netflix.com/en/"));
            startActivity(i);
        });

        privacy.setOnClickListener(view -> {
            Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.whats-on-netflix.com/privacy-policy/"));
            startActivity(i);
        });


        getStarted.setOnClickListener(view -> {
            Intent i=new Intent(Swipe_Screen.this,StepOne.class);
            startActivity(i);
        });
        signin.setOnClickListener(view -> {
            Intent i=new Intent(Swipe_Screen.this,SignInActivity.class);
            startActivity(i);
        });


    }
}