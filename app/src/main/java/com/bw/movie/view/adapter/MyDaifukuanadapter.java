package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class MyDaifukuanadapter extends RecyclerView.Adapter<MyDaifukuanadapter.myViewHolder> {
    private ArrayList<GouPao> list;
    private Context context;
    private View view;

    public MyDaifukuanadapter( Context context) {
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
    public MyDaifukuanadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.item_daifukuan, viewGroup, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDaifukuanadapter.myViewHolder myViewHolder, final int i) {
        myViewHolder.imageView.setImageURI(list.get(i).imageUrl);
        myViewHolder.text_Id.setText(list.get(i).orderId);
        myViewHolder.text_name.setText(list.get(i).movieName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy" + "-" + "MM" + "-" + "dd" + " "+"HH"+":"+"mm");
        String format = simpleDateFormat.format(list.get(i).createTime);
        myViewHolder.text_time.setText(format);
        myViewHolder.dianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isWork.work(list.get(i).orderId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder{

         SimpleDraweeView imageView;
         TextView text_name;
         TextView text_Id;
         TextView text_time;
         Button dianji;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            text_name = itemView.findViewById(R.id.text_name);
            text_Id = itemView.findViewById(R.id.text_Id);
            text_time = itemView.findViewById(R.id.text_time);
            dianji = itemView.findViewById(R.id.dianji);
        }
    }
    private IsWork isWork;

    public void setIsWork(IsWork isWork) {
        this.isWork = isWork;
    }

    public interface IsWork{
        void work(String id);
    }
}
