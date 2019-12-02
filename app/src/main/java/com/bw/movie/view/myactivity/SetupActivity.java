package com.bw.movie.view.myactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.view.activity.LoginActivity;
import com.bw.movie.view.activity.XuiGaiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置
 */
public class SetupActivity extends BaseActivity {


    @BindView(R.id.but_tuiLogin)
    Button butTuiLogin;
    @BindView(R.id.genxin)
    TextView mGenxin;
    @BindView(R.id.gen)
    ImageView mGen;
    @BindView(R.id.shezhi_jian)
    ImageView shezhiJian;
    @BindView(R.id.pwds)
    RelativeLayout pwds;

    @Override
    protected int initLayout() {
        return R.layout.activity_setup;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.genxin, R.id.gen, R.id.but_tuiLogin, R.id.shezhi_jian,R.id.pwds})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_tuiLogin:
                SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
                Intent intent = new Intent(SetupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.genxin:
                Intent intent2 = new Intent(SetupActivity.this, BanActivity.class);
                startActivity(intent2);
                break;
            case R.id.gen:
                Intent intent6 = new Intent(SetupActivity.this, BanActivity.class);
                startActivity(intent6);
                break;
            case R.id.shezhi_jian:
                finish();
                break;
            case R.id.pwds:
                Intent intent1 = new Intent(SetupActivity.this, XuiGaiActivity.class);
                startActivity(intent1);
                break;
        }
    }


}
