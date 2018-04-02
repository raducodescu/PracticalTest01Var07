package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;
import java.util.Date;
import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ProcessingThread extends Thread {

    private Context context = null;
    private boolean isRunning = true;

    private Random random = new Random();

    private int n1,n2,n3,n4;

    public ProcessingThread(Context context) {
        this.context = context;


    }

    @Override
    public void run() {
        Log.d("[ProcessingThread]", "Thread has started!");
        while (isRunning) {
            Log.d("service", "Trimit mesajjjjjjjjjjjjjjjjjjjjjjjjj");
            sendMessage();
            sleep();
            Random rd = new Random();
            n1 = rd.nextInt();
            n2 = rd.nextInt();
            n3 = rd.nextInt();
            n4 = rd.nextInt();
        }
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.putExtra("n1", n1);
        intent.putExtra("n2", n2);
        intent.putExtra("n3", n3);
        intent.putExtra("n4", n4);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}

