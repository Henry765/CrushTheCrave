package com.example.hrzhulocal.crushthecraveprototype2;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.content.Intent;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.androidplot.xy.XYPlot;
import com.facebook.appevents.AppEventsLogger;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class MainActivityHome extends ActionBarActivity {
//public class MainActivityHome extends MyPersonalization {
    Button button;
    ImageButton imageButton;

    public static int isFirstTime5 = 1;
    long startDayNum = -1;
    long startDayNum6 = -1;
    long quitDayNum = -1;
    long quitDayNum6 = -1;
    long daysInBetween = 0;
    long daysInBetween2 = 0;
    int moneySaved = 0;

    long temp = 0;

    public static long smokeFreeDay = 0;
    public static long smokeFreeDayNum = 0;

    //Count number of time user click crave or smoke
    public static int theNumberOfCrave = 0;       //theNumberOfCrave is always the total and it never decrease
    public static int theNumberOfSmoke = 0;
    public static int theNumberOfSmokeTotal = 0;
    final Context context = this;

    private TextView switchStatus;
    private Switch mySwitch;

    public static int cigarSmokedPerDay = 0;
    public static int numberOfCigarPerPack = 0;
    public static float costPerPack = 0;
    public static float moneySavedTotal = 0;        //assume you did not smoke after you set quit day

    public static String final_data22;
    public static String final_data23;
    public static ImageView iv61;
    public static Drawable drawable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.fragment_main_activity_home);

        final TextView myMessage = (TextView) findViewById(R.id.textView19);

        TextView moneySaved = (TextView) findViewById(R.id.textView50);
        TextView noSmokedDay = (TextView) findViewById(R.id.textView51);
        TextView myPersonalization = (TextView) findViewById(R.id.textView72);

        //set desktop photo
        if(iv61 != null && drawable != null) {
            iv61.setImageDrawable(drawable);
        }

        TimeZone.setDefault(TimeZone.getTimeZone("America/Toronto")); //Eastern Time here
        //****************
        loadDate();
        //****************

        //total days pass since user installed the app
        daysInBetween = (quitDayNum - startDayNum) / (24 * 60 * 60 * 1000);

        //DAYS BEFORE THE YOU START TO QUIT
        daysInBetween2 = (quitDayNum6 - startDayNum)/ (24 * 60 * 60 * 1000);

        //number of consecutive days without clicking on SMOKE button
        smokeFreeDay = (quitDayNum - smokeFreeDayNum) / (24 * 60 * 60 * 1000);
        addListenerOnCRAVEButton();
        addListenerOnSMOKEButton();
        //Options for navigation from home
        addListenerOnAwardImageButton();
        addListenerOnProgressImageButton();
        addListenerOnQuitHelpImageButton();
        addListenerOnMoreImageButton();
        //SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        //final_data22 = sp.getString("FINAL_DATA22", final_data22);
        myPersonalization.setText(final_data22);
        myMessage.setText("startDayNum   " + startDayNum + "\nquitDayNum   " + quitDayNum + "\nquitDayNum6   " + quitDayNum6 + "\ndaysInBetween   " + daysInBetween
                        + "\nstartDayNum2   " + "\ndaysInBetween2   " + daysInBetween2 + "\nsmokeFreeDayNum   " + smokeFreeDayNum +"\n "+(quitDayNum6-startDayNum)
          +"\nquitDayNum - smokeFreeDayNum\n"+(quitDayNum - smokeFreeDayNum)
        );

        //make sure money is in two decimal places
        NumberFormat formatter = new DecimalFormat("#0.00");
        moneySaved.setText("Money saved $"+ formatter.format(moneySavedTotal));
        noSmokedDay.setText("Number of days smoke-free" + smokeFreeDay);


        ListenerSetDesktopPhoto();
        moneySaved.refreshDrawableState();
    }
    /**
     * A class, that can be used as a TouchListener on any view (e.g. a Button).
     * It cyclically runs a clickListener, emulating keyboard-like behaviour. First
     * click is fired immediately, next after initialInterval, and subsequent after
     * normalInterval.
     *
     * <p>Interval is scheduled after the onClick completes, so it has to run fast.
     * If it runs slow, it does not generate skipped onClicks.
     */

    private void ListenerSetDesktopPhoto(){
        //For hold button in order to set desktop photo
        ImageButton ib = (ImageButton)findViewById(R.id.imageButton61);
        ib.setOnTouchListener(new RepeatListener(400, 100, new OnClickListener() {
            @Override
            public void onClick(View view) {
                // the code to execute repeatedly
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),0);
            }


        }));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 0:data.getDataString();
                if (resultCode == RESULT_OK) {

                    Bitmap bitmap = null;
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    drawable = new BitmapDrawable(getResources(), bitmap);
                    iv61 =(ImageButton)findViewById(R.id.imageButton61);

//                        bg.setBackgroundDrawable(drawable);
                    if(iv61 != null){
                        iv61.setImageDrawable(drawable);

                    }
                }
        }
    }
    public class RepeatListener implements OnTouchListener {

        private Handler handler = new Handler();

        private int initialInterval;
        private final int normalInterval;
        private final OnClickListener clickListener;

        private Runnable handlerRunnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, normalInterval);
                clickListener.onClick(downView);
            }
        };

        private View downView;

        /**
         * @param initialInterval The interval after first click event
         * @param normalInterval The interval after second and subsequent click
         *       events
         * @param clickListener The OnClickListener, that will be called
         *       periodically
         */
        public RepeatListener(int initialInterval, int normalInterval,
                              OnClickListener clickListener) {
            if (clickListener == null)
                throw new IllegalArgumentException("null runnable");
            if (initialInterval < 0 || normalInterval < 0)
                throw new IllegalArgumentException("negative interval");

            this.initialInterval = initialInterval;
            this.normalInterval = normalInterval;
            this.clickListener = clickListener;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    handler.removeCallbacks(handlerRunnable);
                    handler.postDelayed(handlerRunnable, initialInterval);
                    downView = view;
                    clickListener.onClick(view);
                    return true;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    handler.removeCallbacks(handlerRunnable);
                    downView = null;
                    return true;
            }

            return false;
        }

    }

    public void addListenerOnCRAVEButton() {
        //increment number of click
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.CraveButtonID);

        imageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                //increment number of click
                Toast.makeText(getApplicationContext(), "quit date is " + quitDayNum + " time", Toast.LENGTH_LONG).show();
                theNumberOfCrave++;
                //go to Crave screen
                Intent intent = new Intent(context, CraveActivity.class);
                startActivity(intent);
            }
        });
    }
    public void addListenerOnSMOKEButton() {

        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.SmokeButtonID);

        imageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                //increment number of click
                theNumberOfSmoke++;
                theNumberOfSmokeTotal++;

                //reset the smokeFreeDayNum to quitDayNum
                smokeFreeDayNum = quitDayNum;
                //Toast.makeText(getApplicationContext(), "smokeFreeDayNum " + smokeFreeDayNum + " time", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), "quitDayNum - smokeFreeDayNum/(24 * 60 * 60 * 1000); " + (quitDayNum - smokeFreeDayNum) / (24 * 60 * 60 * 1000) + " time", Toast.LENGTH_LONG).show();

                if (theNumberOfSmoke <= 5) {
                    //go to Smoke screen
                    Intent intent = new Intent(context, SmokeActivity.class);

                    startActivity(intent);
                }
                //show alert if click smoke more than 5 times
                if (theNumberOfSmoke > 5) {

                    AlertDialog.Builder alertDialogBuilderInst = new AlertDialog.Builder(context);

                    //set title
                    alertDialogBuilderInst.setTitle("Crush The Crave");

                    //set dialog message
                    alertDialogBuilderInst
                            .setMessage("It looks like you are having trouble quitting. Would you like to reset your quit date?");
                    alertDialogBuilderInst.setCancelable(false)
                            .setPositiveButton("Yup", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, reset
                                    theNumberOfSmoke = 0;
                                }
                            })
                            .setNegativeButton("I'm good", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }
                            });
                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilderInst.create();
                    // show it
                    alertDialog.show();
                }
            }
        });
    }
    public void addListenerOnHomeImageButton() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, MainActivityHome.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnAwardImageButton() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton2);

        imageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, My_AwardsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnProgressImageButton() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton3);

        imageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, My_ProgressActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnQuitHelpImageButton() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton4);

        imageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Quit_Help.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnMoreImageButton() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton5);

        imageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, More.class);
                startActivity(intent);
            }
        });
    }
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_home, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_activity_home, container, false);

            return rootView;
        }
    }

    private void saveData() {
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("Crave", theNumberOfCrave);
        editor.putInt("Smoke", theNumberOfSmoke);
        editor.putInt("ISFIRSTTIME5", isFirstTime5);
        editor.putLong("STARTDAYNUM6", startDayNum6);
        editor.putFloat("MONEYSAVEDTOTAL", moneySavedTotal);
        editor.putLong("SMOKEFREEDAYNUM", smokeFreeDayNum);
        editor.putInt("SmokeTotal", theNumberOfSmokeTotal);
        editor.putString("FINAL_DATA22", final_data22);
        editor.putLong("STARTDAYNUM", startDayNum);


        editor.commit();
    }
    private void loadData() {
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        theNumberOfCrave = sp.getInt("Crave", theNumberOfCrave);
        theNumberOfSmoke = sp.getInt("Smoke", theNumberOfSmoke);
        isFirstTime5 = sp.getInt("ISFIRSTTIME5", isFirstTime5);
        startDayNum6 = sp.getLong("STARTDAYNUM6", startDayNum6);
        quitDayNum6 = sp.getLong("QUITDAYNUM6", quitDayNum6);
        smokeFreeDayNum = sp.getLong("SMOKEFREEDAYNUM", smokeFreeDayNum);
        theNumberOfSmokeTotal = sp.getInt("SmokeTotal", theNumberOfSmokeTotal);
        final_data22 = sp.getString("FINAL_DATA22", final_data22);
        startDayNum = sp.getLong("STARTDAYNUM", startDayNum);

    }

    private void saveDate() {
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("QUITDAYNUM", quitDayNum);
        editor.putLong("QUITDAYNUM6", quitDayNum6);
        editor.putString("FINAL_DATA22", final_data22);

        moneySavedTotal = sp.getFloat("MONEYSAVEDTOTAL", moneySavedTotal);

        editor.commit();
    }
    private void loadDate() {
        TextView myMessage = (TextView) findViewById(R.id.textView19);

        /*final*/ SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        /*final*/ Calendar quitDay = Calendar.getInstance();
        quitDayNum = quitDay.getTimeInMillis();

        startDayNum = sp.getLong("STARTDAYNUM", startDayNum);
        quitDayNum6 = sp.getLong("QUITDAYNUM6", quitDayNum6);
        final_data22 = sp.getString("FINAL_DATA22", final_data22);


        Toast.makeText(getApplicationContext(), "startDayNum in loadDate() " + startDayNum, Toast.LENGTH_SHORT).show();

        if (startDayNum == -1 && quitDayNum != -1) {
            //First time user open it
            startDayNum = quitDayNum;
            startDayNum = sp.getLong("STARTDAYNUM", startDayNum);

        } else {
            saveDate();
        }
    }

    //@Override
    protected void onPause() {
        super.onPause();
        saveData();
        saveDate();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    //@Override
    protected void onResume() {
        super.onResume();
        loadData();
        loadDate();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("CURRENTSCORE", startDayNum);
        outState.putLong("CURRENTLIFE", startDayNum6);
        outState.putLong("CURRENTHIGHESTSCORE", quitDayNum);
        outState.putLong("4", daysInBetween);
        outState.putLong("5", daysInBetween2);
    }
    //Display values in UI that were saved right before orientation changed and save
    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        startDayNum = saveInstanceState.getLong("CURRENTSCORE");
        startDayNum6 = saveInstanceState.getLong("CURRENTLIFE");
        quitDayNum = saveInstanceState.getLong("CURRENTHIGHESTSCORE");
        daysInBetween = saveInstanceState.getLong("4");
        daysInBetween2 = saveInstanceState.getLong("5");
    }
}