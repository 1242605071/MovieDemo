package com.bw.movie.view.myactivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.model.bean.ComBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.SeenMovie;
import com.bw.movie.presenter.FindComingSoonMovieListPresenter;
import com.bw.movie.presenter.SeeMoviePresenter;
import com.bw.movie.view.adapter.SeeAdapter;
import com.bw.movie.view.adapter.SeeMovieAdapter;
import com.bw.movie.view.core.DataCall;
import com.facebook.drawee.backends.pipeline.Fresco;

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
    private SharedPreferences login;

    @Override
    protected int initLayout() {
        return R.layout.activity_seen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ButterKnife.bind(this);

        Fresco.initialize(this);
        login = getSharedPreferences("login", MODE_PRIVATE);
        String userId = login.getString("userId", "");
        String sessionId = login.getString("sessionId", "");

        seeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        seerec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        SeeMoviePresenter seeMoviePresenter = new SeeMoviePresenter(new seeMovieBack());
        seeMoviePresenter.RequestData(userId,sessionId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    class seeMovieBack implements DataCall<List<SeenMovie>>{

        @Override
        public void success(List<SeenMovie> data) {

            SeeMovieAdapter seeMovieAdapter = new SeeMovieAdapter(R.layout.seed_item, data);
            seerec.setAdapter(seeMovieAdapter);

        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
