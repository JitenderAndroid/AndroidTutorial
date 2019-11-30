package com.jitenderkumar.demoducat.networking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jitenderkumar.demoducat.R;
import com.jitenderkumar.demoducat.activities.recyclerviewdemo.RecyclerViewAdapter;
import com.jitenderkumar.demoducat.networking.pojo.Example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonVolleyActivity extends AppCompatActivity {

    private String JSON_URL = "https://simplifiedcoding.net/demos/view-flipper/heroes.php";

    private ArrayList<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_volley);

        loadHeroList();
    }

    private void loadHeroList() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //hiding the progressbar after completion
                        progressBar.setVisibility(View.INVISIBLE);

                        try {
                            heroList = new ArrayList<>();
                            JSONObject obj = new JSONObject(response);

                            // using gson parsing
                            parseUsingGson(obj.toString());

                            JSONArray heroArray = obj.getJSONArray("heroes");

                            for (int i = 0; i < heroArray.length(); i++) {
                                JSONObject heroObject = heroArray.getJSONObject(i);
                                Hero hero = new Hero(heroObject.getString("name"), heroObject.getString("imageurl"));
                                heroList.add(hero);
                            }

                            setRecyclerView(heroList);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    void parseUsingGson(String jsonString) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Example example= gson.fromJson(jsonString, Example.class);

        Log.e("hero", "array" +  example.getHeroes().get(0).getName());
    }

    void setRecyclerView(ArrayList<Hero> arrayList) {
        RecyclerView recyclerView = findViewById(R.id.recycler_list);

        //to set layout type orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerVolleyAdapter recyclerViewAdapter = new RecyclerVolleyAdapter(this, arrayList);

        //to set divider between items
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
