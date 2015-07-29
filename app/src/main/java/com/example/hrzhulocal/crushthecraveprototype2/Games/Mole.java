/*package com.example.hrzhulocal.crushthecraveprototype2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Mole extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mole);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mole, menu);
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


import com.example.hrzhulocal.crushthecraveprototype2.R;

public class Mole {

    private Integer talpa;
    private Integer farfalla;
    private Integer cigarette;

    public Mole() {

        talpa = R.drawable.talpa;
        farfalla = R.drawable.farfalla;
        cigarette = R.drawable.cigarette;
    }

    public Integer getTalpa() {

        return talpa;
    }

    public Integer getFarfalla() {

        return farfalla;
    }

    public Integer getCigarette() {

        return cigarette;
    }

}
