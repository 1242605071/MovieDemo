package com.bw.movie.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.view.fragment.showFragment.CinemaFragment;
import com.bw.movie.view.fragment.showFragment.FilmFragment;
import com.bw.movie.view.fragment.showFragment.MypageFragment;
import com.kyle.radiogrouplib.NestedRadioGroup;
import com.kyle.radiogrouplib.NestedRadioLayout;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  * <p>文件描述：登录进入页面<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class ShowActivity extends BaseActivity {


    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.tv_movies)
    TextView tvMovies;
    @BindView(R.id.rb_movies)
    NestedRadioLayout rbMovies;
    @BindView(R.id.tv_cinema)
    TextView tvCinema;
    @BindView(R.id.rb_cinema)
    NestedRadioLayout rbCinema;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.rb_mine)
    NestedRadioLayout rbMine;
    @BindView(R.id.rg_group)
    NestedRadioGroup rgGroup;
    private FilmFragment homeFragment;
    private CinemaFragment cinemaFragment;
    private MypageFragment mineFragment;
    @Override
    protected int initLayout() {
        return R.layout.activity_show;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        // 初始化Fragment
        homeFragment = new FilmFragment();
        cinemaFragment = new CinemaFragment();
        mineFragment = new MypageFragment();
        // 显示隐藏
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, homeFragment)
                .add(R.id.frame, cinemaFragment)
                .add(R.id.frame, mineFragment)
                .show(homeFragment)
                .hide(cinemaFragment)
                .hide(mineFragment)
                .commit();
        tvMovies.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.rb_movies, R.id.rb_cinema, R.id.rb_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_movies:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(homeFragment)
                        .hide(cinemaFragment)
                        .hide(mineFragment)
                        .commit();
                rbMovies.setChecked(true);
                rbCinema.setChecked(false);
                rbMine.setChecked(false);
                tvMovies.setVisibility(View.VISIBLE);
                tvCinema.setVisibility(View.GONE);
                tvMine.setVisibility(View.GONE);
                break;
            case R.id.rb_cinema:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(homeFragment)
                        .show(cinemaFragment)
                        .hide(mineFragment)
                        .commit();
                rbMovies.setChecked(false);
                rbCinema.setChecked(true);
                rbMine.setChecked(false);
                tvMovies.setVisibility(View.GONE);
                tvCinema.setVisibility(View.VISIBLE);
                tvMine.setVisibility(View.GONE);
                break;
            case R.id.rb_mine:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(homeFragment)
                        .hide(cinemaFragment)
                        .show(mineFragment)
                        .commit();
                rbMovies.setChecked(false);
                rbCinema.setChecked(false);
                rbMine.setChecked(true);
                tvMovies.setVisibility(View.GONE);
                tvCinema.setVisibility(View.GONE);
                tvMine.setVisibility(View.VISIBLE);
                break;
        }
    }
    boolean isState = true;
    public void onBackPressed() {
        if (isState) {
            isState = false;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    isState = true;
                }
            }, 2000);
        } else {
            finish();
        }
    }
}
