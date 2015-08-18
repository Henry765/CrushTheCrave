package com.example.hrzhulocal.crushthecraveprototype2.Graph;

/**
 * Created by hrzhulocal on 23/06/2015.
 */
import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hrzhulocal.crushthecraveprototype2.MainActivityHome;
import com.example.hrzhulocal.crushthecraveprototype2.MyProgress;

import static android.app.PendingIntent.getActivity;

public class PagerAdapterGraph extends FragmentPagerAdapter {

    MainActivityHome MAH;
    int theNumberOfFragment = 0;

    public PagerAdapterGraph(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
        final MyProgress.FragmentThree f3 = new MyProgress.FragmentThree();
    }
    @Override
    public Fragment getItem(int theNumberOfFragment) {
        // TODO Auto-generated method stub

        switch (theNumberOfFragment) {
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
    //This method dynamically adjust the number of fragment
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        /*for(int i = 0; (MAH.daysInBetween - MAH.daysInBetween2) >= i; i++){
            //get the quotient
            theNumberOfFragment = (i/7);
        }

        MainActivityHome mah = new MainActivityHome();
        //if user did not set a quit day yet
        if(mah.arrayListQuitNow == null)
        {
            theNumberOfFragment = 1;
        }
        return (theNumberOfFragment + 1);*/

        if(MAH.daysInBetween2 == 0 || MAH.daysInBetween2 == 7){
            return 1;
        }
        else {
            for (int i = 0; i <= MAH.daysInBetween2; i++) {
                theNumberOfFragment = i / 7;
            }
            return (theNumberOfFragment + 1);
        }
    }
    /**
     * Created by hrzhulocal on 23/06/2015.
     * helper class to the PagerAdapterGraph class
     */
    public static class PagerAdapterInherits extends PagerAdapterGraph {
        public PagerAdapterInherits(FragmentManager fm) {
            super(fm);
        }
    }
}
