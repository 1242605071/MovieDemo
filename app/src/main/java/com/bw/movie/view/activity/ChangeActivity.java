package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.base.BaseIActivity;
import com.bw.movie.model.base.BasePersenter;
import com.bw.movie.model.bean.CinemaBean;
import com.bw.movie.model.bean.CinemasInfoByRegionBean;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.RegionListBean;
import com.bw.movie.presenter.FindMoviesDetailPresenter;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.presenter.RecomPresenter;
import com.bw.movie.view.adapter.ChangeAdapter;
import com.bw.movie.view.adapter.CinemaByRegionAdapter;
import com.bw.movie.view.adapter.RecomAdapter;
import com.bw.movie.view.adapter.RegionListAdapter;
import com.bw.movie.view.core.DataCall;
import com.bw.movie.view.core.IView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChangeActivity extends BaseIActivity implements IView.doView {


    @BindView(R.id.iv_pic)
    ImageView ivPic;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv_director)
    TextView tvDirector;
    @BindView(R.id.rb_region)
    RadioButton rbRegion;
    @BindView(R.id.rb_time)
    RadioButton rbTime;
    @BindView(R.id.rb_lowPrice)
    RadioButton rbLowPrice;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.rv)
    RecyclerView rv;
    private String name;
    private IView.doData persenter;
    private ChangeAdapter adapter;
    private RecomPresenter recomPresenter;

    @Override
    protected BasePersenter initPersenter() {
        return new Presenter(this);
    }

    @Override
    protected void initView() {
        persenter = (IView.doData) initPersenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_change;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        Intent intent = getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        name =intent.getStringExtra("name");
        FindMoviesDetailPresenter findMoviesDetailPresenter = new FindMoviesDetailPresenter(new SerachData());
        findMoviesDetailPresenter.RequestData(movieId);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChangeActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        adapter = new ChangeAdapter();
        rv.setAdapter(adapter);
        adapter.setOnItemClickLister(new ChangeAdapter.OnItemClickLister() {
            @Override
            public void onClick(int postion) {
                Intent intent = new Intent(ChangeActivity.this,SelectionActivity.class);
                startActivity(intent);
            }
        });
        recomPresenter = new RecomPresenter(new Rccom());
        recomPresenter.RequestData("13764","157312968444113764",true);


    }



    @Override
    public void onCurress(Object obj) {

    }

    @Override
    public void onExcurr(String str) {

    }

    private class SerachData implements DataCall<DetailsBean> {
        @Override
        public void success(DetailsBean data) {
            Glide.with(getApplicationContext()).load(data.imageUrl).into(ivPic);
            tvName.setText(data.name);
            tvTime.setText(data.duration);
            tvScore.setText(data.score + "分");
            String str = "";
            for (int i = 0; i < data.movieDirector.size(); i++) {
                str += data.movieDirector.get(i).name + " ";
            }
            tvDirector.setText(str);
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }

    private class Rccom implements DataCall<List<CinemaBean>> {
        @Override
        public void success(List<CinemaBean> data) {
            adapter.addAll(data);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
