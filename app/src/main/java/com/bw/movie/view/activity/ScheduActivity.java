package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.model.bean.Requests;
import com.bw.movie.presenter.PeriodPresenter;
import com.bw.movie.view.adapter.Madapter;
import com.bw.movie.view.core.DataCalls;
import com.bw.movie.view.fragment.cinemaFragment.Fragment_pq;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Time:  2019-11-14
 * Author:  杨世博
 * Description: 影院的电影排期
 */
public class ScheduActivity extends BaseActivity {


    @BindView(R.id.pq_tab)
    TabLayout pqTab;
    @BindView(R.id.pq_vp)
    ViewPager pqVp;
    private int movieId;
    private ArrayList<Fragment> list;
    private Madapter madapter;
    private PeriodPresenter periodPresenter;

    @Override
    protected int initLayout() {
        return R.layout.layout_cinemaschedulelist;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        Intent intent = getIntent();
        movieId = intent.getIntExtra("Id", 0);
        pqTab.addTab(pqTab.newTab());
        pqTab.addTab(pqTab.newTab());
        pqTab.addTab(pqTab.newTab());
        pqTab.addTab(pqTab.newTab());
        pqTab.addTab(pqTab.newTab());
        pqTab.addTab(pqTab.newTab());
        pqTab.addTab(pqTab.newTab());

        list = new ArrayList<>();
        list.add(new Fragment_pq(movieId));
        list.add(new Fragment_pq(movieId));
        list.add(new Fragment_pq(movieId));
        list.add(new Fragment_pq(movieId));
        list.add(new Fragment_pq(movieId));
        list.add(new Fragment_pq(movieId));
        list.add(new Fragment_pq(movieId));


        madapter = new Madapter(getSupportFragmentManager(), list);
        pqVp.setAdapter(madapter);
        pqTab.setupWithViewPager(pqVp);
        periodPresenter = new PeriodPresenter(new PeriodPresen());
        periodPresenter.Request();
    }

    private class PeriodPresen implements DataCalls {

        @Override
        public void Success(Requests data) {
            List<String> result = data.result;
            String s = result.toString();
            String[] split = s.split(",");
            pqTab.getTabAt(0).setText(split[0]);
            pqTab.getTabAt(1).setText(split[1]);
            pqTab.getTabAt(2).setText(split[2]);
            pqTab.getTabAt(3).setText(split[3]);
            pqTab.getTabAt(4).setText(split[4]);
            pqTab.getTabAt(5).setText(split[5]);
            pqTab.getTabAt(6).setText(split[6]);
        }

        @Override
        public void Error(String request) {

        }
    }
}
