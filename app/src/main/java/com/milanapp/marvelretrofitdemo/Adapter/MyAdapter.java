package com.milanapp.marvelretrofitdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.milanapp.marvelretrofitdemo.Description;
import com.milanapp.marvelretrofitdemo.Model.Marvel;
import com.milanapp.marvelretrofitdemo.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Marvel> marvelArrayList = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<Marvel> marvelArrayList) {
        this.context = context;
        this.marvelArrayList = marvelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.raw_item,parent,false);
        final MyViewHolder holder = new MyViewHolder(view);

        holder.item_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Description.class);

                intent.putExtra("charecter_name",marvelArrayList.get(holder.getAdapterPosition()).getName());
                intent.putExtra("bio",marvelArrayList.get(holder.getAdapterPosition()).getBio());
                context.startActivity(intent);

            }
        });




        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final  Marvel marvel = marvelArrayList.get(position);

        holder.marvel_real_name.setText(marvel.getRealname());
        holder.marvel_charecter_name.setText(marvel.getName());
        holder.marvel_team_name.setText(marvel.getTeam());
        holder.marvel_publisher.setText(marvel.getPublisher());
        holder.marvel_Apperence.setText(marvel.getFirstappearance());
        Glide.with(context).load(marvel.getImageurl()).centerCrop().into(holder.marvel_img);

    }

    @Override
    public int getItemCount() {
        return marvelArrayList.size();
    }

    public static final class   MyViewHolder extends RecyclerView.ViewHolder{
        TextView marvel_charecter_name,marvel_real_name,marvel_team_name,marvel_publisher,marvel_Apperence;
        ImageView marvel_img;
        RelativeLayout item_relative;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            marvel_charecter_name = itemView.findViewById(R.id.marvel_charecter_name);
            marvel_real_name = itemView.findViewById(R.id.marvel_real_name);
            marvel_team_name = itemView.findViewById(R.id.marvel_team_name);
            marvel_publisher = itemView.findViewById(R.id.marvel_publisher);
            marvel_Apperence = itemView.findViewById(R.id.marvel_Apperence);
            marvel_img = itemView.findViewById(R.id.marvel_img);
            item_relative = itemView.findViewById(R.id.item_relative);


        }
    }
}
