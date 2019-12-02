package com.bw.movie.model.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;


public abstract class BaseActivity extends AppCompatActivity {
    protected BasePresenter basePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        if (initLayout()!=0){
            setContentView(initLayout());
            //初始化
        }
    }

    protected abstract int initLayout();

    //内存泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (basePresenter!=null){
            basePresenter.onDestroy();
        }
    }


}
