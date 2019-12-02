package com.bw.movie.view.myactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *
 * 看过的电影
 */
public class SeenActivity extends BaseActivity {


    private Unbinder bind;

    @Override
    protected int initLayout() {
        return R.layout.activity_seen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
