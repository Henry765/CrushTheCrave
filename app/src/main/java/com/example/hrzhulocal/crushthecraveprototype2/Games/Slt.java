/*package com.example.hrzhulocal.crushthecraveprototype2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;


public class Slt extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slt);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_slt, menu);
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
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.hrzhulocal.crushthecraveprototype2.Games.CustomGraphicsMole;
import com.example.hrzhulocal.crushthecraveprototype2.Games.CustomMoleGame;

import android.os.Vibrator;
import android.media.AudioManager;
import android.media.SoundPool;

public class Slt extends Activity {

    //private static int CURRENTSCORE= scoreCurr;
    //private static int CURRENTLIFE = lifeCurr;

    private CustomGraphicsMole im;
    private int currentMolePos = -1;
    private static int scoreCurr = 0;
    private static int lifeCurr = 3;
    //I created a highest score value since you first started to play the game after installing CTC
    private static int highestScore = 0;

    private Handler step;
    private Handler Update;
    private CustomMoleGame mg;
    private boolean isMole = true;
    private Mole mole = new Mole();
    private double prob=0.7;

    // variables used for recreating sound effect for game
    private SoundPool sounds;
    private int sndmale;
    private int sndfemale;
    private int msprite = 6;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startgame);
        final TextView scoreTview = (TextView) findViewById(R.id.Score);
        final TextView lifeTview = (TextView) findViewById(R.id.Life);
        final TextView highestScoreTview = (TextView) findViewById(R.id.highestScore);
        final GridView gw = (GridView) findViewById(R.id.gridview);
        step = new ChangeImage();
        Update = new Handler();
        im = new CustomGraphicsMole(this);
        gw.setAdapter(im);
        final Context context = this;

        sounds = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        sndmale = sounds.load(context, R.raw.explodedcut, 1);
        // ----------------------------

        gw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View v,
                                    int position, long id) {
                if (currentMolePos == position) {

                    Update.post(new Runnable() {

                        @Override
                        public void run() {

                            //If you smash the object you get one score
                            if (isMole == true) {
                                scoreCurr++;
                                scoreTview.setText("Score: " + scoreCurr);
                                //update the highest score
                                highestScore = scoreCurr;
                                highestScoreTview.setText("High Score: " + highestScore);
                                scoreTview.refreshDrawableState();
                                // Sounds effect game
                                sounds.play(sndmale, 1.0f,1.0f,0,0,1.5f);
                                if(scoreCurr==12){
                                    setProbability(0.60);
                                    mg.setTimeToWait(700);
                                }
                                else if(scoreCurr==22){
                                    setProbability(0.50);
                                    mg.setTimeToWait(600);
                                }
                                else if(scoreCurr == 30){
                                    setProbability(0.40);
                                    mg.setTimeToWait(500);
                                }// Insanely diffculty
                                 if(scoreCurr == 40){
                                    setProbability(0.5);
                                    mg.setTimeToWait(400);
                                }
                                else if(scoreCurr == 65){
                                    AlertDialog.Builder alertDialogBuilderInst = new AlertDialog.Builder(context);

                                    //set title
                                    alertDialogBuilderInst.setTitle("Crush The Crave");

                                    //set dialog message
                                    alertDialogBuilderInst
                                            .setMessage("WOW!! unbelievable! If you can win this game, you can quit smoking too! Do you want to replay? ");
                                    alertDialogBuilderInst.setCancelable(false)
                                            .setPositiveButton("Yup",new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog,int id) {
                                                    // if this button is clicked, replay
                                                    //reset the values
                                                    lifeCurr = 3;
                                                    scoreCurr = 0;
                                                    Intent intent = new Intent(context, Slt.class);
                                                    startActivity(intent);
                                                }
                                            })
                                            .setNegativeButton("I'm good",new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog,int id) {
                                                    // if this button is clicked, just close
                                                    // the dialog box and do nothing
                                                    dialog.cancel();
                                                    mg.stopThread();

                                                    lifeCurr = 3;
                                                    scoreCurr = 0;
                                                    Intent gameOverIntent = new Intent(Slt.this, GameOver.class);
                                                    startActivity(gameOverIntent);
                                                    finish();

                                                }
                                            });

                                    // create alert dialog
                                    AlertDialog alertDialog = alertDialogBuilderInst.create();

                                    // show it
                                    alertDialog.show();
                                }
                            } else {
                                lifeCurr--;
                                lifeTview.setText("Life: " + lifeCurr);
                                lifeTview.refreshDrawableState();
                                // Get instance of Vibrator from current Context
                                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                                // Vibrate for 350 milliseconds
                                v.vibrate(350);

                                if (lifeCurr == 0) {
                                    mg.stopThread();

                                    //reset the values
                                    lifeCurr = 3;
                                    scoreCurr = 0;
                                    Intent gameOverIntent = new Intent(Slt.this, GameOver.class);
                                    startActivity(gameOverIntent);
                                    finish();
                                }
                            }
                        }
                    });
                }
            }
        });
        mg = new CustomMoleGame(step);
        mg.start();
    }

    public Activity getActivity(){

        return this.getActivity();
    }

    // ---------------------------
    private class ChangeImage extends Handler {

        Hole hole = new Hole();
        private int oldPosition = -1;


        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();

            currentMolePos = bundle.getInt("newPosition");
            if (Math.random() < prob) {
                im.setItem(currentMolePos, mole.getCigarette());
                isMole = true;
            } else {
                im.setItem(currentMolePos, mole.getFarfalla());
                isMole = false;
            }

            if (oldPosition != -1 && currentMolePos != oldPosition) {
                im.setItem(oldPosition, hole.getHole());
            }

            oldPosition = currentMolePos;
            im.notifyDataSetChanged();
        }

    }

    public void setProbability(double prob){
        this.prob=prob;
    }
    //Save screen state when orientation changes
    //this method is called before change orientation, so we can preserve values
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("CURRENTSCORE", scoreCurr);
        outState.putInt("CURRENTLIFE", lifeCurr);
        outState.putInt("CURRENTHIGHESTSCORE", highestScore);


    }
    //Display values in UI that were saved right before orientation changed and save
    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        scoreCurr = saveInstanceState.getInt("CURRENTSCORE");
        lifeCurr = saveInstanceState.getInt("CURRENTLIFE");
        highestScore = saveInstanceState.getInt("CURRENTHIGHESTSCORE");
        final TextView scoreTview = (TextView) findViewById(R.id.Score);
        final TextView lifeTview = (TextView) findViewById(R.id.Life);
        final TextView highestScoreTview = (TextView) findViewById(R.id.highestScore);
        final GridView gw = (GridView) findViewById(R.id.gridview);

        //Need to update the values once after restore
        scoreTview.setText("Score: " + scoreCurr);
        scoreTview.refreshDrawableState();

        lifeTview.setText("Life: " + lifeCurr);
        lifeTview.refreshDrawableState();

        highestScoreTview.setText("High Score: " + highestScore);
        lifeTview.refreshDrawableState();

    }
    //For save and load the highest score even after you restart the device
    private void saveData(){
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("CURRENTHIGHESTSCORE", highestScore);
        editor.commit();
    }
    private void loadData(){
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        highestScore = sp.getInt("CURRENTHIGHESTSCORE", highestScore);
    }

    //@Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    //@Override
    protected void onResume() {
        super.onResume();
        loadData();
    }
}