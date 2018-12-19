package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Lenovo on 19-02-2017.
 */

public class Headache2 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.headache2);
        Intent act=getIntent();
        int ans1,ans2;
        ans1=act.getIntExtra("ans1",0);
        ans2=act.getIntExtra("ans2",0);

        String str1[]=new String[10];
        str1[0]="Cluster Headache";
        String str3[]=new String[4];
        str3[0]="Giant cell arteritis";
        str3[1]="Migraine";
        str3[2]="TMJ Disorder";

        String str4[]=new String[1];
        str4[0]="Concussion";

        String str5[]=new  String[5];
        //use string 5 for symptom 6
        str5[0]="Meningitis";
        String ans[]=new String [5];
        int count=0;
        int i,j,k;
        if(ans1==1)
        {
            ans[0]=str1[0];
            count++;
        }
        else if(ans1==2||ans1==3)
        {
            for(i=0;i<3;i++)
            {
                ans[i]=str3[i];
                count++;
            }
        }
        if(ans2==1)
        {
            ans[count]=str4[0];
        	count++;
        }
        else
        {
            ans[count]=str5[0];
            count++;
        }
        String finalans[]=new String[count];

            for(i=0;i<count;i++)
            {
                finalans[i]=ans[i];
            }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.listview,finalans);
        ListView list=(ListView)findViewById(R.id.lv4);
        list.setAdapter(adapter);







    }
}
