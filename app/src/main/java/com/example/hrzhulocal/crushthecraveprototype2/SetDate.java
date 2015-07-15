package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import android.app.AlertDialog;

import com.example.hrzhulocal.crushthecraveprototype2.Graph.MainActivity;


public class SetDate extends MainActivityHome {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_date);

        //TextView textView = (TextView) findViewById(R.id.textView41);

        if(quitDayNum6 == -1) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);
            // set title
            alertDialogBuilder.setTitle(" Do you want to add a brand new quit day?");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Our evidence suggest that setting a quit date in the next 2-6 weeks is the way to go.")
                    .setCancelable(false)
                    .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, close
                            // current activity
                            //save quitDayNum6 value
                            Calendar quitDay = Calendar.getInstance();
                            quitDayNum6 = quitDay.getTimeInMillis();
                            SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putLong("QUITDAYNUM6", quitDayNum6);
                            editor.commit();
                            Toast.makeText(context, "quitDayNum6 before: " + quitDayNum6, Toast.LENGTH_LONG).show();
                            TextView textView1 = (TextView) findViewById(R.id.textView41);

                            textView1.setText("quitDayNum6" + quitDayNum6);
                        }
                    })
                    .setNegativeButton("No",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();

        }
        else{
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set title
            alertDialogBuilder.setTitle("You already set a quit day.");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Do you want to update and add a new quit day?")
                    .setCancelable(false)
                    .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, close
                            // current activity
                            Calendar quitDay = Calendar.getInstance();
                            quitDayNum6 = quitDay.getTimeInMillis();
                            SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putLong("QUITDAYNUM6", quitDayNum6);
                            editor.commit();
                            Toast.makeText(context, "quitDayNum6 before: " + quitDayNum6, Toast.LENGTH_LONG).show();
                            TextView textView = (TextView) findViewById(R.id.textView41);

                            textView.setText("quitDayNum6" + quitDayNum6);

                        }
                    })
                    .setNegativeButton("No",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }
        Toast.makeText(context, "quitDayNum6 after: " + quitDayNum6, Toast.LENGTH_LONG).show();
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
