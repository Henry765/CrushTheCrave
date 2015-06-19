package com.example.hrzhulocal.crushthecraveprototype2;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

/**
 * Created by hrzhulocal on 27/05/2015.
 */
// extends MainActivityHome and implements DatePickerDialog at the same time
public class DateSettings extends MainActivityHome implements DatePickerDialog.OnDateSetListener{

    Context context;
    public DateSettings(Context context)
    {
        this.context = context;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(context, "You have selected that date you would like to start quitting smoke: "+dayOfMonth+ " / "+monthOfYear+" / " +year, Toast.LENGTH_SHORT).show();
        Calendar quitDay = Calendar.getInstance();
        quitDayNum6 = quitDay.getTimeInMillis();
        Toast.makeText(context, "quitDayNum6: " +quitDayNum6, Toast.LENGTH_LONG).show();
    }

}
