package com.bw.movie.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.model.bean.CinemaScheduleList;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.CinemaScheduleListPresenter;
import com.bw.movie.view.adapter.Down_Adapter;
import com.bw.movie.view.core.DataCall;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Time:  2019-11-14
 * Author:  杨世博
 * Description: 影院的电影排期
 */
public class ScheduActivity extends BaseActivity {
    @BindView(R.id.ima_pai)
    ImageView imaPai;
    @BindView(R.id.xia_pai)
    XRecyclerView xiaPai;
    private CinemaScheduleListPresenter cinemaScheduleListPresenter;
    private Down_Adapter down_adapter;

    @Override
    protected int initLayout() {
        return R.layout.layout_cinemaschedulelist;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ScheduActivity.this);
        xiaPai.setLayoutManager(linearLayoutManager);
        down_adapter = new Down_Adapter();
        xiaPai.setAdapter(down_adapter);
        cinemaScheduleListPresenter = new CinemaScheduleListPresenter(new Downn());
        cinemaScheduleListPresenter.RequestData(1,1,10);
    }

    @OnClick(R.id.ima_pai)
    public void onViewClicked() {
        finish();
    }

    private class Downn implements DataCall<List<CinemaScheduleList>> {
        @Override
        public void success(List<CinemaScheduleList> data) {
            down_adapter.addAll(data);
            down_adapter.notifyDataSetChanged();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
