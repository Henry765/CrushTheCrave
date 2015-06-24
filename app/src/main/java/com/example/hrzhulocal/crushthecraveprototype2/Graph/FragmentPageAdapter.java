package com.example.hrzhulocal.crushthecraveprototype2.Graph;

/**
 * Created by hrzhulocal on 17/06/2015.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentPageAdapter extends FragmentPagerAdapter {
    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem (int arg0) {
        // TODO Auto-generated method stub
        switch (arg0) {
            case 0:
                return new TabbedPrabeeshJavaFragment();
            case 1:
                return new TabbedPrabeeshPhpFragment();
            case 2:
                return new TabbedPrabeeshDotNetFragment();
            default:
                break;
        }
        return null;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3;
    }
}