package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.model.bean.CinemaInfo;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.CinemaInfoPresenter;
import com.bw.movie.view.adapter.FragmentAdapter;
import com.bw.movie.view.core.DataCall;
import com.bw.movie.view.fragment.cinema_detailsFragment.CommentFragment;
import com.bw.movie.view.fragment.cinema_detailsFragment.DetailsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Time:  2019-11-11
 * Author:  l
 * Description: 影院详情
 */
public class Cinema_detailsActivity extends BaseActivity {
    @BindView(R.id.jian)
    ImageView jian;
    @BindView(R.id.cim_tab)
    TabLayout cimTab;
    @BindView(R.id.cim_view)
    ViewPager cimView;
    @BindView(R.id.btn_paiqi)
    Button btnPaiqi;
    @BindView(R.id.xiang_name)
    TextView xiangName;

    private FragmentAdapter adapter;
    private int id;

    @Override
    protected int initLayout() {
        return R.layout.layout_cinema_details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        List<Fragment> list = new ArrayList<>();
        list.add(new DetailsFragment());
        list.add(new CommentFragment());

        adapter = new FragmentAdapter(getSupportFragmentManager(), list);
        cimView.setAdapter(adapter);
        cimTab.setupWithViewPager(cimView);

        cimTab.getTabAt(0).setText("影院详情");
        cimTab.getTabAt(1).setText("影院评价");

        CinemaInfoPresenter presenter = new CinemaInfoPresenter(new Cinmess());
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        presenter.RequestData("13772", "157355978503213772", id);

    }

    @OnClick({R.id.jian, R.id.btn_paiqi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jian:
                finish();
                break;
            case R.id.btn_paiqi:
                Intent intent = new Intent(this, ScheduActivity.class);
                intent.getIntExtra("Id",id);
                startActivity(intent);
                break;
        }
    }

    private class Cinmess implements DataCall<CinemaInfo> {
        @Override
        public void success(CinemaInfo data) {
              xiangName.setText(data.name);
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
