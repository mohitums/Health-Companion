package com.example.lenovo.healthcompanion;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
/**
 * Created by Lenovo on 29-04-2017.
 */

public class Doctor2 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor2);
        TextView name1,add1,contact;
        name1=(TextView)findViewById(R.id.name1);
        add1=(TextView)findViewById(R.id.add1);
        contact=(TextView)findViewById(R.id.contact);
        Intent intent=getIntent();
        String item=intent.getStringExtra("name");
        name1.setText(item);
        String add=intent.getStringExtra("add");
        add1.setText(add);
        String num=intent.getStringExtra("con");
        contact.setText(num);
    }

}
