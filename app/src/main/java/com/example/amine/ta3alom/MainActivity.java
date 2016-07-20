package com.example.amine.ta3alom;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Firebase ref = new Firebase("https://glaring-fire-6264.firebaseio.com/");
    String login_name,login_pass;
    EditText login,pass;
    boolean test=false;
    static String uid;
    AuthData users;
    static TextToSpeech ttsobject ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login =(EditText) findViewById(R.id.username);
        pass=(EditText) findViewById(R.id.pass);
        ttsobject = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    ttsobject.setLanguage(Locale.FRENCH);
                }else{
                    Toast.makeText(getApplicationContext() , "Feature not Supported in your Device" , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void onButtonClick(View v){
        if(v.getId() == R.id.bS){
        Intent i =new Intent(MainActivity.this,SingUp.class);
            startActivity(i);
        }
        if(v.getId() == R.id.login){
            String method="login";
           /* BackgroundTask bt=new BackgroundTask(this);*/
            login_name=login.getText().toString();
            login_pass=pass.getText().toString();

            ref.authWithPassword(login_name, login_pass, new Firebase.AuthResultHandler() {
                @Override
                public void onAuthenticated(AuthData authData) {
                    Toast.makeText(MainActivity.this,"connected success"+authData.getUid(),Toast.LENGTH_LONG).show();
                    Intent i=new Intent(MainActivity.this,Bar.class);
                    startActivity(i);                }

                @Override
                public void onAuthenticationError(FirebaseError firebaseError) {
                    Toast.makeText(MainActivity.this,"connected error",Toast.LENGTH_LONG).show();
                }
            });

           /* bt.execute(method,login_name,login_pass);*/
    MainActivity user=new MainActivity();
        //    userslist=ref.getAuth();
//            Toast.makeText(MainActivity.this,userslist.getUid(),Toast.LENGTH_LONG).show();
        }
        if(v.getId() == R.id.textView4) {

            login =(EditText) findViewById(R.id.username);
            ref.resetPassword(login.getText().toString(), new Firebase.ResultHandler() {
                @Override
                public void onSuccess() {
                    Toast.makeText(MainActivity.this,"Mot De Passe envoyé dans votre email",Toast.LENGTH_LONG).show();
                }

                @Override
                public void onError(FirebaseError firebaseError) {
                    Toast.makeText(MainActivity.this,"Erreur d\'envoi",Toast.LENGTH_LONG).show();
                }
            });
        }

    }


}

