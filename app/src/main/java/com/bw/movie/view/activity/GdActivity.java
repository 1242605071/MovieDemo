package com.bw.movie.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.view.adapter.GdAdapter;
import com.bw.movie.view.fragment.MoreFragment.PopularFragment;
import com.bw.movie.view.fragment.MoreFragment.ShowFragment;
import com.bw.movie.view.fragment.MoreFragment.SoonFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  * <p>文件描述：更多页面<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */

public class GdActivity extends BaseActivity {


    @BindView(R.id.tc)
    ImageView tc;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<Fragment> list;

    @Override
    protected int initLayout() {
        return R.layout.activity_gd;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        list = new ArrayList<>();
        list.add(new ShowFragment());
        list.add(new SoonFragment());
        list.add(new PopularFragment());
        tab.setupWithViewPager(vp);
        GdAdapter gdAdapter = new GdAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(gdAdapter);
        tab.getTabAt(0).setText("正在上映");
        tab.getTabAt(1).setText("即将上映");
        tab.getTabAt(2).setText("热门电影");
    }

    @OnClick(R.id.tc)
    public void onViewClicked() {
        finish();
    }
}
