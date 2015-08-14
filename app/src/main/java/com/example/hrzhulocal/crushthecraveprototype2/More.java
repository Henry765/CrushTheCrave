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
 *  Crush The Crave Version 2.3
 *  Native rebuilt by Henry Zhu, contact email: hrzhu@uwaterloo.ca
 *  For the University Of Waterloo Propel Centre For Population Health Impact
 ******************************************************************************/
public class More extends MainActivityHome {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        //  TextView myMessage = (TextView) findViewById(R.id.textView20);
        //       myMessage.setMovementMethod(LinkMovementMethod.getInstance());
        addListenerOnHomeImageButton();
        addListenerOnAwardImageButton();
        addListenerOnProgressImageButton();
        addListenerOnQuitHelpImageButton();
        addListenerOnWhoWeAre();
        addListenerOnSettings();
        listeneropenFB();
        listeneropenTW();
        listeneropenCTC();
        listenerFeedBack();
    }

    private void listenerFeedBack(){
        imageButton = (ImageButton) findViewById(R.id.imageButton54);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Feedback.class);
                startActivity(intent);
            }
        });
    }
    private void listeneropenCTC(){
        imageButton = (ImageButton) findViewById(R.id.imageButton41);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.crushthecrave.ca/"));
                startActivity(intent);
            }
        });
    }
    private void listeneropenFB(){
        imageButton = (ImageButton) findViewById(R.id.imageButton27);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/CrushTheCrave"));
                startActivity(intent);
            }
        });
    }
    private void listeneropenTW(){
        imageButton = (ImageButton) findViewById(R.id.imageButton28);

        imageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://twitter.com/crushthecrave"));
                startActivity(intent);
            }
        });
    }
    private void addListenerOnSettings(){
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton8);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
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
}