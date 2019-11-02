package com.jitenderkumar.demoducat.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jitenderkumar.demoducat.R;
import com.jitenderkumar.demoducat.fragments.FirstFragment;

public class MainFrgamentActivity extends AppCompatActivity implements FirstFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frgament);
        Log.e("MainFrgamentActivity", "oncreate");

      /*  getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                int count = getSupportFragmentManager().getBackStackEntryCount();

                for (int i= 1; i< count ; i++) {
                    FragmentManager.BackStackEntry backStackEntry =
                            getSupportFragmentManager().getBackStackEntryAt(i);
                   Log.e("backstack", ""+backStackEntry.getName());
                }
            }
        });*/
    }

    public void getMessage() {
        Toast.makeText(this, "thi sis valye", Toast.LENGTH_LONG).show();
    }

    private void startFragment() {
       // SingletonClass.getInstance().getSpecialNumber();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_main, new FirstFragment());
        ft.addToBackStack("firstfragment");
        // ft.disallowAddToBackStack();
        ft.commit();
    }

    @Override
    public void onRssItemSelected(String link) {
        Toast.makeText(this, "thi sis valye", Toast.LENGTH_LONG).show();
    }

    //when activity started with fragment
    /*
    2019-09-28 11:56:13.365 3565-3565/com.jitenderkumar.demoducat E/MainFrgamentActivity: oncreate
2019-09-28 11:56:13.464 3565-3565/com.jitenderkumar.demoducat E/FirstFragment: onAttactch
2019-09-28 11:56:13.464 3565-3565/com.jitenderkumar.demoducat E/FirstFragment: oncreate
2019-09-28 11:56:13.465 3565-3565/com.jitenderkumar.demoducat E/FirstFragment: onCreateview
2019-09-28 11:56:13.471 3565-3565/com.jitenderkumar.demoducat E/FirstFragment: onviewCreated
2019-09-28 11:56:13.471 3565-3565/com.jitenderkumar.demoducat E/FirstFragment: onActivityCreated
2019-09-28 11:56:13.472 3565-3565/com.jitenderkumar.demoducat E/FirstFragment: onStart
2019-09-28 11:56:13.472 3565-3565/com.jitenderkumar.demoducat E/MainFrgamentActivity: onstart
2019-09-28 11:56:13.477 3565-3565/com.jitenderkumar.demoducat E/MainFrgamentActivity: onresume
2019-09-28 11:56:13.477 3565-3565/com.jitenderkumar.demoducat E/FirstFragment: onResume*/

    protected void onStart() {
        super.onStart();
        Log.e("MainFrgamentActivity", "onstart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainFrgamentActivity", "onPAuse");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainFrgamentActivity", "onstop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainFrgamentActivity", "onresume");
        startFragment();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("MainFrgamentActivity", "onrestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainFrgamentActivity", "destroy");
    }
}
