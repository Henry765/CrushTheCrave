package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class addOtherSp5 extends SmokeActivity {

    public addOtherSp5(String triggerEntry) {
        super(triggerEntry);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_other_sp5);

        final EditText message7 = (EditText) findViewById(R.id.editText);
        ImageButton saveSp4 = (ImageButton) findViewById(R.id.imageButton31);
        saveSp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOther5 = message7.getText().toString();
                try {
                    //1. Create an object of the FileOutputStream class using the openFileOutput method.
                    //MODE_WORLD_READABLE Allows to write permission to all the applications
                    FileOutputStream fou2 = openFileOutput("SP5.txt", MODE_WORLD_READABLE);
                    //2. Get an object of the OutPutStreamWriter class using the FileOutputStream object.
                    OutputStreamWriter osw = new OutputStreamWriter(fou2);
                    try {
                        //3. Write the data
                        osw.write(addOther5);
                        osw.flush();
                        osw.close();

                    } catch (IOException e) {
                        //TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Toast.makeText(getBaseContext(), "Data saved " + addOther5, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, SmokeActivity.class);
                startActivity(intent);

            }

        });

        Message5 = final_dataSP5;
        Toast.makeText(getBaseContext(), "Data saved be3" + Message5, Toast.LENGTH_SHORT).show();
    }
}


