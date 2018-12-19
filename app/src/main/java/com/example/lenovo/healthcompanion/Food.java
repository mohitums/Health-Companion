package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.database.Cursor;
import android.widget.ListView;
import android.view.View;
import java.io.IOException;
import android.view.*;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.content.Context;
import android.widget.AdapterView;
import android.view.View.OnClickListener;
import java.util.Calendar;
import android.content.Intent;
/**
 * Created by Lenovo on 18-04-2017.
 */

public class Food extends Activity implements AdapterView.OnItemClickListener{
    public int calorie=0,protein=0,carbs=0;
    NumberPicker n1;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);
        ListView listview = (ListView) findViewById(R.id.lvf);
        listview.setOnItemClickListener(this);
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
        String select="select _id from calorie";
        Cursor c;
        int i=0;
        db = myDbHelper.getReadableDatabase();
        c = db.rawQuery(select, null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            food[i]=c.getString(0);
            i++;
            c.moveToNext();

        }
        System.out.println("reached here"+food[2]);
        int count = i;
        int k = 0;

        String finalans[] = new String[count];
        for (i = 0, k = 0; i < count; i++) {
            finalans[i] = food[k];
            k++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.mylist, finalans);
        ListView list = (ListView) findViewById(R.id.lvf);
        list.setAdapter(adapter);
        c.close();
        myDbHelper.close();
        db.close();

    }
    String food[]=new String[30];
    SQLiteDatabase db;

    String item;
    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        item= (String) l.getItemAtPosition(position);
        initiatePopupWindow();
    }


    private PopupWindow pwindo;

    Button btnClosePopup;
    Button btnCreatePopup;
    private void initiatePopupWindow() {
        try {


            LayoutInflater inflater = (LayoutInflater) this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup_window,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindo = new PopupWindow(layout, 1000, 500, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            n1=(NumberPicker)layout.findViewById(R.id.numberPicker);
            n1.setMinValue(1);
            n1.setMaxValue(9);
            btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
           btnClosePopup.setOnClickListener(cancel_button_click_listener);

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    private OnClickListener cancel_button_click_listener = new OnClickListener() {
        public void onClick(View v) {
            System.out.println("Went inside");
            pwindo.dismiss();
            int a=n1.getValue();
            store(a);
        }
    };
    public void store(int ser)
    {
        DataBaseHelper myDbHelper;
        myDbHelper = new DataBaseHelper(this);
        String str=item;

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
        String query="select cal,carbs,protein from calorie where _id='"+str+"'";
        Cursor d;
        int i=0;
        int temp1,temp2,temp3;
        db = myDbHelper.getReadableDatabase();
        d = db.rawQuery(query, null);
        d.moveToFirst();
        calorie=(ser*d.getInt(0))+calorie;
        carbs=carbs+ ser*d.getInt(1);
        protein=protein+ser*d.getInt(2);
        System.out.println("cal"+calorie+"protein"+protein);
        final Calendar c= Calendar.getInstance();
        int day=c.get(Calendar.DAY_OF_MONTH);
        int month=c.get(Calendar.MONTH);
        int val=(day*1000)+month;
        d=db.rawQuery("select * from data where _id='"+val+"'",null);
        System.out.println(d.getCount()+"the count");
        if(d.getCount()==0)
        {
            System.out.println("inside insert");
            db.execSQL("insert into data values ("+val+",'Final'"+","+calorie+","+carbs+")");
            db.execSQL("insert into data values("+val+",'"+item+"',"+calorie+","+carbs+")");
        }
        else
        {
            d=db.rawQuery("select * from data where name='Final' and _id="+val,null);
            d.moveToFirst();
            temp1=d.getInt(2)+calorie;
            temp2=d.getInt(3)+carbs;
            db.execSQL("update data set cal="+temp1+",carb="+temp2+" where name='Final' and _id="+val);
            calorie=0;
            carbs=0;
            protein=0;
            System.out.println("Statement executed");
            d=db.rawQuery("select * from data where name='Final' and _id="+val,null);
            d.moveToFirst();
            temp1=d.getInt(2)+calorie;
            System.out.println("temp1 new val"+temp1);
            Intent main=new Intent(Food.this,Calorie.class);
            startActivity(main);
        }

       // d=db.rawQuery("select * from data where _id='"+val+"'",null);
        //d.moveToFirst();
       // System.out.println(d.getInt());
        db.close();
        myDbHelper.close();

    }

}
