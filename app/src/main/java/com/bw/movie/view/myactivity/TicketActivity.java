package com.bw.movie.view.myactivity;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的电影票
 */
public class TicketActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.dian)
    Button mDian;
    @BindView(R.id.rl)
    RelativeLayout mRl;
    @BindView(R.id.piao)
    ImageView mPiao;
    @BindView(R.id.quxiao)
    CardView mQuxiao;
    @BindView(R.id.but_qu)
    Button mButQu;

    @Override
    protected int initLayout() {
        return R.layout.activity_ticket;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.back, R.id.dian, R.id.quxiao,R.id.but_qu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.dian:
                mRl.setVisibility(View.GONE);
                mPiao.setVisibility(View.VISIBLE);
                mQuxiao.setVisibility(View.VISIBLE);
                break;
            case R.id.quxiao:
                mRl.setVisibility(View.VISIBLE);
                mPiao.setVisibility(View.GONE);
                mQuxiao.setVisibility(View.GONE);
                break;
            case R.id.but_qu:
                mRl.setVisibility(View.VISIBLE);
                mPiao.setVisibility(View.GONE);
                mQuxiao.setVisibility(View.GONE);
                break;
        }
    }


}
