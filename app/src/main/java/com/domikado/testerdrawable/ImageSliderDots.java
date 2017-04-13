package com.domikado.testerdrawable;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class ImageSliderDots extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;

    private static final Integer[] imageNya= {R.drawable.devi1,R.drawable.devi2, R.drawable.irrr};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();

    private AdapterImageSliderDots adapteraasss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slider_dots);

        init();
    }

    private void init(){
        for (int i= 0; i< imageNya.length; i++){
            XMENArray.add(imageNya[i]);
        }

        mPager = (ViewPager) findViewById(R.id.pager);
//        mPager.setAdapter(new AdapterImageSliderDots(ImageSliderDots.this,XMENArray)); //bisa pakai ini juga
        adapteraasss = new AdapterImageSliderDots(ImageSliderDots.this, XMENArray);
        mPager.setAdapter(adapteraasss);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);


        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == imageNya.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 2500, 2500);
    }
}
