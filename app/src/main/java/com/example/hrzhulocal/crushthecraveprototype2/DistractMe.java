package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;


public class DistractMe extends CraveActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distract_me);
        addListenerOnGameWack();
        addListenerOnGameTicTacToe();
        ListenerOpenSMSAPP();
        ListenerrOpenYouTubeAPP();
    }
    private void ListenerrOpenYouTubeAPP(){

        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton19);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/channel/UCRmoG8dTnv0B7y9uoocikLw"));
                intent.setComponent(new ComponentName("com.google.android.youtube", "com.google.android.youtube.PlayerActivity"));

                PackageManager manager = context.getPackageManager();
                List<ResolveInfo> infos = manager.queryIntentActivities(intent, 0);
                if (infos.size() > 0) {
                    context.startActivity(intent);
                } else {
                    //No Application can handle your intent
                }
            }
        });
    }
    private void ListenerOpenSMSAPP(){
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton25);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);
            }
        });
    }
    private void addListenerOnGameWack(){
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton17);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Help.class);
                startActivity(intent);
            }
        });
    }
    private void addListenerOnGameTicTacToe(){
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton26);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, TicTacToe.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_distract_me, menu);
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
