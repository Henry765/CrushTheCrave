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
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

public class TwitterShare extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_share);
        TwitterAuthConfig authConfig =  new TwitterAuthConfig("consumerKey", "consumerSecret");
        Fabric.with(this, new TwitterCore(authConfig), new TweetComposer());

        //File myImageFile = new File("O:/Students/CTC Coop/CTC Version/June5 after meeting/CrushTheCravePrototype2/app/src/main/res/drawable/btngames");
        //File myImageFile = new File("O:\\Students\\CTC Coop\\CTC Version\\June5 after meeting\\CrushTheCravePrototype2\\app\\src\\main\\res\\drawable\\icon100cigarettes_sel.png");
//file:///O:/Students/CTC%20Coop/CTC%20Version/June5%20after%20meeting/CrushTheCravePrototype2/app/src/main/res/drawable/icon100cigarettes_sel.png
        File myImageFile = new File("O:/Students/CTC%20Coop/CTC%20Version/June5%20after%20meeting/CrushTheCravePrototype2/app/src/main/res/drawable/icon100cigarettes_sel.png");

        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("just setting up my Fabric.")
                .image(Uri.fromFile(myImageFile));
        builder.show();
    }

}
