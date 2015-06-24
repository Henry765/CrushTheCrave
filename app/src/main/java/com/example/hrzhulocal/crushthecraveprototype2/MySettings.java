package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;

import android.util.Log;


public class MySettings extends More /*FragmentActivity*/ {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_settings);
        addListenerOnSetDate();
        addlistenerOnResetSmokingStatus();
        addListenerOnMyInformation();
        addListenerOnMyPersonlization();

        addListenerOnAwardImageButton();
        addListenerOnProgressImageButton();
        addListenerOnQuitHelpImageButton();
        addListenerOnMoreImageButton();
        addListenerOnHomeImageButton();
    }
    public void setDate(View view){
        PickerDialogs pickerDialogs = new PickerDialogs();
        pickerDialogs.show(getSupportFragmentManager(), "date_picker");
    }
    public void clearApplicationData() {
        File cache = getCacheDir();
        File appDir = new File(cache.getParent());
        if (appDir.exists()) {
            String[] children = appDir.list();
            for (String s : children) {
                if (!s.equals("lib")) {
                    deleteDir(new File(appDir, s));
                    Log.i("TAG", "**************** File /data/data/APP_PACKAGE/" + s + " DELETED *******************");
                }
            }
        }
    }
    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        return dir.delete();
    }
    private void addListenerOnMyInformation(){
        final Context context = this;
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton20);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, MyInformation.class);
                startActivity(intent);
            }
        });
    }
    private void RESETEVERYTHING(){
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton22);
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //********************WARNING DO NOT TOUCH THIS WILL RESET EVERYTIHNG*****************************
                //clearApplicationData();
                //sp.edit().clear().commit();
                //********************WARNING DO NOT TOUCH THIS WILL RESET EVERYTIHNG*****************************
            }
        });
    }
    private void addListenerOnSetDate(){
        final Context context = this;
        ImageButton imageButton = (ImageButton) findViewById(R.id.SetNowToStartQuitSmoking);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, SetDate.class);
                startActivity(intent);
            }
        });
    }
    private void addlistenerOnResetSmokingStatus()
    {
        final Context context = this;
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton16);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, ResetSmokingStatus.class);
                startActivity(intent);
            }
        });
    }
    private void addListenerOnMyPersonlization(){
        final Context context = this;
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton21);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, MyPersonalization.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_settings, menu);
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
