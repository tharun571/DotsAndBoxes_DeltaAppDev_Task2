package com.example.dotsandboxes_deltat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    TextView result,play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        String st =intent.getStringExtra(Game.EXTRA_P);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        result=(TextView)findViewById(R.id.result);
        play=(TextView)findViewById(R.id.play);

        result.setText(st);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Score.this,Multi.class);
                startActivity(intent1);
            }
        });
    }
}
