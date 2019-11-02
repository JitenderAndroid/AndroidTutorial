package com.jitenderkumar.demoducat.broadcast;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jitenderkumar.demoducat.R;

public class MainBroadCastActivity extends AppCompatActivity {

    MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_broad_cast);

        findViewById(R.id.button_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sendMessage();
            }
        });
        myReceiver = new MyReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }

    public void sendBroadCast() {
        Intent intent = new Intent();
        intent.setAction("com.journaldev.AN_INTENT");

        //intent.setComponent(new ComponentName(getPackageName(),"com.journaldev.androidoreobroadcastreceiver.MyReceiver"));
        getApplicationContext().sendBroadcast(intent);
    }
}
