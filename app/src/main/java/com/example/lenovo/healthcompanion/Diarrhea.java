package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by Lenovo on 18-02-2017.
 */

public class Diarrhea extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diarrhea);

    }
    public void calldir(View v)

    {
        RadioButton r1,r2,r3,r4,r5;
        r1=(RadioButton)findViewById(R.id.ongoing);
        r2=(RadioButton)findViewById(R.id.anti);
        r3=(RadioButton)findViewById(R.id.recent);
        r4=(RadioButton)findViewById(R.id.pain);

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

        else
        {
            ans2=2;
        }
        Intent i=new Intent(Diarrhea.this,Diarrhea2.class);
        i.putExtra("ans1",ans1);
        i.putExtra("ans2",ans2);
        startActivity(i);

    }
}
