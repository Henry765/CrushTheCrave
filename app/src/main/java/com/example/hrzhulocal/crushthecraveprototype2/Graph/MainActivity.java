package com.example.hrzhulocal.crushthecraveprototype2.Graph;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.*;
import com.example.hrzhulocal.crushthecraveprototype2.PagerAdapterInherits;
import com.example.hrzhulocal.crushthecraveprototype2.R;

import java.util.Arrays;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
public class MainActivity extends FragmentActivity  {

/**
 * A straightforward example of using AndroidPlot to plot some data.
 */
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
                PagerAdapterInherits padapter = new PagerAdapterInherits(getSupportFragmentManager());
                viewpager.setAdapter(padapter);
                //86400000 in 24 hours
                //putseralizalied for 2 d array!!1
            }
}






