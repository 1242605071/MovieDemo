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
import com.bw.movie.model.bean.NearbyBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:  2019-11-07
 * Author:  l
 * Description: 附近影院页面适配器
 */
public class NearAdapter extends XRecyclerView.Adapter {
    private List<NearbyBean> list = new ArrayList<>();

    public void addAll(List<NearbyBean> data) {
        if (data != null) {
            list.addAll(data);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_near, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        ((MyViewHolder) holder).text_name.setText(list.get(position).name);
        ((MyViewHolder) holder).text_address.setText(list.get(position).address);
        ((MyViewHolder) holder).text_mi.setText(list.get(position).distance+"米");
        Glide.with(holder.itemView.getContext()).load(list.get(position).logo)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.mipmap.ic_launcher)
                .into(((MyViewHolder) holder).image_view);
//        String logo = list.get(position).logo;
//        ((MyViewHolder) holder).image_view.setImageURI(Uri.parse(logo));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image_view;
        TextView text_name, text_address,text_mi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image_view = itemView.findViewById(R.id.image_view);
            text_name = itemView.findViewById(R.id.text_name);
            text_address = itemView.findViewById(R.id.text_address);
            text_mi = itemView.findViewById(R.id.text_mi);
        }
    }
}
