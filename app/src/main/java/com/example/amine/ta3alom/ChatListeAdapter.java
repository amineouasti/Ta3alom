package com.example.amine.ta3alom;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

/**
 * Created by amine on 21-May-16.
 */
class ChatListAdapter extends FirebaseListAdapter<Chat> {
    public String username;

    // The mUsername for this client. We use this to indicate which messages originated from this user
    public String mUsername;
    private static final String FIREBASE_URL = "https://glaring-fire-6264.firebaseio.com/";
    Firebase ref=new Firebase(FIREBASE_URL);
    AuthData user=ref.getAuth();
    String uid =user.getUid();
    public ChatListAdapter(Query ref, Activity activity, int layout, String mUsername) {
        super(ref, Chat.class, layout, activity);
        this.mUsername = mUsername;
    }

    /**
     * Bind an instance of the <code>Chat</code> class to our view. This method is called by <code>FirebaseListAdapter</code>
     * when there is a data change, and we are given an instance of a View that corresponds to the layout that we passed
     * to the constructor, as well as a single <code>Chat</code> instance that represents the current data to bind.
     *
     * @param view A view instance corresponding to the layout we passed to the constructor.
     * @param chat An instance representing the current state of a chat message
     */
    @Override
    protected void populateView(View view, final Chat chat) {
        // Map a Chat object to an entry in our listview
        final String author = chat.getAuthor();
        ImageButton by = (ImageButton)view.findViewById(R.id.soundButton);
       final TextView authorText = (TextView) view.findViewById(R.id.author);
         final TextView m=(TextView) view.findViewById(R.id.message);
        final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)m.getLayoutParams();

        authorText.setText(author + ": ");

        ref.child("users").child(uid).child("Pseudo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mUsername=dataSnapshot.getValue(String.class);
                if (author != null && author.equals(mUsername)) {
                    authorText.setTextColor(Color.RED);
                    //m.setBackgroundResource(R.drawable.left);
                    //layoutParams.gravity= Gravity.LEFT;
                } else {
                   // m.setBackgroundResource(R.drawable.blue_left);
                    authorText.setTextColor(Color.BLUE);
                   // layoutParams.gravity= Gravity.RIGHT;
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        // If the message was sent by this user, color it differently
        /*if (author != null && author.equals(mUsername)) {
            authorText.setTextColor(Color.RED);
        } else {
            authorText.setTextColor(Color.BLUE);
        }*/
        ((TextView) view.findViewById(R.id.message)).setText(chat.getMessage());
        ImageButton err = (ImageButton) view.findViewById(R.id.btn);


        by.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ttsobject.speak(chat.getMessage(), TextToSpeech.QUEUE_FLUSH , null);
            }
        });
        err.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Msg.vaar=true;
                Msg.sttr=chat.getMessage();
            }
        });
    }
}
