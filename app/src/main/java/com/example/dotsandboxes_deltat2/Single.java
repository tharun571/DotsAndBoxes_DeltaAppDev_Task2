package com.example.dotsandboxes_deltat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Single extends AppCompatActivity {

    public static final String EXTRA_P="com.example.DotsAndBoxes_DeltaT2.EXTRA_P";

    Button e,m,h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        e=(Button)findViewById(R.id.e);
        m=(Button)findViewById(R.id.m);
        h=(Button)findViewById(R.id.h);

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Single.this,GameplayS.class);
                intent.putExtra(EXTRA_P,3);
                startActivity(intent);
            }
        });

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Single.this,GameplayS.class);
                intent.putExtra(EXTRA_P,4);
                startActivity(intent);

            }
        });

        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Single.this,GameplayS.class);
                intent.putExtra(EXTRA_P,5);
                startActivity(intent);

            }
        });




    }
}
