package com.example.lenovo.healthcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullscreenactivity);
    }
    public void onsymptom(View v)
    {
        if (v.getId() == R.id.s1) {
            Intent i = new Intent(FullscreenActivity.this, Symptom.class);
          //  i.putExtra("value", ans);
            startActivity(i);

        }
    }
    public void ongenmed(View v1)
    {
        {
            if (v1.getId() == R.id.g1) {
                Intent i1 = new Intent(FullscreenActivity.this, Genmed.class);
                //  i.putExtra("value", ans);
                startActivity(i1);

            }
        }
    }
    public void onwater(View v2)
    {

            if (v2.getId() == R.id.w1) {
                Intent i2 = new Intent(FullscreenActivity.this, WaterReminder.class);
                startActivity(i2);
            }

    }
    public void oncal(View v3)
    {
        if (v3.getId() == R.id.c1) {
            Intent i3 = new Intent(FullscreenActivity.this, Calorie.class);
            startActivity(i3);

        }
    }
    public void onpill(View p)
    {
        if(p.getId()==R.id.p1)
        {
            Intent pill=new Intent(FullscreenActivity.this,PillReminder.class);
            startActivity(pill);
        }
    }
    public void calldoc(View doc){
        if(doc.getId()==R.id.doc)
        {
            Intent d1=new Intent(FullscreenActivity.this,Doctor.class);
            startActivity(d1);
        }
    }


}
