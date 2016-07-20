package com.example.amine.ta3alom;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by amine on 17-Jul-16.
 */
class CostumAdapter extends ArrayAdapter<String> {
    static String uidrecep;
      Firebase ref = new Firebase("https://glaring-fire-6264.firebaseio.com/");
    Firebase userRef=ref.child("users");
    CostumAdapter(Context context, ArrayList<String> resource) {
        super(context, R.layout.l1, resource);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater userInflater = LayoutInflater.from(getContext());
        convertView = userInflater.inflate(R.layout.l1, parent, false);
        final String userItem = getItem(position);
        final String[] ps = new String[1];
       final TextView text = (TextView) convertView.findViewById(R.id.ttx);
        userRef.child(userItem).child("Pseudo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ps[0] =dataSnapshot.getValue().toString();
                text.setText(ps[0]);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        ImageView btn = (ImageView) convertView.findViewById(R.id.btns);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(getContext(),Msg.class));
                 uidrecep=userItem;

            }
        });
        ImageView p=(ImageView) convertView.findViewById(R.id.profil);
            p.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uidrecep=userItem;
                    v.getContext().startActivity(new Intent(getContext(),Profil.class));
                }
            });

        return convertView;
    }
}

