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

    private int page;

    public RecomPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        boolean isRefresh = (boolean) args[2];
        if (isRefresh) {
            page = 1;
        } else {
            page++;
        }
        return api.findRecommendCinemas((String) args[0], (String) args[1], page, 10);
    }

    public int getPage() {
        return page;
    }
}
