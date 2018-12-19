package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import java.io.IOException;

/**
 * Created by Lenovo on 19-04-2017.
 */

public class Doctor extends Activity implements AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener{
    SQLiteDatabase db;
    int loop;
    String name[]=new String[5];
    String add[]=new String [5];
    String num[]=new String[5];
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.doctorlist, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        ListView listview = (ListView) findViewById(R.id.dlist);
        listview.setOnItemClickListener(this);
    }
    public void onItemSelected(AdapterView<?> parent, View view,int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

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
        String select = "Select * from doctor where city= '" + parent.getItemAtPosition(pos) + "'";
        Cursor c;
        db = myDbHelper.getReadableDatabase();

        c = db.rawQuery(select, null);
        System.out.println("The row count is"+c.getCount());
        if (c == null) {
            System.out.println("null value");
        }

        loop=0;
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            name[loop]=c.getString(0);
            num[loop]=c.getString(2);
            add[loop]=c.getString(3);
            loop++;
            c.moveToNext();
        }
        System.out.println( "The loop count is:"+loop);
        String finalans[]=new String[loop];

        for(int i=0;i<loop;i++)
        {
            finalans[i]=name[i];
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.mylist,finalans);
        ListView list=(ListView)findViewById(R.id.dlist);
        list.setAdapter(adapter);
        db.close();
        myDbHelper.close();

    }
    public void onNothingSelected(AdapterView<?> parent) {

    }
    String item;
    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        item= (String) l.getItemAtPosition(position);
        initiatePopupWindow();
    }

    private void initiatePopupWindow() {
        try {
            int j,k;
          for(j=0;j<loop;j++)
            {
                if(item==name[j])
                {
                    break;
                }
            }
            System.out.println("the values are \n"+item+"\n"+add[j]+"\n"+num[j]);
            Intent i = new Intent(Doctor.this, Doctor2.class);
            i.putExtra("name", item);
            i.putExtra("add",add[j]);
            i.putExtra("con",num[j]);
            startActivity(i);

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }


}
