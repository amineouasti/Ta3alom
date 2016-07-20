package com.example.amine.ta3alom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

/**
 * Created by amine on 17-Jul-16.
 */
public class Costumadapchat extends ArrayAdapter<String>{
    Firebase ref = new Firebase("https://glaring-fire-6264.firebaseio.com/");
    Firebase userRef=ref.child("users");
    public Costumadapchat(Context context, ArrayList<String> resource) {
        super(context,R.layout.cnv ,resource);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater userInflater = LayoutInflater.from(getContext());
        convertView = userInflater.inflate(R.layout.cnv, parent, false);
       final String item=getItem(position);
        final String[] ps = new String[1];
        final TextView tex=(TextView) convertView.findViewById(R.id.ch);
        userRef.child(item).child("Pseudo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ps[0] =dataSnapshot.getValue().toString();
                tex.setText(ps[0]);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
LinearLayout ch=(LinearLayout) convertView.findViewById(R.id.da);
ch.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        CostumAdapter.uidrecep=item;
        v.getContext().startActivity(new Intent(getContext(),Msg.class));
    }
});
    return convertView;

    }
}
