package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RadioButton;



public class Cough extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cough);
    }
    public void callcough(View v)

    {
        RadioButton r1,r2,r3,r4,r5;
        r1=(RadioButton)findViewById(R.id.dry);
        r2=(RadioButton)findViewById(R.id.wet);
        r3=(RadioButton)findViewById(R.id.appetite);
        r4=(RadioButton)findViewById(R.id.fever);
        r5=(RadioButton)findViewById(R.id.sore);
        int ans1,ans2;

        if(r1.isChecked())
        {
            ans1=1;
        }
        else
        {
            ans1=1;
        }
        if(r3.isChecked())
        {
            ans2=1;
        }
        else if(r4.isChecked())
        {
            ans2=2;
        }
        else
        {
            ans2=3;
        }
        Intent i=new Intent(Cough.this,Cough2.class);
        i.putExtra("ans1",ans1);
        i.putExtra("ans2",ans2);
        startActivity(i);

    }
}
