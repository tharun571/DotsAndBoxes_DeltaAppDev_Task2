package com.example.dotsandboxes_deltat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Multi extends AppCompatActivity  {
    public static final String EXTRA_P="com.example.DotsAndBoxes_DeltaT2.EXTRA_P";
    public static final String EXTRA_Q="com.example.DotsAndBoxes_DeltaT2.EXTRA_Q";
    Button d;
    String s1,s2;
    Spinner aDrp,sDrp;
    int a,b;

    private static final String TAG="MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        d=findViewById(R.id.d);





        ArrayAdapter<CharSequence> ae;
        ArrayAdapter<CharSequence> ax;

        String[] AArr = {"2", "3","4"};
        String[] sArr = {"3", "4","5"};

         aDrp =(Spinner)findViewById(R.id.spinner);
         sDrp    =(Spinner)findViewById(R.id.spinner1);

        ae =    new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,AArr);
        ae.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aDrp.setAdapter(ae);

        ax=     new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,sArr);
        ax.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDrp.setAdapter(ax);







        Log.w(TAG,"value "+s1+" "+s2);





        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1  = aDrp.getSelectedItem().toString();
                s2  = sDrp.getSelectedItem().toString();
                Log.w(TAG,"values "+s1+" "+s2);



                if (s1.toString().matches(""+2)){
                    a=2;

                }
                else if (s1.toString().matches(""+3)){
                    a=3;

                }
                else if (s1.toString().matches(""+4)){
                    a=4;

                }

                if (s2.toString().matches(""+3)){
                    b=3;

                }
                if (s2.toString().matches(""+4)){
                    b=4;

                }
                if (s2.toString().matches(""+5)){
                    b=5;

                }










                Intent intent = new Intent(Multi.this, Gameplay.class);

                intent.putExtra(EXTRA_P, a);
                intent.putExtra(EXTRA_Q, b);
                startActivity(intent);

            }
        });


















    }


}
