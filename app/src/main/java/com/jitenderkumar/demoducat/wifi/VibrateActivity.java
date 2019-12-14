package com.jitenderkumar.demoducat.wifi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.view.View;

import com.jitenderkumar.demoducat.R;

public class VibrateActivity extends Activity {

    private Vibrator v;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_vibrate);

        findViewById(R.id.button_on).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
            }
        });

        findViewById(R.id.button_off).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelVibration();
            }
        });
    }

    void vibrate() {
        // Get instance of Vibrator from current Context
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

       // Start without a delay
       // Vibrate for 100 milliseconds
       // Sleep for 1000 milliseconds
       long[] pattern = {0, 100, 1000};

        // The '0' here means to repeat indefinitely
        // '0' is actually the index at which the pattern keeps repeating from (the start)
        // To repeat the pattern from any other point, you could increase the index, e.g. '1'
        v.vibrate(pattern, 0);
    }

    void cancelVibration() {
        if (v==null) return;
        v.cancel();
    }
}
