package com.example.ero_sol_pc_04.notificationmanager;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ERO-SOL-PC-04 on 2/20/2017.
 */

public class Button_listener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        manager.cancel(intent.getExtras().getInt("id"));
        Toast.makeText(context,"Notification",Toast.LENGTH_SHORT).show();
        //Intent i = new Intent(context,TestActivity.class);
        //context.startActivity(i);

    }
}
