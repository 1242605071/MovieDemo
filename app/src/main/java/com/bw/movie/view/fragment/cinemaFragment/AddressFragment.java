package com.bw.movie.view.fragment.cinemaFragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.RegioBean;
import com.bw.movie.model.bean.ResultInfo;
import com.bw.movie.presenter.AddressPresenter;
import com.bw.movie.presenter.RegionListPresenter;
import com.bw.movie.view.adapter.Address_ChildAdapter;
import com.bw.movie.view.adapter.Address_ParentAdapter;
import com.bw.movie.view.core.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Time:  2019-11-07
 * Author:  l
 * Description: 根据区域查询影院
 */
public class AddressFragment extends BaseFragment {
    @BindView(R.id.recy_parent)
    RecyclerView recyParent;
    @BindView(R.id.recy_child)
    RecyclerView recyChild;
    Unbinder unbinder;
    private Address_ParentAdapter parentAdapter;
    private Address_ChildAdapter childAdapter;
    private AddressPresenter presenter;
    private RegionListPresenter regionListPresenter;
    private LinearLayoutManager linearLayoutManager;
    private LinearLayoutManager linearLayoutManager1;

    @Override
    protected void initData() {

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyParent.setLayoutManager(linearLayoutManager);
        regionListPresenter = new RegionListPresenter(new Regions());
        regionListPresenter.RequestData();
        parentAdapter = new Address_ParentAdapter();
        recyParent.setAdapter(parentAdapter);
        parentAdapter.setOnItemCilckListener(new Address_ParentAdapter.OnItemCilckListener() {
            @Override
            public void OnItemCilck(int position) {
                presenter.RequestData(position);
            }
        });


        linearLayoutManager1 = new LinearLayoutManager(getActivity());
        recyChild.setLayoutManager(linearLayoutManager1);
        presenter = new AddressPresenter(new Address());
        childAdapter = new Address_ChildAdapter();
        recyChild.setAdapter(childAdapter);
    }

    @Override
    protected int initView() {
        return R.layout.fragment_address;
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

    private class Address implements DataCall<List<RegioBean>> {
        @Override
        public void success(List<RegioBean> data) {
            childAdapter.clear();
            childAdapter.addAll(data);
            childAdapter.notifyDataSetChanged();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }

    private class Regions implements DataCall<List<ResultInfo>> {


        @Override
        public void success(List<ResultInfo> data) {
             parentAdapter.addAll(data);
             parentAdapter.notifyDataSetChanged();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
