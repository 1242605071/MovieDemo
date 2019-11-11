package com.bw.movie.view.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;

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

    @Override
    protected int initLayout() {
        return R.layout.layout_cinema_details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.jian)
    public void onViewClicked() {
        finish();
    }
}
