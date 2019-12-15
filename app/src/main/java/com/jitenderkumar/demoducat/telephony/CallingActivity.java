package com.jitenderkumar.demoducat.telephony;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jitenderkumar.demoducat.R;

public class CallingActivity extends AppCompatActivity {

    String CALL_CENTER_NUMBER = "69655654564654";
    int REQUEST_PHONE = 101;
    private String[] permissions = {Manifest.permission.CALL_PHONE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);

        ActivityCompat.requestPermissions(this, permissions, REQUEST_PHONE);
        findViewById(R.id.button_call_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callThroughDialer();
            }
        });


        findViewById(R.id.button_call_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDirectly();
            }
        });

        findViewById(R.id.button_call_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkConnection.netConnection(CallingActivity.this);
            }
        });
    }

    private void callThroughDialer() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0987654321"));
        startActivity(intent);
    }

    private void callDirectly() {
     if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + CALL_CENTER_NUMBER));
            startActivity(callIntent);
        } else {
         ActivityCompat.requestPermissions(this, permissions, REQUEST_PHONE);
      }
    }
}
