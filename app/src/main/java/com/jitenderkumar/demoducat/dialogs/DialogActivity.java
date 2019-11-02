package com.jitenderkumar.demoducat.dialogs;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.jitenderkumar.demoducat.R;

import java.util.zip.Inflater;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.button_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();

                SimpleDialog simpleDialog = new SimpleDialog();
                simpleDialog.show(fm, "fragment_alert");
                simpleDialog.setCancelable(false);
            }
        });
    }
}
