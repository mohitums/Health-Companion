package com.example.lenovo.healthcompanion;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.view.animation.DecelerateInterpolator;
import android.graphics.drawable.RotateDrawable;
import android.widget.TextView;
import android.os.*;
import android.view.View;

import java.io.IOException;
import java.util.Calendar;

/**
 * Created by Lenovo on 07-04-2017.
 */

public class Calorie extends Activity {

    private TextView txtProgress;
    private ProgressBar progressBar,p2;
    SQLiteDatabase db;
    private int pStatus = 0;
    private Handler handler = new Handler();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie);
        txtProgress = (TextView) findViewById(R.id.txtProgress);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        DataBaseHelper myDbHelper;
        myDbHelper = new DataBaseHelper(this);
        try {

            myDbHelper.createDataBase();
        } catch (IOException ioe) {

            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        final Calendar ct= Calendar.getInstance();
        int day=ct.get(Calendar.DAY_OF_MONTH);
        int month=ct.get(Calendar.MONTH);
        int val=(day*1000)+month;
        String select="select cal,carb from data where name='Final' and _id='"+val+"'";
        Cursor c;
        int i=0;
        db = myDbHelper.getReadableDatabase();
        c = db.rawQuery(select, null);
        c.moveToFirst();

        int cal=0,carb=0;
        while(!c.isAfterLast()&&c.getCount()!=0)
        {
            cal=c.getInt(0);
            carb=c.getInt(1);
            i++;
            c.moveToNext();
        }
        if(c.getCount()==0)
        {
            cal=0;
            carb=0;
        }
        System.out.println("the calorie is"+cal);
         int temp=(cal*100)*2500;
        System.out.println("the ans is"+temp);
        if(temp>100)
        {
            temp=100;
        }
        final int ans=temp;
       // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.mylist, finalans);
        //ListView list = (ListView) findViewById(R.id.lvf);
        //list.setAdapter(adapter);
        c.close();
        myDbHelper.close();
        db.close();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (pStatus <= ans) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(pStatus);
                            txtProgress.setText(pStatus + " %");
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pStatus++;
                }
            }
        }).start();
    /*    */

    }
    public void plus(View cal)
    {
        if(cal.getId()==R.id.image1)
        {
            Intent cal1=new Intent(Calorie.this,Food.class);
            startActivity(cal1);
        }
    }
}
