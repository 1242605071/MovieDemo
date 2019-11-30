package com.bw.movie.view.adapter;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import com.bw.movie.model.bean.ComBean;
import com.bw.movie.view.activity.SubscribeActivity;
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
public class SoonAdapter extends BaseQuickAdapter<ComBean,BaseViewHolder> {
    public SoonAdapter(int layoutResId, @Nullable List<ComBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final ComBean item) {
        helper.setText(R.id.name,item.name);
        SimpleDateFormat format=new SimpleDateFormat("MM"+"月"+"dd"+"日上映");
        String format1 = format.format(item.releaseTime);
        helper.setText(R.id.time1,format1+"");
        helper.setText(R.id.person,item.wantSeeNum+"人想看");
        ImageView imageView = helper.getView(R.id.image1);
        imageView.setImageURI(Uri.parse(item.imageUrl));
        helper.addOnClickListener(R.id.subscribeone);
        helper.addOnClickListener(R.id.subscribetwo);
        final Button subscribeone = helper.getView(R.id.subscribeone);
        final Button subscribetwo = helper.getView(R.id.subscribetwo);
        subscribeone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               subscribeone.setVisibility(View.INVISIBLE);
               subscribetwo.setVisibility(View.VISIBLE);

            }
        });
        subscribetwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                subscribetwo.setVisibility(View.INVISIBLE);
                subscribeone.setVisibility(View.VISIBLE);

            }
        });
    }

    public interface subscribeoneOnClickListener{

        void subscribeOnClickone(int position);

    }

    public subscribeoneOnClickListener subscribeoneOnClickListener;

    public void setSubscribeoneOnClickListener(SoonAdapter.subscribeoneOnClickListener subscribeoneOnClickListener) {
        this.subscribeoneOnClickListener = subscribeoneOnClickListener;
    }

    public interface subscribetwoOnClickListener{
        void subscribeOnClicktwo(int position);
    }

    public subscribetwoOnClickListener subscribetwoOnClickListener;

    public void setSubscribetwoOnClickListener(SoonAdapter.subscribetwoOnClickListener subscribetwoOnClickListener) {
        this.subscribetwoOnClickListener = subscribetwoOnClickListener;
    }
}
