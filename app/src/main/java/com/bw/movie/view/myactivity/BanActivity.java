package com.bw.movie.view.myactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BanActivity extends BaseActivity {


    @BindView(R.id.but)
    Button mBut;
    @BindView(R.id.back)
    ImageView mBack;

    @Override
    protected int initLayout() {
        return R.layout.activity_ban;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.back, R.id.but})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.but:
                Toast.makeText(this, "暂无更新", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
