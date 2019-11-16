package com.bw.movie.view.adapter;

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
import com.bw.movie.model.bean.CinemaScheduleList;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:  2019-11-15
 * Author:  杨世博
 * Description:
 */
public class Down_Adapter extends XRecyclerView.Adapter {
    private List<CinemaScheduleList> list = new ArrayList<>();

    public void addAll(List<CinemaScheduleList> data) {
        if (data != null) {
            list.addAll(data);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_cinemaschedulelist, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MyViewHolder) viewHolder).down_name.setText(list.get(i).name);
        ((MyViewHolder) viewHolder).down_dao.setText("导演:"+list.get(i).director);
        ((MyViewHolder) viewHolder).down_yan.setText("演员:"+list.get(i).starring);
        ((MyViewHolder) viewHolder).down_fen.setText("评分:"+list.get(i).score+"分");
       // Glide.with(viewHolder.itemView.getContext()).load(list.get(i).imageUrl).into(((MyViewHolder) viewHolder).down_ima);
        String logo = list.get(i).imageUrl;
        ((MyViewHolder) viewHolder).down_ima.setImageURI(Uri.parse(logo));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView down_name,down_yan,down_dao,down_fen;
        ImageView down_ima;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            down_name = itemView.findViewById(R.id.down_name);
            down_yan = itemView.findViewById(R.id.down_yan);
            down_dao = itemView.findViewById(R.id.down_dao);
            down_fen = itemView.findViewById(R.id.down_fen);
            down_ima = itemView.findViewById(R.id.down_ima);
        }
    }
}
