package com.example.hrzhulocal.androidplot;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYStepMode;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends ActionBarActivity {
    private XYPlot plot;
    ArrayList <Double> Vector = new ArrayList<Double>();
    public double DataX, DataY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plot = (XYPlot) findViewById(R.id.androidplot);
        plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 0.5);
        plot.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 1);
        plot.getGraphWidget().getGridBackgroundPaint().setColor(Color.rgb(0, 0, 0));
        plot.getGraphWidget().getDomainGridLinePaint().setColor(Color.rgb(255, 0, 0));
        plot.getGraphWidget().getRangeGridLinePaint().setColor(Color.rgb(255, 0, 0));
        plot.setRangeBoundaries(0, 5, BoundaryMode.FIXED);

        for(int i = 0; i <= 20; i++){
            DataX = DataX + 0.5;
            Vector.add(DataX);
            DataY = Math.random()*5;
            Vector.add(DataY);
        }
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Refrescar();
            }
            }, 0, 150);

        XYSeries series = new SimpleXYSeries(Vector, SimpleXYSeries.ArrayFormat.XY_VALS_INTERLEAVED, "hack");
        LineAndPointFormatter seriesFormat = new LineAndPointFormatter(Color.rgb( 255, 255,255),0,0,null );
        plot.clear();
        plot.addSeries(series, seriesFormat);
    }

    private void Refrescar(){
        this.runOnUiThread(Graf);
    }
    private Runnable Graf = new Runnable(){
        public void run() {

            DataX = DataX + 0.5;
            Vector.remove(0);
            Vector.add(DataX);
            DataY = Math.random()*5;
            Vector.remove(0);

            Vector.add(DataY);

            XYSeries series = new SimpleXYSeries(Vector, SimpleXYSeries.ArrayFormat.XY_VALS_INTERLEAVED, "hack");
            LineAndPointFormatter seriesFormat = new LineAndPointFormatter(Color.rgb( 255, 255,255),0,0,null );
            plot.clear();
            plot.addSeries(series, seriesFormat);
        }

    };
}
