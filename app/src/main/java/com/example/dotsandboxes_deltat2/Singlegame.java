package com.example.dotsandboxes_deltat2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Example1 {

    public static int a;
    public static int b;

}

class Games1 {

    private static final String TAG = "MyActivity";


    public Games1(int x,int y) {

        Example1.a = x;
        Example1.b = y;


    }

}

public class Singlegame extends View {

    private static final String TAG="MyActivity";


    public static final String EXTRA_P="com.example.DotsAndBoxes_DeltaT2.EXTRA_P";

    int y1=0;

    View g;
    int x,y;
    int t=Example1.a,u=Example1.b;

    Context cn;

    int r=0;
    int c=0;



    int sc1=0,sc2=0;
    int s1,s2,s3,s4;

    ArrayList<Integer>[] mn = new ArrayList[20]; // to store the boxes which are filled


    MediaPlayer mp= MediaPlayer.create(getContext(),R.raw.sample);

    int start=3;
    int st=0;
    int s=0;


    int p,q; // players and grid values

    // seperate arrays for horizontal and vertical lines in the grid

    ArrayList<Integer> valuex= new ArrayList<>();
    ArrayList<Integer> valuey= new ArrayList<>();

    ArrayList<Integer>[] occx = new ArrayList[5];  // for turns
    ArrayList<Integer>[] occy = new ArrayList[5];  // for turns

    // for undo
    int ulx=0;
    int uly=0;
    int[] ub=new int[25];
    int ul1x=0,ul1y=0,ub1=0,ub2=0,uu=0,ubb=0;

    // for boxes
    int[][] square= new int[5][5];
    ArrayList<Integer> box= new ArrayList<>();

    public Singlegame(Context context) {
        super(context);
        init(context);
    }

    public Singlegame(Context context,  AttributeSet attrs) {
        super(context, attrs);
        cn=context;
        init(context);
    }

    public Singlegame(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

  private void init(Context context){

      for (int i = 0; i < 5; i++) {
          occx[i] = new ArrayList<Integer>();
      }

      for (int i = 0; i < 5; i++) {
          occy[i] = new ArrayList<Integer>();
      }

      for(int i=0;i<5;i++){
          Arrays.fill(square[i],0);
      }
      for (int i = 0; i < 20; i++) {
          mn[i] = new ArrayList<Integer>();
      }





      start=t-1;




      postInvalidate();


  }
    protected void onDraw(Canvas canvas) {



        super.onDraw(canvas);

        Log.w(TAG,"MOK 11 ");



        t = Example1.a;
        u = Example1.b;
        int va = (180 * 4) / (u - 1);
        Paint paint = new Paint();
        int m=0;

        int i,j;


        for(i=0;i<u-1;i++){
            int b1=30+va*i;
            int b2=30+va*(i+1);

            for(j=0;j<u-1;j++){
                m++;
                int a1=30+va*j;
                int a2=30+va*(j+1);
                if(box.contains(m)==true) {


                    if(mn[0].contains(m)==true) {
                        paint.setColor(Color.parseColor("#33FF4500"));






                    }


                    else if(mn[1].contains(m)==true){
                        paint.setColor(Color.parseColor("#3300FF00"));


                    }




                    canvas.drawRect(a1, b1, a2, b2, paint);
                }
            }
        }


        paint.setColor(Color.parseColor("#C0C0C0"));
        paint.setStrokeWidth(15);




        m=0;

        for(i=1;i<u;i++){
            int a11=30+(va*i);
            int a22=30+(va*(i-1));
            for( j=0;j<u;j++){
                int b11=30+(va*j);
                int b22=30+(va*(j));

                m++;

                if(valuex.contains(m)==true){

                    if(occx[0].contains(m)==true) {
                        paint.setColor(Color.parseColor("#FF4500"));

                    }


                    else if(occx[1].contains(m)==true){
                        paint.setColor(Color.parseColor("#00FF00"));

                    }




                    canvas.drawLine(a22,b22,a11,b11,paint);



                }


                else {
                    paint.setColor(Color.parseColor("#C0C0C0"));
                    canvas.drawLine(a22, b22, a11, b11, paint);

                }

            }
        }
        m=0;
        for(i=0;i<u;i++){
            int a11=30+(va*i);
            int a22=30+(va*(i));
            for(j=1;j<u;j++){
                int b11=30+(va*j);
                int b22=30+(va*(j-1));
                m++;


                if(valuey.contains(m)==true){


                    if(occy[0].contains(m)==true) {
                        paint.setColor(Color.parseColor("#FF4500"));

                    }


                    else if(occy[1].contains(m)==true){
                        paint.setColor(Color.parseColor("#00FF00"));

                    }





                    canvas.drawLine(a22,b22,a11,b11,paint);

                }


                else {
                    paint.setColor(Color.parseColor("#C0C0C0"));
                    canvas.drawLine(a22, b22, a11, b11, paint);

                }

            }
        }

        paint.setColor(Color.parseColor("#FFFFFF"));
        for (i = 0; i < u; i++) {
            for (j = 0; j < u; j++) {
                canvas.drawCircle(30 + (va * i), 30 + (va * j), 30, paint);
            }
        }


        if(start==0){

            generate();
        }


        invalidate();
    }

    private void generate(){
        Log.w(TAG,"OIU ");

        int a=0,b=0;
        final int rr= new Random().nextInt(2);

        if(rr == 0){

            final int r = new Random().nextInt(u*(u-1))+1;
            a=r;

            while(valuex.contains(a)==true){
                final int rrr = new Random().nextInt(u*(u-1))+1;
                a=rrr;

            }
        }
        if(rr == 1){
            final int r = new Random().nextInt(u*(u-1))+1;
            b=r;

            while(valuey.contains(b)==true){
                final int rrr = new Random().nextInt(u*(u-1))+1;
                b=rrr;
            }
        }
        Log.w(TAG,"OIU "+a+" "+b);

        turns(a,b);




    }

    private void score(){

        TextView s1 = (TextView) ((GameplayS)getContext()).findViewById(R.id.sc11);
        TextView s2 = (TextView) ((GameplayS)getContext()).findViewById(R.id.sc21);

        if(t==2){
            s1.setText(""+sc1);
            s2.setText(""+sc2);
        }






    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value1=super.onTouchEvent(event);



        y1++;
        float x = event.getX();
        float y = event.getY();

        Log.w(TAG,"MOK 1 "+x+" "+y);





        int c1 = Math.round(x);
        int c2 = Math.round(y);




        function(c1, c2);


        return value1;

    }

    private void function(int c1,int c2){
        Log.w(TAG,"MOK 2");
        int i,j,q1=Example1.b,q2=Example1.a,l=0,l2=0;
        int m1=0,m2=0,m=0;



        // just in case these values arent initialised in init
        if(s==0){
            start=q2-1;
            for ( i = 0; i < 5; i++) {
                occx[i] = new ArrayList<Integer>();
            }
            for ( i = 0; i < 5; i++) {
                occy[i] = new ArrayList<Integer>();
            }
            for ( i = 0; i < 20; i++) {
                mn[i] = new ArrayList<Integer>();
            }
            for( i=0;i<5;i++){
                Arrays.fill(square[i],0);
            }
            s++;
        }


        uu=0;


        int va = (180 * 4) / (q1 - 1);

        for(i=1;i<q1;i++){
            int a1=30+(va*i);
            int a2=30+(va*(i-1));
            for(j=0;j<q1;j++){
                int b1=30+(va*j);
                int b2=30+(va*(j));
                m++;

                if(c1>a2&&c1<a1&&((c2>b2+35)|(c2>b2-35))&&((c2<b1+35)|(c2<b1-35))){

                    if(valuex.contains(m)){
                        l2++;
                    }
                    else {
                        valuex.add(m);

                        uu++;
                        ul1x++;
                        m1=m;
                    }
                    l++;

                }

            }
        }
        if(l==0) {
            m = 0;
            for (i = 0; i < q1; i++) {
                int a1 = 30 + (va * i);
                int a2 = 30 + (va * (i));
                for (j = 1; j < q1; j++) {
                    int b1 = 30 + (va * j);
                    int b2 = 30 + (va * (j - 1));
                    m++;

                    if (c2 < b1 && c2 > b2 && ((c1 < a1 + 35) | (c1 < a1 - 35)) && ((c1 > a2 + 35) | (c1 > a2 - 35))) {

                        if(valuey.contains(m)){
                            l2++;
                        }
                        else {
                            valuey.add(m);

                            ul1y++;

                            m2=m;
                        }
                        l++;

                    }
                }
            }


        }

        if(l2==0&&l!=0) {
            turns(m1,m2);
        }





    }



    private void turns(int m1,int m2){
        Log.w(TAG,"MOK 3 "+m1+" "+m2);
        Log.w(TAG,"OIU 2 "+m2+" "+m1);

        if(valuey.contains(m2)==false&&m2!=0){
            valuey.add(m2);
        }
        if(valuex.contains(m1)==false&&m1!=0){
            valuex.add(m1);
        }


        mp.start();

        int t1=Example1.a;
        int t2=Example1.b;

        st=start;

        if(start>=0&&start<3){

            if(m1==0){
                occy[start].add(m2);
                Log.w(TAG,"OIU 2 "+m2);
            }
            else {
                occx[start].add(m1);
            }
            start--;


        }



        else{

            start=t1-1;
            st=start;
            if(m1==0){
                occy[start].add(m2);

            }
            else {
                occx[start].add(m1);

            }
            start--;

        }






        if(t2==3){
            box3(m1,m2);
        }
        if(t2==4){
            box4(m1,m2);
        }
        if(t2==5){
            box5(m1,m2);
        }


        ulx=m1;
        uly=m2;



    }

    private void box3(int m1,int m2){
        Log.w(TAG,"MOK 4");



        if(m1==1|m1==2|m2==1|m2==3){
            square[0][0]++;
        }

        if(m1==4|m1==5|m2==5|m2==3){
            square[0][1]++;

        }

        if(m1==3|m1==2|m2==4|m2==2){
            square[1][0]++;
        }

        if(m1==5|m1==6|m2==4|m2==6){
            square[1][1]++;
        }
        boxq();
    }

    private void box4(int m1,int m2){


        if(m1==1|m2==1|m1==2|m2==4){
            square[0][0]++;
        }
        if(m1==6|m2==7|m1==5|m2==4){

        }
        if(m1==9|m1==10|m2==7|m2==10){
            square[0][2]++;
        }
        if(m1==2|m1==3|m2==5|m2==2){
            square[1][0]++;
        }
        if(m1==6|m1==7|m2==5|m2==8){
            square[1][1]++;
        }
        if(m1==10|m1==11|m2==8|m2==11){
            square[1][2]++;

        }
        if(m1==4|m1==3|m2==3|m2==6){
            square[2][0]++;
        }
        if (m1==8|m1==7|m2==6|m2==9){
            square[2][1]++;
        }
        if(m1==11|m1==12|m2==9|m2==12){
            square[2][2]++;
        }
        boxq();
    }

    private void box5(int m1,int m2){

        if(m2==1|m2==5|m1==1|m1==2){
            square[0][0]++;
        }
        if(m1==7|m1==6|m2==5|m2==9){
            square[0][1]++;
        }
        if(m1==12|m1==11|m2==9|m2==13){
            square[0][2]++;
        }
        if(m1==16|m1==17|m2==13|m2==17){
            square[0][3]++;
        }
        if(m1==2|m1==3|m2==2|m2==6){
            square[1][0]++;
        }
        if(m1==8|m1==7|m2==6|m2==10){
            square[1][1]++;
        }
        if(m1==13|m1==12|m2==14|m2==10){
            square[1][2]++;
        }
        if(m1==17|m1==18|m2==14|m2==18){
            square[1][3]++;
        }
        if(m1==4|m1==3|m2==3|m2==7){
            square[2][0]++;
        }
        if(m1==8|m1==9|m2==7|m2==11){
            square[2][1]++;
        }
        if(m1==14|m1==13|m2==15|m2==11){
            square[2][2]++;
        }
        if(m1==18|m1==19|m2==19|m2==15){
            square[2][3]++;
        }
        if(m1==5|m1==4|m2==4|m2==8){
            square[3][0]++;
        }
        if(m1==9|m1==10|m2==8|m2==12){
            square[3][1]++;
        }
        if(m1==15|m1==14|m2==12|m2==16){
            square[3][2]++;
        }
        if(m1==19|m1==20|m2==16|m2==20){
            square[3][3]++;
        }

        boxq();

    }
    private void boxq(){
        Log.w(TAG,"MOK 5");

        ub1=0;ub2=0;
        s1=sc1;
        s2=sc2;



        int t=Example1.b;
        int m=0;
        for(int i=0;i<t-1;i++){
            for(int j=0;j<t-1;j++){
                m++;
                if(square[i][j]==4){

                    if(box.contains(m)==false){
                        r++;
                        box.add(m);
                        mn[st].add(m);
                        start=st;
                        ubb++;
                        if(st==0){
                            sc1++;ub1++;ub2=m;
                            Vibrator vi =(Vibrator)cn.getSystemService(Context.VIBRATOR_SERVICE);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                vi.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                            } else {
                                //deprecated in API 26
                                vi.vibrate(500);
                            }
                        }
                        if(st==1){
                            sc2++;ub1++;ub2=m;
                            Vibrator vi =(Vibrator)cn.getSystemService(Context.VIBRATOR_SERVICE);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                vi.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                            } else {
                                //deprecated in API 26
                                vi.vibrate(500);
                            }
                        }





                    }
                }

            }
        }

        score();
        postInvalidate();

        if(r==((u-1)*(u-1))){
            result();
        }



    }

    public void undo(){
        if(y1!=0) {
            y1--;
            int t2 = Example1.b;

            sc1 = s1;
            sc2 = s2;

            score();


            if (uu == 0) {
                valuey.remove(ul1y - 1);
                if(start==0){
                    occy[0].remove(occy[0].size()-1);
                }
                if(start==1){
                    occy[1].remove(occy[1].size()-1);
                }


                ul1y--;
                start++;
            } else {
                valuex.remove(ul1x - 1);
                if(start==0){
                    occx[0].remove(occx[0].size()-1);
                }
                if(start==1){
                    occx[1].remove(occx[1].size()-1);
                }

                ul1x--;
                start++;
            }

            if (ub1 == 1) {
                box.remove(ubb - 1);
                if(st==0){
                    mn[0].remove(mn[0].size()-1);
                }
                if(st==1){
                    mn[1].remove(mn[1].size()-1);
                }


                ubb--;
                start = st;
                r--;

            }

            if (t2 == 3) {
                box3u(ulx, uly);
            }
            if (t2 == 4) {
                box4u(ulx, uly);
            }
            if (t2 == 5) {
                box5u(ulx, uly);
            }
        }

    }
    private void box3u(int m1,int m2){



        if(m1==1|m1==2|m2==1|m2==3){
            square[0][0]--;
        }

        if(m1==4|m1==5|m2==5|m2==3){
            square[0][1]--;

        }

        if(m1==3|m1==2|m2==4|m2==2){
            square[1][0]--;
        }

        if(m1==5|m1==6|m2==4|m2==6){
            square[1][1]--;
        }
        postInvalidate();
    }

    private void box4u(int m1,int m2){


        if(m1==1|m2==1|m1==2|m2==4){
            square[0][0]--;
        }
        if(m1==6|m2==7|m1==5|m2==4){
            square[0][1]--;
        }
        if(m1==9|m1==16|m2==9|m2==10){
            square[0][2]--;
        }
        if(m1==2|m1==3|m2==5|m2==2){
            square[1][0]--;
        }
        if(m1==6|m1==7|m2==5|m2==8){
            square[1][1]--;
        }
        if(m1==8|m1==11|m2==10|m2==11){
            square[1][2]--;
        }
        if(m1==4|m1==3|m2==3|m2==6){
            square[2][0]--;
        }
        if (m1==8|m1==7|m2==6|m2==9){
            square[2][1]--;
        }
        if(m1==11|m1==12|m2==9|m2==12){
            square[2][2]--;
        }
        postInvalidate();
    }

    private void box5u(int m1,int m2) {

        if (m2 == 1 | m2 == 5 | m1 == 1 | m1 == 2) {
            square[0][0]--;
        }
        if (m1 == 7 | m1 == 6 | m2 == 5 | m2 == 9) {
            square[0][1]--;
        }
        if (m1 == 12 | m1 == 11 | m2 == 9 | m2 == 13) {
            square[0][2]--;
        }
        if (m1 == 16 | m1 == 17 | m2 == 13 | m2 == 17) {
            square[0][3]--;
        }
        if (m1 == 2 | m1 == 3 | m2 == 2 | m2 == 6) {
            square[1][0]--;
        }
        if (m1 == 8 | m1 == 7 | m2 == 6 | m2 == 10) {
            square[1][1]--;
        }
        if (m1 == 13 | m1 == 12 | m2 == 14 | m2 == 10) {
            square[1][2]--;
        }
        if (m1 == 14 | m1 == 18 | m2 == 17 | m2 == 18) {
            square[1][3]--;
        }
        if (m1 == 4 | m1 == 3 | m2 == 3 | m2 == 7) {
            square[2][0]--;
        }
        if (m1 == 8 | m1 == 9 | m2 == 7 | m2 == 11) {
            square[2][1]--;
        }
        if (m1 == 14 | m1 == 13 | m2 == 15 | m2 == 11) {
            square[2][2]--;
        }
        if (m1 == 18 | m1 == 19 | m2 == 19 | m2 == 15) {
            square[2][3]--;
        }
        if (m1 == 5 | m1 == 4 | m2 == 4 | m2 == 8) {
            square[3][0]--;
        }
        if (m1 == 9 | m1 == 10 | m2 == 8 | m2 == 12) {
            square[3][1]--;
        }
        if (m1 == 15 | m1 == 14 | m2 == 12 | m2 == 16) {
            square[3][2]--;
        }
        if (m1 == 19 | m1 == 20 | m2 == 16 | m2 == 20) {
            square[3][3]--;
        }

        postInvalidate();
    }

    private void result(){
        Intent intent=new Intent(cn,Score.class);

        if(sc1>sc2){
            intent.putExtra(EXTRA_P,"COMPUTER THE WINNER");
        }
        if(sc1<sc2){
            intent.putExtra(EXTRA_P,"YOU ARE THE WINNER");
        }

        if(sc1==sc2){
            intent.putExtra(EXTRA_P,"DRAW MATCH");
        }



        cn.startActivity(intent);


    }







}
