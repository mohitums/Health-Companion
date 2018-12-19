package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

/**
 * Created by Lenovo on 18-02-2017.
 */

public class Nausea extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nausea);



    }
    public void ondiz(View v)
    {
        CheckBox c1,c2,c3,c4;
        c1=(CheckBox)findViewById(R.id.c1);
        c2=(CheckBox)findViewById(R.id.c2);
        c3=(CheckBox)findViewById(R.id.c3);
        c4=(CheckBox)findViewById(R.id.c4);
        int ans1=0,ans2=0,ans3=0,ans4=0;
        if(c1.isChecked())
        {
        ans1=1;
        }
        if(c2.isChecked())
        {
            ans2=1;
        }
        if(c3.isChecked())
        {
        ans3=1;
        }
        if(c4.isChecked())
        {
            ans4=1;
        }

        Intent i=new Intent(this,Nausea2.class);
        i.putExtra("ans1",ans1);
        i.putExtra("ans2",ans2);
        i.putExtra("ans3",ans3);
        i.putExtra("ans4",ans4);
        startActivity(i);
    }
}
