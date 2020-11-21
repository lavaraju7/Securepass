package com.lava.securepass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id,username,password,website;
    Activity activity;

    CustomAdapter(Activity activity,Context context,ArrayList id,ArrayList website,ArrayList username,ArrayList password){
        this.activity=activity;
        this.context=context;
        this.id=id;
        this.website=website;
        this.username=username;
        this.password=password;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.username_txt.setText(String.valueOf(username.get(position)));
        holder.password_txt.setText(String.valueOf(password.get(position)));

        if(String.valueOf(website.get(position)).equals(context.getString(R.string.Amazon)))
            holder.imageView.setImageResource(R.drawable.ic_amazon);
        else if(String.valueOf(website.get(position)).equals(context.getString(R.string.Fb)))
            holder.imageView.setImageResource(R.drawable.ic_facebook);
        else if(String.valueOf(website.get(position)).equals(context.getString(R.string.Gmail)))
            holder.imageView.setImageResource(R.drawable.ic_gmail);
        else if(String.valueOf(website.get(position)).equals(context.getString(R.string.Insta)))
            holder.imageView.setImageResource(R.drawable.ic_instagram);
        else if(String.valueOf(website.get(position)).equals(context.getString(R.string.Link)))
            holder.imageView.setImageResource(R.drawable.ic_linkedin);
        else if(String.valueOf(website.get(position)).equals(context.getString(R.string.Pinterest)))
            holder.imageView.setImageResource(R.drawable.ic_pinterest);
        else if(String.valueOf(website.get(position)).equals(context.getString(R.string.Spot)))
            holder.imageView.setImageResource(R.drawable.ic_spotify);
        else if(String.valueOf(website.get(position)).equals(context.getString(R.string.Steam)))
            holder.imageView.setImageResource(R.drawable.ic_steam);
        else if(String.valueOf(website.get(position)).equals(context.getString(R.string.Twitter)))
            holder.imageView.setImageResource(R.drawable.ic_twitter);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Updateactivity.class);
                intent.putExtra("id",String.valueOf(id.get(position)));
                intent.putExtra("website",String.valueOf(website.get(position)));
                intent.putExtra("username",String.valueOf(username.get(position)));
                intent.putExtra("password",String.valueOf(password.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return username.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView username_txt;
        TextView password_txt;
        ImageView imageView;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview1);
            username_txt = itemView.findViewById(R.id.username_txt);
            password_txt = itemView.findViewById(R.id.password_txt);
            mainLayout = itemView.findViewById(R.id.main_layout);

        }
    }
}
