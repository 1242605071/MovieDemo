package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.view.adapter.FragmentAdapter;
import com.bw.movie.view.fragment.Cinema_detailsFragment.CommentFragment;
import com.bw.movie.view.fragment.Cinema_detailsFragment.DetailsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Time:  2019-11-11
 * Author:  l
 * Description:
 */
public class Cinema_detailsActivity extends BaseActivity {
    @BindView(R.id.jian)
    ImageView jian;
    @BindView(R.id.cim_tab)
    TabLayout cimTab;
    @BindView(R.id.cim_view)
    ViewPager cimView;
    private FragmentAdapter adapter;

    @Override
    protected int initLayout() {
        return R.layout.layout_cinema_details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        List<Fragment> list = new ArrayList<>();
        list.add(new DetailsFragment());
        list.add(new CommentFragment());

        adapter = new FragmentAdapter(getSupportFragmentManager(), list);
        cimView.setAdapter(adapter);
        cimTab.setupWithViewPager(cimView);

        cimTab.getTabAt(0).setText("影院详情");
        cimTab.getTabAt(1).setText("影院评价");


    }

    @OnClick(R.id.jian)
    public void onViewClicked() {
        finish();
    }
}
