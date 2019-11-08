package com.bw.movie.model.base;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.http.HttpUtils;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class BasePresenter {
    private DataCall dataCall;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    public void RequestData(Object... args) {
        Api api = HttpUtils.getHttpUtils().create(Api.class);
        getModel(api, args)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<IRequest>() {

                    @Override
                    public void accept(IRequest iRequest) throws Exception {
                        if (iRequest.status.equals("0000")) {
                            dataCall.success(iRequest.result);
                        }else
                        {
                            dataCall.fail(iRequest);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });

    }

    protected abstract Observable getModel(Api api, Object... args);
    public void onDestroy(){
        if (dataCall!=null){
            dataCall = null;
        }
    }
}
