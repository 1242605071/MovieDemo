package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;

/**
 * Time:  2019-11-12
 * Author:  杨世博
 * Description:
 */
public class CinemaInfoPresenter extends BasePresenter {
    public CinemaInfoPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.findCinemaInfo((String)args[0],(String)args[1],(int)args[2]);
    }
}
