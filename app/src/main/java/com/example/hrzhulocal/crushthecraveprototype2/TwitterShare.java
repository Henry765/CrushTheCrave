package com.example.hrzhulocal.crushthecraveprototype2;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import java.io.File;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Fabric;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

public class TwitterShare extends ActionBarActivity {
    int[] ImageFile3 = {R.drawable.iconcommitted_sel, R.drawable.iconquitdate_sel, R.drawable.iconday1_sel, R.drawable.iconweek1_sel, R.drawable.iconweek3_sel,
            R.drawable.iconmouth1_sel, R.drawable.icon100cigarettes_sel, R.drawable.icon250cigarettes_sel,  R.drawable.icon500cigarettes_sel, R.drawable.iconsmoked_sel,
            R.drawable.iconcarvings_sel, R.drawable.icon100_sel, R.drawable.icon500_sel, R.drawable.icon1000_sel, R.drawable.iconoxygen2_sel, R.drawable.iconoxygen_sel,
            R.drawable.icono2_sel, R.drawable.iconbetterhealth_sel, R.drawable.iconnicotine_sel, R.drawable.icontasteandsmell_sel, R.drawable.iconhappyheart_sel,
            R.drawable.iconheart2_sel, R.drawable.iconshare_sel, R.drawable.iconfeedback_sel, R.drawable.iconnightout_sel};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_share);
        TwitterAuthConfig authConfig =  new TwitterAuthConfig("consumerKey", "consumerSecret");
        Fabric.with(this, new TwitterCore(authConfig), new TweetComposer());

        //File myImageFile = new File("O:/Students/CTC Coop/CTC Version/June5 after meeting/CrushTheCravePrototype2/app/src/main/res/drawable/btngames");
        //File myImageFile = new File("O:\\Students\\CTC Coop\\CTC Version\\June5 after meeting\\CrushTheCravePrototype2\\app\\src\\main\\res\\drawable\\icon100cigarettes_sel.png");
//file:///O:/Students/CTC%20Coop/CTC%20Version/June5%20after%20meeting/CrushTheCravePrototype2/app/src/main/res/drawable/icon100cigarettes_sel.png
        //file:///c|/WINDOWS/clock.avi
        //f:\June 30\CrushTheCravePrototype2\app\src\main\res\drawable
        File myImageFile = new File("file:///f:/June 30/CrushTheCravePrototype2/app/src/main/res/drawable/icon100cigarettes_sel.png");

        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("just setting up my Fabric.")
                .image(Uri.fromFile(myImageFile));
        builder.show();
    }

}
