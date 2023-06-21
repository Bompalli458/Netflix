package com.example.netflix.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.netflix.R;

public class ViewPagerAdapter extends PagerAdapter {

    private final Context context;
    private final Integer[] images={R.drawable.netflixhome1,R.drawable.netflixhome2,R.drawable.netflixhome3};
LayoutInflater layoutInflater;
    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
         layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         View view= layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView= view.findViewById(R.id.imageviewCustomLayout);
        imageView.setImageResource(images[position]);
        ViewPager viewpager=(ViewPager)container;
        viewpager.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager=(ViewPager)container;
        View view=(View) object;
        viewPager.removeView(view);
    }
}
