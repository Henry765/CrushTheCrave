package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.ShareApi;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import java.util.Arrays;
import java.util.List;

public class FaceBookShare extends AppCompatActivity {

    My_AwardsActivity myawardactivity;
    private CallbackManager callbackManager;
    private LoginManager manager;
    ShareDialog shareDialog;
    int[] ImageFile2 = {R.drawable.iconcommitted_sel, R.drawable.iconquitdate_sel, R.drawable.iconday1_sel, R.drawable.iconweek1_sel, R.drawable.iconweek3_sel,
            R.drawable.iconmouth1_sel, R.drawable.icon100cigarettes_sel, R.drawable.icon250cigarettes_sel,  R.drawable.icon500cigarettes_sel,
            R.drawable.icon100_sel, R.drawable.icon500_sel, R.drawable.icon1000_sel, R.drawable.iconoxygen2_sel, R.drawable.iconoxygen_sel,
            R.drawable.icono2_sel, R.drawable.iconbetterhealth_sel, R.drawable.iconnicotine_sel, R.drawable.icontasteandsmell_sel, R.drawable.iconhappyheart_sel,
            R.drawable.iconheart2_sel};
    //create another instance of Committed class to use helperImageFile array
    public Committed arrayhelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        if (ShareDialog.canShow(ShareLinkContent.class)) {
            callbackManager = CallbackManager.Factory.create();
            shareDialog = new ShareDialog(this);

            List<String> permissionNeeds;
            permissionNeeds = Arrays.asList("publish_actions");

            //this loginManager helps you eliminate adding a LoginButton to your UI
            manager = LoginManager.getInstance();

            manager.logInWithPublishPermissions(this, permissionNeeds);
            FaceBookShare test = new FaceBookShare();

            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("Congratulations!")
                    .setContentDescription("I earned this quit smoking award!")
                    .build();
            Bitmap image = BitmapFactory.decodeResource(getResources(), test.CallImageFile(myawardactivity.ShareOption));//ImageFile[myawardactivity.ShareOption]);//Iarrayhelp.helperImageFile[1]));//icon100cigarettes_sel);
                    SharePhoto photo = new SharePhoto.Builder()
                            .setBitmap(image)
                            .setCaption("I earned this quit smoking award!")
                            .build();
            SharePhotoContent content = new SharePhotoContent.Builder()
                    .addPhoto(photo)
                    .build();
            ShareApi.share(content, null);
            shareDialog.show(linkContent);
            onPause();
        }
    }
    public int CallImageFile(int index){
        //return myawardactivity.ImageFile[index];
        return ImageFile2[index];
        //1:48
    }
    /*@Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data) {
        super.onActivityResult(requestCode, responseCode, data);
        callbackManager.onActivityResult(requestCode, responseCode, data);
    }*/

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
    }
}




//show the ShareDialog:
        /*if (ShareDialog.canShow(ShareLinkContent.class)) {
            callbackManager = CallbackManager.Factory.create();
            shareDialog = new ShareDialog(this);

            List<String> permissionNeeds;
            permissionNeeds = Arrays.asList("publish_actions");

            //this loginManager helps you eliminate adding a LoginButton to your UI
            manager = LoginManager.getInstance();

            manager.logInWithPublishPermissions(this, permissionNeeds);

            /////////////////

            final ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("Congratulations!")
                    .setContentDescription(
                            "I earned this quit smoking award!")
                    .build();
            Bitmap image = BitmapFactory.decodeResource(getResources(), Integer.parseInt(arrayhelp.helperImageFile[1]));//icon100cigarettes_sel);
                    SharePhoto photo = new SharePhoto.Builder()
                            .setBitmap(image)
                            .setCaption("I earned this quit smoking award!")
                            .build();
            SharePhotoContent content = new SharePhotoContent.Builder()
                    .addPhoto(photo)
                    .build();
            ShareApi.share(content, new FacebookCallback<Sharer.Result>() {
                @Override
                public void onSuccess(Sharer.Result result) {
                    shareDialog.show(linkContent);

                    Intent intent = new Intent(context, My_AwardsActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onCancel() {
                    Intent intent = new Intent(context, My_AwardsActivity.class);
                    startActivity(intent);
                    Log.v("FACEBOOK_TEST", "share api cancel");
                }

                @Override
                public void onError(FacebookException e) {
                    Log.v("FACEBOOK_TEST", "share api error " + e);
                }
            });*/

        /*BitmapFactory.Options bmOptions = new BitmapFactory.Options();

        bmOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;

        Bitmap image = BitmapFactory.decodeFile(String.valueOf(R.drawable.icon100cigarettes_sel), bmOptions);

        SharePhoto photo = new SharePhoto.Builder().setBitmap(image).build();

        SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();

        Toast.makeText(getApplicationContext(), getString(R.string.facebook_uploading), Toast.LENGTH_SHORT).show();

        ShareApi.share(content, new FacebookCallback<Sharer.Result>() {
            @Override
            public void onSuccess(Sharer.Result result)
            {
                Toast.makeText(getApplicationContext(), getString(R.string.facebookSuccessful), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel()
            {
                Log.v("FACEBOOK_TEST", "share api cancel");
            }

            @Override
            public void onError(FacebookException e)
            {
                Log.v("FACEBOOK_TEST", "share api error " + e);
            }
        });
    }*/


    /*- See more at: http://simpledeveloper.com/how-to-share-an-image-on-facebook-in-android/#sthash.8U7u92TN.dpuf
       callbackManager = CallbackManager.Factory.create();

        List<String> permissionNeeds = Arrays.asList("publish_action");

        //this loginManager helps you eliminate adding a LoginButton to your UI
        manager = LoginManager.getInstance();

        manager.logInWithPublishPermissions(this, permissionNeeds);

        manager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                publishImage();
            }

            @Override
            public void onCancel() {
                System.out.println("onCancel");
            }

            @Override
            public void onError(FacebookException exception) {
                System.out.println("onError");
                Log.v("LoginActivity", exception.getCause().toString());
            }
        });


        shareDialog = new ShareDialog(this);
        //show the ShareDialog:
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("Congratulations!")
                    .setContentDescription(
                            "I earned this quit smoking award!")
                    .build();

            shareDialog.show(linkContent);
            onPause();
        }

    }

    private void publishImage(){
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.icon100cigarettes_sel);

        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(image)
                .build();
        SharePhotoContent content = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();
        ShareApi.share(content, null);

    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data){
        super.onActivityResult(requestCode, responseCode, data);
        callbackManager.onActivityResult(requestCode, responseCode, data);
    }*/
    /*@Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first

    }*/


