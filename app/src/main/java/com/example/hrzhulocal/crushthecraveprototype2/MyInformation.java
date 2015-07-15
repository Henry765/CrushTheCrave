package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
  import android.app.Activity;
  import android.os.Bundle;
  import android.view.Menu;
  import android.view.View;
  import android.view.View.OnClickListener;
  import android.widget.Button;
  import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
public class MyInformation extends MySettings{

    ImageButton save, load;
    EditText message, message2, message3;
    String Message, Message2, Message3;
    int data_block = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_information);
        save=(ImageButton) findViewById(R.id.imageButton24);  //update is same is save here
        load = (ImageButton) findViewById(R.id.imageButton23);
        message = (EditText) findViewById(R.id.editText6);
        message2 = (EditText) findViewById(R.id.editText12);
        message3 = (EditText) findViewById(R.id.editText13);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message = message.getText().toString();
                Message2 = message2.getText().toString();
                Message3 = message3.getText().toString();
                try {
                    //1. Create an object of the FileOutputStream class using the openFileOutput method.
                    //MODE_WORLD_READABLE Allows to write permission to all the applications
                    FileOutputStream fou = openFileOutput("myinformation.txt", MODE_WORLD_READABLE);
                    //2. Get an object of the OutPutStreamWriter class using the FileOutputStream object.
                    OutputStreamWriter osw = new OutputStreamWriter(fou);
                    try {
                        //3. Write the data
                        osw.write(Message);
                        osw.write(Message2);
                        osw.write(Message3);
                        osw.flush();
                        osw.close();

                        Toast.makeText(getBaseContext(), "Data saved", Toast.LENGTH_SHORT).show();

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
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //4. For reading the data from the file, first you need to create an object of the FileInputStream class.
                    FileInputStream fis = openFileInput("myinformation.txt");
                    //5. Get an object of the InputStreamReader class .
                    InputStreamReader isr = new InputStreamReader(fis);
                    char[] data = new char[data_block];
                    String final_data = "";
                    int size;
                    //there is 80 character, this size will return into the variable size
                    try {
                        while ((size = isr.read(data)) > 0) {
                            //copy each string of data in this string read_data
                            String read_data = String.copyValueOf(data, 0, size);
                            //attach each piece of read_data the final string
                            final_data += read_data;
                            data = new char[data_block];
                        }
                        Toast.makeText(getBaseContext(), "Message :"+final_data, Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        addListenerOnHomeImageButton();
        addListenerOnAwardImageButton();
        addListenerOnProgressImageButton();
        addListenerOnQuitHelpImageButton();
        addListenerOnMoreImageButton();
        }


            //@Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_my_information, menu);
                return true;
            }
        }

