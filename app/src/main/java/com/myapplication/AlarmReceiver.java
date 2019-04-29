package com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by qhsj on 2017/12/8.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
//        Intent i = new Intent(context, HorizonService.class);
//        context.startService(i);

        Log.e("chris","BroadcastReceiver get...and...log");
    }
}
