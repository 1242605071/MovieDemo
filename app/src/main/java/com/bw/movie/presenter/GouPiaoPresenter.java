package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/12/2<p>
 * <p>更改时间：2019/12/2<p>
 */
public class GouPiaoPresenter extends BasePresenter {
    public GouPiaoPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.findUserBuyTicketRecord((int)args[0],(String)args[1],(int)args[2],(int)args[3],(int)args[4]);
    }
}
