
package com.example.hrzhulocal.crushthecraveprototype2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYStepMode;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.*;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GraphFragmentOne extends Fragment{
    private XYPlot mySimpleXYPlot;
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static final GraphFragmentOne newInstance(String message)
    {
        GraphFragmentOne f = new GraphFragmentOne();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }
    //@Override
    public View onCreate(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState)  {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_graph_fragment_one);
/*
        // initialize our XYPlot reference:
        mySimpleXYPlot = (XYPlot) findViewById(R.id.app);

        // Create a couple arrays of y-values to plot:
        Number[] series1Numbers = {1, 8, 5, 2, 7, 4};
        Number[] series2Numbers = {4, 6, 3, 8, 2, 10};

        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(series1Numbers),          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Series1");                             // Set the display title of the series

        // same as above
        XYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");

        // Create a formatter to use for drawing a series using LineAndPointRenderer:
        LineAndPointFormatter series1Format = new LineAndPointFormatter(
                Color.rgb(0, 200, 0),                   // line color
                Color.rgb(0, 100, 0),                   // point color
                null,                                   // fill color (none)
                new PointLabelFormatter(Color.WHITE));                           // text color

        // add a new series' to the xyplot:
        mySimpleXYPlot.addSeries(series1, series1Format);

        // same as above:
        mySimpleXYPlot.addSeries(series2,
                new LineAndPointFormatter(
                        Color.rgb(0, 0, 200),
                        Color.rgb(0, 0, 100),
                        null,
                        new PointLabelFormatter(Color.WHITE)));

        // reduce the number of range labels
        mySimpleXYPlot.setTicksPerRangeLabel(3);
    }*/
        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.activity_graph_fragment_one, container, false);
        TextView messageTextView = (TextView) v.findViewById(R.id.textView);
        messageTextView.setText(message);

        return v;
    }
}

/*public class GraphFragmentOne extends Fragment {
    private XYPlot plot;
    ArrayList<Double> Vector = new ArrayList<Double>();
    public double DataX, DataY;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        final View rootView = inflater.inflate(R.layout.activity_graph_fragment_one, container, false);
        // return inflater.inflate(R.layout.activity_graph_fragment_one,container,false);


        XYPlot plot = (XYPlot) rootView.findViewById(R.id.app);
        plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 0.5);
        plot.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);
        plot.getGraphWidget().getGridBackgroundPaint().setColor(Color.rgb(0, 0, 0));
        plot.getGraphWidget().getDomainGridLinePaint().setColor(Color.rgb(255, 0, 0));
        plot.getGraphWidget().getRangeGridLinePaint().setColor(Color.rgb(255, 0, 0));
        plot.setRangeBoundaries(0, 5, BoundaryMode.FIXED);

        for (int i = 0; i <= 20; i++) {
            DataX = DataX + 0.5;
            Vector.add(DataX);
            DataY = Math.random() * 5;
            Vector.add(DataY);
        }
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                //   Refrescar();
            }
        }, 0, 150);

        XYSeries series = new SimpleXYSeries(Vector, SimpleXYSeries.ArrayFormat.XY_VALS_INTERLEAVED, "hack");
        LineAndPointFormatter seriesFormat = new LineAndPointFormatter(Color.rgb(255, 255, 255), 0, 0, null);
        plot.clear();
        plot.addSeries(series, seriesFormat);
        return inflater.inflate(R.layout.activity_graph_fragment_one,container,false);

    }

    //private void Refrescar(){
      // this.runOnUiThread(Graf);
    //}
    private Runnable Graf = new Runnable() {
        public void run() {

            DataX = DataX + 0.5;
            Vector.remove(0);
            Vector.add(DataX);
            DataY = Math.random() * 5;
            Vector.remove(0);

            Vector.add(DataY);

            XYSeries series = new SimpleXYSeries(Vector, SimpleXYSeries.ArrayFormat.XY_VALS_INTERLEAVED, "hack");
            LineAndPointFormatter seriesFormat = new LineAndPointFormatter(Color.rgb(255, 255, 255), 0, 0, null);
            plot.clear();
            plot.addSeries(series, seriesFormat);
        }

    };
}
/*import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class GraphFragmentOne extends Fragment {
    Button button;
    ViewPager viewpager2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.activity_graph_fragment_one,container,false);

        //addListenerOnHomeImageButton();
        //addListenerOnAwardImageButton();
        //addListenerOnProgressImageButton();
        //addListenerOnQuitHelpImageButton();
        //addListenerOnMoreImageButton();
        //addListenerOnHealthCalImageButton();
        final GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.setTitle("Progress Graph");

        //NumberFormat nf = NumberFormat.getInstance();
        //nf.setMinimumFractionDigits(3);
        // nf.setMinimumIntegerDigits(2);
        viewpager2 = (ViewPager)findViewById(R.id.pager2);
        PagerAdapter padapter = new PagerAdapter(getChildFragmentManager()); //getSupportFragmentManager()
        viewpager2.setAdapter(padapter);
        final StaticLabelsFormatter graphView = new StaticLabelsFormatter(graph);
        graphView.setHorizontalLabels(new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"});
        graph.getGridLabelRenderer().setLabelFormatter(graphView);

        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    graphView.setHorizontalLabels(new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"});
                    graph.getGridLabelRenderer().setLabelFormatter(graphView);

                    return super.formatLabel(value, isValueX);
                } else {
                    // show currency for y values
                    return super.formatLabel(value, isValueX);
                }
            }
        });

// set manual Y bounds
// graph.getViewport().setYAxisBoundsManual(true);
// graph.getViewport().setMinY(0);
// graph.getViewport().setMaxY(10);


        graph.getViewport().setScrollable(true);
        //graph.getViewport().setScalable(true);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(0, 10),
                new DataPoint(1, 10),
                new DataPoint(2, 10),
                new DataPoint(3, 8),
                new DataPoint(4, 8),
                new DataPoint(5, 8),
                new DataPoint(6, 8),*/
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
       /* });
        graph.addSeries(series);
        series.setColor(Color.GREEN);
    }

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
    }*/
//}




