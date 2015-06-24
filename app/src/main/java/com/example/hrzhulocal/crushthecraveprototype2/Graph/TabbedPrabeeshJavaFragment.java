package com.example.hrzhulocal.crushthecraveprototype2.Graph;

/**
 * Created by hrzhulocal on 17/06/2015.
 */
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hrzhulocal.crushthecraveprototype2.Graph.FragmentPageAdapter;
import com.example.hrzhulocal.crushthecraveprototype2.R;

import static com.example.hrzhulocal.crushthecraveprototype2.R.layout.activity_my__progress_activity3;
//import static com.example.hrzhulocal.crushthecraveprototype2.R.layout.prabeesh_graph_one;

public class TabbedPrabeeshJavaFragment extends Fragment{
    ActionBar actionbar;
    ViewPager viewpager;
    FragmentPageAdapter ft;
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        return inflater.inflate(R.layout.activity_graph_fragment_one, container,false);
    }
}
