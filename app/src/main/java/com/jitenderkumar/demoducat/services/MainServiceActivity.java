package com.jitenderkumar.demoducat.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jitenderkumar.demoducat.R;

public class MainServiceActivity extends AppCompatActivity {

    public static String INTENTACTION = "intentaction";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service);

        registerBroadcast();
        Intent intent = new Intent(MainServiceActivity.this, MainService.class);
        startService(intent);
    }

    void registerBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(INTENTACTION);

        LocalBroadcastManager.getInstance(this).registerReceiver(new Receiver(), intentFilter);
    }

    class Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(MainServiceActivity.this, "called", Toast.LENGTH_LONG).show();
        }
    }

    void unregisterREceiver() {
        unregisterREceiver();
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterREceiver();
        Intent intent = new Intent(MainServiceActivity.this, MainService.class);
        stopService(intent);
    }
}
