package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;


public class MyPersonalization extends MainActivityHome {

    public static EditText message;
    public static String MessageMyPer;
    int data_block22 = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_personalization);
        ImageButton save = (ImageButton) findViewById(R.id.imageButton29);   // save is the same as update
        //ImageButton load = (ImageButton) findViewById(R.id.imageButton30);
        message = (EditText) findViewById(R.id.editText14);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageMyPer = message.getText().toString();
                try {
                    //1. Create an object of the FileOutputStream class using the openFileOutput method.
                    //MODE_WORLD_READABLE Allows to write permission to all the applications
                    FileOutputStream fou = openFileOutput("myPersonalization.txt", MODE_WORLD_READABLE);
                    //2. Get an object of the OutPutStreamWriter class using the FileOutputStream object.
                    OutputStreamWriter osw = new OutputStreamWriter(fou);
                    try {
                        //3. Write the data
                        osw.write(MessageMyPer);
                        osw.flush();
                        osw.close();

                        Toast.makeText(getBaseContext(), "Data saved", Toast.LENGTH_SHORT).show();

                        try {
                            //4. For reading the data from the file, first you need to create an object of the FileInputStream class.
                            FileInputStream fis = openFileInput("myPersonalization.txt");
                            //5. Get an object of the InputStreamReader class .
                            InputStreamReader isr = new InputStreamReader(fis);
                            char[] data = new char[data_block22];
                            final_data22 = "";
                            int size;
                            //there is 80 character, this size will return into the variable size
                            try {
                                while ((size = isr.read(data)) > 0) {
                                    //copy each string of data in this string read_data
                                    String read_data = String.copyValueOf(data, 0, size);
                                    //attach each piece of read_data the final string
                                    final_data22 += read_data;
                                    data = new char[data_block22];
                                }
                                Toast.makeText(getBaseContext(), "Message :" + final_data22, Toast.LENGTH_LONG).show();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        //TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_personalization, menu);
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
