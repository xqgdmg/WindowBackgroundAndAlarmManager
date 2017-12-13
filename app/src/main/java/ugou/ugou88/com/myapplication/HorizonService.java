package ugou.ugou88.com.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.util.Date;

/**
 * Created by qhsj on 2017/12/8.
 */

public class HorizonService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        long elapsedRealtimeTriggerTime = SystemClock.elapsedRealtime();
        long currentTimeMillisTriggerTime = System.currentTimeMillis();

        Intent i = new Intent(this, AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);// context, requestCode, intent, flags

        // a. 2000 实际上是没有用的，5.1之后，必须最少一分钟，小于一分钟默认一分钟
        // b. RTC_WAKEUP 对应 currentTimeMillis , ELAPSED_REALTIME_WAKEUP 对应 elapsedRealtime（1970年 & bootTime）
        manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,elapsedRealtimeTriggerTime,2000,pi);
        return super.onStartCommand(intent, flags, startId);

    }
}
