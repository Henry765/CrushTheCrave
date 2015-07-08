package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.share.ShareApi;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hrzhulocal on 29/06/2015.
 */
public class FBQuitDate extends FaceBookShare {
    private CallbackManager callbackManager;
    private LoginManager manager;
    ShareDialog shareDialog;

    //create another instance of Committed class to use helperImageFile array
    public Committed arrayhelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        final Context context = this;
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            callbackManager = CallbackManager.Factory.create();
            shareDialog = new ShareDialog(this);

            List<String> permissionNeeds;
            permissionNeeds = Arrays.asList("publish_actions");

            //this loginManager helps you eliminate adding a LoginButton to your UI
            manager = LoginManager.getInstance();

            manager.logInWithPublishPermissions(this, permissionNeeds);

            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("Congratulations!")
                    .setContentDescription(
                            "I earned this quit smoking award!")
                    .build();
            Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.iconquitdate_sel);
            SharePhoto photo = new SharePhoto.Builder()
                    .setBitmap(image)
                    .setCaption("I earned this quit smoking award!")
                    .build();
            SharePhotoContent content = new SharePhotoContent.Builder()
                    .addPhoto(photo)
                    .build();
            ShareApi.share(content, null);
            shareDialog.show(linkContent);

        }
    }
    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
    }

}
