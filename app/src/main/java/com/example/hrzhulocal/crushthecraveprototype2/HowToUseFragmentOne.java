package com.example.hrzhulocal.crushthecraveprototype2;


/**
 * Created by hrzhulocal on 26/05/2015.
 * This is the first slide of swipeView to be implemented for the How to Use section in the More tab
 */
import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

public class HowToUseFragmentOne extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.fragment_one_layout,container,false);
    }

    public static class FragmentTwo extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            return inflater.inflate(R.layout.fragment_two_layout,container,false);
        }
    }
    /**
     * Created by hrzhulocal on 26/05/2015.
     */
    public static class FragmentThree extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            return inflater.inflate(R.layout.fragment_three_layout,container,false);
        }
    }

    public static class FragmentFour extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            return inflater.inflate(R.layout.fragment_four_layout,container,false);
        }
    }

    public static class FragmentFive extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            return inflater.inflate(R.layout.fragment_five_layout,container,false);
        }
    }

    public static class FragmentSix extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            return inflater.inflate(R.layout.fragment_six_layout,container,false);
        }
    }

    public static class FragmentSeven extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            return inflater.inflate(R.layout.fragment_seven_layout,container,false);
        }
    }

    public static class FragmentEight extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            return inflater.inflate(R.layout.fragment_eight_layout, container, false);
        }
    }

    public static class FragmentNine extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            return inflater.inflate(R.layout.fragment_nine_layout,container,false);
        }

    }
}

