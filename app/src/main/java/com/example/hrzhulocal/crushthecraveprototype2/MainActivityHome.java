package com.example.hrzhulocal.crushthecraveprototype2;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.content.Intent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;

//import com.example.hrzhulocal.crushthecraveprototype2.Graph.My_ProgressActivity;
import com.example.hrzhulocal.crushthecraveprototype2.Graph.MainActivity;
import com.facebook.appevents.AppEventsLogger;

import android.view.MotionEvent;
import android.view.View.OnTouchListener;

import org.json.JSONArray;
import org.json.JSONException;

import bolts.Task;

public class MainActivityHome extends AppCompatActivity//ActionBarActivity {
{
//public class MainActivityHome extends MyPersonalization {
    Button button;
    ImageButton imageButton;

    public static int isFirstTime5 = 1;
    public static int isFirstTimeUserOpenTheApp2 = 1;
    public static long startDayNum = -1;
    long startDayNum6 = -1;
    long quitDayNum = -1;
    public static long quitDayNum6 = -1;////////////////////////////////////////////////////////////////////////Aug.14 was like long quitDayNum6 = -1;
    public static long daysInBetween = 0;
    public static long daysInBetween2 = 0;
    //int moneySaved = 0;
    long temp = 0;

    public static long smokeFreeDay = 0;
    public static long smokeFreeDayNum= 0;

    //Count number of time user click crave or smoke
    public static int theNumberOfCrave = 0;       //theNumberOfCrave is always the total and it never decrease
    public static int theNumberOfSmoke = 0;
    public static int theNumberOfSmokeTotal = 0;
    final Context context = this;

    public static int cigarSmokedPerDay = 0;
    public static int numberOfCigarPerPack = 0;
    public static float costPerPack = 0;
    public static float moneySavedTotal = 0;        //assume you did not smoke after you set quit day

    public static String final_data22;
    public static ImageView iv61;
    public static Drawable drawable;

    //track the progress in graph and the index represent the number of quit day that passed
    public static int[] TrackSmoke = new int[125];
    public static int[] TrackCrave = new int[200];
    public static int TrackSmokeCount = 0;
    public static int TrackCraveCount = 0;

    //is first time for Crave and Smoke
    public static boolean isSmokeFirstTime = true;
    public static boolean isCraveFirstTime = true;

    public static String cigarSmokedPerDayS = "";
    public static String NumberOfCigarPerPackS = "";
    public static String costPerPackS = "";
    //JSONArray is dynamic and is a linked list
    //JSONArray TrackSmoke = new JSONArray();
    //JSONArray TrackCrave = new JSONArray();

    // create an array list to replace quitDayNum6
    public static ArrayList arrayListQuitNow = new ArrayList();
    //use a string as a workaround to save ArrayList
    public static String workAroundQuitDate;
    public static int TimeZoneOption;
    private static String mCurrentPhotoPath;
;

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

        final String PREFS_NAME = "MyPrefsFile";

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        if (settings.getBoolean("my_first_time", true)) {
            //the app is being launched for first time, do something
            Log.d("Comments", "First time");

            final Context context = this;
            Intent intent = new Intent(context, ResetSmokingStatus.class);
            startActivity(intent);

            // record the fact that the app has been started at least once
            settings.edit().putBoolean("my_first_time", false).commit();
        }
        if( mCurrentPhotoPath != null){
        //  Toast.makeText(getApplicationContext(), "sss"+String.valueOf(mCurrentPhotoPath) + " time", Toast.LENGTH_LONG).show();
            loadImageFile();
        }
             ListenerSetDesktopPhoto();

        switch(TimeZoneOption) {
            case 0:
                TimeZone.setDefault(TimeZone.getTimeZone("America/Toronto")); //Standard Eastern Time here
                break;
            case 1:
                TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles")); //Pacific Time here
                break;
            case 2:
                TimeZone.setDefault(TimeZone.getTimeZone("America/Denver")); //Mountain Time here calgary
                break;
            case 3:
                TimeZone.setDefault(TimeZone.getTimeZone("US/Central")); //Central Time here Regina
                break;
            case 4:
                TimeZone.setDefault(TimeZone.getTimeZone("Canada/Atlantic")); //Canada Atlantic Time here Nova Scotia
                break;
            case 5:
                TimeZone.setDefault(TimeZone.getTimeZone("Canada/Newfoundland")); //Canada Newfoundland Time here
                break;
            default:
                TimeZone.setDefault(TimeZone.getTimeZone("America/Toronto")); //Standard Eastern Time here
                break;
        }
            //****************
            loadDate();
            loadSetUpInformation();
            //****************
            //total days pass since user installed the app
            daysInBetween = (quitDayNum - startDayNum) / (24 * 60 * 60 * 1000);

            //DAYS BEFORE THE YOU START TO QUIT
            daysInBetween2 = (quitDayNum6 - startDayNum) / (24 * 60 * 60 * 1000);

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

        myMessage.setText("Your current quit date is: \n"+ DateFormat.getDateTimeInstance().format(quitDayNum6)+"startDayNum   " + startDayNum + "\nquitDayNum   " + quitDayNum + "\nquitDayNum6   " + quitDayNum6 + "\ndaysInBetween   " + daysInBetween
                        + "\nstartDayNum2   " + "\ndaysInBetween2   " + daysInBetween2 + "\nsmokeFreeDayNum   " + smokeFreeDayNum + "\n " + (quitDayNum6 - startDayNum)
                        + "\nquitDayNum - smokeFreeDayNum\n" + (quitDayNum - smokeFreeDayNum) + "array list" + arrayListQuitNow + "leeminho\n" + workAroundQuitDate+"\npath"+mCurrentPhotoPath
        );

        moneySavedTotal = (costPerPack / numberOfCigarPerPack) * theNumberOfCrave;

        if (quitDayNum6 != -1) {
                //two decimal places
                NumberFormat formatter = new DecimalFormat("#0.00");
                //if(formatter.format(moneySavedTotal == null))
                moneySaved.setText("Money saved $" + formatter.format(moneySavedTotal));
                noSmokedDay.setText("Number of smoke-free day " + smokeFreeDay);
            }
            //moneySaved.refreshDrawableState();
            isFirstTimeUserOpenTheApp2 = 1;
        //dispatchTakePictureIntent();

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

    //saveArray and loadArray found from
    //http://stackoverflow.com/questions/3876680/is-it-possible-to-add-an-array-or-object-to-sharedpreferences-on-android

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
       //////////////////////////////////////////////////////////////////// Toast.makeText(getApplicationContext(), "kkh"+String.valueOf(mCurrentPhotoPath) + " time", Toast.LENGTH_LONG).show();

        return image;
    }

    /*private File SaveImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        FileOutputStream out = null;
        Bitmap bmap = BitmapFactory.decodeFile((String.valueOf(mCurrentPhotoPath)));

        try {
            out = new FileOutputStream(imageFileName);
            bmap.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
            // PNG is a lossless format, the compression factor (100) is ignored
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
    private void loadImageFile(){
        File root = Environment.getExternalStorageDirectory();

        File imgFile = new File(mCurrentPhotoPath);
        ImageButton ib61 = (ImageButton) findViewById(R.id.imageButton61);
        /*Bitmap bmap = BitmapFactory.decodeFile((String.valueOf(mCurrentPhotoPath)));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bmap);
        ib61.setBackgroundDrawable(bitmapDrawable);
        ib61.setImageBitmap(BitmapFactory.decodeFile(String.valueOf(mCurrentPhotoPath)));*/
        Bitmap myBitmap = BitmapFactory.decodeFile(String.valueOf(mCurrentPhotoPath));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), myBitmap);
        ib61.setImageBitmap(myBitmap);
        ib61.setBackgroundDrawable(bitmapDrawable);

        ///////////////////////////////////////////////////////////////////Toast.makeText(getApplicationContext(), "sdfsdf"+String.valueOf(mCurrentPhotoPath) + " time", Toast.LENGTH_LONG).show();
    }

    private void ListenerSetDesktopPhoto(){
        //For hold button in order to set desktop photo
        ImageButton ib = (ImageButton)findViewById(R.id.imageButton61);
        ib.setOnTouchListener(new RepeatListener(15000, 100, new OnClickListener() {
            @Override
            public void onClick(View view) {
                // the code to execute repeatedly
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 0);
                try {
                    createImageFile();
                    // SaveImageFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {//////////////////////////////////////////////////////
            case 0:
                if(data != null){data.getDataString();}
                if (resultCode == RESULT_OK) {

                    Bitmap bitmap = null;
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    drawable = new BitmapDrawable(getResources(), bitmap);
                    iv61 =(ImageButton)findViewById(R.id.imageButton61);
                        //iv61.setBackgroundDrawable(drawable);
                    if(mCurrentPhotoPath != null){
                        iv61.setImageDrawable(drawable);
                        iv61.setBackgroundDrawable(drawable);//////////////////////////////////////////////////////

                        //loadImageFile();
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
    private void addListenerOnCRAVEButton() {
        //increment number of click
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.CraveButtonID);
        imageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                //keep a list of the time when you crave
                if (isCraveFirstTime) {
                    for (int i = 0; i < TrackCrave.length; i++) {
                        TrackCrave[i] = 0;
                    }
                    isCraveFirstTime = false;
                }
                if (TrackCraveCount < 200) {
                    Calendar trackCrave = Calendar.getInstance();
                    //if s day has passed
                    /*if((daysInBetween-daysInBetween2) == 0) {
                        TrackCraveCount = 0;
                    }
                    else if((daysInBetween - daysInBetween2) == 1) {
                        TrackCraveCount = 1;
                    }
                    else if((daysInBetween - daysInBetween2) == 2) {
                        TrackCraveCount = 2;
                    }
                    else if((daysInBetween - daysInBetween2) == 3 ){
                        TrackCraveCount = 3;
                    }
                    else if((daysInBetween - daysInBetween2) == 4) {
                        TrackCraveCount = 4;
                    }
                    else if((daysInBetween - daysInBetween2) == 5) {
                        TrackCraveCount = 5;
                    }
                    else if((daysInBetween - daysInBetween2) == 6 ){
                        TrackCraveCount = 6;
                    }else if((daysInBetween - daysInBetween2) == 7) {
                        TrackCraveCount = 7;
                    }
                    else if((daysInBetween - daysInBetween2) == 8) {
                        TrackCraveCount = 8;
                    }
                    else if((daysInBetween - daysInBetween2) == 9 ){
                        TrackCraveCount = 9;
                    }else if((daysInBetween - daysInBetween2) == 10) {
                        TrackCraveCount = 10;
                    }
                    else if((daysInBetween - daysInBetween2) == 11) {
                        TrackCraveCount = 11;
                    }
                    else if((daysInBetween - daysInBetween2) == 11 ){
                        TrackCraveCount = 11;
                    }else if((daysInBetween - daysInBetween2) == 12) {
                        TrackCraveCount = 12;
                    }
                    else if((daysInBetween - daysInBetween2) == 13) {
                        TrackCraveCount = 13;
                    }
                    else if((daysInBetween - daysInBetween2) == 14 ){
                        TrackCraveCount = 14;
                    }else if((daysInBetween - daysInBetween2) == 15) {
                        TrackCraveCount = 15;
                    }*/
                    for (int i = 0; i < TrackCrave.length; i++) {
                        if (daysInBetween - daysInBetween2 == i) {
                            TrackCraveCount = i;
                            break;
                        }
                    }
                    TrackCrave[TrackCraveCount]++;
                    /*if (TrackCrave != null) {
                        int len = TrackCrave.length();
                        for (int i=0; i<len; i++){
                            try {
                                TrackCrave.get(i).toString();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }*/
                    //assert TrackCrave != null;
                    //TrackCrave[TrackCraveCount] = trackCrave.getTimeInMillis();
                    //TrackCrave[TrackCraveCount] = TrackCrave[TrackCraveCount] / (60*60*1000*24);
                    //if a day has passed

                }
                //increment number of click
             //////////////////////////////////////////////////////////////   Toast.makeText(getApplicationContext(), "quit date is " + quitDayNum + " time", Toast.LENGTH_LONG).show();
                theNumberOfCrave++;
                //go to Crave screen
                Intent intent = new Intent(context, CraveActivity.class);
                startActivity(intent);
            }
        });
    }
    private void addListenerOnSMOKEButton() {

        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.SmokeButtonID);
        imageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                //increment number of click
                theNumberOfSmoke++;
                theNumberOfSmokeTotal++;
                if( isSmokeFirstTime == true){
                    for(int i = 0; i < TrackSmoke.length; i++)
                    {
                        TrackSmoke[i] = 0;
                    }
                    isSmokeFirstTime = false;
                }

                //keep a list of the time when you smoke
                if (TrackSmokeCount < 125) {
                    Calendar trackSmoke = Calendar.getInstance();
                    //TrackSmoke[TrackSmokeCount] = trackSmoke.getTimeInMillis();
                    //TrackSmoke[TrackSmokeCount] = TrackSmoke[TrackSmokeCount] / (60*60*1000*24);

                    //if s day has passed
                    /*if((daysInBetween-daysInBetween2) == 0) {
                        TrackSmokeCount = 0;
                    }
                    else if((daysInBetween - daysInBetween2) == 1) {
                        TrackSmokeCount = 1;
                    }
                    else if((daysInBetween - daysInBetween2) == 2) {
                        TrackSmokeCount = 2;
                    }
                    else if((daysInBetween - daysInBetween2) == 3 ){
                        TrackSmokeCount = 3;
                    }
                    else if((daysInBetween - daysInBetween2) == 4) {
                        TrackSmokeCount = 4;
                    }
                    else if((daysInBetween - daysInBetween2) == 5) {
                        TrackSmokeCount = 5;
                    }
                    else if((daysInBetween - daysInBetween2) == 6 ){
                        TrackSmokeCount = 6;
                    }else if((daysInBetween - daysInBetween2) == 7) {
                        TrackSmokeCount = 7;
                    }
                    else if((daysInBetween - daysInBetween2) == 8) {
                        TrackSmokeCount = 8;
                    }
                    else if((daysInBetween - daysInBetween2) == 9 ){
                        TrackSmokeCount = 9;
                    }else if((daysInBetween - daysInBetween2) == 10) {
                        TrackSmokeCount = 10;
                    }
                    else if((daysInBetween - daysInBetween2) == 11) {
                        TrackSmokeCount = 11;
                    }
                    else if((daysInBetween - daysInBetween2) == 11 ){
                        TrackSmokeCount = 11;
                    }else if((daysInBetween - daysInBetween2) == 12) {
                        TrackSmokeCount = 12;
                    }
                    else if((daysInBetween - daysInBetween2) == 13) {
                        TrackSmokeCount = 13;
                    }
                    else if((daysInBetween - daysInBetween2) == 14 ){
                        TrackSmokeCount = 14;
                    }else if((daysInBetween - daysInBetween2) == 15) {
                        TrackSmokeCount = 15;
                    }*/
                    for(int i = 0; i<TrackCrave.length; i++){
                        if(daysInBetween - daysInBetween2 == i)
                        {
                            TrackCraveCount = i;
                            break;
                        }
                    }

                    TrackSmoke[TrackCraveCount]++;

                    /*for(int n = 0; ; n++ )
                    {
                        //after quit days
                        if((daysInBetween - daysInBetween2) == n)
                        {
                            TrackCraveCount = n;
                        }
                        if(n != TrackCraveCount)
                        {
                            TrackCrave[TrackCraveCount] = 0;
                            TrackCrave[TrackCraveCount]++;
                            break;
                        }
                    }*/
                }
              ///////////////////////////////////////////////////////////////  Toast.makeText(getApplicationContext(), "startDayNum in loadDate() " + startDayNum, Toast.LENGTH_SHORT).show();

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
                            .setNegativeButton("No, I'm good", new DialogInterface.OnClickListener() {
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
                Intent intent;
                intent = new Intent(context,MainActivity.class);
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

    /*private*/
    public void saveData() {
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
        editor.putInt("TRACKCRAVECOUNT", TrackCraveCount);
        editor.putInt("TRACKSMOKECOUNT", TrackSmokeCount);
        editor.putBoolean("ISCRAVEFIRSTTIME", isCraveFirstTime);
        editor.putBoolean("ISSMOKEFIRSTTIME", isSmokeFirstTime);
        editor.putInt("FIRSTTIME2", isFirstTimeUserOpenTheApp2);
        /*Set<String> set = new HashSet<String>();
        set.addAll(arrayListQuitNow);
        editor.putStringSet("ArrayListkey", set);*/
        editor.putString("ArrayListSaveInAString", arrayListQuitNow.toString());
        editor.putString("WORKAROUNDQUITDATE", workAroundQuitDate);
        editor.putString("CIGARSMOKEDPERDAYS",cigarSmokedPerDayS);
        editor.putString("NUMBEROFCIGARPERPACKS",NumberOfCigarPerPackS);
        editor.putString("COSTPERPACKS", costPerPackS);


        editor.putInt("CIGARSMOKEDPERDAY", cigarSmokedPerDay);
        editor.putInt("NUMBEROFCIGARPERPACK", numberOfCigarPerPack);
        editor.putFloat("COSTPERPACK", costPerPack);

        editor.putFloat("MONEYSAVEDTOTAL", moneySavedTotal);
       // editor.putFloat("TOGGLE", MySettings.toggle);
        editor.putString("HOMEIMAGE", mCurrentPhotoPath);


        editor.commit();
        //save arrays to sharedpreference
        for( int i = 0; i < 125; i++ ){
            editor.putInt("TRACKSMOKE"+String.valueOf(i), TrackSmoke[i]);
        }
        for( int i = 0; i < 200; i++ ){
            editor.putInt("TRACKCRAVE"+String.valueOf(i), TrackCrave[i]);
        }

        //save the progress
        //editor.putLongArray("TRACKSMOKE", TrackSmoke[]);
        //editor.putInt("TRACKSMOKECOUNT", TrackSmokeCount);
        //editor.putLong("TRACKCRAVE", TrackCrave[]);

        editor.commit();
    }
    public void addTask(Task t) {
        /*if (null == currentTasks) {
            currentTasks = new ArrayList<task>();
        }
        currentTasks.add(t);

        //save the task list to preference
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        try {
            editor.putString(TASKS, ObjectSerializer.serialize(currentTasks));
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.commit();*/
    }
    private void loadData() {
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        theNumberOfCrave = sp.getInt("Crave", theNumberOfCrave);
        theNumberOfSmoke = sp.getInt("Smoke", theNumberOfSmoke);
        isFirstTime5 = sp.getInt("ISFIRSTTIME5", isFirstTime5);
        startDayNum6 = sp.getLong("STARTDAYNUM6", startDayNum6);
        ////////////////////////////////////quitDayNum6 = sp.getLong("QUITDAYNUM6", quitDayNum6);
        smokeFreeDayNum = sp.getLong("SMOKEFREEDAYNUM", smokeFreeDayNum);
        theNumberOfSmokeTotal = sp.getInt("SmokeTotal", theNumberOfSmokeTotal);
        final_data22 = sp.getString("FINAL_DATA22", final_data22);
        startDayNum = sp.getLong("STARTDAYNUM", startDayNum);
        TrackCraveCount = sp.getInt("TRACKCRAVECOUNT", TrackCraveCount);
        TrackSmokeCount = sp.getInt("TRACKSMOKECOUNT", TrackSmokeCount);
        isCraveFirstTime = sp.getBoolean("ISCRAVEFIRSTTIME", isCraveFirstTime);
        isSmokeFirstTime = sp.getBoolean("ISSMOKEFIRSTTIME", isSmokeFirstTime);
        isFirstTimeUserOpenTheApp2 = sp.getInt("FIRSTTIME2", isFirstTimeUserOpenTheApp2);
        workAroundQuitDate = sp.getString("ArrayListSaveInAString", null);
        workAroundQuitDate = sp.getString("WORKAROUNDQUITDATE", workAroundQuitDate);
        cigarSmokedPerDayS = sp.getString("CIGARSMOKEDPERDAYS", cigarSmokedPerDayS);
        NumberOfCigarPerPackS = sp.getString("NUMBEROFCIGARPERPACKS", NumberOfCigarPerPackS);
        costPerPackS = sp.getString("COSTPERPACKS", costPerPackS);

        cigarSmokedPerDay = sp.getInt("CIGARSMOKEDPERDAY", cigarSmokedPerDay);
        numberOfCigarPerPack = sp.getInt("NUMBEROFCIGARPERPACK", numberOfCigarPerPack);
        costPerPack = sp.getFloat("COSTPERPACK", costPerPack);
        moneySavedTotal = sp.getFloat("MONEYSAVEDTOTAL", moneySavedTotal);
//        MySettings.toggle = sp.getInt("TOGGLE", MySettings.toggle);
        mCurrentPhotoPath = sp.getString("HOMEIMAGE", mCurrentPhotoPath);

        //Retrieve the values
        Set<String> set = sp.getStringSet("ArrayListkey", null);
        for(int i = 0; i < 125; i++){
            TrackSmoke[i] = sp.getInt("TRACKSMOKE"+String.valueOf(i), TrackSmoke[i]);
        }
        for(int i = 0; i < 200; i++){
            TrackCrave[i] = sp.getInt("TRACKCRAVE"+String.valueOf(i), TrackCrave[i]);
        }
    }

    public void saveDate() {
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("QUITDAYNUM", quitDayNum);
        editor.putLong("QUITDAYNUM6", quitDayNum6);
        editor.putString("FINAL_DATA22", final_data22);

        moneySavedTotal = sp.getFloat("MONEYSAVEDTOTAL", moneySavedTotal);

        editor.commit();
    }
    public void loadDate() {
        TextView myMessage = (TextView) findViewById(R.id.textView19);

        /*final*/ SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        /*final*/ Calendar quitDay = Calendar.getInstance();
        quitDayNum = quitDay.getTimeInMillis();

        startDayNum = sp.getLong("STARTDAYNUM", startDayNum);
        quitDayNum6 = sp.getLong("QUITDAYNUM6", quitDayNum6);
        final_data22 = sp.getString("FINAL_DATA22", final_data22);


        ///////////////////////////Toast.makeText(getApplicationContext(), "startDayNum in loadDate() " + startDayNum, Toast.LENGTH_SHORT).show();

        if (startDayNum == -1 && quitDayNum != -1) {
            //First time user open it
            startDayNum = quitDayNum;
            startDayNum = sp.getLong("STARTDAYNUM", startDayNum);

        } else {
            saveDate();
        }
    }
    public void loadSetUpInformation(){
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        cigarSmokedPerDay = sp.getInt("CIGARSMOKEDPERDAY", cigarSmokedPerDay);
        numberOfCigarPerPack = sp.getInt("NUMBEROFCIGARPERPACK", numberOfCigarPerPack);
        costPerPack = sp.getFloat("COSTPERPACK", costPerPack);

        theNumberOfCrave = sp.getInt("Crave", theNumberOfCrave);
        smokeFreeDayNum = sp.getLong("SMOKEFREEDAYNUM", smokeFreeDayNum);
        mCurrentPhotoPath = sp.getString("HOMEIMAGE", mCurrentPhotoPath);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_home, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent3 = new Intent(this, MySettings.class);
            startActivity(intent3);
        }
        switch(item.getItemId()){
            case R.id.mainFB:
                //Committed award
                My_AwardsActivity.ShareOption = 0;
                Intent intent = new Intent(this, FaceBookShare.class);
                startActivity(intent);
            case R.id.mainTW:
                Intent intent2 = new Intent(this, TwitterShare.class);
                startActivity(intent2);
        }

        return super.onOptionsItemSelected(item);
    }

}