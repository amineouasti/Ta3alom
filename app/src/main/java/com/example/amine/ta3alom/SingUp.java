package com.example.amine.ta3alom;

import android.accounts.AccountAuthenticatorResponse;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.content.Context;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Firebase.ValueResultHandler;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;





public class SingUp extends Activity  {
    Firebase ref=new Firebase("https://glaring-fire-6264.firebaseio.com/");
    EditText pass1,t2,ps,pass2,prenom,nom,email,dt,lm,la;
    RadioButton ar1 , ar2 , fr1 , fr2 ,femme;
    DatePicker datePicker;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ps=(EditText) findViewById(R.id.ps);
        pass1=(EditText) findViewById(R.id.pass1);
        pass2=(EditText) findViewById(R.id.pass2);
        prenom=(EditText) findViewById(R.id.prenom);
        nom=(EditText) findViewById(R.id.nom);
        email=(EditText) findViewById(R.id.email);
        datePicker = (DatePicker) findViewById(R.id.date);
        ar1 = (RadioButton)findViewById(R.id.llar);
        femme = (RadioButton)findViewById(R.id.femme);
        ar2 = (RadioButton)findViewById(R.id.llar2);
        fr1 = (RadioButton)findViewById(R.id.llfr);
        fr2 = (RadioButton)findViewById(R.id.llfr2);
        //lm=(EditText) findViewById(R.id.lm);
        //la=(EditText) findViewById(R.id.la);
    }
    AuthData id;

    Firebase userRef=ref.child("userslist");

    public void setOnData(View view){
   /* Map<String, Object> nom = new HashMap<String, Object>();
    Map<String, Object> username= new HashMap<String, Object>();*/
        // User user=new User(t3.getText().toString(),t1.getText().toString(),t2.getText().toString());
 /*   nom.put("nom",user.getNom());
    username.put("username",user.getUsername());*/

        final Firebase userRef=ref.child("users");
   /* userRef.updateChildren(nom);
    userRef.updateChildren(username);*/
   /*userRef.child("nom").setValue(user.getNom());
    userRef.child("username").setValue(user.getUsername());*/
        if((ar1.isChecked() || fr1.isChecked()) && (ar2.isChecked() || fr2.isChecked())){
            if(pass1.getText().toString().equals(pass2.getText().toString()) ){
                if( pass1.getText().toString().length()>=6){

                    userRef.createUser(email.getText().toString(), pass1.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {
                        @Override
                        public void onSuccess(Map<String, Object> result) {
                            Toast.makeText(SingUp.this, "compte créer :: \n" + result.get("uid"), Toast.LENGTH_LONG).show();
                            Firebase user = userRef.child(result.get("uid").toString());
                            user.child("Pseudo").setValue(ps.getText().toString());
                            user.child("mots de pass").setValue(pass1.getText().toString());
                            user.child("nom").setValue(nom.getText().toString());
                            user.child("prenom").setValue(prenom.getText().toString());
                            user.child("email").setValue(email.getText().toString());
                            if(ar1.isChecked()) {
                                user.child("Langue maternelle").setValue("Arabe");
                            }else{
                                user.child("Langue maternelle").setValue("Français");
                            }
                            if(ar2.isChecked()){
                                user.child("langue à apprendre").setValue("Arabe");
                            }else{
                                user.child("langue à apprendre").setValue("Français");
                            }
                            if(femme.isChecked()){
                                user.child("sexe").setValue("Femme");

                            }else{
                                user.child("sexe").setValue("Homme");
                            }

                            int day = datePicker.getDayOfMonth();
                            int month = datePicker.getMonth() + 1;
                            int year = datePicker.getYear();
                            String date=day+"/"+month+"/"+year;
                            user.child("date de naissance").setValue(date);


                           // user.child("Niveau Francais ").setValue(TestNiveau.n);
                            //user.child("Niveau Arabe ").setValue(TestNiveauAr.n);

                        }

                        @Override
                        public void onError(FirebaseError firebaseError) {

                        }
                    });
                }

                else{
                    Toast.makeText(SingUp.this,"Le Mot De Passe doit avoir au moins 6 caractères",Toast.LENGTH_LONG).show();
                }
            }
            else {Toast.makeText(SingUp.this,"Confirmation de Mots de Passe Erroné",Toast.LENGTH_LONG).show();}

        }
        else {
            Toast.makeText(SingUp.this,"S.T.P. Saisir vôtre langue voulez vous apprendre et votre langue matérnelle",Toast.LENGTH_LONG).show();
        }

    }


 public void onClick(View v){
        if(v.getId() == R.id.fr){

            startActivity(new Intent(this,TestNiveau.class));
        }
        if(v.getId() == R.id.ar){

            startActivity(new Intent(this,TestNiveauAr.class));
        }

    }

}
