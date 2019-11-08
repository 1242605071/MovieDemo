package com.bw.movie.view.fragment.detailsFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.FindMoviesDetailPresenter;
import com.bw.movie.view.activity.DetailsActivity;
import com.bw.movie.view.adapter.TrailerFragmentAdapter;
import com.bw.movie.view.core.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *  * <p>文件描述：预告<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/8<p>
 *  * <p>更改时间：2019/11/8<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class TrailerFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private TrailerFragmentAdapter adapter;

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        FindMoviesDetailPresenter findMoviesDetailPresenter = new FindMoviesDetailPresenter(new SerachData());
        findMoviesDetailPresenter.RequestData(movieId);
        adapter = new TrailerFragmentAdapter();
        rv.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        rv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initView() {
        return R.layout.fragment_trailer;
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

    private class SerachData implements DataCall<DetailsBean> {


        @Override
        public void success(DetailsBean data) {
            List<DetailsBean.ShortFilmListBean> shortFilmList = data.shortFilmList;
            adapter.addAll(shortFilmList);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
