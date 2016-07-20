package com.example.amine.ta3alom;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by saidi on 7/18/2016.
 */
public class ChangePassword  extends Activity {

    EditText eml , mt , mtn ;
    Button btch ;
    Firebase ref = new Firebase("https://glaring-fire-6264.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
        eml = (EditText)findViewById(R.id.em);
        mt = (EditText)findViewById(R.id.mtp);
        mtn = (EditText)findViewById(R.id.mtpn);
        btch = (Button)findViewById(R.id.btchhh);

        btch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mtn.getText().toString().length() >= 6) {
                    ref.changePassword(eml.getText().toString(), mt.getText().toString(), mtn.getText().toString(), new Firebase.ResultHandler() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(ChangePassword.this, "Votre Mot de passe a été changer", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(ChangePassword.this, Personne.class));
                        }

                        @Override
                        public void onError(FirebaseError firebaseError) {
                            Toast.makeText(ChangePassword.this, "Erreur de changement du Mot De Passe", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else{
                    Toast.makeText(ChangePassword.this, "Le Mot De Passe doit contenir au moins 6 caractères", Toast.LENGTH_LONG).show();
                }
            }
        });


    }


}