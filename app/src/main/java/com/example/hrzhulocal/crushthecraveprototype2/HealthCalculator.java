package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

// was like public class HealthCalculator extends ActionBarActivity {
public class HealthCalculator extends MainActivityHome {

    //Typically assume 18 milligram of tar per cigarette
    final static int tarPerCigar = 18;
    //Assume there are 365 days in a year
    final static int daysInAYear = 365;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_calculator);

        TextView myStatus = (TextView) findViewById(R.id.textView16);

        //make sure money is in two decimal places
        NumberFormat formatter = new DecimalFormat("#0.00");

        //assume you did not smoke after you set quit day - number of smoke's cost
        //moneySavedTotal = ((daysInBetween - daysInBetween2) * theNumberOfCrave * (costPerPack / numberOfCigarPerPack))-((daysInBetween - daysInBetween2)*theNumberOfSmokeTotal*(costPerPack/numberOfCigarPerPack));
        //Matthew's formula
        //(this is checked off when you calculate the cost per cigarette based on the values entered in the registration form.
        // Multiply the cost per cigarettes by the number of cigarettes not smoked determined for the above reward when this value is greater than or equal to $ X dolloars

        moneySavedTotal = (costPerPack / numberOfCigarPerPack) * theNumberOfCrave;
        myStatus.setTextSize(17);
        myStatus.setText("Number of days smoke-free:  " + smokeFreeDay + " day(s)"
                +"\nTar from cigarettes crushed:  " + (tarPerCigar*theNumberOfCrave)+" milligram(s)"
                +"\nMoney saved so far:  $"+ formatter.format(moneySavedTotal)
                +"\nMoney on track to save this year:  $"+ formatter.format(((double) (daysInAYear* (moneySavedTotal / daysInBetween ))))     // use ratio to estimate the money saved this year
                +"\nTotal number of cravings:  " + theNumberOfCrave
                +"\nTotal number of slips/smoke:  " + theNumberOfSmokeTotal    //theNumberOfSmokeTotal can change thus it added endfix Total
                );
        myStatus.refreshDrawableState();

        addListenerOnHomeImageButton();
        addListenerOnAwardImageButton();
        addListenerOnProgressImageButton();
        addListenerOnQuitHelpImageButton();
        addListenerOnMoreImageButton();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_health_calculator, menu);
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
}
