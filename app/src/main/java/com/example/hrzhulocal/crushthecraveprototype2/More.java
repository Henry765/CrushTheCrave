package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.io.FileNotFoundException;
import java.io.IOException;


/******************************************************************************
 *  Crush The Crave Version 2.3 beta
 *  Rebuilt by Henry Zhu, contact email: hrzhu@uwaterloo.ca
 *  For the University Of Waterloo Propel Centre For Population Health Impact
 ******************************************************************************/
public class More extends MainActivityHome {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        TextView myMessage = (TextView) findViewById(R.id.textView20);

        myMessage.setText(Html.fromHtml("<a href=\"http://www.crushthecrave.ca/\">Crush The Crave Official Website</a>"
                + "<p><a href=\"https://play.google.com/store/apps/details?id=com.techahead.ctc.main/\">Crush the Crave On Google Play</a></p> "
                + "<p><a href=\"https://www.facebook.com/CrushTheCrave\">Like our app page on Facebook!</a></p> "
                + "<p><a href=\"https://twitter.com/crushthecrave\">Follow our app page on Twitter!</a></p> "));
        myMessage.setMovementMethod(LinkMovementMethod.getInstance());

        addListenerOnHomeImageButton();
        addListenerOnAwardImageButton();
        addListenerOnProgressImageButton();
        addListenerOnQuitHelpImageButton();
        addListenerOnWhoWeAre();
        addListenerOnSettings();
         ListenerUsePic();
        ListenerUsePic();
    }
    private void ListenerUsePic(){
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton7);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, SetDesktopImage.class);
                startActivity(intent);
            }
        });
    }

    private void addListenerOnSettings(){
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton8);

        imageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent = new Intent(context, MySettings.class);
                startActivity(intent);
            }
        });
    }
    private void addListenerOnWhoWeAre(){
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton6);

        imageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent = new Intent(context, WhoWeAre.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_more, menu);
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