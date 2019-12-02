package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;

public class PaiqiPresenter extends BasePresenter {
    public PaiqiPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.paiqischedulelist((int)args[0],(int)args[1],(int)args[2]);
    }
}
