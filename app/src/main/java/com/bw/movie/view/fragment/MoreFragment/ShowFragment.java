package com.bw.movie.view.fragment.MoreFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.HotBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.FindReleaseMovieListPresenter;
import com.bw.movie.view.activity.DetailsActivity;
import com.bw.movie.view.adapter.ReleaseAdapter;
import com.bw.movie.view.adapter.ReleasedAdapter;
import com.bw.movie.view.core.DataCall;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *  * <p>文件描述：更多正在上映<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/8<p>
 *  * <p>更改时间：2019/11/8<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class ShowFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;

    @Override
    protected void initData() {
        FindReleaseMovieListPresenter findReleaseMovieListPresenter = new FindReleaseMovieListPresenter(new MovieData());
        findReleaseMovieListPresenter.RequestData(1,10);
    }

    @Override
    protected int initView() {
        return R.layout.fragment_show;
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

    private class MovieData implements DataCall<List<HotBean>> {
        @Override
        public void success(final List<HotBean> data) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rv.setLayoutManager(linearLayoutManager);
            ReleasedAdapter releasedAdapter = new ReleasedAdapter(R.layout.more_item,data);
            rv.setAdapter(releasedAdapter);
            releasedAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    int movieId = data.get(position).movieId;
                    Intent intent = new Intent(getContext(), DetailsActivity.class);
                    intent.putExtra("movieId", movieId);
                    getActivity().startActivity(intent);
                }
            });

        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
