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
public class Address_ParentPresenter extends BasePresenter {

    public Address_ParentPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.findRegionList();
    }
}
