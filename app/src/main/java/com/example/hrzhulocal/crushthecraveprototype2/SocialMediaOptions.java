package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class SocialMediaOptions extends My_AwardsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media_options);
        ListenerShareOnFB();
        ListenerShareOnTW();


    }
    public void ListenerShareOnFB(){
        final Context context = this;

        ImageButton fb = (ImageButton)findViewById(R.id.imageButton62);
        fb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent intent = new Intent(context, FaceBookShare.class);
                startActivity(intent);
            }
        });
    }
    public void ListenerShareOnTW(){
        ImageButton fb = (ImageButton)findViewById(R.id.imageButton64);
        fb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent intent = new Intent(context, TwitterShare.class);
                startActivity(intent);
            }
        });
    }

}
