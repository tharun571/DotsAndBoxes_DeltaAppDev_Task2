package com.example.dotsandboxes_deltat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation anim,top,scale;
    TextView d,b,and;

    private static int SPLASH=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        top= AnimationUtils.loadAnimation(this,R.anim.top);
        anim= AnimationUtils.loadAnimation(this,R.anim.anim);
        scale= AnimationUtils.loadAnimation(this,R.anim.scale);
        d=findViewById(R.id.d);
        b=findViewById(R.id.b);
        and=findViewById(R.id.and);


        d.setAnimation(top);
        b.setAnimation(anim);
        and.setAnimation(scale);






        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        },SPLASH);







    }
}
