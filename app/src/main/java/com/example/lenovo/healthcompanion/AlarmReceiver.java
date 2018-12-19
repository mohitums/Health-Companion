package com.example.lenovo.healthcompanion;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
import android.net.Uri;
import android.widget.EditText;
import android.app.Activity;

/**
 * Created by Lenovo on 16-04-2017.
 */

public class AlarmReceiver extends BroadcastReceiver {
    String s;
    @Override
   public void onReceive (Context context,Intent intent)
    {
        PillReminder p=new PillReminder();
        s=p.getstr();
        System.out.println("the "+s);
        System.out.println("printed alarm");
        Uri sound= Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.notif);
        NotificationManager notif=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notify=new Notification.Builder
                (context.getApplicationContext()).setContentTitle("Pill Reminder").setContentText("Take pill:"+s).
                setSmallIcon(R.drawable.pill).setSound(sound).build();
        notif.notify(0,notify);
    }


}
