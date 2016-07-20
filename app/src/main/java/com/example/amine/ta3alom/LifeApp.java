package com.example.amine.ta3alom;

import android.app.Application;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by amine on 20-May-16.
 */
public class LifeApp extends Application {

    TextView fireData;
    Firebase gRef;
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
