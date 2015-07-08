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

//  the committed award is always awarded to users who install the app!!
public class Committed extends My_AwardsActivity {

    //create an helper array to store the awards image file name
    String helperImageFile[] = {"iconquitdate_sel","iconday1_sel"};
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
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
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
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }
    }

    public static class AwardWeek1 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_week1);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }

    }

    public static class AwardSmokingTracker extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_smoking_tracker);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();

        }

    }

    public static class AwardSharing extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_sharing);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();

        }

    }

    public static class AwardQuitDate extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_quit_date);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();

        }

    }

    public static class AwardO2 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_o2);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();

        }

    }

    public static class AwardNightOut extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_night_out);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();

        }

    }

    public static class AwardNicotineFree extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_nicotine_free);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();

        }

    }

    public static class AwardMonth1 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_month1);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();

        }

    }

    public static class AwardHappyHeart2 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_happy_heart2);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }

    }

    public static class AwardHappyHeart extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_happy_heart);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }

    }

    public static class AwardFriends extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_friends);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }

    }

    public static class AwardFeedback extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_feedback);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }

    }

    public static class AwardDay1 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_day1);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }

    }

    public static class AwardCravingTracker extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_craving_tracker);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }

    }

    public static class AwardBreatheEasier2 extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_breathe_easier2);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }

    }

    public static class AwardBreatheEasier extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_breathe_easier);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }


    }

    public static class AwardBetterTasteAndSmell extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_better_taste_and_smell);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }

    }

    public static class AwardBetterHealth extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award_better_health);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }

    }

    public static class Award1000Saved extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award1000_saved);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }


    }

    public static class Award500Saved extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award500_saved);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }


    }

    public static class Award500Cig extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award500_cig);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }

    }

    public static class Award250Cig extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award250_cig);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
        }

    }

    public static class Award100Saved extends My_AwardsActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_award100_saved);
            ListenerShare();
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
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
            addListenerOnHomeImageButton();
            addListenerOnAwardImageButton();
            addListenerOnProgressImageButton();
            addListenerOnQuitHelpImageButton();
            addListenerOnMoreImageButton();
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


                 @Override
                 protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
                     super.onActivityResult(requestCode, resultCode, data);
                     callbackManager.onActivityResult(requestCode, resultCode, data);
                 }

    }

}
