package com.jitenderkumar.demoducat.events;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jitenderkumar.demoducat.R;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Button button = findViewById(R.id.button_event);
        EditText editText = findViewById(R.id.edit_text);
        EditText editText1 = findViewById(R.id.edit_text_2);

        ConstraintLayout constraintLayout = findViewById(R.id.constraint_top);
        constraintLayout.setOnTouchListener(touchListener);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EventActivity.this, "simple click", Toast.LENGTH_SHORT).show();
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Log.e("focus change", ""+b);
            }
        });

        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Log.e("focus change", ""+b);
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(EventActivity.this, "Long click", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private String KEYCODE = "keycode";

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        //replaces the default 'Back' button action
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Log.i("KEYCODE", "back ppressded");
        }
        return true;
    }   */

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_D:
                Log.i("KEYCODE", "touched d");
                return true;
            case KeyEvent.KEYCODE_F:
                Log.i("KEYCODE", "touched f");
                return true;
            case KeyEvent.KEYCODE_J:
                Log.i("KEYCODE", "touched j");
                return true;
            case KeyEvent.KEYCODE_K:
                Log.i("KEYCODE", "touched k");
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.i("TAG", "touched down");
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.i("TAG", "moving: (" + x + ", " + y + ")");
                    break;
                case MotionEvent.ACTION_UP:
                    Log.i("TAG", "touched up");
                    break;
            }

            return true;
        }
    };


}
