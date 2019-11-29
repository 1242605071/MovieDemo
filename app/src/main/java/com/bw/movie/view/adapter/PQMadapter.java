package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.bean.YingYuanPaiQi;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/19<p>
 * <p>更改时间：2019/11/19<p>
 */
public class PQMadapter extends XRecyclerView.Adapter<PQMadapter.MyViewHolder> {

    private List<YingYuanPaiQi> list;
    private Context context;

    public PQMadapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<YingYuanPaiQi> data){
        if (data != null) {
            list.addAll(data);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_paiqi, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        //Uri parse = Uri.parse();
        myViewHolder.iv.setImageURI(list.get(i).imageUrl);
    myViewHolder.releasedmovie_tv_name.setText(list.get(i).name);
    myViewHolder.releasedmovie_tv_time.setText(list.get(i).director);
    myViewHolder.releasedmovie_tv_usernum.setText(list.get(i).starring);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView releasedmovie_tv_time,releasedmovie_tv_usernum;
        SimpleDraweeView iv;
        TextView releasedmovie_tv_name;
        Button releasedmovie_bt,reservation_bt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.releasedmovie_iv);
            releasedmovie_tv_name = itemView.findViewById(R.id.releasedmovie_tv_name);
            releasedmovie_tv_time = itemView.findViewById(R.id.releasedmovie_tv_time);
            releasedmovie_tv_usernum = itemView.findViewById(R.id.releasedmovie_tv_usernum);
            releasedmovie_bt = itemView.findViewById(R.id.releasedmovie_bt);
            reservation_bt = itemView.findViewById(R.id.reservation_bt);
        }
    }
}
