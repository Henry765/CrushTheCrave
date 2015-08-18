package com.example.hrzhulocal.crushthecraveprototype2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

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
    public DateSettings(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distract_me);

    }
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(context, "You have selected that date you would like to start quitting smoke: "+dayOfMonth+ " / "+Integer.valueOf(monthOfYear+1)+" / " +year, Toast.LENGTH_SHORT).show();
       // Toast.makeText(context, "before quitDayNum6: " + quitDayNum6, Toast.LENGTH_LONG).show();
        //saveFutureDate();
        DatePicker datePicker = new DatePicker(context);
        TimePicker timePicker = new TimePicker(context);
        Calendar cal12 = Calendar.getInstance();
        cal12.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        cal12.set(Calendar.MONTH, monthOfYear);
        cal12.set(Calendar.YEAR, year);

        quitDayNum6 = cal12.getTimeInMillis();

        quitDayNum6 = cal12.getTimeInMillis();

        SharedPreferences sp2 = context.getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sp2.edit();

        //quitDayNum6 = quitDay2.getTimeInMillis();
        editor2.putLong("QUITDAYNUM6", quitDayNum6);
        editor2.commit();
        //calendarFuture.setTimeInMillis(quitDayNum6);
        //pickerDialogs.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
        //timePicker.getCurrentHour(), timePicker.getCurrentMinute(), 0);

        //Toast.makeText(context, "quitDayNum6: " + quitDayNum6, Toast.LENGTH_LONG).show();

    }
   /* private void saveFutureDate(){
        Calendar quitDay2 = Calendar.getInstance();
        SharedPreferences sp = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        //quitDayNum6 = quitDay2.getTimeInMillis();
        editor.putLong("QUITDAYNUM6", quitDayNum6);
        editor.commit();
    }*/

    /**
     * Created by hrzhulocal on 27/05/2015.
     */
    public static class PickerDialogs extends DialogFragment {
        Context context;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //saveFutureDate();
        }
        @NonNull
        //@Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            DateSettings dateSettings = new DateSettings(getActivity());
            //saveFutureDate();
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog;
            dialog = new DatePickerDialog(getActivity(), dateSettings, year, month, day);

            //calendar.setTimeInMillis(quitDayNum6);
            //quitDayNum6 = calendar.get();
            //Toast.makeText(context, "quitDayNum6:kj " + MainActivityHome.quitDayNum6, Toast.LENGTH_LONG).show();


            return dialog;
        }
    }
}