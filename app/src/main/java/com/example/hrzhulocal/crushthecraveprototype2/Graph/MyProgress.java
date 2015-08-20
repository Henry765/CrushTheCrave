//package com.example.hrzhulocal.crushthecraveprototype2;
/*
 * Copyright 2012 AndroidPlot.com
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
public class MyProgress extends Fragment{
    private XYPlot plot;
    //create one getTimeAndCount instance to extends two classes
    private MainActivityHome getTimeAndCount;

    public static int decrementFactor = 0;
    public static long tempFirstFrag = 1;
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.gfragment_one_layout, container, false); //inflater.inflate(R.layout.activity_main, container, false);
        getTimeAndCount = new MainActivityHome();
        plot = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotOne);

        //DAYS BEFORE THE YOU START TO QUIT
        getTimeAndCount.daysInBetween2 = (getTimeAndCount.quitDayNum6 - getTimeAndCount.startDayNum) / (24 * 60 * 60 * 1000);
        // Create a couple arrays of y-values to plot:

        //if quit day is now show no allowance
        /*if(MainActivityHome.daysInBetween2 == 0){
            Number[] allowance = {0, 0, 0, 0, 0, 0, 0};
        }*/

        if(MainActivityHome.daysInBetween2 != 7){
            //2223 in 2pm today
            tempFirstFrag = (MainActivityHome.daysInBetween2/7)+1;
        }
        // if before quit date is divisible by 7
        if( MainActivityHome.daysInBetween2 % 7 == 0) {

            for (int n = 1; n <= 8; n++) {

                if (n * 7 == MainActivityHome.daysInBetween2) {
                    tempFirstFrag = n;
                    break;
                }
            }
        }

       /* Number[] allowance = {
                MainActivityHome.cigarSmokedPerDay,
                MainActivityHome.cigarSmokedPerDay,
                MainActivityHome.cigarSmokedPerDay,
                (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1)))};*/
        Number[] allowance = {
                MainActivityHome.cigarSmokedPerDay,
                MainActivityHome.cigarSmokedPerDay,
                MainActivityHome.cigarSmokedPerDay,
                //Below work for a future quit date greater than 7 days
                (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/(tempFirstFrag))),
                (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/(tempFirstFrag))),
                (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/(tempFirstFrag))),
                (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/(tempFirstFrag)))};

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
                MainActivityHome.TrackCrave[4],//1104537600, // 2005
                MainActivityHome.TrackCrave[5],//1072915200, // 2004
                MainActivityHome.TrackCrave[6] //1104537600  // 2005
        };

        // Turn the above arrays into XYSeries':
        XYSeries Allowance = new SimpleXYSeries(
                Arrays.asList(allowance),          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Allowance");                             // Set the display title of the series
        // Create a formatter to use for drawing a series using LineAndPointRenderer
        // and configure it from xml:
        LineAndPointFormatter AllowanceFORMAT = new LineAndPointFormatter();

        AllowanceFORMAT.configure(container.getContext(),
                R.xml.line_point_formatter_with_plf1_2);
        plot.addSeries(Allowance, AllowanceFORMAT);

        XYSeries Crave = new SimpleXYSeries(
                Arrays.asList(CRAVE),          // SimpleXYSeries takes a List so turn our array into a List
                //Arrays.asList(allowance),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Crave");
        LineAndPointFormatter CraveFORMAT = new LineAndPointFormatter(Color.BLACK, Color.BLACK, Color.BLACK, null);


        LineAndPointFormatter CRAVEFormat2 = new LineAndPointFormatter();

        CRAVEFormat2.configure(container.getContext(),
                R.xml.line_point_formatter_with_plf1);

        plot.addSeries(Crave, CRAVEFormat2);

        // add a new series' to the xyplot:*********************************************
        XYSeries Smoke = new SimpleXYSeries(
                Arrays.asList(SMOKE),          // SimpleXYSeries takes a List so turn our array into a List
                //Arrays.asList(allowance),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Smoke");
        LineAndPointFormatter SMOKEFormat = new LineAndPointFormatter();

        SMOKEFormat.configure(container.getContext(),
                R.xml.line_point_formatter_with_plf1_3);
        // add a new series' to the xyplot:*********************************************
        plot.addSeries(Smoke, SMOKEFormat);


        /*LineAndPointFormatter formatter = new LineAndPointFormatter(Color.GREEN, Color.BLUE, Color.BLACK, null);
        plot.getGraphWidget().setPaddingRight(2);
        plot.addSeries(series1, formatter);*/

        //Remove legend
        //plot.getLayoutManager().remove(plot.getLegendWidget());
        //plot.getLayoutManager().remove(plot.getDomainLabelWidget());
        plot.getLayoutManager().remove(plot.getRangeLabelWidget());
        //plot.getLayoutManager().remove(plot.getTitleWidget());

        //plot.getGraphWidget().getDomainLabelPaint().setTextSize(10);

        //set background colors
        plot.getBackgroundPaint().setColor(Color.BLACK);
        plot.setBorderStyle(XYPlot.BorderStyle.SQUARE, null, null);
        plot.getGraphWidget().getBackgroundPaint().setColor(Color.BLACK);
        plot.getGraphWidget().getGridBackgroundPaint().setColor(Color.BLACK);
        // draw a domain tick for each year:
        plot.setDomainStep(XYStepMode.SUBDIVIDE, SMOKE.length);

        // customize our domain/range labels
        plot.setRangeLabel("Value");

        // get rid of decimal points in the domain labels:
        plot.setDomainValueFormat(new DecimalFormat("0"));
        plot.setRangeValueFormat(new DecimalFormat("0"));
        // reduce the number of range labels
        plot.setTicksPerRangeLabel(3);
        plot.getGraphWidget().setDomainLabelOrientation(-45);
        //plot.setRangeStepValue(6);
        // setup our line fill paint to be a slightly transparent gradient:
        Paint lineFill = new Paint();
        lineFill.setAlpha(200);

        // ugly usage of LinearGradient. unfortunately there's no way to determine the actual size of
        // a View from within onCreate.  one alternative is to specify a dimension in resources
        // and use that accordingly.  at least then the values can be customized for the device type and orientation.
        lineFill.setShader(new LinearGradient(0, 0, 200, 200, Color.WHITE, Color.GREEN, Shader.TileMode.REPEAT));
        //7 domain ticks 6 range ticks
        plot.setDomainStep(XYStepMode.SUBDIVIDE, 7);
        plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
        plot.setRangeStep(XYStepMode.SUBDIVIDE, 6);
        plot.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

        //set boundaries
        plot.setRangeBoundaries(0, 15, BoundaryMode.AUTO);
        //plot.getGraphWidget().setMarginLeft(0);

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



    public static class FragmentTwo extends MyProgress {
        private XYPlot plot2;

        // MainActivityHome mAH;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.gfragment_two_layout, container, false);

            /*if(mAH.daysInBetween-mAH.daysInBetween2 >= 14){

            }*/
            // initialize our XYPlot reference:
            plot2 = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotTwo);

            /*FragmentManager fm = getFragmentManager();
            fm.beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    //.show()
                    .commit();*/

            //rl2.setVisibility(View.GONE);
            //FragmentTwo.getView().setVisibility(View.GONE);
            /*FragmentManager fm = getFragmentManager();
            fm.beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .hide
                    .commit();*/
            // Create a couple arrays of y-values to plot:
            Number[] allowance = {
                    MainActivityHome.cigarSmokedPerDay,
                    MainActivityHome.cigarSmokedPerDay,
                    MainActivityHome.cigarSmokedPerDay,
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1)))};

            Number[] SMOKE = {
                    //86400000 in 24 hours
                    0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackSmoke[7],
                    MainActivityHome.TrackSmoke[8],
                    MainActivityHome.TrackSmoke[9],
                    MainActivityHome.TrackSmoke[10],
                    MainActivityHome.TrackSmoke[11],
                    MainActivityHome.TrackSmoke[12],
                    MainActivityHome.TrackSmoke[13]
            };
            Number[] CRAVE = {
                    //86400000 in 24 hours
                    0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackCrave[7],
                    MainActivityHome.TrackCrave[8],
                    MainActivityHome.TrackCrave[9],
                    MainActivityHome.TrackCrave[10],
                    MainActivityHome.TrackCrave[11],
                    MainActivityHome.TrackCrave[12],
                    MainActivityHome.TrackCrave[13]
            };
            // Turn the above arrays into XYSeries':
            XYSeries Allowance = new SimpleXYSeries(
                    Arrays.asList(allowance),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Allowance");                             // Set the display title of the series
            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter AllowanceFORMAT = new LineAndPointFormatter();

            AllowanceFORMAT.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_2);
            plot2.addSeries(Allowance, AllowanceFORMAT);

            XYSeries Crave = new SimpleXYSeries(
                    Arrays.asList(CRAVE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Crave");
            LineAndPointFormatter CraveFORMAT = new LineAndPointFormatter(Color.BLACK, Color.BLACK, Color.BLACK, null);

            LineAndPointFormatter CRAVEFormat2 = new LineAndPointFormatter();

            CRAVEFormat2.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1);

            plot2.addSeries(Crave, CRAVEFormat2);

            // add a new series' to the xyplot:*********************************************
            XYSeries Smoke = new SimpleXYSeries(
                    Arrays.asList(SMOKE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Smoke");
            LineAndPointFormatter SMOKEFormat = new LineAndPointFormatter();

            SMOKEFormat.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_3);
            // add a new series' to the xyplot:*********************************************
            plot2.addSeries(Smoke, SMOKEFormat);


            plot2.setTicksPerRangeLabel(3);
            //Remove legend
            plot2.getLayoutManager().remove(plot2.getRangeLabelWidget());

            //set background colors
            plot2.getBackgroundPaint().setColor(Color.BLACK);
            plot2.setBorderStyle(XYPlot.BorderStyle.SQUARE, null, null);
            plot2.getGraphWidget().getBackgroundPaint().setColor(Color.BLACK);
            plot2.getGraphWidget().getGridBackgroundPaint().setColor(Color.BLACK);
            // draw a domain tick for each year:
            plot2.setDomainStep(XYStepMode.SUBDIVIDE, SMOKE.length);

            // customize our domain/range labels
            plot2.setRangeLabel("Value");

            // get rid of decimal points in the domain labels:
            plot2.setDomainValueFormat(new DecimalFormat("0"));
            plot2.setRangeValueFormat(new DecimalFormat("0"));
            // reduce the number of range labels
            //plot2.setTicksPerRangeLabel(6);
            plot2.getGraphWidget().setDomainLabelOrientation(-45);

            //7 domain ticks 6 range ticks
            plot2.setDomainStep(XYStepMode.SUBDIVIDE, 7);
            plot2.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
            plot2.setRangeStep(XYStepMode.SUBDIVIDE, 6);
            plot2.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

            //set boundaries
            plot2.setRangeBoundaries(0, 15, BoundaryMode.AUTO);
            plot2.setDomainBoundaries(7, 13, BoundaryMode.FIXED); //7->13

            // TODO Auto-generated method stub
            return rootView;//inflater.inflate(R.layout.fragment_one_layout,container,false);
        }
    }

    public static class FragmentThree extends FragmentTwo {

        private XYPlot plot3;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.gfragment_three_layout,container,false);
            // initialize our XYPlot reference:
            plot3 = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotThree);

            decrementFactor = decrementFactor + 2;
            // Create a couple arrays of y-values to plot:
            Number[] allowance = {
                    MainActivityHome.cigarSmokedPerDay,
                    MainActivityHome.cigarSmokedPerDay,
                    MainActivityHome.cigarSmokedPerDay,
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((3*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((3*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((3*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((3*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1)))
            };
            Number[] SMOKE = {
                    //86400000 in 24 hours
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackSmoke[14],
                    MainActivityHome.TrackSmoke[15],
                    MainActivityHome.TrackSmoke[16],
                    MainActivityHome.TrackSmoke[17],
                    MainActivityHome.TrackSmoke[18],
                    MainActivityHome.TrackSmoke[19],
                    MainActivityHome.TrackSmoke[20]
            };
            Number[] CRAVE = {
                    //86400000 in 24 hours
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackCrave[14],
                    MainActivityHome.TrackCrave[15],
                    MainActivityHome.TrackCrave[16],
                    MainActivityHome.TrackCrave[17],
                    MainActivityHome.TrackCrave[18],
                    MainActivityHome.TrackCrave[19],
                    MainActivityHome.TrackCrave[20]
            };
            XYSeries Allowance = new SimpleXYSeries(
                    Arrays.asList(allowance),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Allowance");                             // Set the display title of the series
            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter AllowanceFORMAT = new LineAndPointFormatter();

            AllowanceFORMAT.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_2);
            plot3.addSeries(Allowance, AllowanceFORMAT);

            XYSeries Crave = new SimpleXYSeries(
                    Arrays.asList(CRAVE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Crave");
            LineAndPointFormatter CraveFORMAT = new LineAndPointFormatter(Color.BLACK, Color.BLACK, Color.BLACK, null);
            plot3.getGraphWidget().setPaddingRight(1);


            LineAndPointFormatter CRAVEFormat2 = new LineAndPointFormatter();

            CRAVEFormat2.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1);

            plot3.addSeries(Crave, CRAVEFormat2);

            // add a new series' to the xyplot:*********************************************
            XYSeries Smoke = new SimpleXYSeries(
                    Arrays.asList(SMOKE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Smoke");
            LineAndPointFormatter SMOKEFormat = new LineAndPointFormatter();

            SMOKEFormat.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_3);
            // add a new series' to the xyplot:*********************************************
            plot3.addSeries(Smoke, SMOKEFormat);


            //plot3.setTicksPerRangeLabel(5);
            //Remove legend
            plot3.getLayoutManager().remove(plot3.getRangeLabelWidget());

            //set background colors
            plot3.getBackgroundPaint().setColor(Color.BLACK);
            plot3.setBorderStyle(XYPlot.BorderStyle.SQUARE, null, null);
            plot3.getGraphWidget().getBackgroundPaint().setColor(Color.BLACK);
            plot3.getGraphWidget().getGridBackgroundPaint().setColor(Color.BLACK);
            // draw a domain tick for each year:
            plot3.setDomainStep(XYStepMode.SUBDIVIDE, SMOKE.length);

            // customize our domain/range labels
            plot3.setRangeLabel("Value");

            // get rid of decimal points in the domain labels:
            plot3.setDomainValueFormat(new DecimalFormat("0"));
            plot3.setRangeValueFormat(new DecimalFormat("0"));
            // reduce the number of range labels
            plot3.setTicksPerRangeLabel(3);
            plot3.getGraphWidget().setDomainLabelOrientation(-45);

            //7 domain ticks 6 range ticks
            plot3.setDomainStep(XYStepMode.SUBDIVIDE, 7);
            plot3.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
            plot3.setRangeStep(XYStepMode.SUBDIVIDE, 6);
            plot3.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

            //set boundaries
            plot3.setRangeBoundaries(0, 15, BoundaryMode.AUTO);
            plot3.setDomainBoundaries(14 ,20, BoundaryMode.FIXED);
            //plot3.getGraphWidget().setMarginLeft(0);
            //plot3.getGraphWidget().getRangeLabelPaint().setColor(Color.TRANSPARENT);
            return rootView;//inflater.inflate(R.layout.fragment_three_layout,container,false);
        }

    }

    public static class FragmentFour extends FragmentThree {
        private XYPlot plot4;

        //@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.gfragment_four_layout,container,false); //inflater.inflate(R.layout.activity_main, container, false);


            // initialize our XYPlot reference:
            plot4 = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotFour);
            decrementFactor = decrementFactor + 2;

            // Create a couple arrays of y-values to plot:
            Number[] allowance = {
                    MainActivityHome.cigarSmokedPerDay,
                    MainActivityHome.cigarSmokedPerDay,
                    MainActivityHome.cigarSmokedPerDay,
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((2*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((3*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((3*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((3*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((3*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - ((3*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((3*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((3*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((4*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((4*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((4*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - ((4*MainActivityHome.cigarSmokedPerDay)/((MainActivityHome.daysInBetween2/7)+1)))}
            ;
            Number[] SMOKE = {
                    //86400000 in 24 hours
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackSmoke[21],
                    MainActivityHome.TrackSmoke[22],
                    MainActivityHome.TrackSmoke[23],
                    MainActivityHome.TrackSmoke[24],
                    MainActivityHome.TrackSmoke[25],
                    MainActivityHome.TrackSmoke[26],
                    MainActivityHome.TrackSmoke[27]
            };
            Number[] CRAVE = {
                    //86400000 in 24 hours
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackCrave[21],
                    MainActivityHome.TrackCrave[22],
                    MainActivityHome.TrackCrave[23],
                    MainActivityHome.TrackCrave[24],
                    MainActivityHome.TrackCrave[25],
                    MainActivityHome.TrackCrave[26],
                    MainActivityHome.TrackCrave[27]
            };
            //set boundaries
            plot4.setRangeBoundaries(0, 15, BoundaryMode.FIXED);
            // Turn the above arrays into XYSeries':
            XYSeries Allowance = new SimpleXYSeries(
                    Arrays.asList(allowance),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Allowance");                             // Set the display title of the series
            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter AllowanceFORMAT = new LineAndPointFormatter();

            AllowanceFORMAT.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_2);
            plot4.addSeries(Allowance, AllowanceFORMAT);

            XYSeries Crave = new SimpleXYSeries(
                    Arrays.asList(CRAVE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Crave");
            LineAndPointFormatter CraveFORMAT = new LineAndPointFormatter(Color.BLACK, Color.BLACK, Color.BLACK, null);
            plot4.getGraphWidget().setPaddingRight(1);


            LineAndPointFormatter CRAVEFormat2 = new LineAndPointFormatter();

            CRAVEFormat2.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1);

            plot4.addSeries(Crave, CRAVEFormat2);

            // add a new series' to the xyplot:*********************************************
            XYSeries Smoke = new SimpleXYSeries(
                    Arrays.asList(SMOKE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Smoke");
            LineAndPointFormatter SMOKEFormat = new LineAndPointFormatter();

            SMOKEFormat.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_3);
            // add a new series' to the xyplot:*********************************************
            plot4.addSeries(Smoke, SMOKEFormat);


            plot4.setTicksPerRangeLabel(3);
            //Remove legend
            plot4.getLayoutManager().remove(plot4.getRangeLabelWidget());

            //set background colors
            plot4.getBackgroundPaint().setColor(Color.BLACK);
            plot4.setBorderStyle(XYPlot.BorderStyle.SQUARE, null, null);
            plot4.getGraphWidget().getBackgroundPaint().setColor(Color.BLACK);
            plot4.getGraphWidget().getGridBackgroundPaint().setColor(Color.BLACK);
            // draw a domain tick for each year:
            plot4.setDomainStep(XYStepMode.SUBDIVIDE, SMOKE.length);

            // customize our domain/range labels
            plot4.setRangeLabel("Value");

            // get rid of decimal points in the domain labels:
            plot4.setDomainValueFormat(new DecimalFormat("0"));
            plot4.setRangeValueFormat(new DecimalFormat("0"));
            // reduce the number of range labels
            //plot4.setTicksPerRangeLabel(6);
            plot4.getGraphWidget().setDomainLabelOrientation(-45);

            //7 domain ticks 6 range ticks
            plot4.setDomainStep(XYStepMode.SUBDIVIDE, 7);
            plot4.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
            plot4.setRangeStep(XYStepMode.SUBDIVIDE, 6);
            plot4.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

            //set boundaries
            plot4.setRangeBoundaries(0, 15, BoundaryMode.AUTO);
            plot4.setDomainBoundaries(21, 27, BoundaryMode.FIXED);

            return rootView;//inflater.inflate(R.layout.fragment_one_layout,container,false);
        }
    }

    public static class FragmentFive extends FragmentFour {
        private XYPlot plot5;

        //@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.gfragment_five_layout,container,false); //inflater.inflate(R.layout.activity_main, container, false);

            // initialize our XYPlot reference:
            plot5 = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotFive);
            decrementFactor = decrementFactor + 2;

            /*if(MainActivityHome.daysInBetween2 == 0){
                Number[] allowance = {0,0,0,0,0,0,0
                };*/
            // Create a couple arrays of y-values to plot:
            Number[] allowance = {
                    MainActivityHome.cigarSmokedPerDay,
                    MainActivityHome.cigarSmokedPerDay,
                    MainActivityHome.cigarSmokedPerDay,
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (5*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (5*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (5*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (5*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1)))};


                    Number[] SMOKE = {
                    //86400000 in 24 hours
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackSmoke[28],
                    MainActivityHome.TrackSmoke[29],
                    MainActivityHome.TrackSmoke[30],
                    MainActivityHome.TrackSmoke[31],
                    MainActivityHome.TrackSmoke[32],
                    MainActivityHome.TrackSmoke[33],
                    MainActivityHome.TrackSmoke[34]
            };
            Number[] CRAVE = {
                    //86400000 in 24 hours
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackCrave[28],
                    MainActivityHome.TrackCrave[29],
                    MainActivityHome.TrackCrave[30],
                    MainActivityHome.TrackCrave[31],
                    MainActivityHome.TrackCrave[32],
                    MainActivityHome.TrackCrave[33],
                    MainActivityHome.TrackCrave[34]
            };
            //set boundaries
            plot5.setRangeBoundaries(0, 15, BoundaryMode.FIXED);
            // Turn the above arrays into XYSeries':
            XYSeries Allowance = new SimpleXYSeries(
                    Arrays.asList(allowance),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Allowance");                             // Set the display title of the series
            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter AllowanceFORMAT = new LineAndPointFormatter();

            AllowanceFORMAT.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_2);
            plot5.addSeries(Allowance, AllowanceFORMAT);

            XYSeries Crave = new SimpleXYSeries(
                    Arrays.asList(CRAVE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Crave");
            LineAndPointFormatter CraveFORMAT = new LineAndPointFormatter(Color.BLACK, Color.BLACK, Color.BLACK, null);
            plot5.getGraphWidget().setPaddingRight(1);


            LineAndPointFormatter CRAVEFormat2 = new LineAndPointFormatter();

            CRAVEFormat2.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1);

            plot5.addSeries(Crave, CRAVEFormat2);

            // add a new series' to the xyplot:*********************************************
            XYSeries Smoke = new SimpleXYSeries(
                    Arrays.asList(SMOKE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Smoke");
            LineAndPointFormatter SMOKEFormat = new LineAndPointFormatter();

            SMOKEFormat.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_3);
            // add a new series' to the xyplot:*********************************************
            plot5.addSeries(Smoke, SMOKEFormat);


            plot5.setTicksPerRangeLabel(3);
            //Remove legend
            plot5.getLayoutManager().remove(plot5.getRangeLabelWidget());

            //set background colors
            plot5.getBackgroundPaint().setColor(Color.BLACK);
            plot5.setBorderStyle(XYPlot.BorderStyle.SQUARE, null, null);
            plot5.getGraphWidget().getBackgroundPaint().setColor(Color.BLACK);
            plot5.getGraphWidget().getGridBackgroundPaint().setColor(Color.BLACK);
            // draw a domain tick for each year:
            plot5.setDomainStep(XYStepMode.SUBDIVIDE, SMOKE.length);

            // customize our domain/range labels
            plot5.setRangeLabel("Value");

            // get rid of decimal points in the domain labels:
            plot5.setDomainValueFormat(new DecimalFormat("0"));
            plot5.setRangeValueFormat(new DecimalFormat("0"));
            // reduce the number of range labels
            //plot5.setTicksPerRangeLabel(6);
            plot5.getGraphWidget().setDomainLabelOrientation(-45);

            //7 domain ticks 6 range ticks
            plot5.setDomainStep(XYStepMode.SUBDIVIDE, 7);
            plot5.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
            plot5.setRangeStep(XYStepMode.SUBDIVIDE, 6);
            plot5.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

            //set boundaries
            plot5.setRangeBoundaries(0, 15, BoundaryMode.AUTO);
            plot5.setDomainBoundaries(28, 34, BoundaryMode.FIXED);

            return rootView;//inflater.inflate(R.layout.fragment_one_layout,container,false);
        }


    }

    public static class FragmentSix extends FragmentFive{
        private XYPlot plot6;

        //@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.gfragment_six_layout,container,false); //inflater.inflate(R.layout.activity_main, container, false);


            // initialize our XYPlot reference:
            plot6 = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotSix);
            Number[] allowance = {
                    MainActivityHome.cigarSmokedPerDay,
                    MainActivityHome.cigarSmokedPerDay,
                    MainActivityHome.cigarSmokedPerDay,
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (2*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (3*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),

                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (4*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (5*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (5*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (5*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (5*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),


                    (MainActivityHome.cigarSmokedPerDay - (5*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (5*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (5*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (6*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (6*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (6*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1))),
                    (MainActivityHome.cigarSmokedPerDay - (6*MainActivityHome.cigarSmokedPerDay/((MainActivityHome.daysInBetween2/7)+1)))};

            // Turn the above arrays into XYSeries':
            XYSeries Allowance = new SimpleXYSeries(
                    Arrays.asList(allowance),          // SimpleXYSeries takes a List so turn our array into a List
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Allowance");                             // Set the display title of the series
            // Create a formatter to use for drawing a series using LineAndPointRenderer
            // and configure it from xml:
            LineAndPointFormatter AllowanceFORMAT = new LineAndPointFormatter();

            AllowanceFORMAT.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_2);
            plot6.addSeries(Allowance, AllowanceFORMAT);
            // Create a couple arrays of y-values to plot:
            Number[] SMOKE = {
                    //86400000 in 24 hours
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackSmoke[35],
                    MainActivityHome.TrackSmoke[36],
                    MainActivityHome.TrackSmoke[37],
                    MainActivityHome.TrackSmoke[38],
                    MainActivityHome.TrackSmoke[39],
                    MainActivityHome.TrackSmoke[40],
                    MainActivityHome.TrackSmoke[41]
            };
            Number[] CRAVE = {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackCrave[35],
                    MainActivityHome.TrackCrave[36],
                    MainActivityHome.TrackCrave[37],
                    MainActivityHome.TrackCrave[38],
                    MainActivityHome.TrackCrave[39],
                    MainActivityHome.TrackCrave[40],
                    MainActivityHome.TrackCrave[41]
            };
            //set boundaries
            plot6.setRangeBoundaries(0, 15, BoundaryMode.FIXED);
            // Turn the above arrays into XYSeries':

            XYSeries Crave = new SimpleXYSeries(
                    Arrays.asList(CRAVE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Crave");
            LineAndPointFormatter CraveFORMAT = new LineAndPointFormatter(Color.BLACK, Color.BLACK, Color.BLACK, null);
            plot6.getGraphWidget().setPaddingRight(1);


            LineAndPointFormatter CRAVEFormat2 = new LineAndPointFormatter();

            CRAVEFormat2.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1);

            plot6.addSeries(Crave, CRAVEFormat2);

            // add a new series' to the xyplot:*********************************************
            XYSeries Smoke = new SimpleXYSeries(
                    Arrays.asList(SMOKE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Smoke");
            LineAndPointFormatter SMOKEFormat = new LineAndPointFormatter();

            SMOKEFormat.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_3);
            // add a new series' to the xyplot:*********************************************
            plot6.addSeries(Smoke, SMOKEFormat);


            plot6.setTicksPerRangeLabel(3);
            //Remove legend
            plot6.getLayoutManager().remove(plot6.getRangeLabelWidget());

            //set background colors
            plot6.getBackgroundPaint().setColor(Color.BLACK);
            plot6.setBorderStyle(XYPlot.BorderStyle.SQUARE, null, null);
            plot6.getGraphWidget().getBackgroundPaint().setColor(Color.BLACK);
            plot6.getGraphWidget().getGridBackgroundPaint().setColor(Color.BLACK);
            // draw a domain tick for each year:
            plot6.setDomainStep(XYStepMode.SUBDIVIDE, SMOKE.length);

            // customize our domain/range labels
            plot6.setRangeLabel("Value");

            // get rid of decimal points in the domain labels:
            plot6.setDomainValueFormat(new DecimalFormat("0"));
            plot6.setRangeValueFormat(new DecimalFormat("0"));
            // reduce the number of range labels
            //plot6.setTicksPerRangeLabel(6);
            plot6.getGraphWidget().setDomainLabelOrientation(-45);

            //7 domain ticks 6 range ticks
            plot6.setDomainStep(XYStepMode.SUBDIVIDE, 7);
            plot6.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
            plot6.setRangeStep(XYStepMode.SUBDIVIDE, 6);
            plot6.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

            //set boundaries
            plot6.setRangeBoundaries(0, 15, BoundaryMode.AUTO);
            plot6.setDomainBoundaries(35, 41, BoundaryMode.FIXED);

            return rootView;//inflater.inflate(R.layout.fragment_one_layout,container,false);
        }


    }

    public static class FragmentSeven extends FragmentSix{
        private XYPlot plot;

        //@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.gfragment_seven_layout,container,false); //inflater.inflate(R.layout.activity_main, container, false);


            // initialize our XYPlot reference:
            plot = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotSeven);

            // Create a couple arrays of y-values to plot:
            Number[] SMOKE = {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackSmoke[42],
                    MainActivityHome.TrackSmoke[43],
                    MainActivityHome.TrackSmoke[44],
                    MainActivityHome.TrackSmoke[45],
                    MainActivityHome.TrackSmoke[46],
                    MainActivityHome.TrackSmoke[47],
                    MainActivityHome.TrackSmoke[48]
            };
            Number[] CRAVE = {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackCrave[42],
                    MainActivityHome.TrackCrave[43],
                    MainActivityHome.TrackCrave[44],
                    MainActivityHome.TrackCrave[45],
                    MainActivityHome.TrackCrave[46],
                    MainActivityHome.TrackCrave[47],
                    MainActivityHome.TrackCrave[48]
            };
            //set boundaries
            plot.setRangeBoundaries(0, 15, BoundaryMode.FIXED);
            // Turn the above arrays into XYSeries':

            XYSeries Crave = new SimpleXYSeries(
                    Arrays.asList(CRAVE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Crave");
            LineAndPointFormatter CraveFORMAT = new LineAndPointFormatter(Color.BLACK, Color.BLACK, Color.BLACK, null);
            plot.getGraphWidget().setPaddingRight(1);


            LineAndPointFormatter CRAVEFormat2 = new LineAndPointFormatter();

            CRAVEFormat2.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1);

            plot.addSeries(Crave, CRAVEFormat2);

            // add a new series' to the xyplot:*********************************************
            XYSeries Smoke = new SimpleXYSeries(
                    Arrays.asList(SMOKE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Smoke");
            LineAndPointFormatter SMOKEFormat = new LineAndPointFormatter();

            SMOKEFormat.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_3);
            // add a new series' to the xyplot:*********************************************
            plot.addSeries(Smoke, SMOKEFormat);


            plot.setTicksPerRangeLabel(3);
            //Remove legend
            plot.getLayoutManager().remove(plot.getRangeLabelWidget());

            //set background colors
            plot.getBackgroundPaint().setColor(Color.BLACK);
            plot.setBorderStyle(XYPlot.BorderStyle.SQUARE, null, null);
            plot.getGraphWidget().getBackgroundPaint().setColor(Color.BLACK);
            plot.getGraphWidget().getGridBackgroundPaint().setColor(Color.BLACK);
            // draw a domain tick for each year:
            plot.setDomainStep(XYStepMode.SUBDIVIDE, SMOKE.length);

            // customize our domain/range labels
            plot.setRangeLabel("Value");

            // get rid of decimal points in the domain labels:
            plot.setDomainValueFormat(new DecimalFormat("0"));
            plot.setRangeValueFormat(new DecimalFormat("0"));
            // reduce the number of range labels
            //plot6.setTicksPerRangeLabel(6);
            plot.getGraphWidget().setDomainLabelOrientation(-45);

            //7 domain ticks 6 range ticks
            plot.setDomainStep(XYStepMode.SUBDIVIDE, 7);
            plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
            plot.setRangeStep(XYStepMode.SUBDIVIDE, 6);
            plot.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

            //set boundaries
            plot.setRangeBoundaries(0, 15, BoundaryMode.AUTO);
            plot.setDomainBoundaries(42, 48, BoundaryMode.FIXED);
            //this.getGraphWidget().setDomainValueFormat(new GraphXLabelFormat());
            return rootView;//inflater.inflate(R.layout.fragment_one_layout,container,false);
        }
    }

    public static class FragmentEight extends FragmentSeven{
        private XYPlot plot;

        //@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.gfragment_eight_layout,container,false); //inflater.inflate(R.layout.activity_main, container, false);


            // initialize our XYPlot reference:
            plot = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlotEight);

            // Create a couple arrays of y-values to plot:
            Number[] SMOKE = {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackSmoke[49],
                    MainActivityHome.TrackSmoke[50],
                    MainActivityHome.TrackSmoke[51],
                    MainActivityHome.TrackSmoke[52],
                    MainActivityHome.TrackSmoke[53],
                    MainActivityHome.TrackSmoke[54],
                    MainActivityHome.TrackSmoke[55]
            };
            Number[] CRAVE = {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    MainActivityHome.TrackCrave[49],
                    MainActivityHome.TrackCrave[50],
                    MainActivityHome.TrackCrave[51],
                    MainActivityHome.TrackCrave[52],
                    MainActivityHome.TrackCrave[53],
                    MainActivityHome.TrackCrave[54],
                    MainActivityHome.TrackCrave[55]
            };
            //set boundaries
            plot.setRangeBoundaries(0, 15, BoundaryMode.FIXED);
            // Turn the above arrays into XYSeries':

            XYSeries Crave = new SimpleXYSeries(
                    Arrays.asList(CRAVE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Crave");
            LineAndPointFormatter CraveFORMAT = new LineAndPointFormatter(Color.BLACK, Color.BLACK, Color.BLACK, null);
            plot.getGraphWidget().setPaddingRight(1);


            LineAndPointFormatter CRAVEFormat2 = new LineAndPointFormatter();

            CRAVEFormat2.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1);

            plot.addSeries(Crave, CRAVEFormat2);

            // add a new series' to the xyplot:*********************************************
            XYSeries Smoke = new SimpleXYSeries(
                    Arrays.asList(SMOKE),          // SimpleXYSeries takes a List so turn our array into a List
                    //Arrays.asList(allowance),
                    SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                    "Smoke");
            LineAndPointFormatter SMOKEFormat = new LineAndPointFormatter();

            SMOKEFormat.configure(container.getContext(),
                    R.xml.line_point_formatter_with_plf1_3);
            // add a new series' to the xyplot:*********************************************
            plot.addSeries(Smoke, SMOKEFormat);


            plot.setTicksPerRangeLabel(3);
            //Remove legend
            plot.getLayoutManager().remove(plot.getRangeLabelWidget());

            //set background colors
            plot.getBackgroundPaint().setColor(Color.BLACK);
            plot.setBorderStyle(XYPlot.BorderStyle.SQUARE, null, null);
            plot.getGraphWidget().getBackgroundPaint().setColor(Color.BLACK);
            plot.getGraphWidget().getGridBackgroundPaint().setColor(Color.BLACK);
            // draw a domain tick for each year:
            plot.setDomainStep(XYStepMode.SUBDIVIDE, SMOKE.length);

            // customize our domain/range labels
            plot.setRangeLabel("Value");

            // get rid of decimal points in the domain labels:
            plot.setDomainValueFormat(new DecimalFormat("0"));
            plot.setRangeValueFormat(new DecimalFormat("0"));
            // reduce the number of range labels
            //plot6.setTicksPerRangeLabel(6);
            plot.getGraphWidget().setDomainLabelOrientation(-45);

            //7 domain ticks 6 range ticks
            plot.setDomainStep(XYStepMode.SUBDIVIDE, 7);
            plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);
            plot.setRangeStep(XYStepMode.SUBDIVIDE, 6);
            plot.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);

            //set boundaries
            plot.setRangeBoundaries(0, 15, BoundaryMode.AUTO);
            plot.setDomainBoundaries(49, 55, BoundaryMode.FIXED);

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
