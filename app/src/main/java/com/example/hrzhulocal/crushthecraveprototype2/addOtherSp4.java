package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class addOtherSp4 extends SmokeActivity {

    public addOtherSp4(String triggerEntry) {
        super(triggerEntry);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_other_sp4);

        ImageButton saveSp4 = (ImageButton) findViewById(R.id.imageButton31);
        saveSp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addNewText4 = true;
                EditText message7 = (EditText) findViewById(R.id.editText);
                addNewText4 = 1;
                addOther4 = message7.getText().toString();
                //Message4 = message7.getText().toString();
               // Message4 = sp4.getSelectedItem().toString();
                try {
                    //1. Create an object of the FileOutputStream class using the openFileOutput method.
                    //MODE_WORLD_READABLE Allows to write permission to all the applications
                    FileOutputStream fou2 = openFileOutput("SP4.txt", MODE_WORLD_READABLE);
                    //2. Get an object of the OutPutStreamWriter class using the FileOutputStream object.
                    OutputStreamWriter osw = new OutputStreamWriter(fou2);
                    try {
                        //3. Write the data
                        osw.write(addOther4);
                        osw.flush();
                        osw.close();
                        Toast.makeText(getBaseContext(), "addNewText4 in SP4" +addNewText4 , Toast.LENGTH_LONG).show();

                    } catch (IOException e) {
                        //TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Message4 = addOther4;

                Intent intent = new Intent(context, SmokeActivity.class);
                startActivity(intent);
            }

        });

        /*saveSp4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {

                    //4. For reading the data from the file, first you need to create an object of the FileInputStream class.
                    FileInputStream fis = openFileInput("ADDOTHERSP4.txt");
                    //5. Get an object of the InputStreamReader class .
                    InputStreamReader isr = new InputStreamReader(fis);
                    char[] data = new char[data_block];
                    int size;
                    //there is 80 character, this size will return into the variable size
                    try {
                        while ((size = isr.read(data)) > 0) {
                            //copy each string of data in this string read_data
                            String read_data = String.copyValueOf(data, 0, size);
                            //attach each piece of read_data the final string
                            final_dataSP4 += read_data;
                            data = new char[data_block];
                            Toast.makeText(getBaseContext(), "Data saved be1" + final_dataSP4, Toast.LENGTH_SHORT).show();

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getBaseContext(), "Data saved be12" + final_dataSP4, Toast.LENGTH_SHORT).show();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getBaseContext(), "Data saved be13" + final_dataSP4, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, SmokeActivity.class);
                startActivity(intent);
            }
        });*/
        //Message4 = final_dataSP4;
        //Toast.makeText(getBaseContext(), "Data saved be2" + final_dataSP4, Toast.LENGTH_SHORT).show();
    }
}