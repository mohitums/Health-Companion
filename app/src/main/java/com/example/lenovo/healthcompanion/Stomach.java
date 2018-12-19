package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by Lenovo on 18-02-2017.
 */

public class Stomach extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stomach);
    }
    public void stomach1(View v)

    {
        int ans1,ans2;
        RadioButton acute,chronic,burning,lower,upper,middle;
        acute=(RadioButton)findViewById(R.id.acute);
        burning=(RadioButton)findViewById(R.id.burning);
        chronic=(RadioButton)findViewById(R.id.chronic);
        lower=(RadioButton)findViewById(R.id.lstomach);
        upper=(RadioButton)findViewById(R.id.ustomach);
        if(acute.isChecked())
        {
            ans1=1;
        }
        else if(burning.isChecked())
        {
            ans1=2;
        }
        else
        {
            ans1=3;
        }
        if(lower.isChecked())
        {
            ans2=1;

        }
        else if(upper.isChecked())
        {
            ans2=2;
        }
        else
        {
            ans2=3;
        }
        Intent i=new Intent(Stomach.this,Stomach2.class);
        i.putExtra("ans1",ans1);
        i.putExtra("ans2",ans2);
        startActivity(i);

    }


}
