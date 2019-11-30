package com.bw.movie.view.myactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.view.adapter.MyViewAdapter;
import com.bw.movie.view.fragment.mycomment.CinemaReviewFragment;
import com.bw.movie.view.fragment.mycomment.MovieReviewFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的评论
 */
public class MyCommentActivity extends BaseActivity {
    private List<String> tabs = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;

    @Override
    protected int initLayout() {
        return R.layout.activity_my_comment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        tabs.add("电影"); // 创建标签数据
        tabs.add("影院");

        mTab.addTab(mTab.newTab().setText(tabs.get(0))); // 添加指示器
        mTab.addTab(mTab.newTab().setText(tabs.get(1)));

        fragments.add(new MovieReviewFragment()); // 创建fragment并存入集合
        fragments.add(new CinemaReviewFragment());

        MyViewAdapter myViewAdapter = new MyViewAdapter(getSupportFragmentManager(), fragments, tabs);
        mVp.setAdapter(myViewAdapter);

        mTab.setupWithViewPager(mVp); // 关联

    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
