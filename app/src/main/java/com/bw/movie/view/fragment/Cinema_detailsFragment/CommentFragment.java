package com.bw.movie.view.fragment.cinema_detailsFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.CinemaCommentBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.CinemaCommentPresenter;
import com.bw.movie.view.activity.ScheduActivity;
import com.bw.movie.view.adapter.CommentAdapter;
import com.bw.movie.view.core.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Time:  2019-11-12
 * Author:  杨世博
 * Description: 影院评价
 */
public class CommentFragment extends BaseFragment {
    @BindView(R.id.comm_recy)
    RecyclerView commRecy;
    Unbinder unbinder;
 
    private CommentAdapter adapter;
    private CinemaCommentPresenter presenter;

    @Override
    protected void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        commRecy.setLayoutManager(linearLayoutManager);
        adapter = new CommentAdapter();
        commRecy.setAdapter(adapter);
        presenter = new CinemaCommentPresenter(new Cinema());
        presenter.RequestData(1, 1, 5);
    }

    @Override
    protected int initView() {
        return R.layout.fragment_comment;
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



    private class Cinema implements DataCall<List<CinemaCommentBean>> {
        @Override
        public void success(List<CinemaCommentBean> data) {
            adapter.addAll(data);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
