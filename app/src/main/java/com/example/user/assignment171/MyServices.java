package com.example.user.assignment171;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by user on 19-12-2017.
 */

//MyServices class extending Services class
public class MyServices extends Service
{
    //creating object of MediaPlayer
    private MediaPlayer mediaPlayer;

    //onCreate Method
    @Override
    public void onCreate() {
        super.onCreate();

        //setting MediaPlayer
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.nokia_tune);
    }

    //onStartCommand Method
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //starting MediaPlayer
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        //making a simple notification with icon , title & text
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Assignment17.1").setContentText("Notification released and focus taken to MainActivity");

        //intent to return to mainActivity
        Intent intent1 = new Intent(MyServices.this,MainActivity.class);

        //pendingIntent to wait until the notification is released
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent1,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        //making notificationManager object to notify
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //notifying
        notificationManager.notify(0,builder.build());

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //onDestrou method
    @Override
    public void onDestroy() {

        //stopping mediaPlayer
        mediaPlayer.release();

        super.onDestroy();
    }
}
