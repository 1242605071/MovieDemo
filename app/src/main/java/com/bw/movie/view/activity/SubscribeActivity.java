package com.bw.movie.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.model.bean.ComBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.FindComingSoonMovieListPresenter;
import com.bw.movie.view.adapter.SubscribeAdapter;
import com.bw.movie.view.core.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SubscribeActivity extends BaseActivity {

    @BindView(R.id.subscriberec)
    RecyclerView subscriberec;
    @BindView(R.id.subscribe_back)
    ImageView subscribeBack;
    private Unbinder bind;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int initLayout() {
        return R.layout.activity_subscribe;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ButterKnife.bind(this);

        FindComingSoonMovieListPresenter findComingSoonMovieListPresenter = new FindComingSoonMovieListPresenter(new soonBack());
        findComingSoonMovieListPresenter.RequestData(1, 5);
        linearLayoutManager = new LinearLayoutManager(this);

        subscribeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    class soonBack implements DataCall<List<ComBean>> {
        @Override
        public void success(List<ComBean> data) {

            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            subscriberec.setLayoutManager(linearLayoutManager);
            SubscribeAdapter subscribeAdapter = new SubscribeAdapter(R.layout.subscribe_item, data);
            subscriberec.setAdapter(subscribeAdapter);

        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
