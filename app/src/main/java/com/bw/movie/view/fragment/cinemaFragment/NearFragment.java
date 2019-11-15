package com.bw.movie.view.fragment.cinemaFragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.CinemaBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.NearbyBean;
import com.bw.movie.presenter.NearPresneter;
import com.bw.movie.presenter.RecomPresenter;
import com.bw.movie.view.activity.Cinema_detailsActivity;
import com.bw.movie.view.adapter.NearAdapter;
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
 * Description: 附近影院页面
 */
public class NearFragment extends BaseFragment implements XRecyclerView.LoadingListener {
    @BindView(R.id.near_xrecview)
    XRecyclerView nearXrecview;
    Unbinder unbinder;
    private NearAdapter adapter;
    private NearPresneter nearPresneter;

    @Override
    protected void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        nearXrecview.setLayoutManager(linearLayoutManager);
        adapter = new NearAdapter();
        nearXrecview.setAdapter(adapter);
        nearPresneter = new NearPresneter(new Neart());
        nearXrecview.setLoadingListener(this);
        adapter.setOnItemClickListener(new NearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getContext(), Cinema_detailsActivity.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });
        onRefresh();
    }

    @Override
    protected int initView() {
        return R.layout.fragment_near;
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
        nearPresneter.RequestData("13764", "157312968444113764", "116.30551391385724", "40.04571807462411", true);
        nearXrecview.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        nearPresneter.RequestData("13764", "157312968444113764", "116.30551391385724", "40.04571807462411", false);
        nearXrecview.loadMoreComplete();
    }

    private class Neart implements DataCall<List<NearbyBean>> {
        @Override
        public void success(List<NearbyBean> data) {
            if (nearPresneter.getPage() ==1){
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
