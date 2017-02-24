package com.example.ero_sol_pc_04.notificationmanager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {
    private NotificationCompat.Builder builder ;
    private NotificationManager notificationManager;
    private int notificationId ;
    private RemoteViews remoteViews;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        remoteViews = new RemoteViews(getPackageName(),R.layout.noti_layout);
        remoteViews.setImageViewResource(R.id.img_view_user,R.mipmap.ic_launcher);
        remoteViews.setTextViewText(R.id.txt_view_user_name,"ABC");

        Intent Button_Intent = new Intent("Button_Clicked");
        Button_Intent.putExtra("id",notificationId);
        PendingIntent pIntent = PendingIntent.getBroadcast(context,123,Button_Intent,0);
        remoteViews.setOnClickPendingIntent(R.id.btn,pIntent);



        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noti_Intent = new Intent(context,MainActivity.class);
                PendingIntent intent = PendingIntent.getActivity(context,0,noti_Intent,0);
                builder = new NotificationCompat.Builder(context);
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true)
                        .setCustomBigContentView(remoteViews)
                        .setContentIntent(intent);
                notificationManager.notify(notificationId,builder.build());

            }
        });
    }
}
