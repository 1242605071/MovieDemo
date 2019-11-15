package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;

/**
 * Time:  2019-11-15
 * Author:  杨世博
 * Description:
 */
public class CinemaScheduleListPresenter extends BasePresenter {

    public CinemaScheduleListPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.findCinemaScheduleList((int)args[0],(int)args[1],(int)args[2]);
    }
}
