package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Lenovo on 19-02-2017.
 */

public class Diarrhea2  extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diarrhea2);
        Intent act=getIntent();
        int ans1;
        ans1=act.getIntExtra("ans1",0);

        String str1[]=new String[10];
        str1[0]="Colitis";
        str1[1]="Intestinal Obstruction";
        str1[2]="Lactose Intolerance";
        str1[3]="Stomach Flu";

        String str2[]=new String[10];
        str2[0]="Colitis";
        str2[1]="Intestinal Obstruction";
        str2[2]="Stomach Flu";
        str2[3]="Travellers Diarrhea";
        String str3[]=new String[5];
        str3[0]="Antibiotic Associated Diarrhea";

        String str4[]=new String[5];
        str4[0]="Glardia Indection";
        str4[1]="Food Poisoning";
        str4[2]="Crohns Disease";

        int count=0,i,j;
        String ans[]=new String[10];
        if(ans1==1)
        {
            for(i=0;i<4;i++)
            {
                ans[i]=str1[i];
                count++;
            }
        }
        else if(ans1==2)
        {
            for(i=0;i<4;i++)
            {
                ans[i]=str2[i];
                count++;
            }
        }
        else
        {
            for(i=0;i<1;i++)
            {
                ans[i]=str3[i];
                count++;
            }
        }
        ans[i]=str4[0];
        i++;
        ans[i]=str4[1];
        i++;
        ans[i]=str4[2];
        count=count+3;
        String finalans[]=new String[count];
        for(i=0;i<count;i++)
        {
            finalans[i]=ans[i];

        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.listview,finalans);
        ListView list=(ListView)findViewById(R.id.lv3);
        list.setAdapter(adapter);

    }
}
