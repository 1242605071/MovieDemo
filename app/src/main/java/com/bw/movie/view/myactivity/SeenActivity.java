package com.bw.movie.view.myactivity;

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
import com.bw.movie.view.adapter.SeeAdapter;
import com.bw.movie.view.core.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 看过的电影
 */
public class SeenActivity extends BaseActivity {


    @BindView(R.id.seerec)
    RecyclerView seerec;
    @BindView(R.id.seeback)
    ImageView seeback;
    private Unbinder bind;

    @Override
    protected int initLayout() {
        return R.layout.activity_seen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ButterKnife.bind(this);

        seeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        seerec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        FindComingSoonMovieListPresenter findComingSoonMovieListPresenter = new FindComingSoonMovieListPresenter(new seeBack());
        findComingSoonMovieListPresenter.RequestData(1, 3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    private class seeBack implements DataCall<List<ComBean>> {
        @Override
        public void success(final List<ComBean> data) {

            SeeAdapter seeAdapter = new SeeAdapter(R.layout.seed_item, data);
            seerec.setAdapter(seeAdapter);
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
