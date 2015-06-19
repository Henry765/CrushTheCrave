package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class SetDate extends MainActivityHome {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_date);

        TextView textView = (TextView) findViewById(R.id.textView41);


        if(quitDayNum6 == -1) {
            Calendar quitDay = Calendar.getInstance();
            quitDayNum6 = quitDay.getTimeInMillis();
            SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putLong("QUITDAYNUM6", quitDayNum6);
            editor.commit();

        }
        Toast.makeText(context, "quitDayNum6: " + quitDayNum6, Toast.LENGTH_LONG).show();
        textView.setText("quitDayNum6"+quitDayNum6);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set_date, menu);
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
