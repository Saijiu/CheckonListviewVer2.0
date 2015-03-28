package com.moi.showstateapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyCloseReceiver extends BroadcastReceiver {
    public MyCloseReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent stopIntent = new Intent(context, MyService.class);
        context.stopService(stopIntent);
        ExitApplication.getInstance().exit();
    }
}
