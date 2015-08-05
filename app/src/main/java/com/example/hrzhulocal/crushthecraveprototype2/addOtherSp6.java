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


public class addOtherSp6 extends SmokeActivity {

    public addOtherSp6() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_other_sp6);
        final EditText message7 = (EditText) findViewById(R.id.editText);
        ImageButton saveSp4 = (ImageButton) findViewById(R.id.imageButton31);
        saveSp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOther6 = message7.getText().toString();
                try {
                    //1. Create an object of the FileOutputStream class using the openFileOutput method.
                    //MODE_WORLD_READABLE Allows to write permission to all the applications
                    FileOutputStream fou2 = openFileOutput("SP4.txt", MODE_WORLD_READABLE);
                    //2. Get an object of the OutPutStreamWriter class using the FileOutputStream object.
                    OutputStreamWriter osw = new OutputStreamWriter(fou2);
                    try {
                        //3. Write the data
                        osw.write(addOther6);
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
                Intent intent = new Intent(context, SmokeActivity.class);
                startActivity(intent);

            }

        });

        Message6 = final_dataSP6;
        Toast.makeText(getBaseContext(), "Data saved be2" + final_dataSP6, Toast.LENGTH_SHORT).show();

        Toast.makeText(getBaseContext(), "Data saved be3" + Message4, Toast.LENGTH_SHORT).show();
    }
}
