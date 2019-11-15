package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;

/**
 * Time:  2019-11-14
 * Author:  杨世博
 * Description:
 */
public class FindAllCinemasPresenter extends BasePresenter {
    public FindAllCinemasPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.findAllCinemas((int)args[0],(int)args[1],(String) args[2]);
    }
}
