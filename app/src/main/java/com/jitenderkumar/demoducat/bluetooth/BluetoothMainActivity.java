package com.jitenderkumar.demoducat.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jitenderkumar.demoducat.R;

public class BluetoothMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bluetooth);

        Button btntOn = (Button) findViewById(R.id.btnOn);
        Button btntOff = (Button) findViewById(R.id.btnOFF);
        Button btnDisc = (Button) findViewById(R.id.btnDiscoverable);

        final BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();
        btntOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bAdapter == null) {
                    Toast.makeText(getApplicationContext(), "Bluetooth Not Supported", Toast.LENGTH_SHORT).show();
                } else {
                    if (!bAdapter.isEnabled()) {
                        startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), 1);
                        Toast.makeText(getApplicationContext(), "Bluetooth Turned ON", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btntOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bAdapter.disable();
                Toast.makeText(getApplicationContext(), "Bluetooth Turned OFF", Toast.LENGTH_SHORT).show();
            }
        });

        btnDisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bAdapter.isDiscovering()) {
                    startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE), 1);
                    Toast.makeText(getApplicationContext(), "Making Device Discoverable", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
