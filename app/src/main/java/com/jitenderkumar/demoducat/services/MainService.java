package com.jitenderkumar.demoducat.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

public class MainService extends IntentService {

    public MainService() {
        super("name");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("called", "bind");
        return null;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e("called", "onhandle");
        doSomeWork();
    }

    @Override
    public void onCreate() {
        Log.e("called", "oncreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("called", "onstartcommand");
        return super.onStartCommand(intent, flags, startId);
    }

    void doSomeWork() {
      for (int i = 0 ; i<5 ; i++) {
          Log.e("called", "this" +i);

          try {
              Thread.sleep(1000);
          }catch (Exception e) {
          }
      }

        Toast.makeText(getApplicationContext(), " Main service called", Toast.LENGTH_LONG).show();

        Intent intent = new Intent();
        intent.setAction(MainServiceActivity.INTENTACTION);

        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        Log.e("called", "destroy");
        super.onDestroy();
    }
}
