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
            ImageButton fbShareweek3 = (ImageButton) findViewById(R.id.fbIDweek3);
            setImageButtonEnabled(this, false, fbShareweek3, R.drawable.btnsighup_new);
            if(smokeFreeDay >= 21){
                setImageButtonEnabled(this, true, fbShareweek3, R.drawable.btnsighup_new);

            }
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
            ImageButton fbShareweek1 = (ImageButton) findViewById(R.id.fbIDweek1);
            setImageButtonEnabled(this, false, fbShareweek1, R.drawable.btnsighup_new);
            if (smokeFreeDay >= 7) {
                setImageButtonEnabled(this, true, fbShareweek1, R.drawable.btnsighup_new);
            }
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
            ImageButton fbShareQuitDay = (ImageButton) findViewById(R.id.fbidquitdate);
            setImageButtonEnabled(this, false, fbShareQuitDay, R.drawable.btnsighup_new);
            // if user set at least one quit date
            if (quitDayNum6 != -1) {
                setImageButtonEnabled(this, true, fbShareQuitDay, R.drawable.btnsighup_new);
            }
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
            ImageButton fbIDO2 = (ImageButton) findViewById(R.id.fbIDO2);
            setImageButtonEnabled(this, false, fbIDO2, R.drawable.btnsighup_new);
            if((double)((daysInBetween - daysInBetween2)/24) >= (double)(8/24)){
                setImageButtonEnabled(this, true, fbIDO2, R.drawable.btnsighup_new);
            }
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
            ImageButton fbIDNicotine = (ImageButton) findViewById(R.id.fbIDNicotine);
            setImageButtonEnabled(this, false, fbIDNicotine, R.drawable.btnsighup_new);
            if((daysInBetween2 - daysInBetween) >= 14){
                setImageButtonEnabled(this, true, fbIDNicotine, R.drawable.btnsighup_new);
            }
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
            ImageButton fbShareMonth1 = (ImageButton) findViewById(R.id.fbIDmonth1);
            setImageButtonEnabled(this, false, fbShareMonth1, R.drawable.btnsighup_new);
            if( smokeFreeDay >= 30 ){
                setImageButtonEnabled(this, true, fbShareMonth1, R.drawable.btnsighup_new);
            }
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
            ImageButton fbIDbetterHeart2 = (ImageButton) findViewById(R.id.fbIDbetterHeart2);
            setImageButtonEnabled(this, false, fbIDbetterHeart2, R.drawable.btnsighup_new);
            if((daysInBetween2 - daysInBetween) >= 365){
                setImageButtonEnabled(this, true, fbIDbetterHeart2, R.drawable.btnsighup_new);
            }

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
            ImageButton fbIDbetterHeart = (ImageButton) findViewById(R.id.fbIDbetterHeart);
            setImageButtonEnabled(this, false, fbIDbetterHeart, R.drawable.btnsighup_new);
            if((daysInBetween2 - daysInBetween) >= 2) {
                setImageButtonEnabled(this, true, fbIDbetterHeart, R.drawable.btnsighup_new);

            }
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
            ImageButton fbShareDay1 = (ImageButton) findViewById(R.id.fbidFirstDay);
            setImageButtonEnabled(this, false, fbShareDay1, R.drawable.btnsighup_new);
            if (smokeFreeDay >= 1) {
                setImageButtonEnabled(this, true, fbShareDay1, R.drawable.btnsighup_new);
            }
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
            ImageButton fbIDBreatheEasier2 = (ImageButton) findViewById(R.id.fbIDBreatheEasier2);
            setImageButtonEnabled(this, false, fbIDBreatheEasier2, R.drawable.btnsighup_new);
            if((daysInBetween - daysInBetween2) >= 90){
                setImageButtonEnabled(this, true, fbIDBreatheEasier2, R.drawable.btnsighup_new);
            }
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
            ImageButton fbIDBreatheEasier = (ImageButton) findViewById(R.id.fbIDBreatheEasier);
            setImageButtonEnabled(this, false, fbIDBreatheEasier, R.drawable.btnsighup_new);
            if((daysInBetween - daysInBetween2) >= 2) {
                setImageButtonEnabled(this, true, fbIDBreatheEasier, R.drawable.btnsighup_new);
            }
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
            ImageButton fbIDbetterSmell = (ImageButton) findViewById(R.id.fbIDbetterSmell);
            setImageButtonEnabled(this, false, fbIDbetterSmell, R.drawable.btnsighup_new);
            if((daysInBetween2 - daysInBetween) >= 2) {
                setImageButtonEnabled(this, true, fbIDbetterSmell, R.drawable.btnsighup_new);

            }

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
            ImageButton fbIDbetterhealth = (ImageButton) findViewById(R.id.fbIDbetterhealth);
            setImageButtonEnabled(this, false, fbIDbetterhealth, R.drawable.btnsighup_new);
            if ((daysInBetween2 - daysInBetween) >= 180) {
                setImageButtonEnabled(this, true, fbIDbetterhealth, R.drawable.btnsighup_new);
            }
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
            ImageButton fbID1000saved = (ImageButton) findViewById(R.id.fbID1000saved);
            setImageButtonEnabled(this, false, fbID1000saved, R.drawable.btnsighup_new);
            if(moneySavedTotal >= 1000) {
                setImageButtonEnabled(this, true, fbID1000saved, R.drawable.btnsighup_new);

            }
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
            ImageButton fbID500saved = (ImageButton) findViewById(R.id.fbID500saved);
            setImageButtonEnabled(this, false, fbID500saved, R.drawable.btnsighup_new);
            if (moneySavedTotal >= 500)  {
                setImageButtonEnabled(this, true, fbID500saved, R.drawable.btnsighup_new);

            }
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
            ImageButton fbID500cig = (ImageButton) findViewById(R.id.fbID500cig);
            setImageButtonEnabled(this, false, fbID500cig, R.drawable.btnsighup_new);
            if (theNumberOfCrave-(cigarSmokedPerDay*(daysInBetween-daysInBetween2)) >= 500) {
                setImageButtonEnabled(this, true, fbID500cig, R.drawable.btnsighup_new);

            }
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
            ImageButton fbID250cig = (ImageButton) findViewById(R.id.fbID250cig);
            setImageButtonEnabled(this, false, fbID250cig, R.drawable.btnsighup_new);
            if (theNumberOfCrave-(cigarSmokedPerDay*(daysInBetween-daysInBetween2)) >= 250)  {
                setImageButtonEnabled(this, true, fbID250cig, R.drawable.btnsighup_new);
            }
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
            ImageButton fbID100saved = (ImageButton) findViewById(R.id.fbID100saved);
            setImageButtonEnabled(this, false, fbID100saved, R.drawable.btnsighup_new);
            if(moneySavedTotal >= 100){
                setImageButtonEnabled(this, true, fbID100saved, R.drawable.btnsighup_new);
            }
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
            ImageButton fbShare100C = (ImageButton) findViewById(R.id.fbID100cig);
            setImageButtonEnabled(this, false, fbShare100C, R.drawable.btnsighup_new);
            if( theNumberOfCrave-(cigarSmokedPerDay*(daysInBetween-daysInBetween2)) >= 100){
                setImageButtonEnabled(this, true, fbShare100C, R.drawable.btnsighup_new);
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
