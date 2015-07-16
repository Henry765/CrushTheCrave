package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmokingTriggers extends SmokeActivity {

    public static boolean isFirstTimeOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoking_triggers);

        TextView textView = (TextView) findViewById(R.id.textView23);
        addListenerOnHomeImageButton();
        addListenerOnAwardImageButton();
        addListenerOnProgressImageButton();
        addListenerOnQuitHelpImageButton();
        addListenerOnMoreImageButton();

        //textView.setText(final_data.substring(6).relace("^", "\n"));
        //If the string is empty
        if(final_data == null ) {
            //do nothing
        }
        else{
            textView.setText(final_data.replace("^", "\n"));

        }
        Toast.makeText(getApplicationContext(), "isFirstTimeOpen " + isFirstTimeOpen, Toast.LENGTH_LONG).show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_smoking_triggers, menu);
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
    private void saveData2() {
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("ISFIRSTTIMEOPEN", isFirstTimeOpen);
        editor.commit();
    }

    private void loadData2() {
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        isFirstTimeOpen = sp.getBoolean("ISFIRSTTIMEOPEN", isFirstTimeOpen);    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData2();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData2();
    }
}
