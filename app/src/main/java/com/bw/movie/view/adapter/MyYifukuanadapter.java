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
import com.bw.movie.model.bean.GuanzhuBean;

import java.util.ArrayList;
import java.util.List;

public class MyYifukuanadapter extends RecyclerView.Adapter<MyYifukuanadapter.myViewHolder> {
    private ArrayList<GuanzhuBean> list;
    private Context context;
    private View view;

    public MyYifukuanadapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<GuanzhuBean> guanzhuBeans){
        if (guanzhuBeans!=null){
            list.addAll(guanzhuBeans);
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

        Glide.with(context).load(list.get(i).imageUrl).into(myViewHolder.imageView);

        myViewHolder.textView.setText(list.get(i).director);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView textView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image2);
            textView = itemView.findViewById(R.id.text_name);

        }
    }
}
