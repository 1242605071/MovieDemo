package com.bw.movie.model.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/11<p>
 *  * <p>更改时间：2019/11/11<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public abstract class BaseIActivity extends AppCompatActivity {
    protected BasePersenter basePersenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (initLayout()!=0){
            setContentView(initLayout());
            //初始化
            initView();
            basePersenter = initPersenter();
        }
    }
    protected abstract BasePersenter initPersenter();

    protected abstract void initView();

    protected abstract int initLayout();
    //内存泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (basePersenter!=null){
            basePersenter.onDestroy();
        }
    }
}
