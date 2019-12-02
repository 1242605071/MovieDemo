package com.bw.movie.presenter;

import android.widget.Toast;

import com.bw.movie.model.app.App;
import com.bw.movie.model.base.IBaseView;
import com.bw.movie.model.bean.CinemasInfoByRegionBean;
import com.bw.movie.model.bean.MaBean;
import com.bw.movie.model.bean.MovieBean;
import com.bw.movie.model.bean.OrderBean;
import com.bw.movie.model.bean.PayBean;
import com.bw.movie.model.bean.SchedBean;
import com.bw.movie.model.bean.SeatleBean;
import com.bw.movie.model.bean.TonBean;
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
                        }else if (orderBean.status.equals("9999")){
                            Toast.makeText(App.context, orderBean.message, Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                     throwable.printStackTrace();
                    }
                });
    }

    @Override
    public void pay(String userId, String sessionId, int paytype, String orderId) {
        HttpUtils.getHttpUtils().getApi()
                .pay(userId, sessionId, paytype, orderId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PayBean>() {
                    @Override
                    public void accept(PayBean payBean) throws Exception {
                        iBaseView.onCurress(payBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void findMyMovieCommentList(String userId, String sessionId, int page, int count) {
        HttpUtils.getHttpUtils().getApi()
                .findMyMovieCommentList(userId, sessionId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieBean>() {
                    @Override
                    public void accept(MovieBean movieBean) throws Exception {
                        iBaseView.onCurress(movieBean);
                    }
                });
    }

    @Override
    public void findAllSysMsgList(String userId, String sessionId, int page, int count) {
        HttpUtils.getHttpUtils().getApi()
                .findAllSysMsgList(userId, sessionId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TonBean>() {
                    @Override
                    public void accept(TonBean tonBean) throws Exception {
                        iBaseView.onCurress(tonBean);
                    }
                });
    }

    @Override
    public void findExchangeCode(String userId, String sessionId, int recordId) {
        HttpUtils.getHttpUtils().getApi()
                .findExchangeCode(userId, sessionId, recordId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MaBean>() {
                    @Override
                    public void accept(MaBean maBean) throws Exception {
                        iBaseView.onCurress(maBean);
                    }
                });
    }
}
