package com.jitenderkumar.demoducat.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jitenderkumar.demoducat.R;
import com.jitenderkumar.demoducat.Utils;
import com.jitenderkumar.demoducat.models.Student;

import java.util.logging.StreamHandler;

public class MainJavaActivity extends AppCompatActivity {

    private Button button;
    final static String INTENT_NAME = "intentname";
    final static String INTENT_STUDENT = "intentstrudent";
    public static SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);

        initSharedPreference();
        button = findViewById(R.id.btn_go);
        Button buttonSave = findViewById(R.id.btn_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent();
            }
        });
    }

    private void initSharedPreference() {
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
    }

    void startIntent() {
        Intent intent = new Intent(this, SecondActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent.putExtra(INTENT_NAME, "username");
        //intent.putExtra(INTENT_STUDENT, getData());
        startActivity(intent);
    }

    Student getData() {
        String name = ((EditText)findViewById(R.id.edit_username)).getText().toString().trim();
        String age = ((EditText)findViewById(R.id.edit_age)).getText().toString().trim();
        String roll = ((EditText)findViewById(R.id.edit_rollno)).getText().toString().trim();

        SharedPreferences.Editor editor = pref.edit();
        editor.putString("NAME", name);
        editor.putString("AGE", age);
        editor.putString("ROLLNO", roll);
        editor.commit();

        Student student = new Student(name, roll, age, "");
        return student;
    }
}
