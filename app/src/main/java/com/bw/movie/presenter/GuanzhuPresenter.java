package com.bw.movie.presenter;

import com.bw.movie.model.bean.GuanzhuBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.http.HttpUtils;
import com.bw.movie.view.core.DataCall;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class GuanzhuPresenter {
    private DataCall dataCall;

    public GuanzhuPresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }
    //int userId,String sessionId,
      public void guanzhu(String userId,String sessionId, int page,int count){
          HttpUtils.getHttpUtils().getApi().findUserFollowMovieList( userId, sessionId,page,count)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Consumer<IRequest<List<GuanzhuBean>>>() {
                      @Override
                      public void accept(IRequest<List<GuanzhuBean>> listIRequest) throws Exception {
                      if (listIRequest.status.equals("0000")){
                          dataCall.success(listIRequest.result);
                      }else {
                          dataCall.fail(listIRequest);
                      }
                      }
                  }, new Consumer<Throwable>() {
                      @Override
                      public void accept(Throwable throwable) throws Exception {
                                   throwable.printStackTrace();
                      }
                  });
      }

}
