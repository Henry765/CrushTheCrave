package com.example.hrzhulocal.crushthecraveprototype2;


/**
 * Created by hrzhulocal on 26/05/2015.
 * Created for How to Use tab
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }
    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        switch (arg0) {
            case 0:
                return new HowToUseFragmentOne();
            case 1:
                return new HowToUseFragmentOne.FragmentTwo();
            case 2:
                return new HowToUseFragmentOne.FragmentThree();
            case 3:
                return new HowToUseFragmentOne.FragmentFour();
            case 4:
                return new HowToUseFragmentOne.FragmentFive();
            case 5:
                return new HowToUseFragmentOne.FragmentSix();
            case 6:
                return new HowToUseFragmentOne.FragmentSeven();
            case 7:
                return new HowToUseFragmentOne.FragmentEight();
            case 8:
                return new HowToUseFragmentOne.FragmentNine();

            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 9;
    }


}
