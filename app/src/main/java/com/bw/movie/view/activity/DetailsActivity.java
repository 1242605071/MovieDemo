package com.bw.movie.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.app.App;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.SerachBean;
import com.bw.movie.presenter.FindMoviesDetailPresenter;
import com.bw.movie.view.adapter.DetailsPageAdapter;
import com.bw.movie.view.core.DataCall;
import com.bw.movie.view.custom.ObservableScrollView;
import com.bw.movie.view.fragment.detailsFragment.CommentsFragment;
import com.bw.movie.view.fragment.detailsFragment.IntroduceFragment;
import com.bw.movie.view.fragment.detailsFragment.StillFragment;
import com.bw.movie.view.fragment.detailsFragment.TrailerFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  * <p>文件描述：详情页面<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */

public class DetailsActivity extends BaseActivity implements ObservableScrollView.ScrollViewListener{

    @BindView(R.id.x_tp)
    SimpleDraweeView xTp;
    @BindView(R.id.x_name)
    TextView xName;
    @BindView(R.id.guanzhu)
    ImageView guanzhu;
    @BindView(R.id.x_leixing)
    TextView xLeixing;
    @BindView(R.id.x_time)
    TextView xTime;
    @BindView(R.id.x_data)
    TextView xData;
    @BindView(R.id.x_guo)
    TextView xGuo;
    @BindView(R.id.details_tab)
    TabLayout detailsTab;
    @BindView(R.id.x_viewpager)
    ViewPager xViewpager;
    @BindView(R.id.scrollView1)
    ObservableScrollView scrollView1;
    @BindView(R.id.x_pingjia)
    Button xPingjia;
    @BindView(R.id.x_xuan)
    Button xXuan;
    @BindView(R.id.tv_titlebar)
    TextView tvTitlebar;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    private int mImageHeight;
    private int movieId;
    private float scale;
    private String name;
    private FindMoviesDetailPresenter findMoviesDetailPresenter;
    private DetailsBean result;
    @Override
    protected int initLayout() {
        return R.layout.activity_details;
    }


    @OnClick({R.id.x_pingjia, R.id.x_xuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.x_pingjia:
                Intent intent = new Intent(DetailsActivity.this, WritecommentsActivity.class);
                intent.putExtra("movieId", movieId);
                intent.putExtra("name", result.name);
                startActivity(intent);
                break;
            case R.id.x_xuan:
                Intent intent1 = new Intent(DetailsActivity.this, ChangeActivity.class);
                intent1.putExtra("movieId",movieId);
                intent1.putExtra("name",result.name);
                startActivity(intent1);

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        Intent intent = getIntent();
        movieId = intent.getIntExtra("movieId", 0);
        findMoviesDetailPresenter = new FindMoviesDetailPresenter(new SerachData());
        findMoviesDetailPresenter.RequestData(movieId);
        initListener();
        initdata();

    }



    private class SerachData implements DataCall <DetailsBean>{



        @Override
        public void success(DetailsBean data) {
            result = data;
            name = result.name;
            xName.setText(name);
            String imageUrl = result.imageUrl;
            xTp.setImageURI(Uri.parse(imageUrl));
            String movieType = result.movieType;
            xLeixing.setText(movieType);
            //分钟
            String duration = result.duration;
            xTime.setText(duration);
            //时间
            SimpleDateFormat format = new SimpleDateFormat("yyyy" + "年" + "MM" + "月" + "dd" + "日");
            String format1 = format.format(result.releaseTime);
            xData.setText(format1);
            String placeOrigin = result.placeOrigin;
            xGuo.setText(placeOrigin);
        }

        @Override
        public void fail(IRequest iRequest) {

        }


    }
    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int l, int t, int oldl, int oldt) {
        if (t <= 0) {
            //设置标题隐藏
            tvTitlebar.setVisibility(View.GONE);
            //设置标题所在背景为透明
            layoutTitle.setBackgroundColor(Color.argb(0, 0, 0, 0));
        } else if (t > 0 && t < mImageHeight) {
            //设置标题显示
            tvTitlebar.setVisibility(View.VISIBLE);
            //获取ScrollView向下滑动,图片消失部分的比例
            scale = (float) t / mImageHeight;
            //根据这个比例,让标题的颜色由浅到深
            float alpha = 255 * scale;

            //设置标题的内容及颜色
            tvTitlebar.setText(result.name);
            //tvTitlebar.setTextColor(Color.WHITE);
            tvTitlebar.setTextColor(Color.argb((int) alpha, 0, 0, 0));
            layoutTitle.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
            //设置标题背景颜色
//            layoutTitle.setBackgroundColor(Color.argb((int)alpha,255,255,255));
        }
    }

    private void initListener() {
        //获取控件的视图观察者,一遍通过视图观察者得到控件的宽高属性
        ViewTreeObserver viewTreeObserver = xTp.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {


            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                //此时就可以得到控件的高度
                mImageHeight = xTp.getHeight();
                //我们做的第一件事情就是移除监听,卸磨杀驴,减少内存的消耗
                xTp.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

    }
    private void initdata() {

        scrollView1.setScrollViewListener(this);
        //介绍
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new IntroduceFragment());
        list.add(new TrailerFragment());
        list.add(new StillFragment());
        list.add(new CommentsFragment());
        //适配器
        DetailsPageAdapter detailsPageAdapter = new DetailsPageAdapter(getSupportFragmentManager(), list);
        xViewpager.setAdapter(detailsPageAdapter);
        detailsTab.setupWithViewPager(xViewpager);
        detailsTab.getTabAt(0).setText("介绍");
        detailsTab.getTabAt(1).setText("预告");
        detailsTab.getTabAt(2).setText("剧照");
        detailsTab.getTabAt(3).setText("影评");
    }

}
