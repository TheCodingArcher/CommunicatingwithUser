package com.android.rahul.nirmesh.communicatingwithuser;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int NOTIFY_ID = 1001;
    private static final String NOTIFICATION_CHANNEL_ID = "my_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        findViewById(R.id.btnNotification).setOnClickListener(this);
    }

    private void createNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        Intent intent = new Intent(this, NotificationResultActivity.class);
        intent.putExtra("notifyID", NOTIFY_ID);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                NOTIFY_ID,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT
        );

        builder.setSmallIcon(R.drawable.ic_stat_sample_notification);
        builder.setContentTitle("Sample Notification");
        builder.setContentText("This is a Sample Notification");

        builder.setAutoCancel(true);

        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

        builder.setSubText("Tap to View");

        builder.setContentIntent(pendingIntent);

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle("This is Big Notification");
        bigTextStyle.bigText(getResources().getString(R.string.LongMsg));
        builder.setStyle(bigTextStyle);

        builder.addAction(R.mipmap.ic_launcher, "Action 1", pendingIntent);
        builder.addAction(R.mipmap.ic_launcher, "Action 2", pendingIntent);

        builder.setVisibility(Notification.VISIBILITY_PUBLIC);
//        builder.setVisibility(Notification.VISIBILITY_SECRET);  // for Secret Notifications
//        builder.setVisibility(Notification.VISIBILITY_PRIVATE); // for Private Notifications

        // Works like a Charm below API level 23
        /*Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, notification);*/

        // For API Level above 23
        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    "App Notifying",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationManager.notify(NOTIFY_ID, notification);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNotification) {
            createNotification();
        }
    }
}
