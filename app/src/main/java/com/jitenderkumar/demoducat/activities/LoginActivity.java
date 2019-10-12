package com.jitenderkumar.demoducat.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jitenderkumar.demoducat.R;
import com.jitenderkumar.demoducat.models.Student;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity {

    @BindView(R.id.button_login)
    Button buttonLogin;

    @BindString(R.string.login)
    String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("login", "oncreate");
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_login)
    void onButtonCLicked() {
        Student student = new Student("rahul", "546", "kjhg", "g");

        Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
        intent.putExtra("NAME", "username");
        intent.putExtra("Student", student);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("login", "onstart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("login", "onPAuse");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("login", "onstop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("login", "onresume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("login", "onrestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("login", "destroy");
    }
}
