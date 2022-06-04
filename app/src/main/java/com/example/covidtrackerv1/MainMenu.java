package com.example.covidtrackerv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {

    private Button startBtn;

    // slideshow variables
    private ViewPager2 viewPager2;
    private List<Image> imageList;
    private ImageAdapter adapter;

    // allows for automatic sliding
    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // initialize start button
        startBtn = findViewById(R.id.mainStartBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configureStartButton();
            }
        }); // listener that calls next activity method

        // start of slideshow code
        viewPager2 = findViewById(R.id.viewPager2);
        imageList = new ArrayList<>();

        // ads images to list for slideshow
        imageList.add(new Image(R.drawable.covid1));
        imageList.add(new Image(R.drawable.covid2));

        adapter = new ImageAdapter(imageList, viewPager2);
        viewPager2.setAdapter(adapter);

        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);

        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer transformer = new CompositePageTransformer();

        // creates space between images in slideshow (margins)
        transformer.addTransformer(new MarginPageTransformer(40));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1- Math.abs(position);
                page.setScaleY(0.85f + r * 0.14f);
            }
        });

        viewPager2.setPageTransformer(transformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                // wait duration before switch
                sliderHandler.postDelayed(sliderRunnable, 2000);
            }
        });

    } // end onCreate method

    // when run, switches to next image (infinite slide)
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    }; // end sliderRunnable

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    } // end pause (exit from app but not closed): pauses slide

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 2000);
    } // end user comes back to app, resumes slide

    public void configureStartButton ()
    {
        Intent intent = new Intent(this, ChooseSymptoms.class);
        startActivity(intent);
    } // end start button handler (goes to next screen when start is pressed)

} // end MainMenu class
