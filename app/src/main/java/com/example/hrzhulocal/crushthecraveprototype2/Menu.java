/*package com.example.hrzhulocal.crushthecraveprototype2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Menu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Menu extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button StartGameButton = (Button)findViewById(R.id.StartGame);
        StartGameButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent StartGameIntent = new Intent(Menu.this,Slt.class);
                startActivity(StartGameIntent);
                finish();

            }
        });

        Button HelpButton = (Button)findViewById(R.id.Help);
        HelpButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent HelpIntent = new Intent(Menu.this,Help.class);
                startActivity(HelpIntent);
            }
        });


        Button CreditsButton = (Button)findViewById(R.id.Credits);
        CreditsButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent CreditsIntent= new Intent(Menu.this,Credits.class);
                startActivity(CreditsIntent);
            }
        });
    }

    public Activity getActivity(){

        return this.getActivity();
    }
}