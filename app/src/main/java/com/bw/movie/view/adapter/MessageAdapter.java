package com.bw.movie.view.adapter;

import android.support.annotation.Nullable;

import com.bw.movie.R;
import com.bw.movie.model.bean.TonBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/12/1<p>
 *  * <p>更改时间：2019/12/1<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class MessageAdapter extends BaseQuickAdapter<TonBean.ResultBean,BaseViewHolder> {
    public MessageAdapter(int layoutResId, @Nullable List<TonBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TonBean.ResultBean item) {
        helper.setText(R.id.mesage_tv,item.title);
        helper.setText(R.id.mesage_xin,item.content);
        SimpleDateFormat format=new SimpleDateFormat("MM"+"-"+"dd");
        String format1 = format.format(item.pushTime);
        helper.setText(R.id.mesage_shi,format1+"");
    }
}
