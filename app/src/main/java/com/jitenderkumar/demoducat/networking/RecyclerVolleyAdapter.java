package com.jitenderkumar.demoducat.networking;

import android.app.Activity;
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

public class RecyclerVolleyAdapter extends RecyclerView.Adapter<RecyclerVolleyAdapter.MyViewHolder> {

    private ArrayList<Hero> moviesList;
    private Activity activity;

    public RecyclerVolleyAdapter(Activity activity, ArrayList<Hero> moviesList) {
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
        holder.title.setText(moviesList.get(position).getName());

        if (moviesList.get(position).getImageUrl() != null)
            Picasso.with(activity).load(moviesList.get(position).getImageUrl())
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
            title = (TextView) view.findViewById(R.id.text_title);
            imageView = (ImageView) view.findViewById(R.id.image_profile);
        }
    }
}