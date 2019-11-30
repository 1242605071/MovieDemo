package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.BasePersenter;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.model.base.IBaseView;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;

/**
 * author: 徐涛
 * data: 2019/11/29 12:12:43
 * function:
 */
public class SubscribePresenter extends BasePresenter {

    public SubscribePresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.reserve((int)args[0],(String)args[1],(int)args[2]);
    }
}
