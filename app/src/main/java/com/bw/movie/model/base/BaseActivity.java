package com.bw.movie.model.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity {
    protected BasePresenter basePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
