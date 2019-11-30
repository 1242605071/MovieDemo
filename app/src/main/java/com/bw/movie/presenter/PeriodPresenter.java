package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.Requests;
import com.bw.movie.model.http.HttpUtils;
import com.bw.movie.view.core.DataCalls;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/14<p>
 * <p>更改时间：2019/11/14<p>
 * <p>更改时间：2019/11/14<p>
 */
public class PeriodPresenter {

    private DataCalls dataCalls;

    public PeriodPresenter(DataCalls dataCalls) {
        this.dataCalls = dataCalls;
    }


    public void Request() {

        Api api = HttpUtils.getHttpUtils().create(Api.class);
         api.findDateList().subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<Requests>() {
                     @Override
                     public void accept(Requests o) throws Exception {
                         if (dataCalls != null) {
                             dataCalls.Success(o);
                         }
                     }
                 }, new Consumer<Throwable>() {
                     @Override
                     public void accept(Throwable throwable) throws Exception {
                         throwable.printStackTrace();
                         if (dataCalls != null) {
                             dataCalls.Error(throwable.getMessage());
                         }
                     }
                 });

    }
}
