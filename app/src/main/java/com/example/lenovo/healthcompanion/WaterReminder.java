package com.example.lenovo.healthcompanion;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.*;
import android.content.*;
import android.view.*;
import android.widget.Button;
import android.icu.util.*;
import android.widget.Toast;

/**
 * Created by Lenovo on 11-03-2017.
 */

public class WaterReminder extends Activity {
    int hr1,min1;
    int hr2,min2;
    AlarmManager am;
    TextView n1;
    TextView tvchange;
    TimePicker t1;
    Button b1;
    int slot;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waterreminder);
        t1=(TimePicker)findViewById(R.id.timePicker);
        n1=(TextView)findViewById(R.id.n1);
        am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        tvchange=(TextView)findViewById(R.id.tvchange);
        b1=(Button)findViewById(R.id.button7);

    }


    @TargetApi(23)
    public void onwake(View w) {
        if (w.getId() == R.id.button7) {
            hr1 = t1.getHour();
            min1 = t1.getMinute();
            System.out.println("hour recorder:"+hr1+":"+min1);
            tvchange.setText("Set Sleep Time:");
            View b=findViewById(R.id.button7);
            b.setVisibility(View.GONE);
            View c=findViewById(R.id.button8);
            c.setVisibility(View.VISIBLE);
        }
    }
    @TargetApi(23)
    public void onsleep(View x) {

        if (x.getId() == R.id.button8) {
            hr2 = t1.getHour();
            min2 = t1.getMinute();
            x=findViewById(R.id.button8);
            x.setVisibility(View.GONE);
            x=findViewById(R.id.btnid);
            x.setVisibility(View.VISIBLE);
        }
    }
    public void butclick(View v)
    {
        if(v.getId()==R.id.btnid)
        {
            int weight= Integer.parseInt(n1.getText().toString());
            int water=1250;

            if(weight>35)
            {
                water=1500;
                if(weight>45)
                {
                    water=1750;
                    if(weight>60)
                    {
                        water=2000;
                        if(weight>80)
                        {
                            water=2500;
                        }
                    }
                }
            }
            else
            {
                water=1000;
            }
            int count=(water)/250;
            int interval;
            interval=(((hr2*60)+min2)-((hr1*60)+min1))*60;
            System.out.println("WENT inside"+interval);
            slot=interval/count;
            slot=slot*1000;
            System.out.println("slot:"+slot);
            setRepeatingAlarm(v);
        }
    }
    @TargetApi(24)
    public void setRepeatingAlarm(View v2) {
        Toast t=Toast.makeText(getApplicationContext(),"Water Reminder Set",Toast.LENGTH_SHORT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hr1);
        calendar.set(Calendar.MINUTE, min1);
        Intent intent = new Intent(getBaseContext(), TimeAlarm.class);
        System.out.println(calendar.getTimeInMillis());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),20*60*1000, pendingIntent);
        t.show();
    }
}
