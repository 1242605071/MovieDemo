package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;

/**
 * Time:  2019-11-07
 * Author:  l
 * Description: 推荐影院页面
 */
public class RecomPresenter extends BasePresenter {

    public RecomPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.findRecommendCinemas((String) args[0], (String) args[1], (int)args[2], (int)args[3]);
    }
}
