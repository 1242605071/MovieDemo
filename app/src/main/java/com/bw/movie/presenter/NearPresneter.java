package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;

/**
 * Time:  2019-11-07
 * Author:  l
 * Description: 附近影院页面
 */
public class NearPresneter extends BasePresenter {
    public NearPresneter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.findNearbyCinemas((String)args[0],(String)args[1],(String)args[2],(String)args[3],(int)args[4],(int)args[5]);
    }
}
