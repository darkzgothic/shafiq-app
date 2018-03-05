package com.kpsoftwaresolutions.shafiqapplication.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by zahid on 12/22/2017.
 */

public class BootUpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent myIntent = new Intent(context, ReceiveNotification.class);
        context.startService(myIntent);
    }
}
