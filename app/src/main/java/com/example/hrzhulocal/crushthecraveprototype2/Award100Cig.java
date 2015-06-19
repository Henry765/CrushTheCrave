package com.example.hrzhulocal.crushthecraveprototype2;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.MessageDialog;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Award100Cig extends My_AwardsActivity {
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_award100_cig);

        ImageView iv5 = (ImageView) findViewById(R.id.imageView5);
        TextView tv = (TextView) findViewById(R.id.textView106);
        ImageButton ib30 = (ImageButton) findViewById(R.id.imageButton30);
        if( theNumberOfCrave == 100){
            tv.setVisibility(View.VISIBLE);
            ib30.setImageResource(R.drawable.icon100cigarettes_sel);
        }

        ListenerShareOnFB();
        //Notification.Builder.setLargeIcon(bitmap);
       // Bitmap image = BitmapFactory.decodeResource
         //       (getResources(), R.drawable.icon100cigarettes_sel);
        //notBuilder.setLargeIcon(image);
        //Drawable myDrawable = getResources().getDrawable(R.drawable.icon100cigarettes_sel);
        //Bitmap awardImage = ((BitmapDrawable) myDrawable).getBitmap();
        /*SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(image);

        SharePhotoContent content = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();*/
        /*SharePhoto.Builder photo = new SharePhoto.Builder()
                .setBitmap(image);
                //.build();
        SharePhotoContent content = new SharePhotoContent.Builder()
                //.addPhoto(photo)
                .build();

        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        //show the ShareDialog:
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("Congratulations!")
                    .setContentDescription(
                            "I earned this award")
                    .build();

            shareDialog.show(linkContent);*/
        }
        //Karen is unavailable at the office until June.16th*****************************************************************************************
        //ShareButton shareButton = (ShareButton)findViewById(R.id.fb_share_button);
        //shareButton.setShareContent(content);


    private void ListenerShareOnFB(){
        final Context context = this;

        ImageButton fb = (ImageButton)findViewById(R.id.fb_share_button);
        fb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent intent = new Intent(context, FaceBookShare.class);
                startActivity(intent);
            }
        });
    }

             @Override
             protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
                 super.onActivityResult(requestCode, resultCode, data);
                 callbackManager.onActivityResult(requestCode, resultCode, data);
             }

             @Override
             public boolean onCreateOptionsMenu(Menu menu) {
                 // Inflate the menu; this adds items to the action bar if it is present.
                 getMenuInflater().inflate(R.menu.menu_award100_cig, menu);
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
