package com.bw.movie.view.adapter;


import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.bean.ComBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 *  * <p>文件描述：即将上映适配器<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/12<p>
 *  * <p>更改时间：2019/10/12<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class SubscribeAdapter extends BaseQuickAdapter<ComBean,BaseViewHolder> {
    public SubscribeAdapter(int layoutResId, @Nullable List<ComBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final ComBean item) {
        helper.setText(R.id.name,item.name);
        SimpleDateFormat format=new SimpleDateFormat("MM"+"月"+"dd"+"日上映");
        String format1 = format.format(item.releaseTime);
        helper.setText(R.id.time1,format1+"");
        helper.setText(R.id.person,item.wantSeeNum+"人想看");
        ImageView imageView = helper.getView(R.id.image1);
        imageView.setImageURI(Uri.parse(item.imageUrl));
    }


}
