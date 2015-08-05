package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;


public class DistractMe extends CraveActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distract_me);
        final Context context = this;

        addListenerOnGameWack();
        addListenerOnGameTicTacToe();
        ListenerOpenSMSAPP();
        ListenerrOpenYouTubeAPP();
        ListenerMusic();
        ListenerMoreGame();
        addListenerOnHomeImageButton();
        addListenerOnAwardImageButton();
        addListenerOnProgressImageButton();
        addListenerOnQuitHelpImageButton();
        addListenerOnMoreImageButton();    }

    private void ListenerOpenSMSAPP() {
        imageButton = (ImageButton) findViewById(R.id.imageButton25);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_VIEW);//ACTION_MAIN);
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);
            }
        });
    }

    private void addListenerOnGameTicTacToe() {
        imageButton = (ImageButton) findViewById(R.id.imageButton26);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, com.example.hrzhulocal.crushthecraveprototype2.TicTacToe.class);
                startActivity(intent);
            }
        });
    }


    private void addListenerOnGameWack() {
        imageButton = (ImageButton) findViewById(R.id.imageButton17);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(context, com.example.hrzhulocal.crushthecraveprototype2.Help.class);
                startActivity(intent);
            }
        });
    }

    private void ListenerMoreGame() {
        final Context context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton14);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               // Uri uri = Uri.parse("vnd.market:");
                Uri uri = Uri.parse("https://play.google.com/store/apps");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });
    }
            private void ListenerMusic() {
                imageButton = (ImageButton) findViewById(R.id.imageButton18);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        try {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"));
                            startActivity(intent);
                        } catch (ActivityNotFoundException ex) {
                            Intent intent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://www.youtube.com/channel/UC-9-kyTW8ZkZNDHQJ6FgpwQ"));
                            startActivity(intent);
                        }
                    }
                });
            }

            private void ListenerrOpenYouTubeAPP() {
                imageButton = (ImageButton) findViewById(R.id.imageButton19);

                imageButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        try {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"));
                            startActivity(intent);
                        } catch (ActivityNotFoundException ex) {
                            Intent intent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://www.youtube.com/"));
                            startActivity(intent);
                        }
                /*Intent intent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/channel/UCRmoG8dTnv0B7y9uoocikLw"));
                intent.setComponent(new ComponentName("com.google.android.youtube", "com.google.android.youtube.PlayerActivity"));

                PackageManager manager = context.getPackageManager();
                List<ResolveInfo> infos = manager.queryIntentActivities(intent, 0);
                if (infos.size() > 0) {
                    context.startActivity(intent);
                } else {
                    //No Application can handle your intent
                }*/
                    }
                });
            }

            public void watchYoutubeVideo(String id) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
                    startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.youtube.com/watch?v=" + id));
                    startActivity(intent);
                }
            }
        }



