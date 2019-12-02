package com.bw.movie.view.fragment.mycomment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.model.app.App;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.base.BasePersenter;
import com.bw.movie.model.bean.MovieBean;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.view.adapter.MovieReviewAdapter;
import com.bw.movie.view.core.IView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

/**
 *  * <p>文件描述：我的评论电影<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/29<p>
 *  * <p>更改时间：2019/11/29<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class MovieReviewFragment extends BaseFragment implements IView.doView{
    @BindView(R.id.rv)
    RecyclerView mRv;
    Unbinder unbinder;
    protected BasePersenter basePersenter;
    private IView.doData persenter;
    @Override
    protected void initData() {
        persenter = (IView.doData) initPersenter();
        basePersenter = initPersenter();
        SharedPreferences login = getActivity().getSharedPreferences("login", MODE_PRIVATE);
           String userId = login.getString("userId", "");
         String  sessionId = login.getString("sessionId", "");
        persenter.findMyMovieCommentList(userId,sessionId,1,5);
    }

    private BasePersenter initPersenter() {
        return new Presenter(this);
    }

    @Override
    protected int initView() {
        return R.layout.fragment_movie_review;
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
    public void onCurress(Object obj) {
        MovieBean movieBean = (MovieBean) obj;
        final List<MovieBean.ResultBean> result = movieBean.result;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(linearLayoutManager);
        MovieReviewAdapter serachcimAdapter = new MovieReviewAdapter(R.layout.movie_item, result);
        mRv.setAdapter(serachcimAdapter);
        serachcimAdapter.notifyDataSetChanged();
    }

    @Override
    public void onExcurr(String str) {

    }
}
