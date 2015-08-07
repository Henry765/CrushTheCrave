package com.example.hrzhulocal.crushthecraveprototype2.Graph;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.androidplot.xy.*;
import com.example.hrzhulocal.crushthecraveprototype2.MainActivityHome;
import com.example.hrzhulocal.crushthecraveprototype2.R;

public class MainActivity extends FragmentActivity  {

/**
 * A straightforward example of using AndroidPlot to plot some data.
 */
MainActivityHome MAH;
ViewPager viewpager;
    private XYPlot plot;
    private XYPlot plot2;
    private XYPlot plot3;

            @Override
            public void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                viewpager = (ViewPager)findViewById(R.id.pagerGraph);
                PagerAdapterGraph.PagerAdapterInherits padapter = new PagerAdapterGraph.PagerAdapterInherits(getSupportFragmentManager());
                viewpager.setAdapter(padapter);
                //86400000 in 24 hours
                //putseralizalied for 2 d array!!
            }
}