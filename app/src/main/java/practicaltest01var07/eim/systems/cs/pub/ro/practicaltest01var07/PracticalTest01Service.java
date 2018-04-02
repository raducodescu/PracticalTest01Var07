package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class PracticalTest01Service extends Service {

    private ProcessingThread processingThread = null;

    @Override
    public void onCreate() {
        processingThread = new ProcessingThread(this);
        processingThread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        processingThread = new ProcessingThread(this);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        processingThread.stopThread();
    }

}