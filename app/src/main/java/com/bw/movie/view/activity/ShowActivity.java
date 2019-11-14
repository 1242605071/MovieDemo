package com.bw.movie.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.view.fragment.showFragment.CinemaFragment;
import com.bw.movie.view.fragment.showFragment.FilmFragment;
import com.bw.movie.view.fragment.showFragment.MypageFragment;

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
    @BindView(R.id.tv_moview)
    TextView tvMoview;
    @BindView(R.id.lin_movie)
    LinearLayout linMovie;
    @BindView(R.id.relay_view1)
    RelativeLayout relayView1;
    @BindView(R.id.tv_cinema)
    TextView tvCinema;
    @BindView(R.id.lin_cinema)
    LinearLayout linCinema;
    @BindView(R.id.cinema_ima)
    ImageView cinemaIma;
    @BindView(R.id.relay_view2)
    RelativeLayout relayView2;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.lin_mine)
    LinearLayout linMine;
    @BindView(R.id.mine_ima)
    ImageView mineIma;
    @BindView(R.id.relay_view3)
    RelativeLayout relayView3;
    @BindView(R.id.movie_ima)
    ImageView movieIma;
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
        linMovie.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.relay_view1, R.id.relay_view2, R.id.relay_view3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relay_view1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(homeFragment)
                        .hide(cinemaFragment)
                        .hide(mineFragment)
                        .commit();
                linMovie.setVisibility(View.VISIBLE);
                linCinema.setVisibility(View.GONE);
                linMine.setVisibility(View.GONE);
                movieIma.setVisibility(View.GONE);
                cinemaIma.setVisibility(View.VISIBLE);
                mineIma.setVisibility(View.VISIBLE);
                break;
            case R.id.relay_view2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(homeFragment)
                        .show(cinemaFragment)
                        .hide(mineFragment)
                        .commit();
                linMovie.setVisibility(View.GONE);
                linCinema.setVisibility(View.VISIBLE);
                linMine.setVisibility(View.GONE);
                movieIma.setVisibility(View.VISIBLE);
                cinemaIma.setVisibility(View.GONE);
                mineIma.setVisibility(View.VISIBLE);
                break;
            case R.id.relay_view3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(homeFragment)
                        .hide(cinemaFragment)
                        .show(mineFragment)
                        .commit();
                linMovie.setVisibility(View.GONE);
                linCinema.setVisibility(View.GONE);
                linMine.setVisibility(View.VISIBLE);
                movieIma.setVisibility(View.VISIBLE);
                cinemaIma.setVisibility(View.VISIBLE);
                mineIma.setVisibility(View.GONE);

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
