/*package com.example.hrzhulocal.crushthecraveprototype2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class GameOver extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_over, menu);
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

public class GameOver extends Activity {
    /** Called when the activity is first created. */



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);
        Button RestartGameButton = (Button)findViewById(R.id.restart);
        RestartGameButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent RestartGameIntent = new Intent(GameOver.this,Menu.class);
                startActivity(RestartGameIntent);

            }
        });

        Button QuitButton = (Button)findViewById(R.id.quit);
        QuitButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
                //mg.getActivity().moveTaskToBack(true);
                //	android.os.Process.sendSignal(pid, 3);

            }
        });

    }

}
