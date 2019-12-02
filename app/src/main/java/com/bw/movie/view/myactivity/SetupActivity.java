package com.bw.movie.view.myactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.view.activity.LoginActivity;
import com.bw.movie.view.activity.ModifyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置
 */
public class SetupActivity extends BaseActivity {


    @BindView(R.id.but_tuiLogin)
    Button butTuiLogin;

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

    @OnClick(R.id.but_tuiLogin)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.but_tuiLogin:
                SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
                Intent intent = new Intent(SetupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }


}
