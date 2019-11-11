package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.bean.CinemasInfoByRegionBean;


import java.util.List;



/**
 * <p>文件描述：一个区域中的影院<p>
 * <p>作者：李大辰<p>
 * <p>创建时间：2019/10/23<p>
 * <p>更改时间：2019/10/23<p>
 */
public class CinemaByRegionAdapter extends RecyclerView.Adapter<CinemaByRegionAdapter.ViewHolder> {

    private Context context;
    private CinemasInfoByRegionBean regionBean;
    public CinemaByRegionListener cinemaByRegionListener;

    public interface CinemaByRegionListener {
        void setOnItemClick(int position);
    }

    public void setCinemaByRegionListener(CinemaByRegionListener cinemaByRegionListener) {
        this.cinemaByRegionListener = cinemaByRegionListener;
    }

    public CinemaByRegionAdapter(Context context, CinemasInfoByRegionBean regionBean) {
        this.context = context;
        this.regionBean = regionBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.region_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<CinemasInfoByRegionBean.ResultInfo> result = regionBean.result;
        holder.tv.setText(result.get(position).name);
        holder.mPosition = position;
    }

    @Override
    public int getItemCount() {
        return regionBean.result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv;
        private int mPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_region);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (cinemaByRegionListener != null) {
                cinemaByRegionListener.setOnItemClick(mPosition);
            }
        }
    }
}
