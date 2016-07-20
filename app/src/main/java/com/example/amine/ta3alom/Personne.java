package com.example.amine.ta3alom;

/**
 * Created by amine on 17-May-16.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static com.example.amine.ta3alom.R.layout.personne_layout;
public class Personne extends Activity {
    Firebase ref = new Firebase("https://glaring-fire-6264.firebaseio.com/");
    AuthData user=ref.getAuth();
    String uid =user.getUid();
    //prenom,ps,email;
    Firebase userRef=ref.child("users").child(uid);
@Override
    protected void onCreate(Bundle savedInstanceState) {

      Firebase nomRef=userRef.child("nom");
      Firebase prenomRef=userRef.child("prenom");
      Firebase emailRef=userRef.child("email");
      Firebase lmRef=userRef.child("Langue maternelle");
      Firebase laRef=userRef.child("langue à apprendre");
      Firebase pseudoRef=userRef.child("Pseudo");
    Firebase lfrancais = userRef.child("Niveau Francais ");
    Firebase larabe = userRef.child("Niveau Arabe ");
    Firebase sexe=userRef.child("sexe");
    Firebase date=userRef.child("date de naissance");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.personne_layout);
    ImageView btnChh = (ImageView) findViewById(R.id.btnChange);
          // nom.setText(user.getUid());
//    FirebaseStorage storage= FirebaseStorage.getInstance();
    //StorageReference st=storage.getReference("gs://glaring-fire-6264.appspot.com").child("image/l.jpg");
    //ImageView x=(ImageView) findViewById(R.id.x);
    nomRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               String nom=dataSnapshot.getValue(String.class);
                ((TextView) findViewById(R.id.nomuser)).setText(nom);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    prenomRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String nom=dataSnapshot.getValue(String.class);
            ((TextView) findViewById(R.id.prenomuser)).setText(nom);


        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    });
    pseudoRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String nom=dataSnapshot.getValue(String.class);
            ((TextView) findViewById(R.id.pseudo)).setText(nom);


        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    });
    lmRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String nom=dataSnapshot.getValue(String.class);
            ((TextView) findViewById(R.id.languem)).setText(nom);


        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    });
    laRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String nom=dataSnapshot.getValue(String.class);
            ((TextView) findViewById(R.id.languea)).setText(nom);


        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    });
    lfrancais.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String x = dataSnapshot.getValue(String.class);
            ((TextView) findViewById(R.id.frr)).setText(x);
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }

    });
    larabe.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String x = dataSnapshot.getValue(String.class);
            ((TextView) findViewById(R.id.arr)).setText(x);
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }

    });
    sexe.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String x = dataSnapshot.getValue(String.class);
            ((TextView) findViewById(R.id.sexep)).setText(x);
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    });
    date.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String x = dataSnapshot.getValue(String.class);
            ((TextView) findViewById(R.id.datep)).setText(x);
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    });
    btnChh.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), ChangePassword.class) ;
            startActivity(i);
        }
    });
    /*pseudoRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String nom=dataSnapshot.getValue(String.class);
            ((TextView) findViewById(R.id.pseudo)).setText(nom);


        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    });*/


    }
}