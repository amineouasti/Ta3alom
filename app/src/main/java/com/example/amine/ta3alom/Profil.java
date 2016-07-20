package com.example.amine.ta3alom;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by amine on 19-Jul-16.
 */
public class Profil extends Activity {
    Firebase ref = new Firebase("https://glaring-fire-6264.firebaseio.com/");
    String uid= CostumAdapter.uidrecep;
    Firebase userRef=ref.child("users").child(uid);
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
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pr_layout);
       nomRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nom=dataSnapshot.getValue(String.class);
                ((TextView) findViewById(R.id.nomp)).setText(nom);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        prenomRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nom=dataSnapshot.getValue(String.class);
                ((TextView) findViewById(R.id.prenomp)).setText(nom);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        pseudoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nom=dataSnapshot.getValue(String.class);
                ((TextView) findViewById(R.id.pseudop)).setText(nom);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        lmRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nom=dataSnapshot.getValue(String.class);
                ((TextView) findViewById(R.id.languemp)).setText(nom);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        laRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nom=dataSnapshot.getValue(String.class);
                ((TextView) findViewById(R.id.langueap)).setText(nom);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        lfrancais.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String x = dataSnapshot.getValue(String.class);
                ((TextView) findViewById(R.id.frrp)).setText(x);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });
        larabe.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String x = dataSnapshot.getValue(String.class);
                ((TextView) findViewById(R.id.arrp)).setText(x);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });
        sexe.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String x = dataSnapshot.getValue(String.class);
                ((TextView) findViewById(R.id.sexe)).setText(x);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        date.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String x = dataSnapshot.getValue(String.class);
                ((TextView) findViewById(R.id.date)).setText(x);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}