package com.bw.movie.view.fragment.cinemaFragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.RegioBean;
import com.bw.movie.model.bean.ResultInfo;
import com.bw.movie.presenter.NearPresenter;
import com.bw.movie.presenter.QuYuQueryPresenter;
import com.bw.movie.view.adapter.QuYuMAdapter;
import com.bw.movie.view.adapter.QuYuQueryMAdapter;
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
    @BindView(R.id.pb)
    ProgressBar pb;
    private NearPresenter nearPresenter;
    private QuYuMAdapter quYuMAdapter;
    private QuYuQueryMAdapter quYuQueryMAdapter;
    private QuYuQueryPresenter quYuQueryPresenter;
    private Boolean b = true;

    @Override
    protected void initData() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyParent.setLayoutManager(linearLayoutManager);
        quYuMAdapter = new QuYuMAdapter(getContext());
        recyParent.setAdapter(quYuMAdapter);
        nearPresenter = new NearPresenter(new NearPersen());
        nearPresenter.RequestData();

        quYuMAdapter.setIsWork(new QuYuMAdapter.IsWork() {
            @Override
            public void SetId(final int Id) {
                if (b) {
                    b = false;
                    pb.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            quYuQueryPresenter.RequestData(Id);
                            pb.setVisibility(View.GONE);
                            b = true;
                        }
                    }, 2000);
                }
            }
        });
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        recyChild.setLayoutManager(linearLayoutManager1);
        quYuQueryMAdapter = new QuYuQueryMAdapter(getContext());
        recyChild.setAdapter(quYuQueryMAdapter);
        quYuQueryPresenter = new QuYuQueryPresenter(new QuYuQueryPresen());
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

    private class NearPersen implements DataCall<List<ResultInfo>> {
        @Override
        public void success(List<ResultInfo> data) {
            quYuMAdapter.addAll(data);

            quYuMAdapter.notifyDataSetChanged();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }

    private class QuYuQueryPresen implements DataCall<List<RegioBean>> {
        @Override
        public void success(List<RegioBean> data) {
            quYuQueryMAdapter.clear();
            quYuQueryMAdapter.addAll(data);

            quYuQueryMAdapter.notifyDataSetChanged();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
