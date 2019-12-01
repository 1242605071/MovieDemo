package com.bw.movie.view.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import com.bw.movie.model.app.App;
import com.bw.movie.model.bean.HotBean;
import com.bw.movie.view.activity.ChangeActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 *  * <p>文件描述：正在上映适配器<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/11<p>
 *  * <p>更改时间：2019/10/11<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class ReleaseAdapter extends BaseQuickAdapter<HotBean,BaseViewHolder> {
    public ReleaseAdapter(int layoutResId, @Nullable List<HotBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final HotBean item) {
        helper.setText(R.id.text1,item.score+"分");
        helper.setText(R.id.name,item.name);
        ImageView imageView = helper.getView(R.id.hot_i1);
        imageView.setImageURI(Uri.parse(item.imageUrl));
        Button payticket = helper.getView(R.id.payticket);
        payticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(App.context, ChangeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("movieId",item.movieId);
                App.context.startActivity(intent);
            }
        });
    }

}
