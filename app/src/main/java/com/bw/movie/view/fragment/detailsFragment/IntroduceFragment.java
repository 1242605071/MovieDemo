package com.bw.movie.view.fragment.detailsFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.FindMoviesDetailPresenter;
import com.bw.movie.view.adapter.IntroduceFragmentAdapter;
import com.bw.movie.view.adapter.IntroduceFragmentYanAdapter;
import com.bw.movie.view.core.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *  * <p>文件描述：介绍<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/8<p>
 *  * <p>更改时间：2019/11/8<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class IntroduceFragment extends BaseFragment {
    @BindView(R.id.tv_introduce_summary)
    TextView tvIntroduceSummary;
    @BindView(R.id.recycler_introduce_movieDirector)
    RecyclerView recyclerIntroduceMovieDirector;
    @BindView(R.id.recycler_introduce_movieActor)
    RecyclerView recyclerIntroduceMovieActor;
    Unbinder unbinder;

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        FindMoviesDetailPresenter findMoviesDetailPresenter = new FindMoviesDetailPresenter(new SerachData());
        findMoviesDetailPresenter.RequestData(movieId);
    }

    @Override
    protected int initView() {
        return R.layout.fragment_introduce;
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

    private class SerachData implements DataCall <DetailsBean>{
        @Override
        public void success(DetailsBean data) {
            //导演布局管理器
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
            recyclerIntroduceMovieDirector.setLayoutManager(linearLayoutManager);
            GridLayoutManager linearLayoutManager1=new GridLayoutManager(getContext(),2);
            recyclerIntroduceMovieActor.setLayoutManager(linearLayoutManager1);
            tvIntroduceSummary.setText(data.summary);
            //导演
            List<DetailsBean.MovieDirectorBean> movieDirector = data.movieDirector;
            IntroduceFragmentAdapter adapter = new IntroduceFragmentAdapter(R.layout.introduce_item,movieDirector);
            recyclerIntroduceMovieDirector.setAdapter(adapter);
            //演员
            List<DetailsBean.MovieActorBean> movieActor = data.movieActor;
            IntroduceFragmentYanAdapter introduceFragmentYanAdapter = new IntroduceFragmentYanAdapter(R.layout.introduce_yan_item,movieActor);
            recyclerIntroduceMovieActor.setAdapter(introduceFragmentYanAdapter);

        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
