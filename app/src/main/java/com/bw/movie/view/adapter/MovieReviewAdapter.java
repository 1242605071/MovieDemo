package com.bw.movie.view.adapter;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.bean.MovieBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 *  * <p>文件描述：我的评论电影适配器<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/29<p>
 *  * <p>更改时间：2019/11/29<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class MovieReviewAdapter extends BaseQuickAdapter<MovieBean.ResultBean,BaseViewHolder> {
    public MovieReviewAdapter(int layoutResId, @Nullable List<MovieBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieBean.ResultBean item) {
        helper.setText(R.id.movie_name,item.movieName);
        helper.setText(R.id.movie_dao,"导演："+item.director);
        helper.setText(R.id.movie_zhu,"主演："+item.starring);
        helper.setText(R.id.movie_ping,"评分："+item.movieScore+"分");
        helper.setText(R.id.movie_nei,item.myCommentContent);
        SimpleDateFormat format=new SimpleDateFormat("MM"+"-"+"dd");
        String format1 = format.format(item.commentTime);
        helper.setText(R.id.movie_shi,format1+"");
        ImageView imageView = helper.getView(R.id.movie_sim);
        imageView.setImageURI(Uri.parse(item.imageUrl));
    }
}
