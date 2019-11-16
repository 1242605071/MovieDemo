package com.bw.movie.view.adapter;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.bean.HotBean;
import com.bw.movie.model.bean.PopBean;
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
public class PopularAdapter extends BaseQuickAdapter<PopBean,BaseViewHolder> {
    public PopularAdapter(int layoutResId, @Nullable List<PopBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PopBean item) {
        helper.setText(R.id.zhu_gd,"主演:"+item.starring);
        helper.setText(R.id.dy_gd,"导演:"+item.director);
        helper.setText(R.id.pf_gd,"评分:"+item.score+"分");
        helper.setText(R.id.name_gd,item.name);
        ImageView imageView = helper.getView(R.id.img_gd);
        imageView.setImageURI(Uri.parse(item.imageUrl));
    }

}
