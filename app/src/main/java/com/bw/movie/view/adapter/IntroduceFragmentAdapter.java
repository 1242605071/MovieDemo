package com.bw.movie.view.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import com.bw.movie.model.bean.DetailsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 *  * <p>文件描述：介绍导演<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/16<p>
 *  * <p>更改时间：2019/10/16<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class IntroduceFragmentAdapter extends BaseQuickAdapter<DetailsBean.MovieDirectorBean,BaseViewHolder> {
    public IntroduceFragmentAdapter(int layoutResId, @Nullable List<DetailsBean.MovieDirectorBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailsBean.MovieDirectorBean item) {
        View view = helper.getView(R.id.iv_introduce_photo);
        String photo = item.photo;
        Glide.with(mContext).load(photo).into((ImageView) view);
        helper.setText(R.id.tv_introduce_name,item.name);
    }
}
