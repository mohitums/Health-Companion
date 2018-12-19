package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Lenovo on 18-02-2017.
 */

public class Stomach2 extends Activity {

    int ans1,ans2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stomach2);

        Intent act=getIntent();
        ans1=act.getIntExtra("ans1",0);
        ans2=act.getIntExtra("ans2",0);
        String acute[]=new String[10];

        acute[0]="Constipation";
        acute[1]="Food Poisoning";
        acute[2]="Intestinal Obstruction";
        acute[3]="Diverticulitis";

        String chronic[]=new String[10];
        chronic[0]="Celiac Disease";
        chronic[1]="Colon Cancer";
        chronic[2]="Crohn's Disease";
        chronic[3]="Irritable Bowel Syndrome";

        String burning[]=new String[10];
        burning[0]="Gastritis";
        burning[1]="Nonulcer Stomach Pain";
        burning[2]="Peptic Ulcer";
        burning[3]="Shingles";

        String lower[]=new String[10];
        lower[0]="Appendicitis";
        lower[1]="Endometriosis";

        String upper[]=new String[5];
        upper[0]="Pancreatitis";
        upper[1]="Cholecystitis";
        upper[2]="Gallstone";

        String middle[]=new String[5];
        middle[0]="Gallstones";
        middle[1]="Gastritis";
        middle[2]="Appendicitis";

        String ans[]=new String[25];
        int i,j,count=0;
        if(ans1==1)
        {
            for (i=0;i<4;i++)
            {
                ans[i]=acute[i];
                count++;
            }
        }
        else if(ans1==2)
        {
            for(i=0;i<4;i++)
            {
                ans[i]=chronic[i];
                count++;
            }

        }
        else
        {
            for(i=0;i<4;i++)
            {
                ans[i]=burning[i];
                count++;
            }
        }

        int k=0;
        if(ans2==1)
        {
            for(j=i;j<(i+2);j++)
            {

                ans[j]=lower[k];
                k++;
                count++;
            }
        }
        else if(ans2==2)
        {
            k=0;
            for(j=i;j<(i+3);j++)
            {
                ans[j]=middle[k];
                k++;
                count++;
            }
        }
        else
        {
            k=0;
            for(j=i;j<(i+3);j++)
            {
                ans[j]=upper[k];
                k++;
                count++;
            }
        }
        String str[]=new String[count];
        for(i=0;i<count;i++)
        {
            str[i]=ans[i];
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.listview,str);
        ListView list=(ListView)findViewById(R.id.lv1);
        list.setAdapter(adapter);

        }
    }





