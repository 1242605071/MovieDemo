package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;

/**
 * Time:  2019-11-07
 * Author:  l
 * Description: 根据区域查询影院
 */
public class AddressPresenter extends BasePresenter {
    public AddressPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.findCinemaByRegion((int) args[0]);
    }
}
