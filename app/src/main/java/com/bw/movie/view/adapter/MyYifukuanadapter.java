package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.GouPao;
import com.bw.movie.model.bean.GuanzhuBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MyYifukuanadapter extends RecyclerView.Adapter<MyYifukuanadapter.myViewHolder> {
    private ArrayList<GouPao> list;
    private Context context;
    private View view;

    public MyYifukuanadapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<GouPao> data){
        if (data!=null){
            list.addAll(data);
        }
    }

    @NonNull
    @Override
    public MyYifukuanadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.daifukuan1_layout, viewGroup, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyYifukuanadapter.myViewHolder myViewHolder, int i) {
        String imageUrl = list.get(i).imageUrl;
        myViewHolder.imageView.setImageURI(imageUrl);
        myViewHolder.name.setText(list.get(i).movieName);
        myViewHolder.text_Id.setText(list.get(i).orderId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy" + "-" + "MM" + "-" + "dd" + " "+"HH"+":"+"mm");
        String Time = format.format(list.get(i).createTime);
        myViewHolder.text_time.setText(Time);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder{

         SimpleDraweeView imageView;
         TextView text_time;
         TextView name;
         TextView text_Id;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image2);
            name = itemView.findViewById(R.id.text_name);
            text_Id = itemView.findViewById(R.id.text_Id);
            text_time = itemView.findViewById(R.id.text_time);

        }
    }
}
