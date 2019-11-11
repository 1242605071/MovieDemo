package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.IBaseView;
import com.bw.movie.model.bean.CinemasInfoByRegionBean;
import com.bw.movie.model.bean.RegionListBean;
import com.bw.movie.model.http.HttpUtils;
import com.bw.movie.view.core.IView;
import com.facebook.drawee.components.RetryManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/11<p>
 *  * <p>更改时间：2019/11/11<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class Presenter extends IView.doData{
    public Presenter(IBaseView iBaseView) {
        super(iBaseView);
    }
    //根据电影id和区域id查询影院
    @Override
    public void findCinemasInfoByRegion(int movieId, int regionId, int page, int count) {
        HttpUtils.getHttpUtils().getApi()
                .findCinemasInfoByRegion(movieId, regionId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CinemasInfoByRegionBean>() {
                    @Override
                    public void accept(CinemasInfoByRegionBean cinemasInfoByRegionBean) throws Exception {
                        iBaseView.onCurress(cinemasInfoByRegionBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
    // 地区
    @Override
    public void findRegionList() {
        HttpUtils.getHttpUtils().getApi()
                .findRegionList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegionListBean>() {
                    @Override
                    public void accept(RegionListBean regionListBean) throws Exception {
                            iBaseView.onCurress(regionListBean);
                    }
                });

    }
}
