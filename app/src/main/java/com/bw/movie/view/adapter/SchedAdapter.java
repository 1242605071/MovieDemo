package com.bw.movie.view.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;

import com.bw.movie.model.bean.SchedBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/24<p>
 *  * <p>更改时间：2019/10/24<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class SchedAdapter extends BaseQuickAdapter<SchedBean.ResultBean ,BaseViewHolder> {
    public SchedAdapter(int layoutResId, @Nullable List<SchedBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final SchedBean.ResultBean item) {
          helper.setText(R.id.recycler_type,item.screeningHall);
          helper.setText(R.id.recycler_Begintime,item.beginTime);
          helper.setText(R.id.recycler_endtime,item.endTime);
        final TextView view = helper.getView(R.id.recycler_type);
        final RelativeLayout reLay = helper.getView(R.id.reLay);
       view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int blue = 0;
                reLay.setBackgroundColor(blue);
                callBack.getBack("0");
                callBack.getId(item.id);
            }
        });

    }
    public interface iCallBack {
        void getBack(String s);
        void getId(int idd);
    }

    iCallBack callBack;

    public void setCallBack(iCallBack callBack) {
        this.callBack = callBack;
    }
}

