package com.jitenderkumar.demoducat.firebase;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.jitenderkumar.demoducat.R;
import com.jitenderkumar.demoducat.activities.LoginActivity;

// https://www.androidhive.info/2016/10/android-working-with-firebase-realtime-database/
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMessagingServ";

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.e("firebase token",""+s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if(remoteMessage.getData()!=null)
            sendNotification(remoteMessage);
    }

    private void getNotificationData(final RemoteMessage remoteMessage) {
        /*Map<String, String> data = remoteMessage.getData();
        Config.title = data.get("title");
        Config.content = data.get("content");
        Config.imageUrl = data.get("imageUrl");
        Config.gameUrl = data.get("gameUrl");
        //Create thread to fetch image from notification*/
        if(remoteMessage.getData()!=null){
        }
    }

    private void sendNotification(RemoteMessage remoteMessage){
        // NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        // style.bigPicture(bitmap);
        //Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent,0);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "101";

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            @SuppressLint("WrongConstant") NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Notification", NotificationManager.IMPORTANCE_MAX);

            //Configure Notification Channel
            notificationChannel.setDescription("Game Notifications");
            notificationChannel.enableLights(true);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setAutoCancel(true)
                .setContentText(remoteMessage.getNotification().getBody())
                .setContentIntent(pendingIntent)
                .setWhen(System.currentTimeMillis());
        notificationManager.notify(1, notificationBuilder.build());
    }
}