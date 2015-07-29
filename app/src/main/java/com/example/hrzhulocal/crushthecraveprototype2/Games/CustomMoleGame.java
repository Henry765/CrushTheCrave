/*package com.example.hrzhulocal.crushthecraveprototype2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MoleGame extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mole_game);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mole_game, menu);
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
package com.example.hrzhulocal.crushthecraveprototype2.Games;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class CustomMoleGame extends Thread {

    final static public int LOWERBOUND = 0;
    //I changed this UPPBOUND from 8 to 7 to avoid null exception
    final static public int UPPERBOUND = 7;

    private int upperBound;
    private int timeWait;
    private Handler handler;

    public enum GameState{RUNNING, STOPPED};

    private GameState gstate;

    public CustomMoleGame(Handler handler) {
        super();
        this.upperBound = UPPERBOUND;
        gstate = GameState.RUNNING;
        this.handler=handler;
        this.timeWait=1000;
    }

    @Override
    public void run() {

        while(gstate == GameState.RUNNING) {

            int newPosition;
            // genero posizione random
            newPosition=(int) (Math.random()*(upperBound+1));
            //setto la nuova posizione
            nextStep(newPosition);

            //attendo tot tempo
            try {
                sleep(timeWait);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void nextStep(int newPosition){
        Message msg = handler.obtainMessage();
        Bundle b = new Bundle();
        b.putInt("newPosition", newPosition);
        msg.setData(b);
        handler.sendMessage(msg);
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public String getGameState() {
        return gstate.name();
    }

    public void setState(String state) {
        if (state.equals(GameState.RUNNING.name()))	this.gstate = GameState.RUNNING;
        else this.gstate = GameState.STOPPED;

    }

    /**
     * Termina il thread in maniera pulita.
     * */
    public synchronized void stopThread() {
        this.gstate = GameState.STOPPED;

    }

    public void setTimeToWait(int timeWait){
        this.timeWait=timeWait;

    }


}

