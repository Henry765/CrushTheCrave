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
package com.example.hrzhulocal.crushthecraveprototype2.Graph;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
//import android.app.FragmentManager;
//import android.app.Fragment;


import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.example.hrzhulocal.crushthecraveprototype2.R;

import java.util.Arrays;

//import android.support.v4.app.FragmentManager;

public class My_ProgressActivity extends FragmentActivity implements ActionBar.TabListener{
    //ViewPager viewpager;
    //MyPageAdapter  pageAdapter;

    ActionBar actionbar;
    ViewPager viewpager;
    FragmentPageAdapter ft;
    private XYPlot plot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__progress);

        viewpager = (ViewPager) findViewById(R.id.pager);
        ft = new FragmentPageAdapter(getSupportFragmentManager());
        actionbar = getActionBar();
        viewpager.setAdapter(ft);
//        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //actionbar.addTab(actionbar.newTab().setText("Java").setTabListener(this));
        //actionbar.addTab(actionbar.newTab().setText("Php").setTabListener(this));actionbar.addTab(actionbar.newTab().setText(".Net").setTabListener(this));
        //viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

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

    public class My_ProgressActivity2 extends FragmentActivity implements ActionBar.TabListener {
        ActionBar actionbar;
        ViewPager viewpager;
        FragmentPageAdapter ft;
        private XYPlot plot2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.activity_graph_fragment_two);
            viewpager = (ViewPager) findViewById(R.id.pager2);
            ft = new FragmentPageAdapter(getSupportFragmentManager());
            actionbar = getActionBar();
            viewpager.setAdapter(ft);
    // initialize our XYPlot reference:
            plot2 = (XYPlot) findViewById(R.id.mySimpleXYPlotTwo);

            // Create a couple arrays of y-values to plot:
            Number[] series1Numbers2 = {1, 8, 5, 2, 7, 4};
            Number[] series2Numbers2 = {1, 6, 3, 8, 2, 10};

            // Turn the above arrays into XYSeries':
            XYSeries series1 = new SimpleXYSeries(
                    Arrays.asList(series1Numbers2),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Series1");                             // Set the display title of the series

            // same as above
            XYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers2), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");

            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter series1Format = new LineAndPointFormatter();
            series1Format.setPointLabelFormatter(new PointLabelFormatter());
            series1Format.configure(getApplicationContext(),
                    R.xml.line_point_formatter_with_plf1);

            // add a new series' to the xyplot:
            plot2.addSeries(series1, series1Format);

            // same as above:
            LineAndPointFormatter series2Format = new LineAndPointFormatter();
            series2Format.setPointLabelFormatter(new PointLabelFormatter());
            series2Format.configure(getApplicationContext(),
                    R.xml.line_point_formatter_with_plf2);
            plot2.addSeries(series2, series2Format);

            // reduce the number of range labels
            plot2.setTicksPerRangeLabel(3);
            plot2.getGraphWidget().setDomainLabelOrientation(-45);
        }

        @Override
        public void onTabSelected(Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabUnselected(Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(Tab tab, FragmentTransaction ft) {

        }
    }

    public class My_ProgressActivity3 extends FragmentActivity implements ActionBar.TabListener {
        ActionBar actionbar;
        ViewPager viewpager;
        FragmentPageAdapter ft;
        private XYPlot plot3;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.activity_my__progress_activity3);
            viewpager = (ViewPager) findViewById(R.id.pager3);
            ft = new FragmentPageAdapter(getSupportFragmentManager());
            actionbar = getActionBar();
            viewpager.setAdapter(ft);

    // initialize our XYPlot reference:
            plot3 = (XYPlot) findViewById(R.id.mySimpleXYPlotThree);

            // Create a couple arrays of y-values to plot:
            Number[] series1Numbers3 = {1, 8, 5, 2, 7, 4};
            Number[] series2Numbers3 = {45, 6, 3, 8, 2, 10};

            // Turn the above arrays into XYSeries':
            XYSeries series1 = new SimpleXYSeries(
                    Arrays.asList(series1Numbers3),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Series1");                             // Set the display title of the series

            // same as above
            XYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers3), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");

            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter series1Format = new LineAndPointFormatter();
            series1Format.setPointLabelFormatter(new PointLabelFormatter());
            series1Format.configure(getApplicationContext(),
                    R.xml.line_point_formatter_with_plf1);

            // add a new series' to the xyplot:
            plot3.addSeries(series1, series1Format);

            // same as above:
            LineAndPointFormatter series2Format = new LineAndPointFormatter();
            series2Format.setPointLabelFormatter(new PointLabelFormatter());
            series2Format.configure(getApplicationContext(),
                    R.xml.line_point_formatter_with_plf2);
            plot3.addSeries(series2, series2Format);

            // reduce the number of range labels
            plot3.setTicksPerRangeLabel(3);
            plot3.getGraphWidget().setDomainLabelOrientation(-45);
        }

        @Override
        public void onTabSelected(Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabUnselected(Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(Tab tab, FragmentTransaction ft) {

        }
        /*
        androidPlot.titleWidget.labelPaint.textSize="@dimen/title_font_size"
            androidPlot.domainLabelWidget.labelPaint.textSize="@dimen/domain_label_font_size"
            androidPlot.rangeLabelWidget.labelPaint.textSize="@dimen/range_label_font_size"
            androidPlot.graphWidget.marginTop="20dp"
            androidPlot.graphWidget.marginLeft="15dp"
            androidPlot.graphWidget.marginBottom="25dp"
            androidPlot.graphWidget.marginRight="10dp"
            androidPlot.graphWidget.rangeLabelPaint.textSize="@dimen/20dp"
            androidPlot.graphWidget.rangeOriginLabelPaint.textSize="@dimen/20dp"
            androidPlot.graphWidget.domainLabelPaint.textSize="@dimen/domain_tick_label_font_size"
            androidPlot.graphWidget.domainOriginLabelPaint.textSize="@dimen/domain_tick_label_font_size"
            androidPlot.legendWidget.textPaint.textSize="@dimen/legend_text_font_size"
            androidPlot.legendWidget.iconSizeMetrics.heightMetric.value="15dp"
            androidPlot.legendWidget.iconSizeMetrics.widthMetric.value="15dp"
            androidPlot.legendWidget.heightMetric.value="25dp"
            androidPlot.legendWidget.positionMetrics.anchor="right_bottom"
            androidPlot.graphWidget.gridLinePaint.color="#000000"

               <dimen name="activity_horizontal_margin">16dp</dimen>
        <dimen name="activity_vertical_margin">16dp</dimen>
        <dimen name="pie_segment_label_font_size">10dp</dimen>
        <dimen name="title_font_size">20dp</dimen>
        <dimen name="domain_label_font_size">13dp</dimen>
        <dimen name="range_label_font_size">13dp</dimen>
        <dimen name="range_tick_label_font_size">15dp</dimen>
        <dimen name="domain_tick_label_font_size">15dp</dimen>
        <dimen name="legend_text_font_size">20dp</dimen>
         */
    }
}