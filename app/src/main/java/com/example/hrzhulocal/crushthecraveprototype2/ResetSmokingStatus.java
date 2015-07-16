package com.example.hrzhulocal.crushthecraveprototype2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ResetSmokingStatus extends MainActivityHome {
    private Spinner spinner1;
    ImageButton imageButton;

    Button save, load;
    EditText message, message2, message3, message4, message5, message6;
    String Message, Message2, Message3, Message4, Message5, Message6, Message7, Message8, Message9, Message10;
    int data_block = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_smoking_status);
        addListenerOnSpinnerItemSelection();
        final Spinner sp3 = (Spinner) findViewById(R.id.spinner3);
        message = (EditText) findViewById(R.id.editText5);
        message2 = (EditText) findViewById(R.id.editText7);
        message3 = (EditText) findViewById(R.id.editText8);
        message4 = (EditText) findViewById(R.id.editText2);
        final Spinner sp = (Spinner) findViewById(R.id.spinner);
        final Spinner sp2 = (Spinner) findViewById(R.id.spinner2);
        final Spinner sp7 = (Spinner) findViewById(R.id.spinner7);
        message5 = (EditText) findViewById(R.id.editText10);
        message6 = (EditText) findViewById(R.id.editText11);

        save = (Button) findViewById(R.id.button9);
        load = (Button) findViewById(R.id.button10);
        if(isFirstTimeUserOpenTheApp){
            isFirstTimeUserOpenTheApp = false;
            SharedPreferences sp9 = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor2 = sp9.edit();
            editor2.putBoolean("FIRSTTIME", isFirstTimeUserOpenTheApp);
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Message = message.getText().toString();
                Message2 = message2.getText().toString();
                Message3 = message3.getText().toString();
                Message4 = message4.getText().toString();
                Message5 = message5.getText().toString();
                Message6 = message6.getText().toString();

                Message7 = sp3.getSelectedItem().toString();
                Message8 = sp2.getSelectedItem().toString();
                Message9 = sp.getSelectedItem().toString();*/
                Message = message.getText().toString();
                Message3 = message3.getText().toString();
                Message4 = message4.getText().toString();

                try {
                    //1. Create an object of the FileOutputStream class using the openFileOutput method.
                    //MODE_WORLD_READABLE Allows to write permission to all the applications
                    FileOutputStream fou = openFileOutput("status.txt", MODE_WORLD_READABLE);
                    //2. Get an object of the OutPutStreamWriter class using the FileOutputStream object.
                    OutputStreamWriter osw = new OutputStreamWriter(fou);
                    try {
                        //3. Write the data
                        /*osw.write(Message);
                        osw.write(Message2);
                        osw.write(Message3);

                        osw.write(Message4);
                        osw.write(Message5);
                        osw.write(Message6);

                        osw.write(Message7);
                        osw.write(Message8);
                        osw.write(Message9);*/
                        osw.write(Message);
                        osw.flush();
                        osw.close();

                        Toast.makeText(getBaseContext(), "Data saved1", Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        //TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                try {
                    //1. Create an object of the FileOutputStream class using the openFileOutput method.
                    //MODE_WORLD_READABLE Allows to write permission to all the applications
                    FileOutputStream fou = openFileOutput("status2.txt", MODE_WORLD_READABLE);
                    //2. Get an object of the OutPutStreamWriter class using the FileOutputStream object.
                    OutputStreamWriter osw = new OutputStreamWriter(fou);
                    try {
                        //3. Write the data
                        osw.write(Message3);
                        osw.flush();
                        osw.close();

                        Toast.makeText(getBaseContext(), "Data saved2", Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        //TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


                try {
                    //1. Create an object of the FileOutputStream class using the openFileOutput method.
                    //MODE_WORLD_READABLE Allows to write permission to all the applications
                    FileOutputStream fou = openFileOutput("status3.txt", MODE_WORLD_READABLE);
                    //2. Get an object of the OutPutStreamWriter class using the FileOutputStream object.
                    OutputStreamWriter osw = new OutputStreamWriter(fou);
                    try {
                        //3. Write the data
                        osw.write(Message4);
                        osw.flush();
                        osw.close();

                        Toast.makeText(getBaseContext(), "Data saved3", Toast.LENGTH_SHORT).show();

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
                    FileInputStream fis = openFileInput("status.txt");
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
                            cigarSmokedPerDayS += read_data;
                            data = new char[data_block];
                            cigarSmokedPerDay = Integer.parseInt(cigarSmokedPerDayS);

                        }
                        Toast.makeText(getBaseContext(), "Message1 :" + cigarSmokedPerDay, Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                try {
                    //4. For reading the data from the file, first you need to create an object of the FileInputStream class.
                    FileInputStream fis = openFileInput("status2.txt");
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
                            NumberOfCigarPerPackS += read_data;
                            data = new char[data_block];
                            numberOfCigarPerPack = Integer.parseInt(NumberOfCigarPerPackS);

                        }
                        Toast.makeText(getBaseContext(), "Message2 :" + numberOfCigarPerPack, Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                try {
                    //4. For reading the data from the file, first you need to create an object of the FileInputStream class.
                    FileInputStream fis = openFileInput("status3.txt");
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
                            costPerPackS += read_data;
                            data = new char[data_block];
                            costPerPack = Float.parseFloat(costPerPackS);

                        }
                        Toast.makeText(getBaseContext(), "Message3 :" + costPerPackS, Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                //assume you did not smoke after you set quit day
                //days after you start quit                             // cost of one cigar you defined

                moneySavedTotal = (daysInBetween - daysInBetween2) * cigarSmokedPerDay * (costPerPack / numberOfCigarPerPack);
                Toast.makeText(getApplicationContext(), "total" + moneySavedTotal, Toast.LENGTH_LONG).show();

                new AlertDialog.Builder(context)
                        .setTitle(" Congratulations ")
                        .setMessage(" You are taking the first step toward quit smoking ")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                                dialog.cancel();
                                Intent intent = new Intent(context, MainActivityHome.class);
                                startActivity(intent);
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });
        QuitDayNow();
    }
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner3);
        spinner1.setOnItemSelectedListener(new ResetCustomOnItemSelectedListenerStatus());
    }
    public void QuitDayNow(){
        final Context context = this;
        Button setQuitDayNow = (Button) findViewById(R.id.button8);

        setQuitDayNow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent = new Intent(context, SetDate.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reset_smoking_status, menu);
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
