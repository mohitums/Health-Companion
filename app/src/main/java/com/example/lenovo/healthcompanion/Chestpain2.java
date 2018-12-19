package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Lenovo on 19-02-2017.
 */

public class Chestpain2 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chestpain2);
        Intent act = getIntent();
        int ans1, ans2;
        ans1 = act.getIntExtra("ans1", 0);
        ans2 = act.getIntExtra("ans2", 0);

        String str1[]=new String[5];
        str1[0]="Angina";
        str1[1]="Costochondritis";
        str1[2]="Pericarditis";

        String str2[]=new String[5];
        str2[0]="Pericarditis";
        str2[1]="Pleurisy";
        str2[2]="Pulmonary Embolism";

        String str3[]=new String[3];

            str3[0]="Esophagal Spasms";
            str3[1]="Heart Attack";//for symptom 4
            str3[2]="Angina";


        String str4[]=new String[2];//for symptom 5
        str4[0]="Heart Attack";
        str4[1]="Panic Attack and Panic Disorder";

        String str5="Asthma";
        int i,j,k,count=0;
        String ans[]=new String[10];
        if(ans1==1)
        {
            for(i=0;i<3;i++)
            {
                ans[i]=str1[i];
                count++;
            }
        }
        else if(ans1==2)
        {
            for(i=0;i<3;i++)
            {
                ans[i]=str2[i];
                count++;
            }
        }
        else
        {
            for(i=0;i<3;i++)
            {
                ans[i]=str3[i];
                count++;
            }
        }
        if(ans2==2||ans2==3)
        {
            for(i=0;i<2;i++)
            {
                if((ans1==3)&&(i==0))
                {
                    i++;
                }
                ans[count]=str4[i];
                count++;
            }
        }
        if(ans2==3)
        {
            ans[count]=str5;
            count++;
        }
        String finalans[]=new String[count];

        for(i=0;i<count;i++)
        {
            finalans[i]=ans[i];
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.listview,finalans);
        ListView list=(ListView)findViewById(R.id.lv5);
        list.setAdapter(adapter);
    }
}
