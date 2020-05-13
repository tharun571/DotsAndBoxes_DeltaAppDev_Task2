package com.example.dotsandboxes_deltat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Gameplay extends AppCompatActivity {
    private static final String TAG="MyActivity";
    int in=0; //to draw the grid before game starts
    float x,y; //coordinates of the touch point
    int p,q; // no of players and grid value

    View g;
    TextView s1,s2,s3,s4;
    ImageButton u;


    private Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
         p = intent.getIntExtra(Multi.EXTRA_P, 0);
         q = intent.getIntExtra(Multi.EXTRA_Q, 0);


        Log.w(TAG,"ASDF 100");



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        s1=(TextView)findViewById(R.id.s1);
        s2=(TextView)findViewById(R.id.s2);
        s3=(TextView)findViewById(R.id.s3);
        s4=(TextView)findViewById(R.id.s4);

        u=(ImageButton)findViewById(R.id.u);


        if(p==2){
            s1.setText(""+0);
            s2.setText(""+0);
        }
        else if(p==3){
            s1.setText(""+0);
            s2.setText(""+0);
            s3.setText(""+0);
        }
        else if(p==4){
            s1.setText(""+0);
            s2.setText(""+0);
            s3.setText(""+0);
            s4.setText(""+0);
        }



        game=(Game)findViewById(R.id.g);

        g=(View)findViewById(R.id.g);

        new Games(p, q);


        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.undo();
            }
        });


    }













}
