package com.bw.movie.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.Paiqi;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class MyPaiqiadapter extends RecyclerView.Adapter<MyPaiqiadapter.myViewHolder> {
    private ArrayList<Paiqi> list;
    private Context context;
    private View view;

    public MyPaiqiadapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

     public void AddAll(List<Paiqi>paiqis){
         if (paiqis!=null){
             list.addAll(paiqis);
         }
     }

    @NonNull
    @Override
    public MyPaiqiadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.paiqi_layout, viewGroup, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPaiqiadapter.myViewHolder myViewHolder, int i) {
       // Glide.with(context).load(list.get(i).imageUrl).into(myViewHolder.imageView8);
        Uri parse = Uri.parse(list.get(i).imageUrl);
        myViewHolder.simpleDraweeView.setImageURI(parse);
        myViewHolder.textView8.setText(list.get(i).name);
        myViewHolder.text_name9.setText(list.get(i).starring);
        myViewHolder.text_name10.setText(list.get(i).director);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder{


        private final TextView textView8;
        private final SimpleDraweeView simpleDraweeView;
        private final TextView text_name9;
        private final TextView text_name10;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            simpleDraweeView = itemView.findViewById(R.id.image8);
            textView8 = itemView.findViewById(R.id.text_name8);
            text_name9 = itemView.findViewById(R.id.text_name9);
            text_name10 = itemView.findViewById(R.id.text_name10);
        }
    }
}
