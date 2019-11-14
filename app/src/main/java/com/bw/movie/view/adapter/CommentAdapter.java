package com.bw.movie.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;
import com.bw.movie.model.bean.CinemaCommentBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Time:  2019-11-14
 * Author:  杨世博
 * Description:
 */
public class CommentAdapter extends RecyclerView.Adapter {
    private List<CinemaCommentBean> list = new ArrayList<>();

    public void addAll(List<CinemaCommentBean> data) {
        if (data != null) {
            list.addAll(data);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_comment, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.com_name.setText(list.get(i).commentUserName);
        Date date = new Date(list.get(i).commentTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        myViewHolder.com_time.setText(format.format(date));
        myViewHolder.com_content.setText(list.get(i).commentContent);
        myViewHolder.com_reply.setText("等" + list.get(i).commentId + "人觉得很赞");
        Glide.with(viewHolder.itemView.getContext()).load(list.get(i).commentHeadPic)
                .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(myViewHolder.com_head);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView com_head;
        TextView com_name, com_time, com_content, com_reply;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            com_head = itemView.findViewById(R.id.com_head);
            com_name = itemView.findViewById(R.id.com_name);
            com_time = itemView.findViewById(R.id.com_time);
            com_content = itemView.findViewById(R.id.com_content);
            com_reply = itemView.findViewById(R.id.com_reply);
        }
    }
}
