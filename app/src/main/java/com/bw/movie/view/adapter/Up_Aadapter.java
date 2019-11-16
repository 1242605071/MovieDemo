package com.bw.movie.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:  2019-11-15
 * Author:  杨世博
 * Description:
 */
public class Up_Aadapter extends RecyclerView.Adapter {
    private List<String> list = new ArrayList<>();

    public void addAll(List<String> data) {
        if (data != null) {
            list.addAll(data);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_up, viewGroup, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView time_up;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            time_up = itemView.findViewById(R.id.time_up);
        }
    }
}
