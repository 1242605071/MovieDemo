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
import com.bw.movie.model.bean.CinemaBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:  2019-11-07
 * Author:  l
 * Description: 选择影院页面适配器
 */
public class ChangeAdapter extends RecyclerView.Adapter {

    private List<CinemaBean> list = new ArrayList<>();

    public void addAll(List<CinemaBean> data) {
        if (data != null) {
            list.addAll(data);
        }
    }
    public interface OnItemClickLister{
        void onClick(int postion);
    }

    private OnItemClickLister lister;

    public void setOnItemClickLister(OnItemClickLister lister) {
        this.lister = lister;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_change, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        ((MyViewHolder) holder).text_name.setText(list.get(position).name);
        ((MyViewHolder) holder).text_address.setText(list.get(position).address);
        Glide.with(holder.itemView.getContext()).load(list.get(position).logo)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.mipmap.ic_launcher)
                .into(((MyViewHolder) holder).image_view);
//        String logo = list.get(position).logo;
//        ((MyViewHolder) holder).image_view.setImageURI(Uri.parse(logo));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lister.onClick(position);
            }
        });
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
        TextView text_name, text_address;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image_view = itemView.findViewById(R.id.image_view);
            text_name = itemView.findViewById(R.id.text_name);
            text_address = itemView.findViewById(R.id.text_address);
        }
    }

}
