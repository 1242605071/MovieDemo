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
import com.bw.movie.model.bean.CommentsBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.CommentsMapPresenter;
import com.bw.movie.view.adapter.CommentsAdapter;
import com.bw.movie.view.core.DataCall;

import java.util.List;

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
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
       CommentsMapPresenter commentsMapPresenter =   new CommentsMapPresenter(new CommData());
       commentsMapPresenter.RequestData(movieId,1,8);
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

    private class CommData implements DataCall <List<CommentsBean>>{
        @Override
        public void success(List<CommentsBean> data) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rv.setLayoutManager(linearLayoutManager);
            CommentsAdapter commentsAdapter = new CommentsAdapter(R.layout.coments_item,data);
            rv.setAdapter(commentsAdapter);
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
