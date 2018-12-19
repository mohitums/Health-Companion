package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.database.SQLException;
import java.io.*;
import android.database.Cursor;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Lenovo on 08-03-2017.
 */

public class Genmed extends Activity{

    SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genmed);

    }
    public void onmed(View v) {
        DataBaseHelper myDbHelper;
        myDbHelper = new DataBaseHelper(this);
        EditText e1 = (EditText) findViewById(R.id.text1);

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
        String str = e1.getText().toString();
        String select = "Select genre from med where _id= '" + str + "'";
        Cursor c, d;
        String test = "select * from med";
        System.out.println(select);
        System.out.println("goes here1");
        db = myDbHelper.getReadableDatabase();
        c = db.rawQuery(select, null);
        if (c == null) {
            System.out.println("null value");
        }
        System.out.println("goes here 2" + c.getCount());
        c.moveToFirst();
        System.out.println("");
        String s1 = c.getString(0);
        System.out.println("the ans is :" + s1);
        System.out.println(s1);
        String select1 = "Select _id,price from med where genre='" + s1 + "'";
        d = db.rawQuery(select1, null);
        d.moveToFirst();
        System.out.println(d.getCount());
        String ans1[] = new String[10];
        String ans2[] = new String[10];
        int i = 0;
        while (!d.isAfterLast()) {
            ans1[i] = d.getString(0);
            ans2[i] = d.getString(1);
            i++;
            d.moveToNext();
        }
        int count = i;
        int k = 0;

        String finalans[] = new String[count];
        for (i = 0, k = 0; i < count; i++) {
            finalans[i] = ans1[k] + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + ans2[k];
            k++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.listview, finalans);
        ListView list = (ListView) findViewById(R.id.lvm);
        list.setAdapter(adapter);
        c.close();
        d.close();
        db.close();
        myDbHelper.close();

    }
}
