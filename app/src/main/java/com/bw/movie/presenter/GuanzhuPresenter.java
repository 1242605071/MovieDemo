package com.bw.movie.presenter;

import android.widget.Toast;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.app.App;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.model.bean.GuanzhuBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.http.HttpUtils;
import com.bw.movie.view.core.DataCall;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class GuanzhuPresenter  {
    private DataCall dataCall;

    public GuanzhuPresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    public void RequestData(String userId,String sessionId,int movieId){
        Api api = HttpUtils.getHttpUtils().create(Api.class);
        api.followMovie(userId,sessionId, movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<IRequest>() {
                    @Override
                    public void accept(IRequest iRequest) throws Exception {
                        if (iRequest.message.equals("0000")) {
                            Toast.makeText(App.context, iRequest.message, Toast.LENGTH_SHORT).show();
                            dataCall.success(iRequest.result);
                        }else if (iRequest.status.equals("9999")){
                            Toast.makeText(App.context, iRequest.message, Toast.LENGTH_SHORT).show();
                            dataCall.fail(iRequest);
                        }else if (iRequest.status.equals("1001")){
                            Toast.makeText(App.context, iRequest.message, Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
