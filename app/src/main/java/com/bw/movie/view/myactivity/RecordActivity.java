package com.bw.movie.view.myactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.view.adapter.Guanzhuadapter;
import com.bw.movie.view.fragment.Goupiaojilu.Daifukuan_feagment;
import com.bw.movie.view.fragment.Goupiaojilu.Yifukuan_fragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 购票记录
 */
public class RecordActivity extends AppCompatActivity {

    @BindView(R.id.imager)
    ImageView imager;
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ButterKnife.bind(this);
        viewPager = findViewById(R.id.view_pager1);
        radioGroup = findViewById(R.id.radio_group1);

        list.add(new Daifukuan_feagment());
        list.add(new Yifukuan_fragment());

        Guanzhuadapter guanzhuadapter = new Guanzhuadapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(guanzhuadapter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb01:
                        viewPager.setCurrentItem(0);
                        break;

                    case R.id.rb02:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });


    }

    @OnClick(R.id.imager)
    public void onClick() {
        finish();



    }
}
