package com.example.amine.ta3alom;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by amine on 27-May-16.
 */
public class Users extends ListActivity {
    Firebase ref = new Firebase("https://glaring-fire-6264.firebaseio.com/");
    AuthData user=ref.getAuth();
    String uid =user.getUid();
    Firebase userRef=ref.child("users");
    ArrayList<String> mUsers=new ArrayList<>();
    ListView mliste;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 setContentView(R.layout.userslist);
   //final Button x=(Button) findViewById(R.id.btns);
        mliste=(ListView) findViewById(android.R.id.list);
    final CostumAdapter adapter=new CostumAdapter(this,mUsers);
        mliste.setAdapter(adapter);
       userRef.addChildEventListener(new ChildEventListener() {
           @Override
           public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               final String Ps=dataSnapshot.getKey();
                if(!Ps.equals(uid)){
                    mUsers.add(Ps);
                    adapter.notifyDataSetChanged();
                }
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
