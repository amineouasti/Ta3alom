package com.example.amine.ta3alom;

/**
 * Created by amine on 20-Jul-16.
 */
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class TestNiveauAr extends AppCompatActivity {
    RadioButton  r1 , r2 , r3 , r4 , r5 , r6 , r7 , r8 , r9 , r10 , r11 , r12 , r13 , r14 , r15  , rr;
    Button bt ;
    static int nv = 0;
    static int n = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testniveauarabe);



        r1 = (RadioButton) findViewById(R.id.rd2);
        r2 = (RadioButton) findViewById(R.id.br2);
        r3 = (RadioButton) findViewById(R.id.rd13);
        r4 = (RadioButton) findViewById(R.id.br4);
        r5 = (RadioButton) findViewById(R.id.rd14);
        r6 = (RadioButton) findViewById(R.id.rd17);
        r7 = (RadioButton) findViewById(R.id.rd24);
        r8 = (RadioButton) findViewById(R.id.rd26);
        r9 = (RadioButton) findViewById(R.id.rd30);
        r10 = (RadioButton) findViewById(R.id.rd32);
        r11 = (RadioButton) findViewById(R.id.rd35);
        r12 = (RadioButton) findViewById(R.id.br12);
        r13 = (RadioButton) findViewById(R.id.rd41);
        r14 = (RadioButton) findViewById(R.id.rd44);
        r15 = (RadioButton) findViewById(R.id.rd47);

        rr = (RadioButton)findViewById(R.id.rd49);
        bt = (Button) findViewById(R.id.btn);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (r1.isChecked())
                    nv++;


                if (r2.isChecked())
                    nv++;

                if (r3.isChecked())
                    nv++;

                if (r4.isChecked())
                    nv++;

                if (r5.isChecked())
                    nv++;

                if (r6.isChecked())
                    nv++;

                if (r7.isChecked())
                    nv++;

                if (r8.isChecked())
                    nv++;

                if (r9.isChecked())
                    nv++;

                if (r10.isChecked())
                    nv++;

                if (r11.isChecked())
                    nv++;

                if (r12.isChecked())
                    nv++;

                if (r13.isChecked())
                    nv++;

                if (r14.isChecked())
                    nv++;

                if (r15.isChecked())
                    nv++;

                if(nv == 0 || nv <= 5 ) {


                    n = 1 ;
                    nv = 0 ;


                }
                else if(nv == 5 || nv <= 10){

                    n = 2 ;
                    nv = 0 ;

                }
                else if(nv == 10 || nv <= 15){

                    n = 3 ;
                    nv = 0 ;
                }


            }
        });




    }




}