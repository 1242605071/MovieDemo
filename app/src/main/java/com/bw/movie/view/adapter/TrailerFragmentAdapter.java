package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import com.bw.movie.model.app.App;
import com.bw.movie.model.bean.DetailsBean;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 *  * <p>文件描述：视频<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/16<p>
 *  * <p>更改时间：2019/10/16<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class TrailerFragmentAdapter extends RecyclerView.Adapter<TrailerFragmentAdapter.ViewHoldera>{
    private List<DetailsBean.ShortFilmListBean> shortFilmList = new ArrayList<>();


    public void addAll(List<DetailsBean.ShortFilmListBean> data){
        if (data!=null){
            shortFilmList.addAll(data);
        }
    }



    @Override
    public ViewHoldera onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trailer_item,null);
        ViewHoldera myViewHoler=new ViewHoldera(view);
        return myViewHoler;
    }

    @Override
    public void onBindViewHolder( ViewHoldera viewHoldera, int i) {
        viewHoldera.tr.setUp(shortFilmList.get(i).videoUrl,null);
        Glide.with(App.context).load(shortFilmList.get(i).videoUrl).into(viewHoldera.tr.ivThumb);
    }



    @Override
    public int getItemCount() {
        return shortFilmList.size();
    }
    public  class ViewHoldera extends BaseViewHolder {

         JCVideoPlayer tr;

        public ViewHoldera(View view) {
            super(view);
            tr = itemView.findViewById(R.id.trailer_movie);
        }
    }


}
