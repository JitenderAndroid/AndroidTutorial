package com.jitenderkumar.demoducat.activities.recyclerviewdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jitenderkumar.demoducat.R;

import java.util.ArrayList;

public class MainRecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler);
        RecyclerView recyclerView = findViewById(R.id.recycler_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Data> arrayList = new ArrayList<>();

        Data data = new Data("http://homepages.cae.wisc.edu/~ece533/images/airplane.png", "kwjhdk");
        arrayList.add(data);
        arrayList.add(data);
        arrayList.add(data);
        arrayList.add(data);
        arrayList.add(data);
        arrayList.add(data);
        arrayList.add(data);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, arrayList);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerViewAdapter.notifyDataSetChanged();
    }
}
