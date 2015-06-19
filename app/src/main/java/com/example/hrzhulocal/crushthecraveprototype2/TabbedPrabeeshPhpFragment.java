package com.example.hrzhulocal.crushthecraveprototype2;

/**
 * Created by hrzhulocal on 17/06/2015.
 */
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYStepMode;

import java.util.Arrays;

public
class TabbedPrabeeshPhpFragment extends Fragment {
    ActionBar actionbar;
    ViewPager viewpager;
    FragmentPageAdapter ft;
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        return inflater.inflate(R.layout.prabeesh_graph_two, container, false);
    }

}
