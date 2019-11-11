package com.bw.movie.view.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.bean.RegionListBean;


import java.util.List;


/**
 * <p>文件描述：地区适配器<p>
 * <p>作者：李大辰<p>
 * <p>创建时间：2019/10/22<p>
 * <p>更改时间：2019/10/22<p>
 */
public class RegionListAdapter extends RecyclerView.Adapter<RegionListAdapter.ViewHolder> {

    private Context context;
    private RegionListBean regionListBean;
    public MRecyclerViewListener recyclerViewListener;

    public interface MRecyclerViewListener {
        void onItemClick(int position);
    }

    public void setMRecyclerViewListener(MRecyclerViewListener recyclerViewListener) {
        this.recyclerViewListener = recyclerViewListener;
    }

    public RegionListAdapter(Context context, RegionListBean regionListBean) {
        this.context = context;
        this.regionListBean = regionListBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.region_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<RegionListBean.ResultInfo> result = regionListBean.result;
        holder.tv_region.setText(result.get(position).regionName);
        holder.mPosition = position;
    }

    @Override
    public int getItemCount() {
        return regionListBean.result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_region;
        private int mPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_region = itemView.findViewById(R.id.tv_region);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (recyclerViewListener != null) {
                recyclerViewListener.onItemClick(mPosition);
            }
        }
    }
}
