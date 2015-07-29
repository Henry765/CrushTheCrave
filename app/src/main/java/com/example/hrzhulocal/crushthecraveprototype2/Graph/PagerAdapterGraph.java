package com.example.hrzhulocal.crushthecraveprototype2.Graph;

/**
 * Created by hrzhulocal on 23/06/2015.
 */
import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapterGraph extends FragmentPagerAdapter {

    public PagerAdapterGraph(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        switch (arg0) {
            case 0:
                return new com.example.hrzhulocal.crushthecraveprototype2.MyProgress();
            case 1:
                return new com.example.hrzhulocal.crushthecraveprototype2.MyProgress.FragmentTwo();
            case 2:
                return new com.example.hrzhulocal.crushthecraveprototype2.MyProgress.FragmentThree();
            case 3:
                return new com.example.hrzhulocal.crushthecraveprototype2.MyProgress.FragmentFour();
            case 4:
                return new com.example.hrzhulocal.crushthecraveprototype2.MyProgress.FragmentFive();
            case 5:
                return new com.example.hrzhulocal.crushthecraveprototype2.MyProgress.FragmentSix();
            case 6:
                return new com.example.hrzhulocal.crushthecraveprototype2.MyProgress.FragmentSeven();
            case 7:
                return new com.example.hrzhulocal.crushthecraveprototype2.MyProgress.FragmentEight();

            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 8;
    }
}
