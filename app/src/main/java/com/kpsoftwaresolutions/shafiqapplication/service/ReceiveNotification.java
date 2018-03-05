package com.kpsoftwaresolutions.shafiqapplication.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kpsoftwaresolutions.shafiqapplication.MainActivity;
import com.kpsoftwaresolutions.shafiqapplication.R;
import com.kpsoftwaresolutions.shafiqapplication.model.Message;

/**
 * Created by zahid on 12/22/2017.
 */

public class ReceiveNotification extends Service {

    private DatabaseReference dbRef;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        dbRef = FirebaseDatabase.getInstance().getReference("msg");
        dbRef.orderByChild("id").equalTo("1").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                Message message = dataSnapshot.getValue(Message.class);
//                Toast.makeText(getApplicationContext(), message.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Message message = dataSnapshot.getValue(Message.class);

                Toast.makeText(ReceiveNotification.this, message.getTitle(), Toast.LENGTH_SHORT).show();

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(getApplicationContext())
                                .setSmallIcon(R.drawable.shafiqlogo2)
                                .setContentTitle("Message ")
                                .setContentText("jj");

//                Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
//                PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent,
//                        PendingIntent.FLAG_UPDATE_CURRENT);
//                builder.setContentIntent(contentIntent);

                // Add as notification
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                manager.notify(0, builder.build());
                Toast.makeText(getApplicationContext(), message.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
