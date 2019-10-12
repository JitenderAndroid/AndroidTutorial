package com.jitenderkumar.demoducat.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jitenderkumar.demoducat.R;
import com.jitenderkumar.demoducat.fragments.FirstFragment;
import com.jitenderkumar.demoducat.fragments.SecondFragment;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tab);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());

        adapter.addFragment(new FirstFragment(), "Tab 1");
        adapter.addFragment(new SecondFragment(), "Tab 2");
        adapter.addFragment(new FirstFragment(), "Tab 3");
        adapter.addFragment(new SecondFragment(), "Tab 4");
        adapter.addFragment(new SecondFragment(), "Tab 5");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
