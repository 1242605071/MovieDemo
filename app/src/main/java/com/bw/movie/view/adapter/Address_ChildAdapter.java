package com.bw.movie.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.bean.RegioBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:  2019-11-12
 * Author:  l
 * Description:
 */
public class Address_ChildAdapter extends RecyclerView.Adapter<Address_ChildAdapter.MyViewHolder> {
    private List<RegioBean> list = new ArrayList<>();

    public void addAll(List<RegioBean> data) {
        if (data != null) {
            list.addAll(data);
        }
    }

    @NonNull
    @Override
    public Address_ChildAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.address_child, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Address_ChildAdapter.MyViewHolder myViewHolder, final int i) {
       myViewHolder.address_child.setText(list.get(i).name);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView address_child;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            address_child = itemView.findViewById(R.id.address_child);
        }
    }

}