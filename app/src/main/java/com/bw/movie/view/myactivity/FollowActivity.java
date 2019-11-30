package com.bw.movie.view.myactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.view.adapter.Guanzhuadapter;
import com.bw.movie.view.fragment.Guanzhu.Dianying_fragment;
import com.bw.movie.view.fragment.Guanzhu.Yingyuan_fragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的关注
 */
public class FollowActivity extends AppCompatActivity {


    @BindView(R.id.back)
    ImageView back;
    private ViewPager viewPager;
    private ArrayList<Fragment> list = new ArrayList<>();
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        ButterKnife.bind(this);

        viewPager = findViewById(R.id.view_pager);
        radioGroup = findViewById(R.id.radio_group);

        list.add(new Dianying_fragment());
        list.add(new Yingyuan_fragment());

        Guanzhuadapter guanzhuadapter = new Guanzhuadapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(guanzhuadapter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });

    }

    @OnClick(R.id.back)
    public void onClick() {
        finish();
    }
}
