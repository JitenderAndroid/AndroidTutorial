package com.jitenderkumar.demoducat.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jitenderkumar.demoducat.R;
import com.jitenderkumar.demoducat.activities.MainJavaActivity;
import com.jitenderkumar.demoducat.models.Student;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    static final int REQUESTCODE = 2;
    static final String USERDATA = "userdata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.e("second", "onCreate");
        textView = findViewById(R.id.text_1);
        Button button  = findViewById(R.id.btn_second);

        Student student = (Student) getIntent().getExtras().get("Student");

        String age = student.getAge();
        String name = student.getName();
        String rollno = student.getRollno();

        Log.e("studennt data", age+"  "+ name+ "      "+ rollno);
        //getData();
   /*     button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainJavaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });*/
    }

    void getData() {
        SharedPreferences sharedPreferences = MainJavaActivity.pref;

        String name = sharedPreferences.getString("NAME", "");
        String age = sharedPreferences.getString("AGE", "");
        String roll = sharedPreferences.getString("ROLLNO", "");

        Log.e("sharedc data", name + "      "+ age + "       " + roll);

    }

    protected void onStart() {
        super.onStart();
        Log.e("second", "onstart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("second", "onPAuse");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("second", "onstop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("second", "onresume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("second", "onrestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("second", "destroy");
    }
}
