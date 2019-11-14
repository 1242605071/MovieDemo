package com.bw.movie.view.fragment.showFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
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
    @BindView(R.id.location_text)
    TextView locationText;
    private ArrayList<Fragment> list;


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

    @OnClick({R.id.recom_button, R.id.near_button, R.id.address_button})
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
        }
    }



}
