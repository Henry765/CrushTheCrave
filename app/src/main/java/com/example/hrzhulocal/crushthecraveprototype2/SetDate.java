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
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import android.app.AlertDialog;

import com.example.hrzhulocal.crushthecraveprototype2.Graph.MainActivity;


public class SetDate extends MainActivityHome {
    public static int days;
    public static int hours;
    public static int minutes;
    public static int seconds;
    public static int temp;

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
                            SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();


                            //set the value into a HashSet
                            arrayListQuitNow.add(quitDay.getTimeInMillis());
                            Set<String> set = new HashSet<String>();
                            set.addAll(arrayListQuitNow);
                            editor.putStringSet("ArrayListkey", set);
                            editor.commit();

                            quitDayNum6 = quitDay.getTimeInMillis();
                            editor.putLong("QUITDAYNUM6", quitDayNum6);
                            editor.commit();
                            Toast.makeText(context, "quitDayNum6 before: " + quitDayNum6, Toast.LENGTH_LONG).show();
                            TextView textView1 = (TextView) findViewById(R.id.textView41);
                            //http://stackoverflow.com/questions/625433/how-to-convert-milliseconds-to-x-mins-x-seconds-in-java
                            String.format("%d day, %d hour, %d min, %d sec",
                                    TimeUnit.MILLISECONDS.toDays(quitDayNum6),
                                    TimeUnit.MILLISECONDS.toHours(quitDayNum6) -
                                    TimeUnit.MILLISECONDS.toMinutes(quitDayNum6) -
                                    TimeUnit.MILLISECONDS.toSeconds(quitDayNum6) -
                                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(quitDayNum6))
                            );

                                    textView1.setText("quitDayNum6" + quitDayNum6 + "\n" + days + "\n" + hours + "\n" + minutes + "\n" + seconds);
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
        // else if user had already set at least one quit date
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
                            SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();

                            //set the value into a HashSet
                            arrayListQuitNow.add(quitDay.getTimeInMillis());
                            /*Set<String> set = new HashSet<String>();
                            set.addAll(arrayListQuitNow);
                            editor.putStringSet("ArrayListkey", set);
                            editor.commit();*/


                            quitDayNum6 = quitDay.getTimeInMillis();
                            editor.putLong("QUITDAYNUM6", quitDayNum6);
                            editor.commit();
                            Toast.makeText(context, "quitDayNum6 before: " + quitDayNum6, Toast.LENGTH_LONG).show();
                            TextView textView = (TextView) findViewById(R.id.textView41);

                            textView.setText("quitDayNum6: " + quitDayNum6 + "arrayList\n"+arrayListQuitNow);

                            textView.setText("quitDayNum6" + quitDayNum6+"\n"+days+"\n"+hours+"\n"+minutes+"\n"+seconds);

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

        addListenerOnAwardImageButton();
        addListenerOnAwardImageButton();
        addListenerOnHomeImageButton();
        addListenerOnMoreImageButton();
        addListenerOnProgressImageButton();
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
