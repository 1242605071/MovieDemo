package com.bw.movie.view.fragment.cinemaFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.CinemaBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.RecomPresenter;
import com.bw.movie.view.activity.Cinema_detailsActivity;
import com.bw.movie.view.adapter.RecomAdapter;
import com.bw.movie.view.core.DataCall;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Time:  2019-11-07
 * Author:  l
 * Description: 推荐影院页面
 */
public class RecomFragment extends BaseFragment implements XRecyclerView.LoadingListener {
    @BindView(R.id.recom_xrecyview)
    XRecyclerView recomXrecyview;
    Unbinder unbinder;
    private RecomAdapter adapter;
    private RecomPresenter recomPresenter;

    @Override
    protected void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recomXrecyview.setLayoutManager(linearLayoutManager);
        adapter = new RecomAdapter();
        recomXrecyview.setAdapter(adapter);
        recomPresenter = new RecomPresenter(new Rccom());
        recomXrecyview.setLoadingListener(this);

        adapter.setOnItemClickListener(new RecomAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getContext(), Cinema_detailsActivity.class);
                startActivity(intent);
            }
        });
        onRefresh();

    }

    @Override
    protected int initView() {
        return R.layout.fragment_recom;
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

    @Override
    public void onRefresh() {
        recomPresenter.RequestData("13764", "157312968444113764", true);
        recomXrecyview.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        recomPresenter.RequestData("13764", "157312968444113764", false);
        recomXrecyview.loadMoreComplete();

    }

    private class Rccom implements DataCall<List<CinemaBean>> {
        @Override
        public void success(List<CinemaBean> data) {
            if (recomPresenter.getPage() == 1) {
                adapter.clear();
            }
            adapter.addAll(data);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
