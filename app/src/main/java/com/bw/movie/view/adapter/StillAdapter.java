package com.bw.movie.view.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import com.bw.movie.model.bean.DetailsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/17<p>
 *  * <p>更改时间：2019/10/17<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class StillAdapter extends BaseQuickAdapter<DetailsBean.ShortFilmListBean,BaseViewHolder> {


    public StillAdapter(int layoutResId, @Nullable List<DetailsBean.ShortFilmListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailsBean.ShortFilmListBean item) {
        ImageView imageView = helper.getView(R.id.still_i1);
        Glide.with(mContext).load(item.imageUrl).into(imageView);
    }
}
