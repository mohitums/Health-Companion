package com.example.lenovo.healthcompanion;

import android.content.BroadcastReceiver;
import android.app.*;
import android.content.*;
import android.app.NotificationManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.net.*;
/**
 * Created by Lenovo on 12-03-2017.
 */

public class TimeAlarm extends BroadcastReceiver{

    NotificationManager nm;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        System.out.println("printed alarm");
        Uri sound= Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.water);
        NotificationManager notif=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notify=new Notification.Builder
                (context.getApplicationContext()).setContentTitle("Water Reminder").setContentText("Its time for WATER").
                setSmallIcon(R.drawable.icon).setSound(sound).build();
        notif.notify(0,notify);
    }

}
