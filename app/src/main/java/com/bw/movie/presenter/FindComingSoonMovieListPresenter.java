package com.bw.movie.presenter;

import com.bw.movie.model.app.Api;
import com.bw.movie.model.base.BasePresenter;
import com.bw.movie.view.core.DataCall;

import io.reactivex.Observable;

/**
 *  * <p>文件描述：即将上映<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/7<p>
 *  * <p>更改时间：2019/11/7<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class FindComingSoonMovieListPresenter extends BasePresenter {
    public FindComingSoonMovieListPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Api api, Object... args) {
        return api.findComingSoonMovieList((int)args[0],(int)args[1]);
    }
}
