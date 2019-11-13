package com.bw.movie.view.fragment.showFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.view.activity.LoginActivity;
import com.bw.movie.view.activity.ModifyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 *  * <p>文件描述：我的<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class MypageFragment extends BaseFragment {
    @BindView(R.id.personimage)
    ImageView personimage;
    @BindView(R.id.textdying)
    TextView textdying;
    @BindView(R.id.sz)
    ImageView sz;
    @BindView(R.id.carddl)
    CardView carddl;
    Unbinder unbinder;
    @BindView(R.id.dsz)
    ImageView dsz;

    @Override
    protected void initData() {

    }

    @Override
    protected int initView() {
        return R.layout.fragment_mypage;
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


    @OnClick({R.id.sz, R.id.carddl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sz:
                Intent intent1 = new Intent(getContext(),ModifyActivity.class);
                startActivity(intent1);
                break;
            case R.id.carddl:
                Intent intent = new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
