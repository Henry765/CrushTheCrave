package com.example.hrzhulocal.crushthecraveprototype2;

/**
 * Created by hrzhulocal on 11/06/2015.
 */

import android.app.Activity;
import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentPagerAdapter;

import com.androidplot.xy.XYPlot;

import java.util.List;

//public class GraphPageAdapater extends FragmentPagerAdapter {
public class GraphPageAdapater extends Activity {

    /*public GraphPageAdapater(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int arg0) {

        // TODO Auto-generated method stub
        //switch (arg0) {
           // case 0:
                //return new GraphFragmentOne();
            //case 1:
                //return new GraphFragmentTwo();
          //  case 2:
                //return new GraphFragmentThree();
       //     default:
       //         break;
      //  }
        return null;
    }*/

    //@Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3;
    }

    /*private List<Fragment> fragments;

    public GraphPageAdapater(FragmentManager fm, List<Fragment> fragments) {
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
    }*/

}
