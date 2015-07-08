//package com.example.hrzhulocal.crushthecraveprototype2;
package com.example.hrzhulocal.crushthecraveprototype2;

/**
 * Created by hrzhulocal on 23/06/2015.
 */
import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidplot.Plot;
import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYStepMode;
import com.example.hrzhulocal.crushthecraveprototype2.Graph.MainActivity;
import com.example.hrzhulocal.crushthecraveprototype2.R;

import org.json.JSONException;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static android.graphics.Color.*;

//***********************************************************************
public class FragmentOne extends Fragment{
    private XYPlot plot;
    //create one getTimeAndCount instance to extends two classes
    private MainActivityHome getTimeAndCount;

    final String[] xLabels = {"Mon", "Tues", "Wed", "Thur", "Fri", "Sat", "Sun"};
    Number[] yValues = {1, 3, 2 ,7 ,6};
    Number[] xValues = {0, 1, 2, 3, 4};

    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.gfragment_one_layout, container, false); //inflater.inflate(R.layout.activity_main, container, false);
        getTimeAndCount = new MainActivityHome();
        plot = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotOne);

        // Create a couple arrays of y-values to plot:
        Number[] allowance = {10, 10, 10, 8, 8, 8, 8};
        Number[] SMOKE = {
                //86400000 in 24 hours
                MainActivityHome.TrackSmoke[0],//MainActivityHome.daysInBetween,//978307200,  // 2001
                MainActivityHome.TrackSmoke[1],//1009843200, // 2002
                MainActivityHome.TrackSmoke[2],//1041379200, // 2003
                MainActivityHome.TrackSmoke[3],//1072915200, // 2004
                MainActivityHome.TrackSmoke[4],//1104537600, // 2005
                MainActivityHome.TrackSmoke[5],//1072915200, // 2004
                MainActivityHome.TrackSmoke[6] //1104537600  // 2005
        };
        Number[] CRAVE = {
                //86400000 in 24 hours
                MainActivityHome.TrackCrave[0],//MainActivityHome.daysInBetween,//978307200,  // 2001
                MainActivityHome.TrackCrave[1],//1009843200, // 2002
                MainActivityHome.TrackCrave[2],//1041379200, // 2003
                MainActivityHome.TrackCrave[3],//1072915200, // 2004
                MainActivityHome.TrackCrave[4],//1104537600,  // 2005
                MainActivityHome.TrackCrave[5],//1072915200, // 2004
                MainActivityHome.TrackCrave[6] //1104537600  // 2005
        };

        // Turn the above arrays into XYSeries':
        XYSeries series12 = new SimpleXYSeries(
                Arrays.asList(allowance),          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Allowance");                             // Set the display title of the series
        // Create a formatter to use for drawing a series using LineAndPointRenderer
        // and configure it from xml:
        LineAndPointFormatter series1Format2 = new LineAndPointFormatter();
        series1Format2.setPointLabelFormatter(new PointLabelFormatter());
        series1Format2.configure(container.getContext(),
                R.xml.line_point_formatter_with_plf1_2);

        // add a new series' to the xyplot:*********************************************
        plot.addSeries(series12, series1Format2);
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(SMOKE),          // SimpleXYSeries takes a List so turn our array into a List
                //Arrays.asList(allowance),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Smoke");

        // add a new series' to the xyplot:*********************************************
        plot.addSeries(series1, series1Format2);
        XYSeries Crave = new SimpleXYSeries(
                Arrays.asList(CRAVE),          // SimpleXYSeries takes a List so turn our array into a List
                //Arrays.asList(allowance),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Smoke");

        plot.addSeries(Crave, series1Format2);




        LineAndPointFormatter formatter = new LineAndPointFormatter(Color.GREEN, Color.BLUE, Color.BLACK, null);
        plot.getGraphWidget().setPaddingRight(2);
        plot.addSeries(series1, formatter);

        // draw a domain tick for each year:
        plot.setDomainStep(XYStepMode.SUBDIVIDE, SMOKE.length);

        // customize our domain/range labels
        plot.setRangeLabel("Value");

        // get rid of decimal points in our range labels:
        plot.setRangeValueFormat(new DecimalFormat("0"));
        // reduce the number of range labels
        plot.setTicksPerRangeLabel(3);
        plot.getGraphWidget().setDomainLabelOrientation(-45);

        //7 domain ticks 6 range ticks
        plot.setDomainStep(XYStepMode.SUBDIVIDE, 7);
        plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
        plot.setRangeStep(XYStepMode.SUBDIVIDE, 6);
        plot.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

        //set boundaries
        plot.setRangeBoundaries(0, 10, BoundaryMode.FIXED);

        // initialize our XYPlot reference:
       /* plot = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotOne);
        Number[] allowance = {10, 10, 10, 8, 8};//, 8, 8};
        Toast.makeText(container.getContext(), "this is my Toast message!!! =)"+ getTimeAndCount.startDayNum, Toast.LENGTH_LONG).show();

        long x = getTimeAndCount.TrackSmoke[getTimeAndCount.TrackSmokeCount]+86400000;
        Number[] days = {
                //86400000 in 24 hours
                978307200,  // 2001
                1009843200, // 2002
                1041379200, // 2003
                1072915200, // 2004
                1104537600  // 2005
                //1072915200, // 2004
                //1104537600  // 2005
        };

        XYSeries series2 = new SimpleXYSeries(
                Arrays.asList(days),
                Arrays.asList(allowance),               // SimpleXYSeries takes a List so turn our array into a List
                //SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "allowance");

        plot.getGraphWidget().getGridBackgroundPaint().setColor(Color.WHITE);
        //plot.getGraphWidget().getGridLinePaint().setColor(Color.BLACK);
        //plot.getGraphWidget().getGridLinePaint().setPathEffect(new DashPathEffect(new float[]{1,1}, 1));
        plot.getGraphWidget().getDomainOriginLinePaint().setColor(Color.BLACK);
        plot.getGraphWidget().getRangeOriginLinePaint().setColor(Color.BLACK);

        plot.setBorderStyle(Plot.BorderStyle.SQUARE, null, null);
        plot.getBorderPaint().setStrokeWidth(1);
        plot.getBorderPaint().setAntiAlias(false);
        plot.getBorderPaint().setColor(Color.WHITE);


        // setup our line fill paint to be a slightly transparent gradient:
        Paint lineFill = new Paint();
        lineFill.setAlpha(200);
        lineFill.setShader(new LinearGradient(0, 0, 0, 250, Color.WHITE, Color.GREEN, Shader.TileMode.MIRROR));


        plot.addSeries(series2, formatter);

        // draw a domain tick for each year:
        plot.setDomainStep(XYStepMode.SUBDIVIDE, days.length);

        // customize our domain/range labels
        plot.setDomainLabel("Year");
        plot.setRangeLabel("# of Sightings");

        // get rid of decimal points in our range labels:
        plot.setRangeValueFormat(new DecimalFormat("0"));*/
        //XYSeries series2 = new SimpleXYSeries(Arrays.asList(days), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");
        //plot.getGraphWidget().setDomainValueFormat(new GraphXLabelFormat());

        // Set the display title of the series
        // Create a formatter to use for drawing a series using LineAndPointRenderer
        // and configure it from xml:
        /*LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.setPointLabelFormatter(new PointLabelFormatter());
        series1Format.configure(container.getContext(),
                R.xml.line_point_formatter_with_plf1);

        // add a new series' to the xyplot:
        plot.addSeries(series1, series1Format);

        // add a new series' to the xyplot:
        // same as above:
        /*LineAndPointFormatter series2Format = new LineAndPointFormatter();
        series2Format.setPointLabelFormatter(new PointLabelFormatter());
        series2Format.configure(container.getContext(),
                R.xml.line_point_formatter_with_plf2);
        plot.addSeries(series2, series2Format);*/

        // setup our line fill paint to be a slightly transparent gradient:
        /*Paint lineFill = new Paint();
        lineFill.setAlpha(200);
        lineFill.setShader(new LinearGradient(0, 0, 0, 250, Color.WHITE, Color.GREEN, Shader.TileMode.CLAMP));

        // customize our domain/range labels
        plot.setDomainLabel("Number of Days of quitting");
        plot.setRangeLabel("Value");
        // get rid of decimal points in our range labels:
        plot.setRangeValueFormat(new DecimalFormat("0"));

        // reduce the number of range labels
        plot.setTicksPerRangeLabel(2);
        plot.getGraphWidget().setDomainLabelOrientation(45);
        //7 domain ticks 6 range ticks
        plot.setDomainStep(XYStepMode.SUBDIVIDE, 7);
        plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
        plot.setRangeStep(XYStepMode.SUBDIVIDE, 6);
        plot.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);*/

        //set boundaries
        return rootView;//inflater.inflate(R.layout.fragment_one_layout,container,false);
    }

    class GraphXLabelFormat extends Format {

        @Override
        public StringBuffer format(Object arg0, StringBuffer arg1, FieldPosition arg2) {
            // TODO Auto-generated method stub

            int parsedInt = Math.round(Float.parseFloat(arg0.toString()));
            Log.d("test", parsedInt + " " + arg1 + " " + arg2);
            String labelString = xLabels[parsedInt];
            arg1.append(labelString);
            return arg1;
        }

        @Override
        public Object parseObject(String arg0, ParsePosition arg1) {
            // TODO Auto-generated method stub
            return java.util.Arrays.asList(xLabels).indexOf(arg0);
        }
    }



    public static class FragmentTwo extends Fragment {
        private XYPlot plot2;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.gfragment_two_layout,container,false);
    // initialize our XYPlot reference:
            plot2 = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotTwo);

            // Create a couple arrays of y-values to plot:
            Number[] allowance = {8, 8, 8, 6, 6, 6, 6};

            // Turn the above arrays into XYSeries':
            XYSeries series12 = new SimpleXYSeries(
                    Arrays.asList(allowance),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "allowance");                             // Set the display title of the series

            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter series1Format2 = new LineAndPointFormatter();
            series1Format2.setPointLabelFormatter(new PointLabelFormatter());
            series1Format2.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_2);

            // add a new series' to the xyplot:
            plot2.addSeries(series12, series1Format2);


            // reduce the number of range labels
            plot2.setTicksPerRangeLabel(3);
            plot2.getGraphWidget().setDomainLabelOrientation(-45);

            //7 domain ticks 6 range ticks
            plot2.setDomainStep(XYStepMode.SUBDIVIDE, 7);
            plot2.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
            plot2.setRangeStep(XYStepMode.SUBDIVIDE, 6);
            plot2.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

            //set boundaries
            plot2.setRangeBoundaries(0, 10, BoundaryMode.FIXED);

            // TODO Auto-generated method stub
            return rootView;//inflater.inflate(R.layout.fragment_one_layout,container,false);
        }

    }

    public static class FragmentThree extends Fragment {

        private XYPlot plot3;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            View rootView = inflater.inflate(R.layout.gfragment_three_layout,container,false);

            // initialize our XYPlot reference:
            plot3 = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotThree);

            // Create a couple arrays of y-values to plot:
            Number[] allowance = {6, 6, 6, 4, 4, 4, 4};

            // Turn the above arrays into XYSeries':
            XYSeries series13 = new SimpleXYSeries(
                    Arrays.asList(allowance),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "allowance");                             // Set the display title of the series

            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter series1Format3 = new LineAndPointFormatter();
            series1Format3.setPointLabelFormatter(new PointLabelFormatter());
            series1Format3.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_3);

            // add a new series' to the xyplot:
            plot3.addSeries(series13, series1Format3);

            // reduce the number of range labels
            plot3.setTicksPerRangeLabel(3);
            plot3.getGraphWidget().setDomainLabelOrientation(-45);
            // TODO Auto-generated method stub
            //7 domain ticks 6 range ticks
            plot3.setDomainStep(XYStepMode.SUBDIVIDE, 7);
            plot3.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
            plot3.setRangeStep(XYStepMode.SUBDIVIDE, 6);
            plot3.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

            //set boundaries
            plot3.setRangeBoundaries(0, 10, BoundaryMode.FIXED);
            return rootView;//inflater.inflate(R.layout.fragment_three_layout,container,false);
        }

    }

    public static class FragmentFour extends Fragment {
        private XYPlot plot4;

        //@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.gfragment_four_layout,container,false); //inflater.inflate(R.layout.activity_main, container, false);


            // initialize our XYPlot reference:
            plot4 = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotFour);

            // Create a couple arrays of y-values to plot:
            Number[] allowance = {4, 4, 4, 2, 2, 2, 2};

            // Turn the above arrays into XYSeries':
            XYSeries series14 = new SimpleXYSeries(
                    Arrays.asList(allowance),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "allowance");                             // Set the display title of the series

            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter series1Format4 = new LineAndPointFormatter();
            series1Format4.setPointLabelFormatter(new PointLabelFormatter());
            series1Format4.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_4);

            // add a new series' to the xyplot:
            plot4.addSeries(series14, series1Format4);

            // reduce the number of range labels
            plot4.setTicksPerRangeLabel(3);
            plot4.getGraphWidget().setDomainLabelOrientation(-45);
            //7 domain ticks 6 range ticks
            plot4.setDomainStep(XYStepMode.SUBDIVIDE, 7);
            plot4.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
            plot4.setRangeStep(XYStepMode.SUBDIVIDE, 6);
            plot4.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

            //set boundaries
            plot4.setRangeBoundaries(0, 10, BoundaryMode.FIXED);

            return rootView;//inflater.inflate(R.layout.fragment_one_layout,container,false);
        }


    }

    public static class FragmentFive extends Fragment {
        private XYPlot plot5;

        //@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.gfragment_five_layout,container,false); //inflater.inflate(R.layout.activity_main, container, false);

            // initialize our XYPlot reference:
            plot5 = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotFive);

            // Create a couple arrays of y-values to plot:
            Number[] allowance = {2, 2, 2, 1, 1, 1, 1};

            // Turn the above arrays into XYSeries':
            XYSeries series15 = new SimpleXYSeries(
                    Arrays.asList(allowance),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "allowance");                             // Set the display title of the series

            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter series1Format5 = new LineAndPointFormatter();
            series1Format5.setPointLabelFormatter(new PointLabelFormatter());
            series1Format5.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_2);

            // add a new series' to the xyplot:
            plot5.addSeries(series15, series1Format5);

            // reduce the number of range labels
            plot5.setTicksPerRangeLabel(3);
            plot5.getGraphWidget().setDomainLabelOrientation(-45);

            plot5.setDomainStep(XYStepMode.SUBDIVIDE, 7);
            plot5.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
            plot5.setRangeStep(XYStepMode.SUBDIVIDE, 6);
            plot5.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

            //set boundaries
            plot5.setRangeBoundaries(0, 10, BoundaryMode.FIXED);

            return rootView;//inflater.inflate(R.layout.fragment_one_layout,container,false);
        }


    }

    public static class FragmentSix extends Fragment{
        private XYPlot plot;

        //@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.gfragment_six_layout,container,false); //inflater.inflate(R.layout.activity_main, container, false);


            // initialize our XYPlot reference:
            plot = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotSix);

            // Create a couple arrays of y-values to plot:
            Number[] series1Numbers6 = {10, 8, 5, 2, 7, 4};

            // Turn the above arrays into XYSeries':
            XYSeries series16 = new SimpleXYSeries(
                    Arrays.asList(series1Numbers6),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "allowance");                             // Set the display title of the series

            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter series1Format5 = new LineAndPointFormatter();
            series1Format5.setPointLabelFormatter(new PointLabelFormatter());
            series1Format5.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_2);

            // add a new series' to the xyplot:
            plot.addSeries(series16, series1Format5);

            // reduce the number of range labels
            plot.setTicksPerRangeLabel(3);
            plot.getGraphWidget().setDomainLabelOrientation(-45);

            return rootView;//inflater.inflate(R.layout.fragment_one_layout,container,false);
        }


    }

    public static class FragmentSeven extends Fragment{
        private XYPlot plot;

        //@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.gfragment_seven_layout,container,false); //inflater.inflate(R.layout.activity_main, container, false);


            // initialize our XYPlot reference:
            plot = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotSeven);

            // Create a couple arrays of y-values to plot:
            Number[] series1Numbers7 = {10, 8, 5, 2, 7, 10};
            // Turn the above arrays into XYSeries':
            XYSeries series7 = new SimpleXYSeries(
                    Arrays.asList(series1Numbers7),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "allowance");                             // Set the display title of the series

            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter series1Format7 = new LineAndPointFormatter();
            series1Format7.setPointLabelFormatter(new PointLabelFormatter());
            series1Format7.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_2);

            // add a new series' to the xyplot:
            plot.addSeries(series7, series1Format7);

            // reduce the number of range labels
            plot.setTicksPerRangeLabel(3);
            plot.getGraphWidget().setDomainLabelOrientation(-45);

            //this.getGraphWidget().setDomainValueFormat(new GraphXLabelFormat());
            return rootView;//inflater.inflate(R.layout.fragment_one_layout,container,false);
        }
    }

    public static class FragmentEight extends Fragment{
        private XYPlot plot;

        //@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.gfragment_eight_layout,container,false); //inflater.inflate(R.layout.activity_main, container, false);


            // initialize our XYPlot reference:
            plot = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotEight);

            // Create a couple arrays of y-values to plot:
            Number[] series1Numbers8 = {10, 8, 5, 2, 7, 10};
            // Turn the above arrays into XYSeries':
            XYSeries series12 = new SimpleXYSeries(
                    Arrays.asList(series1Numbers8),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "allowance");                             // Set the display title of the series

            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter series1Format2 = new LineAndPointFormatter();
            series1Format2.setPointLabelFormatter(new PointLabelFormatter());
            series1Format2.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_2);

            // add a new series' to the xyplot:
            plot.addSeries(series12, series1Format2);

            // reduce the number of range labels
            plot.setTicksPerRangeLabel(3);
            plot.getGraphWidget().setDomainLabelOrientation(-45);

            //this.getGraphWidget().setDomainValueFormat(new GraphXLabelFormat());
            return rootView;//inflater.inflate(R.layout.fragment_one_layout,container,false);
        }
    }
}


/*private class GraphXLabelFormat extends Format {

    private static LABELS = {"Label 1", "Label 2", "Label 3"};

    @Override
    public StringBuffer format(Object object, StringBuffer buffer, FieldPosition field) {
        int parsedInt = Math.round(Float.parseFloat(object.toString()));
        String labelString = = LABELS[parsedInt];

        buffer.append(labelString);
        return buffer;
    }

    @Override
    public Object parseObject(String string, ParsePosition position) {
        return java.util.Arrays.asList(LABELS).indexOf(string);
    }
}*/
/*private class MyDateFormat extends Format {

    private static final long serialVersionUID = 1L;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("DDD:kk/mm/ss");

    @Override
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        long timestamp = ((Number) obj).longValue();
        Date date = new Date(timestamp);
        return dateFormat.format(date, toAppendTo, pos);
    }

    @Override
    public Object parseObject(String source, ParsePosition pos) {
        return null;
    }
}

oneChart.setDomainValueFormat(new MyDateFormat());*/
