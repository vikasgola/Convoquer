package io.github.vikasgola.convoquer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Results extends Fragment {

    TextView[] CS;
    TextView[] EE;
    TextView[] ME;
    DatabaseReference databaseReference,cs,me,ee;


    public Results() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_results, container, false);
        CS = new TextView[8];
        EE = new TextView[8];
        ME = new TextView[8];

        CS[0] = view.findViewById(R.id.CS1);
        CS[1] = view.findViewById(R.id.CS2);
        CS[2] = view.findViewById(R.id.CS3);
        CS[3] = view.findViewById(R.id.CS4);
        CS[4] = view.findViewById(R.id.CS5);
        CS[5] = view.findViewById(R.id.CS6);
        CS[6] = view.findViewById(R.id.CS7);
        CS[7] = view.findViewById(R.id.CS8);

        EE[0] = view.findViewById(R.id.EE1);
        EE[1] = view.findViewById(R.id.EE2);
        EE[2] = view.findViewById(R.id.EE3);
        EE[3] = view.findViewById(R.id.EE4);
        EE[4] = view.findViewById(R.id.EE5);
        EE[5] = view.findViewById(R.id.EE6);
        EE[6] = view.findViewById(R.id.EE7);
        EE[7] = view.findViewById(R.id.EE8);

        ME[0] = view.findViewById(R.id.ME1);
        ME[1] = view.findViewById(R.id.ME2);
        ME[2] = view.findViewById(R.id.ME3);
        ME[3] = view.findViewById(R.id.ME4);
        ME[4] = view.findViewById(R.id.ME5);
        ME[5] = view.findViewById(R.id.ME6);
        ME[6] = view.findViewById(R.id.ME7);
        ME[7] = view.findViewById(R.id.ME8);


        databaseReference = FirebaseDatabase.getInstance().getReference("results");
        ee = databaseReference.child("ee");
        me = databaseReference.child("me");
        cs = databaseReference.child("cs");

        ee.keepSynced(true);
        me.keepSynced(true);
        cs.keepSynced(true);


        eventListener(cs , CS);
        eventListener(me , ME);
        eventListener(ee , EE);

        return view;
    }

    public void eventListener(DatabaseReference t , final TextView[] t2){
        t.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                t2[(int)Long.parseLong( dataSnapshot.getKey())].setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                t2[(int)Long.parseLong( dataSnapshot.getKey())].setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                t2[(int)Long.parseLong( dataSnapshot.getKey())].setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                t2[(int)Long.parseLong( dataSnapshot.getKey())].setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
