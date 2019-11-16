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
public class MovieCommentPresneter extends BasePresenter {
    public MovieCommentPresneter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.movieComment((String) args[0], (String) args[1], (int) args[2], (String) args[3], (double) args[4]);
    }
}
