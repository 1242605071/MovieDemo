package com.bw.movie.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.bean.ResultInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:  2019-11-12
 * Author:  l
 * Description:
 */
public class Address_ParentAdapter extends RecyclerView.Adapter<Address_ParentAdapter.MyViewholder> {
    private List<ResultInfo> list = new ArrayList<>();

    public void addAll(List<ResultInfo> data) {
        if (data != null) {
            list.addAll(data);
        }
    }
    @NonNull
    @Override
    public Address_ParentAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.address_parent, viewGroup, false);
        return new Address_ParentAdapter.MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Address_ParentAdapter.MyViewholder myViewholder, final int i) {
        myViewholder.address_parent.setText(list.get(i).regionName);
        myViewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemCilckListener.OnItemCilck(list.get(i).regionId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView address_parent;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            address_parent = itemView.findViewById(R.id.address_parent);
        }
    }
    //实现接口
    public OnItemCilckListener onItemCilckListener;

    public void setOnItemCilckListener(OnItemCilckListener onItemCilckListener) {
        this.onItemCilckListener = onItemCilckListener;
    }

    //定义接口
    public interface OnItemCilckListener {
        void OnItemCilck(int position);
    }
}
