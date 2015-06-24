package com.example.hrzhulocal.crushthecraveprototype2;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hrzhulocal on 15/06/2015.
 */
public class FBMyApplication extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "dLSqeRJVxD8Za5XLJZ17OvHEM";
    private static final String TWITTER_SECRET = "nwLEFcPRv9EqJJpQYFhNGHMXEf6o6rZLtOLkmGvFtWk2iXXWi2";


    @Override
    public void onCreate(){
        super.onCreate();
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        printHashKey();
    }

    public void printHashKey() {
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.hrzhulocal.crushthecraveprototype2",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("hrzhulocal :", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
}
