package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Quit_Help extends MainActivityHome {
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quit__help);

        addListenerOnAwardImageButton();
        addListenerOnHomeImageButton();
        addListenerOnProgressImageButton();
        addListenerOnMoreImageButton();
        addListenerOnQuitLine();
        addListenerOnQuitAids();
        addListenerOnCraveCrushers();
        addListenerOnMyQuitPlan();
        addListenerOnHowToUse();
        addListenerHealthCalculator();
    }
    private void addListenerHealthCalculator(){
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton66);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, HealthCalculator.class);
                startActivity(intent);
            }
        });
    }
    private void addListenerOnHowToUse(){
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton63);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, HowToUse.class);
                startActivity(intent);
            }
        });
    }
    private void addListenerOnMyQuitPlan(){
        final Context context = this;
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton12);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                Intent intent = new Intent(context, MyQuitPlan.class);
                startActivity(intent);
            }
        });
    }
    private void addListenerOnCraveCrushers(){
        final Context context = this;
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton11);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                Intent intent = new Intent(context, CraveCrushers.class);
                startActivity(intent);
            }
        });
    }
    private void addListenerOnQuitAids(){
        final Context context = this;
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton10);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                Intent intent = new Intent(context, QuitAids.class);
                startActivity(intent);
            }
        });
    }
    private void addListenerOnQuitLine(){
        final Context context = this;
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton9);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                Intent intent = new Intent(context, QuitLine.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quit__help, menu);
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
