package com.bw.movie.view.fragment.detailsFragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *  * <p>文件描述：影评<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/8<p>
 *  * <p>更改时间：2019/11/8<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class CommentsFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;

    @Override
    protected void initData() {

    }

    @Override
    protected int initView() {
        return R.layout.fragment_comments;
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
}
