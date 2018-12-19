package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by Lenovo on 18-02-2017.
 */

public class Headache extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.headache);

    }
    public void onhead(View v)
    {
        RadioButton r1,r2,r3,r4,r5;
        r1=(RadioButton)findViewById(R.id.eye);
        r2=(RadioButton)findViewById(R.id.one);
        r3=(RadioButton)findViewById(R.id.both);
        r4=(RadioButton)findViewById(R.id.dizzy);
        r5=(RadioButton)findViewById(R.id.neck);
        int ans1,ans2;
        if(r1.isChecked())
        {
            ans1=1;
        }
        else if(r2.isChecked())
        {

            ans1=2;
        }
        else
        {
            ans1=3;
        }
        if(r4.isChecked())
        {
            ans2=1;
        }
        else if(r5.isChecked())
        {
            ans2=2;
        }
        else
        {
            ans2=3;
        }
        Intent i=new Intent(Headache.this,Headache2.class);
        i.putExtra("ans1",ans1);
        i.putExtra("ans2",ans2);
       // System.out.println(ans2);
        startActivity(i);
    }
}
