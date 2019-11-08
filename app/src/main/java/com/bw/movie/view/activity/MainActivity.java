package com.bw.movie.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *  * <p>文件描述：引导页面<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class MainActivity extends BaseActivity {


    @BindView(R.id.imageview)
    ImageView imageview;
    private SharedPreferences sp;
    private int time = 5;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (time > 0) {
                    time--;

                    handler.sendEmptyMessageDelayed(0, 1000);
                } else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    sp.edit().putBoolean("isFirst", true).commit();

                    finish();
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        sp = getSharedPreferences("config", MODE_PRIVATE);
        boolean isFirst = sp.getBoolean("isFirst", false);
        if (isFirst) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            sp.edit().putBoolean("isFirst", true).commit();

            finish();
        } else { // 第一次进入
            handler.sendEmptyMessageDelayed(0, 1000);
        }
    }


    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.imageview)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }
}
