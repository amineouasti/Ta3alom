package com.example.amine.ta3alom;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Random;

/**
         * Created by amine on 17-May-16.
 */
public class Msg extends ListActivity{
    static boolean vaar = false ;
    static String sttr ;
    String input;
    String uidrec;
    // TODO: change this to your own Firebase URL
    private static final String FIREBASE_URL = "https://glaring-fire-6264.firebaseio.com/";
    Firebase ref=new Firebase(FIREBASE_URL);
    AuthData user=ref.getAuth();
    String uid =user.getUid();
    private String mUsername;
    private String lu;
    private Firebase mFirebaseRef;
    private Firebase rFirebaseRef;
    private ValueEventListener mConnectedListener;
    private ChatListAdapter mChatListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msg);

        // Make sure we have a mUsername
        setupUsername();

        setTitle("Chatting as " + mUsername);
        AuthData user=ref.getAuth();
        String uid =user.getUid();
        // Setup our Firebase mFirebaseRef;
        uidrec=CostumAdapter.uidrecep;
        if(!CostumAdapter.uidrecep.equals("")){
        mFirebaseRef = new Firebase(FIREBASE_URL).child("users").child(uid).child("chat").child(uidrec);

        rFirebaseRef =new Firebase(FIREBASE_URL).child("users").child(uidrec).child("chat").child(uid);}
        else{
            mFirebaseRef= new Firebase(FIREBASE_URL).child("chat");
        }
        // Setup our input methods. Enter key on the keyboard or pushing the send button
        EditText inputText = (EditText) findViewById(R.id.messageInput);
        inputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_NULL && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    sendMessage();
                }
                return true;
            }
        });

        findViewById(R.id.sendButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Setup our view and list adapter. Ensure it scrolls to the bottom as data changes
        final ListView listView = getListView();
        // Tell our list adapter that we only want 50 messages at a time
        mChatListAdapter = new ChatListAdapter(mFirebaseRef.limit(50), this, R.layout.message, mUsername);
        listView.setAdapter(mChatListAdapter);
        mChatListAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(mChatListAdapter.getCount() - 1);
            }
        });

        // Finally, a little indication of connection status
        mConnectedListener = mFirebaseRef.getRoot().child(".info/connected").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean connected = (Boolean) dataSnapshot.getValue();
                if (connected) {
                    Toast.makeText(Msg.this, "Connected to Firebase", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Msg.this, "Disconnected from Firebase", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                // No-op
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        mFirebaseRef.getRoot().child(".info/connected").removeEventListener(mConnectedListener);
        mChatListAdapter.cleanup();
    }

    private void setupUsername() {
        SharedPreferences prefs = getApplication().getSharedPreferences("ChPrefs", 0);
        mUsername = prefs.getString("username", null);
        if (mUsername == null) {
          // Random r = new Random();
           //  Assign a random user name if we don't have one saved.
           // mUsername = "JavaUser" + r.nextInt(100000);
            ref.child("users").child(uid).child("Pseudo").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                mUsername=dataSnapshot.getValue(String.class);

                                    }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            prefs.edit().putString("username", mUsername).commit();
        }


    }

    private void sendMessage() {
        EditText inputText = (EditText) findViewById(R.id.messageInput);
        if(vaar == true){
            input = "Faute: "+sttr +"\nCorrection : "+inputText.getText().toString();
            vaar=false;
            sttr="";}
        else{ input = inputText.getText().toString();}
        if(!input.equals("")){
            Chat chat = new Chat(input ,mUsername);
            if(!CostumAdapter.uidrecep.equals("")){

            rFirebaseRef.push().setValue(chat);
            mFirebaseRef.push().setValue(chat);
            inputText.setText("");}

        else{
            mFirebaseRef.push().setValue(chat);
            inputText.setText("");
        }}
    }

}