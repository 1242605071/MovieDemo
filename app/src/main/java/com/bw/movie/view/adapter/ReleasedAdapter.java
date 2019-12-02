package com.bw.movie.view.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.app.App;
import com.bw.movie.model.bean.HotBean;
import com.bw.movie.view.activity.ChangeActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 *  * <p>文件描述：更多正在上映适配器<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/11<p>
 *  * <p>更改时间：2019/10/11<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class ReleasedAdapter extends BaseQuickAdapter<HotBean,BaseViewHolder> {
    public ReleasedAdapter(int layoutResId, @Nullable List<HotBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final HotBean item) {
        helper.setText(R.id.zhu_gd,"主演:"+item.starring);
        helper.setText(R.id.dy_gd,"导演:"+item.director);
        helper.setText(R.id.pf_gd,"评分:"+item.score+"分");
        helper.setText(R.id.name_gd,item.name);
        ImageView imageView = helper.getView(R.id.img_gd);
        imageView.setImageURI(Uri.parse(item.imageUrl));
        Button bt_more = helper.getView(R.id.bt_more);
        bt_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.context, ChangeActivity.class);
                intent.putExtra("movieId",item.movieId);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                App.context.startActivity(intent);
            }
        });
    }
}
