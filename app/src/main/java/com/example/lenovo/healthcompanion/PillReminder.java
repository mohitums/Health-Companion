package com.example.lenovo.healthcompanion;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.icu.util.*;
import android.app.TimePickerDialog;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Button;
import android.view.View;
import android.app.AlarmManager;
import android.os.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.StringTokenizer;

import android.content.Intent;
import android.app.PendingIntent;
import android.widget.Toast;

/**
 * Created by Lenovo on 16-04-2017.
 */

public class PillReminder extends Activity {
       public EditText ep;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pillreminder);
    }

    public  void onalarm(View alarm)
    {
        if(alarm.getId()==R.id.set)
        {
            setalarm(alarm);
        }
    }
    public String sp;
    @TargetApi(24)
    public void setalarm(View alarm) {
        TimePicker tp2=(TimePicker)findViewById(R.id.timepick2);
        AlarmManager am;
        int mHour=tp2.getHour();
        int mMinute=tp2.getMinute();
        ep=(EditText)findViewById(R.id.ep);
        sp=ep.getText().toString();
        System.out.println("the string is :"+sp);
        AlarmManager mgrAlarm = (AlarmManager) this.getSystemService(ALARM_SERVICE);
        ArrayList<PendingIntent> intentArray = new ArrayList<PendingIntent>();
        int i=0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, mHour);
        calendar.set(Calendar.MINUTE,mMinute);

        //for(i = 0; i < 10; ++i)
        final int _id=(int)System.currentTimeMillis();
            Intent intent = new Intent(this, AlarmReceiver.class);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, _id, intent, 0);

        i++;
            // Single alarms in 1, 2, ..., 10 minutes (in `i` minutes)
            mgrAlarm.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
           // mgrAlarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
             //       AlarmManager.INTERVAL_DAY, pendingIntent);
            intentArray.add(pendingIntent);
        Toast t=Toast.makeText(getApplicationContext(),"Pill Reminder Set",Toast.LENGTH_SHORT);
        t.show();
    }
    public String getstr()
    {
        System.out.println("the function entered"+ sp);
        return sp;
    }


}
