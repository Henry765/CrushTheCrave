/*package com.example.hrzhulocal.crushthecraveprototype2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Credits extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_credits, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}*/

//package slt.lmb;
package com.example.hrzhulocal.crushthecraveprototype2;

import android.app.Activity;
import android.os.Bundle;

/************************************************************************************************************************
 *
 * Programmer: Henry Zhu, Computer Eng 2019
 * University Of Waterloo, Faculty of Applied Health Sciences, Propel Centre For Population Health Impact
 * Acknowledgement:
 *
 * Supported by Matt VanderMeer
 * Jeff Luo, PhD student and Teaching Assistant
 * Osama Tariq, Software Eng 2018
 * The Mini Game of Whack a Mole is released under GNU GPL v2 License from http://whack-a-mole-android.googlecode.com/svn/
 * Coded and designed by Lorenzo Lambertini  contact: lorenzo.lambertini@gmail.coms
 * Modified by Henry Zhu contact hrzhu@uwaterloo.ca
 *
 ************************************************************************************************************************/

public class Credits extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);

    }
}