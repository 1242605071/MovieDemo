package com.bw.movie.presenter;

import android.widget.Toast;

import com.bw.movie.model.base.IBaseView;
import com.bw.movie.model.bean.CinemasInfoByRegionBean;
import com.bw.movie.model.bean.OrderBean;
import com.bw.movie.model.bean.SchedBean;
import com.bw.movie.model.bean.SeatleBean;
import com.bw.movie.model.http.HttpUtils;
import com.bw.movie.view.core.IView;

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

    @Override
    public void seatle(int hallId) {
        HttpUtils.getHttpUtils().getApi()
                .seatle(hallId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SeatleBean>() {
                    @Override
                    public void accept(SeatleBean seatleBean) throws Exception {
                        iBaseView.onCurress(seatleBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void bySchedule(int movieId, int cinemaId) {
        HttpUtils.getHttpUtils().getApi()
                .bySchedule(movieId, cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SchedBean>() {
                    @Override
                    public void accept(SchedBean schedBean) throws Exception {
                        iBaseView.onCurress(schedBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }

    @Override
    public void buyMovieTickets(String userId, String sessionId, int scheduleId, String seat, String sign) {
        HttpUtils.getHttpUtils().getApi()
                .buyMovieTickets(userId, sessionId, scheduleId, seat, sign)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OrderBean>() {
                    @Override
                    public void accept(OrderBean orderBean) throws Exception {
                        if (orderBean.status.equals("0000")){
                            iBaseView.onCurress(orderBean);
                        }else{


                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                     throwable.printStackTrace();
                    }
                });
    }
}
