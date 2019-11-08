package com.bw.movie.view.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import com.bw.movie.model.bean.SerachBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 *  * <p>文件描述：首页搜索<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/23<p>
 *  * <p>更改时间：2019/10/23<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class SerachAdapter extends BaseQuickAdapter<SerachBean, BaseViewHolder> {
    public SerachAdapter(int layoutResId, @Nullable List<SerachBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SerachBean item) {
        ImageView imageView=helper.getView(R.id.si1);
        Glide.with(mContext).load(item.imageUrl).into(imageView);
        helper.setText(R.id.st1,item.name);
        helper.setText(R.id.st2,"导演:"+item.director);
        helper.setText(R.id.st3,"主演:"+item.starring);
        helper.setText(R.id.st4,"评分:"+item.score+"分");
    }
}
