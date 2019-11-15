package com.bw.movie.view.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.FindAllCinemas;
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
public class SerachcimAdapter extends BaseQuickAdapter<FindAllCinemas, BaseViewHolder> {
    public SerachcimAdapter(int layoutResId, @Nullable List<FindAllCinemas> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FindAllCinemas item) {
        ImageView imageView=helper.getView(R.id.image_view);
        Glide.with(mContext).load(item.logo).into(imageView);
        helper.setText(R.id.text_name,item.name);
        helper.setText(R.id.text_address,item.address);

    }
}
