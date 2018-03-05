package com.kpsoftwaresolutions.shafiqapplication.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kpsoftwaresolutions.shafiqapplication.R;
import com.kpsoftwaresolutions.shafiqapplication.model.Message;
import com.kpsoftwaresolutions.shafiqapplication.service.ReceiveNotification;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    private DatabaseReference dbRef;

    private Button send;
    private EditText msg;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_notification, container, false);

        send = (Button) v.findViewById(R.id.send_btn);
        msg = (EditText) v.findViewById(R.id.msg);

        getActivity().startService(new Intent(getContext(), ReceiveNotification.class));

        dbRef = FirebaseDatabase.getInstance().getReference("msg");

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "1";
                String title = "Message From MD. SHAFIQUZZAMAN SHAFIQ";
                String mes = msg.getText().toString();
                Message message = new Message(id, title, mes);

                dbRef.child(id).setValue(message);
                Toast.makeText(getContext(), "Message Sent", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}
