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
import com.bw.movie.presenter.Address_ParentPresenter;
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
    private AddressPresenter addressPresenter;
    private Address_ParentPresenter address_parentPresenter;

    @Override
    protected void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyParent.setLayoutManager(linearLayoutManager);
        parentAdapter = new Address_ParentAdapter();
        recyParent.setAdapter(parentAdapter);
        address_parentPresenter = new Address_ParentPresenter(new Pdd());
        address_parentPresenter.RequestData();
        parentAdapter.setOnItemCilckListener(new Address_ParentAdapter.OnItemCilckListener() {
            @Override
            public void OnItemCilck(int position) {
                addressPresenter.RequestData(position);
            }
        });

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        recyChild.setLayoutManager(linearLayoutManager1);
        childAdapter = new Address_ChildAdapter();
        recyChild.setAdapter(childAdapter);
        addressPresenter = new AddressPresenter(new Addres());
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

    private class Addres implements DataCall<List<RegioBean>> {
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

    private class Pdd implements DataCall<List<ResultInfo>>{
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
