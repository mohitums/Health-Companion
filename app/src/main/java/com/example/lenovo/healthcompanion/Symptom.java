package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

import static com.example.lenovo.healthcompanion.R.styleable.View;
import android.view.View;
/**
 * Created by Lenovo on 15-02-2017.
 */

public class Symptom extends Activity {

     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symptom);

    }
    public void nextstep(View v) {
        RadioButton r1,r2,r3,r4,r5,r6,r7;
        r1=(RadioButton)findViewById(R.id.radio1);
        r2=(RadioButton)findViewById(R.id.radio2);
        r3=(RadioButton)findViewById(R.id.radio3);
        r4=(RadioButton)findViewById(R.id.radio4);
        r5=(RadioButton)findViewById(R.id.radio5);
        r6=(RadioButton)findViewById(R.id.radio6);


        Intent i;
        if(r1.isChecked())
        {
             i = new Intent(Symptom.this,Stomach.class);
            startActivity(i);
        }
        else if(r2.isChecked())
        {
             i = new Intent(Symptom.this,Cough.class);
            startActivity(i);
        }
        else if(r3.isChecked())
        {
             i = new Intent(Symptom.this,Diarrhea.class);
            startActivity(i);
        }
        else if(r4.isChecked())
        {
             i = new Intent(Symptom.this,Headache.class);
            startActivity(i);
        }
        else if(r5.isChecked())
        {
            i = new Intent(Symptom.this,ChestPain.class);
            startActivity(i);
        }
        else if(r6.isChecked())
        {
            i = new Intent(Symptom.this,Nausea.class);
            startActivity(i);
        }
        else
        {    i = new Intent(Symptom.this,Constipation.class);
            startActivity(i);
        }
    }
}
