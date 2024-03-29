package com.bw.movie.view.fragment.showFragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.app.App;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.BanBean;
import com.bw.movie.model.bean.ComBean;
import com.bw.movie.model.bean.HotBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.PopBean;
import com.bw.movie.model.bean.Subscribe;
import com.bw.movie.presenter.BannerPresenter;
import com.bw.movie.presenter.FindComingSoonMovieListPresenter;
import com.bw.movie.presenter.FindHotMovieListPresenter;
import com.bw.movie.presenter.FindReleaseMovieListPresenter;
import com.bw.movie.presenter.SubscribePresenter;
import com.bw.movie.view.activity.ChangeActivity;
import com.bw.movie.view.activity.DetailsActivity;
import com.bw.movie.view.activity.GdActivity;
import com.bw.movie.view.activity.SearchActivity;
import com.bw.movie.view.activity.SubscribeActivity;
import com.bw.movie.view.adapter.ReleaseAdapter;
import com.bw.movie.view.adapter.SoonAdapter;
import com.bw.movie.view.adapter.WellreiveAdapter;
import com.bw.movie.view.core.DataCall;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

/**
 *  * <p>文件描述：首页<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class FilmFragment extends BaseFragment {
    @BindView(R.id.location)
    ImageView location;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.ss)
    ImageView ss;
    @BindView(R.id.home_banner)
    XBanner homeBanner;
    @BindView(R.id.g1)
    TextView g1;
    @BindView(R.id.homeFragment_HotMovie_recy)
    RecyclerView homeFragmentHotMovieRecy;
    @BindView(R.id.g2)
    TextView g2;
    @BindView(R.id.homeFragment_the_ucoming_recy)
    RecyclerView homeFragmentTheUcomingRecy;
    @BindView(R.id.g3)
    TextView g3;
    @BindView(R.id.home_i1)
    ImageView homeI1;
    @BindView(R.id.rmmove)
    RecyclerView rmmove;
    Unbinder unbinder;
    @BindView(R.id.pb)
    ProgressBar pb;
    private BannerPresenter bannerPresenter;
    private LocationClient mLocationClient;
    private BDLocationListener mBDLocationListener;
    private SubscribePresenter subscribePresenter;
    private SharedPreferences login;
    private String userId;
    private String sessionId;
    private int movieId;

    @Override
    protected int initView() {
        return R.layout.fragment_film;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected void initData() {
        bannerPresenter = new BannerPresenter(new BannerData());
        bannerPresenter.RequestData();
        FindReleaseMovieListPresenter findReleaseMovieListPresenter = new FindReleaseMovieListPresenter(new MovieData());
        findReleaseMovieListPresenter.RequestData(1, 10);
        FindComingSoonMovieListPresenter findComingSoonMovieListPresenter = new FindComingSoonMovieListPresenter(new ComData());
        findComingSoonMovieListPresenter.RequestData(1, 3);
        FindHotMovieListPresenter hotMovieListPresenter = new FindHotMovieListPresenter(new PopData());
        hotMovieListPresenter.RequestData(1, 10);
        //定位
        mLocationClient = new LocationClient(App.context);
        mBDLocationListener = new MyBDLocationListener();
        // 注册监听  
        mLocationClient.registerLocationListener(mBDLocationListener);
        //预约
        subscribePresenter = new SubscribePresenter(new subscribeBack());
        login = getActivity().getSharedPreferences("login", Context.MODE_MULTI_PROCESS);
        userId = login.getString("userId", "");
        sessionId = login.getString("sessionId", "");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (mLocationClient != null) {
            mLocationClient.unRegisterLocationListener(mBDLocationListener);
        }
    }

    @OnClick({R.id.ss, R.id.g1, R.id.g2, R.id.g3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ss:
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.g1:
                Intent intent1 = new Intent(getContext(), GdActivity.class);
                startActivity(intent1);
                break;
            case R.id.g2:
                Intent intent2 = new Intent(getContext(), GdActivity.class);
                startActivity(intent2);
                break;
            case R.id.g3:
                Intent intent3 = new Intent(getContext(), GdActivity.class);
                startActivity(intent3);
                break;
        }
    }

    //预约
    public class subscribeBack implements DataCall<Subscribe>{

        @Override
        public void success(Subscribe data) {
            if (data.status.equals("0000")){
                Toast.makeText(getContext(), ""+data.message, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }

    //定位
    @OnClick(R.id.location)
    public void onViewClicked() {
        pb.setVisibility(View.VISIBLE);
        city.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pb.setVisibility(View.GONE);
                LocationClientOption option = new LocationClientOption();
                option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                option.setCoorType("bd09ll");
                option.setScanSpan(5000);
                option.setIsNeedAddress(true);
                option.setNeedDeviceDirect(true);
                mLocationClient.setLocOption(option);
                mLocationClient.start();
            }
        },1000);
    }

    private class MyBDLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location != null) {
                String address = location.getCity();
                city.setText(address);
                city.setVisibility(View.VISIBLE);
                if (mLocationClient.isStarted()) {
                    mLocationClient.stop();
                }
            }
        }
    }

    //轮播图
    private class BannerData implements DataCall<List<BanBean>> {

        @Override
        public void success(final List<BanBean> data) {
            homeBanner.setData(data, null);
            homeBanner.setPageTransformer(Transformer.Cube);
            homeBanner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(getContext()).load(data.get(position).imageUrl).into((ImageView) view);
                }
            });
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }

    //正在上映
    private class MovieData implements DataCall<List<HotBean>> {
        @Override
        public void success(final List<HotBean> data) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            homeFragmentHotMovieRecy.setLayoutManager(linearLayoutManager);
            final ReleaseAdapter wellreceived = new ReleaseAdapter(R.layout.hot_item, data);
            homeFragmentHotMovieRecy.setAdapter(wellreceived);
            wellreceived.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, final int position) {
                    movieId = data.get(position).movieId;
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

    //即将上映
    private class ComData implements DataCall<List<ComBean>> {
        @Override
        public void success(final List<ComBean> data) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            homeFragmentTheUcomingRecy.setLayoutManager(linearLayoutManager);
            SoonAdapter soonAdapter = new SoonAdapter(R.layout.soon_item, data);
            homeFragmentTheUcomingRecy.setAdapter(soonAdapter);
            soonAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    int movieId = data.get(position).movieId;
                    Intent intent = new Intent(getContext(), DetailsActivity.class);
                    intent.putExtra("movieId", movieId);
                    getActivity().startActivity(intent);
                }
            });
            soonAdapter.setSubscribeoneOnClickListener(new SoonAdapter.subscribeoneOnClickListener() {
                @Override
                public void subscribeOnClickone(int position) {
                    subscribePresenter.RequestData(Integer.valueOf(userId),sessionId,16);
                }
            });
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }

    //热门电影
    private class PopData implements DataCall<List<PopBean>> {
        @Override
        public void success(final List<PopBean> data) {
            homeI1.setImageURI(Uri.parse(data.get(0).horizontalImage));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rmmove.setLayoutManager(linearLayoutManager);
            WellreiveAdapter wellreiveAdapter = new WellreiveAdapter(R.layout.release_item, data);
            rmmove.setAdapter(wellreiveAdapter);
            wellreiveAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
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
