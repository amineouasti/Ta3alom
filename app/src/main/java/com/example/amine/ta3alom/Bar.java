package com.example.amine.ta3alom;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.Window;

import com.firebase.client.Firebase;

/**
 * Created by amine on 30-May-16.
 */
public class Bar extends AppCompatActivity  {

    Firebase ref = new Firebase("https://glaring-fire-6264.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar);

    }
    public void onClickbutton(View v){
        if(v.getId()==R.id.buttonDus){
            Intent i=new Intent(Bar.this,Chatliste.class);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonListe){
            Intent i=new Intent(Bar.this,Users.class);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonP){
            Intent i=new Intent(Bar.this,Personne.class);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonCR){
            CostumAdapter.uidrecep="";
            Intent i=new Intent(Bar.this,Msg.class);
            startActivity(i);

        }
        if(v.getId() == R.id.buttonDx){
            ref.unauth();
            Intent i=new Intent(Bar.this,MainActivity.class);
            startActivity(i);
        }
    }


}
