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
public class XiuGaiPresenter  extends BasePresenter {
    public XiuGaiPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.modifyUserPwd((int)args[0],(String) args[1],(String) args[2],(String) args[3],(String) args[4]);
    }
}
