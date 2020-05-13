package com.example.dotsandboxes_deltat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameplayS extends AppCompatActivity {
    View g1;
    Singlegame game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        int p= intent.getIntExtra(Single.EXTRA_P,0);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay_s);

        g1=(View)findViewById(R.id.g1);

        game=(Singlegame)findViewById(R.id.g1);


        new Games1(2,p);
    }
}
