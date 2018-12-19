package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Lenovo on 19-02-2017.
 */

public class Cough2 extends Activity{


        protected void onCreate(Bundle savedInstanceState) {
            Intent act=getIntent();
            int ans1,ans2;
            ans1=act.getIntExtra("ans1",0);
            ans2=act.getIntExtra("ans2",0);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.cough2);
            String str1[]=new String[10];
            String str2[]=new String[10];
            str1[0]="Acute Sinusitis";
            str1[1]="Asthma";
            str1[2]="Hay Fever";
            str1[3]="Influenza";
            str1[4]="Pneumonia";

            str2[0]="Acute Sinusitis";
            str2[1]="Bronchitis";
            str2[2]="Chronic Sinusitis";
            str2[3]="Pneumonia";

            String str3[]=new String[10];
            str3[0]="Laryngitis";
            str3[1]="GERD";

            String str4[]=new String[10];
            str4[0]="Ephysmea";

            String ans[]=new String[10];
            int count=0;
            int i,j,k;

            if(ans1==1)
            {
                for(i=0;i<5;i++)
                {
                    ans[i]=str1[i];
                    count++;
                }
            }
            else
            {
                for(i=0;i<4;i++)
                {
                    ans[i]=str2[i];
                    count++;
                }
            }
            j=i;
            k=0;
            if(ans2==2)
            {
                for(i=j;i<(j+2);i++)
                {
                    ans[i]=str3[k];
                    k++;
                    count++;
                }
            }
            else
            {
                ans[i]=str3[0];
            }
            String finalans[]=new String[count];
            for(i=0;i<count;i++)
            {
                finalans[i]=ans[i];
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.listview,finalans);
            ListView list=(ListView)findViewById(R.id.lv2);
            list.setAdapter(adapter);

        }
}
