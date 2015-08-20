package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.FacebookSdk;

public class My_AwardsActivity extends MainActivityHome {

    public static int ShareOption = 0;
    public static int[] TotalAwardEarnArray = new int[20];
    public static int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_my__awards);

        //****************
        loadDate();
        loadSetUpInformation();
        //****************
        // initializa all values to 0
        for(int i = 0; i < TotalAwardEarnArray.length; i++){
            TotalAwardEarnArray[i] = 0;
        }
        final ImageButton ib33 = (ImageButton) findViewById(R.id.imageButton33);
        ImageButton ib34 = (ImageButton) findViewById(R.id.imageButton34);
        ImageButton ib35 = (ImageButton) findViewById(R.id.imageButton35);
        ImageButton ib36 = (ImageButton) findViewById(R.id.imageButton36);
        ImageButton ib37 = (ImageButton) findViewById(R.id.imageButton37);
        ImageButton ib38 = (ImageButton) findViewById(R.id.imageButton38);
        ImageButton ib39 = (ImageButton) findViewById(R.id.imageButton39);
        ImageButton ib40 = (ImageButton) findViewById(R.id.imageButton40);
        ImageButton ib42 = (ImageButton) findViewById(R.id.imageButton42);
        ImageButton ib43 = (ImageButton) findViewById(R.id.imageButton43);
        ImageButton ib44 = (ImageButton) findViewById(R.id.imageButton44);
        ImageButton ib45 = (ImageButton) findViewById(R.id.imageButton45);

        ImageButton ib46 = (ImageButton) findViewById(R.id.imageButton46);
        ImageButton ib47 = (ImageButton) findViewById(R.id.imageButton47);

        ImageButton ib49 = (ImageButton) findViewById(R.id.imageButton49);
        ImageButton ib50 = (ImageButton) findViewById(R.id.imageButton50);
        ImageButton ib51 = (ImageButton) findViewById(R.id.imageButton51);

        ImageButton ib52 = (ImageButton) findViewById(R.id.imageButton52);
        ImageButton ib53 = (ImageButton) findViewById(R.id.imageButton53);

        ImageButton ib55 = (ImageButton) findViewById(R.id.imageButton55);
        ImageButton ib56 = (ImageButton) findViewById(R.id.imageButton56);
        ImageButton ib57 = (ImageButton) findViewById(R.id.imageButton57);

//        RelativeLayout rl = (RelativeLayout) findViewById(R.id.MyAwardInnerRL);

        ImageButton fbIDbetterHeart = (ImageButton) findViewById(R.id.fbIDbetterHeart);
        ImageButton fbIDbetterHeart2 = (ImageButton) findViewById(R.id.fbIDbetterHeart2);

        ImageView iv5 = (ImageView) findViewById(R.id.imageView5);

        TextView numberOfAwards = (TextView) findViewById(R.id.textView87);
   //     rl.getLayoutParams().height = 400;
        //setImageButtonEnabled(this, false, ib33, R.id.imageButton33);
        /*setImageButtonEnabled(this, false, fbShareweek1, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbShareweek3, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbShareMonth1, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbShare100C, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbID250cig, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbID500cig, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbID1000cig, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbID500saved, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbID1000saved, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbIDBreatheEasier, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbIDBreatheEasier2, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbIDO2, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbIDbetterhealth, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbIDNicotine, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbIDbetterSmell, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbIDbetterHeart, R.drawable.btnsighup_new);
        setImageButtonEnabled(this, false, fbIDbetterHeart, R.drawable.btnsighup_new);*/


        //setImageButtonEnabled(this, false, ib34, R.drawable.iconday1_sel);
        //setImageButtonEnabled(this, false, ib35, R.id.imageButton35);
        //setImageButtonEnabled(this, false, ib36, R.id.imageButton36);
        //setImageButtonEnabled(this, false, ib37, R.id.imageButton37);
        /*ImageButton fbShareQuitDay = (ImageButton) findViewById(R.id.fbidquitdate);
        ImageButton fbShareDay1 = (ImageButton) findViewById(R.id.fbidFirstDay);
        ImageButton fbShareweek1 = (ImageButton) findViewById(R.id.fbIDweek1);
        ImageButton fbShareweek3 = (ImageButton) findViewById(R.id.fbIDweek3);
        ImageButton fbShareMonth1 = (ImageButton) findViewById(R.id.fbIDmonth1);
        ImageButton fbShare100C = (ImageButton) findViewById(R.id.fbID100cig);
        ImageButton fbID250cig = (ImageButton) findViewById(R.id.fbID250cig);
        ImageButton fbID500cig = (ImageButton) findViewById(R.id.fbID500cig);
        ImageButton fbID1000cig = (ImageButton) findViewById(R.id.fbID100saved);
        ImageButton fbID500saved = (ImageButton) findViewById(R.id.fbID500saved);
        ImageButton fbID1000saved = (ImageButton) findViewById(R.id.fbID1000saved);
        ImageButton fbIDBreatheEasier = (ImageButton) findViewById(R.id.fbIDBreatheEasier);
        ImageButton fbIDBreatheEasier2 = (ImageButton) findViewById(R.id.fbIDBreatheEasier2);
        ImageButton fbIDO2 = (ImageButton) findViewById(R.id.fbIDO2);
        ImageButton fbIDbetterhealth = (ImageButton) findViewById(R.id.fbIDbetterhealth);
        ImageButton fbIDNicotine = (ImageButton) findViewById(R.id.fbIDNicotine);
        ImageButton fbIDbetterSmell = (ImageButton) findViewById(R.id.fbIDbetterSmell);
        ImageButton fbIDbetterHeart = (ImageButton) findViewById(R.id.fbIDbetterHeart);
        ImageButton fbIDbetterHeart2 = (ImageButton) findViewById(R.id.fbIDbetterHeart2);*/
        // check for awards
        if (quitDayNum6 != -1) {
            ib33.setImageResource(R.drawable.iconquitdate_sel);
            TotalAwardEarnArray[1]++;
        }
        if (smokeFreeDay >= 1) {
            ib34.setImageResource(R.drawable.iconday1_sel);
            //ib35.setImageResource(R.drawable.rsz_icon_locked_half);
            ib36.setImageResource(R.drawable.rsz_icon_locked_half);
            ib37.setImageResource(R.drawable.rsz_icon_locked_half);
            TotalAwardEarnArray[2]++;
        }
        if (smokeFreeDay >= 7) {
            ib47.setImageResource(R.drawable.iconweek1_sel);
            TotalAwardEarnArray[3]++;
        }
        if (smokeFreeDay >= 21) {
            ib36.setImageResource(R.drawable.iconweek3_sel);
            TotalAwardEarnArray[4]++;
        }
        if (smokeFreeDay >= 30) { //one month
            ib53.setImageResource(R.drawable.iconmouth1_sel);
            TotalAwardEarnArray[5]++;
        }
        if (((cigarSmokedPerDay*(daysInBetween-daysInBetween2))-theNumberOfSmoke) >= 100) {
            ib51.setImageResource(R.drawable.icon100cigarettes_sel);
            TotalAwardEarnArray[6]++;
        }
        if (((cigarSmokedPerDay*(daysInBetween-daysInBetween2))-theNumberOfSmoke) >= 250)  {
            ib50.setImageResource(R.drawable.icon250cigarettes_sel);
            TotalAwardEarnArray[7]++;
        }
        if (((cigarSmokedPerDay*(daysInBetween-daysInBetween2))-theNumberOfSmoke) >= 500)  {
            ib52.setImageResource(R.drawable.icon500cigarettes_sel);
            TotalAwardEarnArray[8]++;
        }
        //if(trak of smoking)()
        //if(track of craving){}
        if(moneySavedTotal >= 100){
            ib45.setImageResource(R.drawable.icon100_sel);
            TotalAwardEarnArray[9]++;
        }
        if(moneySavedTotal >= 500){
            ib35.setImageResource(R.drawable.icon500_sel);
            TotalAwardEarnArray[10]++;
        }
        if(moneySavedTotal >= 1000){
            ib55.setImageResource(R.drawable.icon1000_sel);
            TotalAwardEarnArray[11]++;
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////1:16 monday
        if((daysInBetween - daysInBetween2) >= 2){
            ib56.setImageResource(R.drawable.iconoxygen2_sel);
            TotalAwardEarnArray[12]++;
        }
        if((daysInBetween - daysInBetween2) >= 90){
            ib49.setImageResource(R.drawable.iconoxygen_sel);
            TotalAwardEarnArray[13]++;
        }
        if(daysInBetween >= daysInBetween2) {
            if ((double) ((daysInBetween - daysInBetween2) / 24) >= (double) (8 / 24)) {
                ib39.setImageResource(R.drawable.icono2_sel);
                TotalAwardEarnArray[14]++;
            }
        }
        if ((daysInBetween2 - daysInBetween) >= 180) {
            ib37.setImageResource(R.drawable.iconbetterhealth_sel);
            TotalAwardEarnArray[15]++;
        }
        if((daysInBetween2 - daysInBetween) >= 14){
            ib43.setImageResource(R.drawable.iconnicotine_sel);
            TotalAwardEarnArray[16]++;
        }
        if(daysInBetween >= daysInBetween2) {
            if ((daysInBetween2 - daysInBetween) >= 2) {
                ib42.setImageResource(R.drawable.icontasteandsmell_sel);
                ib40.setImageResource(R.drawable.iconhappyheart_sel);
                TotalAwardEarnArray[17]++;
            }
        }
        if((daysInBetween2 - daysInBetween) >= 365){
            ib57.setImageResource(R.drawable.iconheart2_sel);
            TotalAwardEarnArray[18]++;
        }
        //x represent total number of award earned, x is 1 because Committed award is always earned
        x = 1;
        //calculate the number of award earned
        for(int i = 0; i < Committed.TotalAwardEarnArray.length; i++ )
        {
            if(Committed.TotalAwardEarnArray[i] != 0)
            {
                //wrong x++; here
                x = x + 1;
            }
        }
        numberOfAwards.setText(x+"/20 Award Earned");
        listenerCommitted();
        listenerQuitDate();
        listenerDay1();
        listenerWeek1();
        listenerWeek3();
        listenerMonth1();
        listener100Cig();
        listener250Cig();
        listener500Cig();
        listener100Saved();
        listener500Saved();
        listener1000Saved();
        listenerBreatheEasier();
        listenerBreatheEasier2();
        listenerO2();
        listenerBetterHealth();
        listenerNicotineFree();
        listenerBetterTasteAndSmell();
        listenerHappyHeart();
        listenerHappyHeart2();
    }
    /**
     * Sets the specified image buttonto the given state, while modifying or
     * "graying-out" the icon as well
     *
     * @param //enabled The state of the menu item
     * @param //item The menu item to modify
     * @param //iconResId The icon ID
     */
    public static void setImageButtonEnabled(Context ctxt, boolean enabled, ImageButton item,
                                             int iconResId) {
        item.setEnabled(enabled);
        Drawable originalIcon = ctxt.getResources().getDrawable(iconResId);
        Drawable icon = enabled ? originalIcon : convertDrawableToGrayScale(originalIcon);
        //Bitmap originalIcon = BitmapFactory.decodeResource(getResources(), iconResId);//ImageFile[myawardactivity.ShareOption]);//Iarrayhelp.helperImageFile[1]));//icon100cigarettes_sel);
        //Bitmap icon = enabled ? originalIcon : convertDrawableToGrayScale(originalIcon);
        item.setImageDrawable(icon);
    }
    /*
     * Mutates and applies a filter that converts the given drawable to a Gray
     * image. This method may be used to simulate the color of disable icons in
     * Honeycomb's ActionBar.
     *
     * @return a mutated version of the given drawable with a color filter
     *         applied.*/

    public static Drawable convertDrawableToGrayScale(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Drawable res = drawable.mutate();
        res.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
        return res;
    }
    /*ImageButton fbShareweek1 = (ImageButton) findViewById(R.id.fbIDweek1);
    ImageButton fbShareweek3 = (ImageButton) findViewById(R.id.fbIDweek3);
    ImageButton fbShareMonth1 = (ImageButton) findViewById(R.id.fbIDmonth1);
    ImageButton fbShare100C = (ImageButton) findViewById(R.id.fbID100cig);
    ImageButton fbID250cig = (ImageButton) findViewById(R.id.fbID250cig);
    ImageButton fbID500cig = (ImageButton) findViewById(R.id.fbID500cig);
    ImageButton fbID1000cig = (ImageButton) findViewById(R.id.fbID100saved);
    ImageButton fbID500saved = (ImageButton) findViewById(R.id.fbID500saved);
    ImageButton fbID1000saved = (ImageButton) findViewById(R.id.fbID1000saved);
    ImageButton fbIDBreatheEasier = (ImageButton) findViewById(R.id.fbIDBreatheEasier);
    ImageButton fbIDBreatheEasier2 = (ImageButton) findViewById(R.id.fbIDBreatheEasier2);
    ImageButton fbIDO2 = (ImageButton) findViewById(R.id.fbIDO2);
    ImageButton fbIDbetterhealth = (ImageButton) findViewById(R.id.fbIDbetterhealth);
    ImageButton fbIDNicotine = (ImageButton) findViewById(R.id.fbIDNicotine);
    ImageButton fbIDbetterSmell = (ImageButton) findViewById(R.id.fbIDbetterSmell);
    ImageButton fbIDbetterHeart = (ImageButton) findViewById(R.id.fbIDbetterHeart);
    ImageButton fbIDbetterHeart2 = (ImageButton) findViewById(R.id.fbIDbetterHeart2);*/

   /* ImageButton fbShareDay1 = (ImageButton) findViewById(R.id.fbidFirstDay);
    ImageButton fbShareweek1 = (ImageButton) findViewById(R.id.fbIDweek1);
    ImageButton fbShareweek3 = (ImageButton) findViewById(R.id.fbIDweek3);
    ImageButton fbShareMonth1 = (ImageButton) findViewById(R.id.fbIDmonth1);
    ImageButton fbShare100C = (ImageButton) findViewById(R.id.fbID100cig);
    ImageButton fbID250cig = (ImageButton) findViewById(R.id.fbID250cig);
    ImageButton fbID500cig = (ImageButton) findViewById(R.id.fbID500cig);
    ImageButton fbID1000cig = (ImageButton) findViewById(R.id.fbID100saved);
    ImageButton fbID500saved = (ImageButton) findViewById(R.id.fbID500saved);
    ImageButton fbID1000saved = (ImageButton) findViewById(R.id.fbID1000saved);
    ImageButton fbIDBreatheEasier = (ImageButton) findViewById(R.id.fbIDBreatheEasier);
    ImageButton fbIDBreatheEasier2 = (ImageButton) findViewById(R.id.fbIDBreatheEasier2);
    ImageButton fbIDO2 = (ImageButton) findViewById(R.id.fbIDO2);
    ImageButton fbIDbetterhealth = (ImageButton) findViewById(R.id.fbIDbetterhealth);
    ImageButton fbIDNicotine = (ImageButton) findViewById(R.id.fbIDNicotine);
    ImageButton fbIDbetterSmell = (ImageButton) findViewById(R.id.fbIDbetterSmell);
    ImageButton fbIDbetterHeart = (ImageButton) findViewById(R.id.fbIDbetterHeart);
    ImageButton fbIDbetterHeart2 = (ImageButton) findViewById(R.id.fbIDbetterHeart2);*/
    public void ListenerShare(){
        final Context context = this;

        switch(ShareOption) {
            case 0:
                ImageButton fb0 = (ImageButton) findViewById(R.id.fbIDquitdate);//notice the difference);
                fb0.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 1:
                ImageButton fb = (ImageButton) findViewById(R.id.fbidquitdate);//imageButton58);
                fb.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 2:
                ImageButton fb2 = (ImageButton) findViewById(R.id.fbidFirstDay);
                fb2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 3:
                ImageButton fb3 = (ImageButton) findViewById(R.id.fbIDweek1);//imageButton58);
                fb3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 4:
                ImageButton fb4 = (ImageButton) findViewById(R.id.fbIDweek3);
                fb4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 5:
                ImageButton fb5 = (ImageButton) findViewById(R.id.fbIDmonth1);
                fb5.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 6:
                ImageButton fb6 = (ImageButton) findViewById(R.id.fbID100cig);
                fb6.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 7:
                ImageButton fb7 = (ImageButton) findViewById(R.id.fbID250cig);
                fb7.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 8:
                ImageButton fb8 = (ImageButton) findViewById(R.id.fbID500cig);
                fb8.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 9:
                ImageButton fb9 = (ImageButton) findViewById(R.id.fbID100saved);
                fb9.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 10:
                ImageButton fb10 = (ImageButton) findViewById(R.id.fbID500saved);
                fb10.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 11:
                ImageButton fb11 = (ImageButton) findViewById(R.id.fbID1000saved);
                fb11.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 12:
                ImageButton fb12 = (ImageButton) findViewById(R.id.fbIDBreatheEasier);
                fb12.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 13:
                ImageButton fb13 = (ImageButton) findViewById(R.id.fbIDBreatheEasier2);
                fb13.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 14:
                ImageButton fb14 = (ImageButton) findViewById(R.id.fbIDO2);
                fb14.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 15:
                ImageButton fb15 = (ImageButton) findViewById(R.id.fbIDbetterhealth);
                fb15.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 16:
                ImageButton fb16 = (ImageButton) findViewById(R.id.fbIDNicotine);
                fb16.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 17:
                ImageButton fb17 = (ImageButton) findViewById(R.id.fbIDbetterSmell);
                fb17.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 18:
                ImageButton fb18 = (ImageButton) findViewById(R.id.fbIDbetterHeart);
                fb18.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
            case 19:
                ImageButton fb19 = (ImageButton) findViewById(R.id.fbIDbetterHeart2);
                fb19.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SocialMediaOptions.class);
                        startActivity(intent);
                    }
                });
                break;
        }
    }

    private void listenerCommitted() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton32);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 0;
                Intent intent = new Intent(context, Committed.AwardCommitted.class);
                startActivity(intent);
            }
        });
    }

    private void listenerQuitDate() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton33);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 1;
                Intent intent = new Intent(context, Committed.AwardQuitDate.class);
                startActivity(intent);
            }
        });
    }
    private void listenerDay1() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton34);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 2;
                Intent intent = new Intent(context, Committed.AwardDay1.class);
                startActivity(intent);
            }
        });
    }

    private void listenerWeek1() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton47);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 3;
                Intent intent = new Intent(context, Committed.AwardWeek1.class);
                startActivity(intent);
            }
        });
    }

    private void listenerWeek3() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton36);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 4;
                Intent intent = new Intent(context, Committed.AwardWeek3.class);
                startActivity(intent);
            }
        });
    }

    private void listenerMonth1() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton53);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 5;
                Intent intent = new Intent(context, Committed.AwardMonth1.class);
                startActivity(intent);
            }
        });
    }

    private void listener100Cig() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton51);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 6;
                Intent intent = new Intent(context, Committed.Award100Cig.class);
                startActivity(intent);
            }
        });
    }

    private void listener250Cig() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton50);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 7;
                Intent intent = new Intent(context, Committed.Award250Cig.class);
                startActivity(intent);
            }
        });
    }

    private void listener500Cig() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton52);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 8;
                Intent intent = new Intent(context, Committed.Award500Cig.class);
                startActivity(intent);
            }
        });
    }

    private void listener100Saved() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton45);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 9;
                Intent intent = new Intent(context, Committed.Award100Saved.class);
                startActivity(intent);
            }
        });
    }

    private void listener500Saved() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton35);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 10;
                Intent intent = new Intent(context, Committed.Award500Saved.class);
                startActivity(intent);
            }
        });
    }

    private void listener1000Saved() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton55);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 11;
                Intent intent = new Intent(context, Committed.Award1000Saved.class);
                startActivity(intent);
            }
        });
    }

    private void listenerBreatheEasier() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton56);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 12;
                Intent intent = new Intent(context, Committed.AwardBreatheEasier.class);
                startActivity(intent);
            }
        });
    }

    private void listenerBreatheEasier2() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton49);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 13;
                Intent intent = new Intent(context, Committed.AwardBreatheEasier2.class);
                startActivity(intent);
            }
        });
    }

    private void listenerO2() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton39);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 14;
                Intent intent = new Intent(context, Committed.AwardO2.class);
                startActivity(intent);
            }
        });
    }
    private void listenerBetterHealth() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton37);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 15;
                Intent intent = new Intent(context, Committed.AwardBetterHealth.class);
                startActivity(intent);
            }
        });
    }   private void listenerNicotineFree() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton43);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 16;
                Intent intent = new Intent(context, Committed.AwardNicotineFree.class);
                startActivity(intent);
            }
        });
    }   private void listenerBetterTasteAndSmell() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton42);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 17;
                Intent intent = new Intent(context, Committed.AwardBetterTasteAndSmell.class);
                startActivity(intent);
            }
        });
    }   private void listenerHappyHeart() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton40);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 18;
                Intent intent = new Intent(context, Committed.AwardHappyHeart.class);
                startActivity(intent);
            }
        });
    }private void listenerHappyHeart2() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton57);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ShareOption = 19;
                Intent intent = new Intent(context, Committed.AwardHappyHeart2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_home, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent3 = new Intent(this, MySettings.class);
            startActivity(intent3);
        }
        switch(item.getItemId()){
            case R.id.mainFB:
                //Committed award
                My_AwardsActivity.ShareOption = 0;
                Intent intent = new Intent(this, FaceBookShare.class);
                startActivity(intent);
            case R.id.mainTW:
                Intent intent2 = new Intent(this, TwitterShare.class);
                startActivity(intent2);
        }

        return super.onOptionsItemSelected(item);
    }
}