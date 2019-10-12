package com.jitenderkumar.demoducat.activities.recyclerviewdemo;

import android.app.Activity;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jitenderkumar.demoducat.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
/*

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<Data> moviesList;
    private Activity activity;

    public RecyclerViewAdapter(Activity activity, ArrayList<Data> moviesList) {
        this.moviesList = moviesList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(moviesList.get(position).getTitle());

        if (moviesList.get(position).getImage() != null)
        Picasso.with(activity).load(moviesList.get(position).getImage())
                .error(R.drawable.ic_launcher_background).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Data data = moviesList.get(getAdapterPosition());
                    data.getTitle();
                    Toast.makeText(activity, "clicked", Toast.LENGTH_LONG).show();
                }
            });
            title = (TextView) view.findViewById(R.id.text_title);
            imageView = (ImageView) view.findViewById(R.id.image_profile);
        }
    }
}*/
