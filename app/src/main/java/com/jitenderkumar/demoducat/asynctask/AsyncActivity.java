package com.jitenderkumar.demoducat.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.jitenderkumar.demoducat.R;

public class AsyncActivity extends AppCompatActivity {

    private TextView textStatus;
    private BackGroundWork backGroundWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        textStatus = findViewById(R.id.text_status);

        backGroundWork = new BackGroundWork(this);
        backGroundWork.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        backGroundWork.cancel(true);
    }

    class BackGroundWork extends AsyncTask<String, Integer, String> {

        Activity activity;
        BackGroundWork(Activity activity) {
            this.activity = activity;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textStatus.setText(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.e("progress", ""+values);
        }

        @Override
        protected String doInBackground(String... strings) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);

                    onProgressUpdate(i);

                    //Toast.makeText(AsyncActivity.this, "Run on Main thread", Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "Executed";
        }
    }
}
