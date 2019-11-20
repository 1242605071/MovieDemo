package com.bw.movie.view.fragment.showFragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bw.movie.R;
import com.bw.movie.model.app.App;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.view.activity.SearchCinActivity;
import com.bw.movie.view.fragment.cinemaFragment.AddressFragment;
import com.bw.movie.view.fragment.cinemaFragment.NearFragment;
import com.bw.movie.view.fragment.cinemaFragment.RecomFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 *  * <p>文件描述：影院<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class CinemaFragment extends BaseFragment {
    @BindView(R.id.recom_button)
    RadioButton recomButton;
    @BindView(R.id.near_button)
    RadioButton nearButton;
    @BindView(R.id.address_button)
    RadioButton addressButton;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    Unbinder unbinder;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.location)
    ImageView location;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.cim_ss)
    ImageView cimSs;
    @BindView(R.id.pb)
    ProgressBar pb;

    private ArrayList<Fragment> list;
    private LocationClient mLocationClient;
    private BDLocationListener mBDLocationListener;

    @Override
    protected void initData() {

        list = new ArrayList<>();
        list.add(new RecomFragment());
        list.add(new NearFragment());
        list.add(new AddressFragment());

        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                radioGroup.check(radioGroup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        //定位
        mLocationClient = new LocationClient(App.context);
        mBDLocationListener = new MyBDLocationListener();
        // 注册监听  
        mLocationClient.registerLocationListener(mBDLocationListener);
    }

    @Override
    protected int initView() {
        return R.layout.fragment_cinema;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.recom_button, R.id.near_button, R.id.address_button, R.id.cim_ss})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.recom_button:
                viewPager.setCurrentItem(0);
                break;
            case R.id.near_button:
                viewPager.setCurrentItem(1);
                break;
            case R.id.address_button:
                viewPager.setCurrentItem(2);
                break;
            case R.id.cim_ss:
                Intent intent = new Intent(getContext(), SearchCinActivity.class);
                startActivity(intent);
                break;
        }
    }

    //定位
    @OnClick(R.id.location)
    public void onViewClicked() {
        pb.setVisibility(View.VISIBLE);
        city.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pb.setVisibility(View.GONE);
                LocationClientOption option = new LocationClientOption();
                option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                option.setCoorType("bd09ll");
                option.setScanSpan(5000);
                option.setIsNeedAddress(true);
                option.setNeedDeviceDirect(true);
                mLocationClient.setLocOption(option);
                mLocationClient.start();
            }
        }, 1000);
    }

    private class MyBDLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location != null) {
                String address = location.getCity();
                city.setText(address);
                city.setVisibility(View.VISIBLE);
                if (mLocationClient.isStarted()) {
                    mLocationClient.stop();
                }
            }
        }
    }


}
