package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ListView;
import android.widget.RadioButton;
import android.content.Intent;

/**
 * Created by Lenovo on 19-02-2017.
 */

public class Nausea2 extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nausea2);
       int ans1,ans2,ans3,ans4;

        String str1[]=new String[10];
        str1[0]="Panick Attack";

        String str2="Motion Sickness";
        String str3="Migraine";
        String str4="Gastroparesis";

        String ans[]=new String [4];
        int count=0;

         Intent act=getIntent();
        ans1=act.getIntExtra("ans1",0);
        ans2=act.getIntExtra("ans2",0);
        ans3=act.getIntExtra("ans3",0);
        ans4=act.getIntExtra("ans4",0);
        if(ans1==1)
        {
            ans[count]=str1[0];
            count++;
        }
        if(ans2==1)
        {
            ans[count]=str2;
            count++;
        }
        if(ans3==1)
        {
            ans[count]=str3;
            count++;
        }
        if(ans4==1)
        {
            ans[count]=str4;
            count++;
        }
        String finalans[]=new String[count];
        for(int i=0;i<count;i++)
        {
            finalans[i]=ans[i];
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.listview,finalans);
        ListView list=(ListView)findViewById(R.id.lv6);
        list.setAdapter(adapter);



    }
}
