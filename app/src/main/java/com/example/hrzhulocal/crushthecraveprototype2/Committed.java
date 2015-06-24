package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.share.widget.ShareDialog;


public class Committed extends My_AwardsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_committed);
    }

    public static class AwardCommitted extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_committed);
            ListenerShare();
        }
    }

    /**
     * Created by hrzhulocal on 22/06/2015.
     */

    public static class AwardWeek3 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_week3);
            ListenerShare();
        }
    }

    public static class AwardWeek1 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_week1);
            ListenerShare();
        }

    }

    public static class AwardSmokingTracker extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_smoking_tracker);
            ListenerShare();

        }

    }

    public static class AwardSharing extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_sharing);
            ListenerShare();

        }

    }

    public static class AwardQuitDate extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_quit_date);
            ListenerShare();

        }

    }

    public static class AwardO2 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_o2);
            ListenerShare();

        }

    }

    public static class AwardNightOut extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_night_out);
            ListenerShare();

        }

    }

    public static class AwardNicotineFree extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_nicotine_free);
            ListenerShare();

        }

    }

    public static class AwardMonth1 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_month1);
            ListenerShare();

        }

    }

    public static class AwardHappyHeart2 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_happy_heart2);
            ListenerShare();

        }

    }

    public static class AwardHappyHeart extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_happy_heart);
            ListenerShare();

        }

    }

    public static class AwardFriends extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_friends);
            ListenerShare();

        }

    }

    public static class AwardFeedback extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_feedback);
            ListenerShare();

        }

    }

    public static class AwardDay1 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_day1);
            ListenerShare();

        }

    }

    public static class AwardCravingTracker extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_craving_tracker);
            ListenerShare();

        }

    }

    public static class AwardBreatheEasier2 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_breathe_easier2);
            ListenerShare();

        }

    }

    public static class AwardBreatheEasier extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_breathe_easier);
            ListenerShare();

        }


    }

    public static class AwardBetterTasteAndSmell extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_better_taste_and_smell);
            ListenerShare();

        }

    }

    public static class AwardBetterHealth extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_better_health);
            ListenerShare();

        }

    }

    public static class Award1000Saved extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award1000_saved);
            ListenerShare();

        }


    }

    public static class Award500Saved extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award500_saved);
            ListenerShare();

        }


    }

    public static class Award500Cig extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award500_cig);
            ListenerShare();

        }

    }

    public static class Award250Cig extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award250_cig);
            ListenerShare();

        }

    }

    public static class Award100Saved extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award100_saved);
            ListenerShare();
        }

    }

    public static class Award100Cig extends My_AwardsActivity {
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

            ListenerShare();
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


        public void ListenerShare(){
            final Context context = this;

            ImageButton fb = (ImageButton)findViewById(R.id.fb_share_button);
            fb.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {

                    Intent intent = new Intent(context, SocialMediaOptions.class);
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
                 public boolean onCreateOptionsMenu(android.view.Menu menu) {
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
}
