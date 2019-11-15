package com.bw.movie.view.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;

import com.bw.movie.model.bean.CommentsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 *  * <p>文件描述：影评<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/16<p>
 *  * <p>更改时间：2019/10/16<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class CommentsAdapter extends BaseQuickAdapter<CommentsBean, BaseViewHolder> {
    public CommentsAdapter(int layoutResId, @Nullable List<CommentsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentsBean item) {
        helper.setText(R.id.name,item.commentUserName);
        SimpleDateFormat format=new SimpleDateFormat("MM"+"-"+"dd");
        String format1 = format.format(item.commentTime);
        helper.setText(R.id.time1,format1+"");
        helper.setText(R.id.nrong,item.commentContent);
        helper.setText(R.id.reply,"等" + item.commentId + "人觉得很赞");
        ImageView imageView = helper.getView(R.id.tx);
        Glide.with(mContext).load(item.commentHeadPic)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
