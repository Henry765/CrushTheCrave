/*package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

public class My_ProgressActivity extends MainActivityHome {

    Button button;
    ViewPager viewpager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__progress);

        addListenerOnHomeImageButton();
        addListenerOnAwardImageButton();
        addListenerOnProgressImageButton();
        addListenerOnQuitHelpImageButton();
        addListenerOnMoreImageButton();
        addListenerOnHealthCalImageButton();
        final GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.setTitle("Progress Graph");

        //NumberFormat nf = NumberFormat.getInstance();
        //nf.setMinimumFractionDigits(3);
        // nf.setMinimumIntegerDigits(2);
        viewpager2 = (ViewPager) findViewById(R.id.pager2);
        PagerAdapter padapter = new PagerAdapter(getSupportFragmentManager());
        viewpager2.setAdapter(padapter);
        final StaticLabelsFormatter graphView = new StaticLabelsFormatter(graph);
        graphView.setHorizontalLabels(new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" });
        graph.getGridLabelRenderer().setLabelFormatter(graphView);

        /*graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    graphView.setHorizontalLabels(new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" });
                    graph.getGridLabelRenderer().setLabelFormatter(graphView);

                    return super.formatLabel(value, isValueX);
                } else {
                    // show currency for y values
                    return super.formatLabel(value, isValueX);
                }
            }
        });*/

// set manual Y bounds
        // graph.getViewport().setYAxisBoundsManual(true);
        // graph.getViewport().setMinY(0);
        // graph.getViewport().setMaxY(10);


        /*graph.getViewport().setScrollable(true);
        //graph.getViewport().setScalable(true);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(0, 10),
                new DataPoint(1, 10),
                new DataPoint(2, 10),
                new DataPoint(3, 8),
                new DataPoint(4, 8),
                new DataPoint(5, 8),
                new DataPoint(6, 8),
                /*new DataPoint(7, 8),
                new DataPoint(8, 8),
                new DataPoint(9, 8),
                new DataPoint(10, 6),
                new DataPoint(11, 6),
                new DataPoint(12, 6),
                new DataPoint(13, 6),
                new DataPoint(14, 6),
                new DataPoint(15, 6),
                new DataPoint(16, 6),
                new DataPoint(17, 4),
                new DataPoint(18, 4),
                new DataPoint(19, 4),
                new DataPoint(20, 4),
                new DataPoint(21, 4),
                new DataPoint(22, 4),
                new DataPoint(23, 4),
                new DataPoint(24, 2),
                new DataPoint(25, 2),
                new DataPoint(26, 2),
                new DataPoint(27, 2),
                new DataPoint(28, 2),
                new DataPoint(29, 2),
                new DataPoint(30, 2)*/
                //after 30 days  the allowance is zero
        //});
        //graph.addSeries(series);
        //series.setColor(Color.GREEN);

        // set manual x bounds to have nice steps
        //graph.getViewport().setMaxX(quitDayGetTime.getTime());
        //graph.getViewport().setXAxisBoundsManual(true);
        //Use Dates as Labels
        // generate Dates
        /*Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d2 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d3 = calendar.getTime();

        GraphView graph = (GraphView) findViewById(R.id.graph);

// you can directly pass Date objects to DataPoint-Constructor
// this will convert the Date to double via Date#getTime()
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(d1, 1),
                new DataPoint(d2, 5),
                new DataPoint(d3, 3)
        });
        graph.addSeries(series);

// set date label formatter
        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        graph.getGridLabelRenderer().setNumHorizontalLabels(3); // only 4 because of the space

// set manual x bounds to have nice steps
        graph.getViewport().setMinX(d1.getTime());
        graph.getViewport().setMaxX(d3.getTime());
        graph.getViewport().setXAxisBoundsManual(true);
        addListenerOnHealthCalImageButton();*/
    /*}

    public void addListenerOnHealthCalImageButton(){
        final Context context = this;
        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, HealthCalculator.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my__progress, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}*/
package com.example.hrzhulocal.crushthecraveprototype2;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
//import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
//import android.app.Fragment;


import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYStepMode;
import com.example.hrzhulocal.crushthecraveprototype2.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
public class My_ProgressActivity extends FragmentActivity implements ActionBar.TabListener{
    //ViewPager viewpager;
    //MyPageAdapter  pageAdapter;

    ActionBar actionbar;
    ViewPager viewpager;
    FragmentPageAdapter ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__progress);

        viewpager = (ViewPager) findViewById(R.id.pager1);
        ft = new FragmentPageAdapter(getSupportFragmentManager());
        actionbar = getActionBar();
        viewpager.setAdapter(ft);
        //actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //actionbar.addTab(actionbar.newTab().setText("Java").setTabListener(this));
        //actionbar.addTab(actionbar.newTab().setText("Php").setTabListener(this));
        //actionbar.addTab(actionbar.newTab().setText(".Net").setTabListener(this));
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
//                actionbar.setSelectedNavigationItem(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
            }
        });

        // initialize our XYPlot reference:
        final XYPlot plot = (XYPlot) findViewById(R.id.mySimpleXYPlotOne);

        //create 7 ticks for the days of a week
        plot.setDomainStep(XYStepMode.SUBDIVIDE, 5);
        plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
        // Create a couple arrays of y-values to plot:
        Number[] series1Numbers = {1, 8, 5, 2, 56, 25};
        Number[] series2Numbers = {4, 6, 3, 8, 2, 10};

        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(series1Numbers),          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Series1");                             // Set the display title of the series

        // same as above
        XYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");

        // Create a formatter to use for drawing a series using LineAndPointRenderer:
        // and configure it from xml
        LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.setPointLabelFormatter(new PointLabelFormatter());
        series1Format.configure(getApplicationContext(), R.xml.line_point_formatter_with_plf1);

        // add a new series' to the xyplot:
        plot.addSeries(series1, series1Format);

        // same as above:
        LineAndPointFormatter series2Format = new LineAndPointFormatter();
        series2Format.setPointLabelFormatter(new PointLabelFormatter());
        series2Format.configure(getApplicationContext(), R.xml.line_point_formatter_with_plf2);
        plot.addSeries(series2, series2Format);

        // reduce the number of range labels
        plot.setTicksPerRangeLabel(3);
        plot.getGraphWidget().setDomainLabelOrientation(-45);
    }
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        viewpager.setCurrentItem(tab.getPosition());
    }
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
    }
        /*viewpager = (ViewPager) findViewById(R.id.pager2);
        GraphPageAdapater padapter = new GraphPageAdapater(getSupportFragmentManager());
        viewpager.setAdapter(padapter);*/
        
       /* List<Fragment> fragments = getFragments();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager =
                (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
    }

    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();

        fList.add(GraphFragmentOne.newInstance("Fragment 1"));
        fList.add(GraphFragmentOne.newInstance("Fragment 2"));
        fList.add(GraphFragmentOne.newInstance("Fragment 3"));

        return fList;
    }

    private class MyPageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public MyPageAdapter(android.support.v4.app.FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }*/
}