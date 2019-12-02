package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;

/**
 * author: 徐涛
 * data: 2019/12/2 13:13:48
 * function:
 */
public class SeeMoviePresenter extends BasePresenter {
    public SeeMoviePresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.findSeenMovie((String)args[0],(String)args[1]);
    }
}
