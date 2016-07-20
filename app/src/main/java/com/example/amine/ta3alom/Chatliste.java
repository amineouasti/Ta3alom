package com.example.amine.ta3alom;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ListView;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.realtime.util.StringListReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amine on 30-Jun-16.
 */
public class Chatliste extends ListActivity{
    Firebase ref = new Firebase("https://glaring-fire-6264.firebaseio.com/");
    AuthData user=ref.getAuth();
    String uid =user.getUid();
    ArrayList<String> mChat=new ArrayList<>();
    Firebase chatRef=ref.child("users").child(uid).child("chat");
    ListView chatlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatlistelayout);
        final Costumadapchat adapter=new Costumadapchat(this,mChat);
        chatlist=(ListView) findViewById(android.R.id.list);

        chatlist.setAdapter(adapter);
        chatRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                final String Cv=dataSnapshot.getKey();
                mChat.add(Cv);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
