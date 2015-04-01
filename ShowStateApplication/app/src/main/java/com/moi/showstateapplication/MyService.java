package com.moi.showstateapplication;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;

public class MyService extends Service {

    private String appName;
    private PackageInfo pi = null;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Notification notification = new Notification(R.drawable.ic_launcher, "Notifaction comes", System.currentTimeMillis());
        Intent notificationIntent = new Intent("MY_BROADCAST");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,notificationIntent,0);
        if (Postion.getInstance().getPostion() == -1) {
            notification.setLatestEventInfo(this, "Click to close app", "You didn't choose an item.", pendingIntent);

        } else {
            notification.setLatestEventInfo(this, "Click to close app", "You choose No." + (Postion.getInstance().getPostion() + 1)+ " item.", pendingIntent);
        }
        startForeground(1, notification);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
