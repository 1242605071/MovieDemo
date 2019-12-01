package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/12/1<p>
 * <p>更改时间：2019/12/1<p>
 */
public class QuYuQueryPresenter extends BasePresenter {

    public QuYuQueryPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.findCinemaByRegion((int)args[0]);
    }
}
