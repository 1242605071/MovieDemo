package com.bw.movie.view.fragment.Goupiaojilu;

import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.model.app.App;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.base.BasePersenter;
import com.bw.movie.model.bean.GouPao;
import com.bw.movie.model.bean.GuanzhuBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.PayBean;
import com.bw.movie.presenter.GouPiaoPresenter;
import com.bw.movie.presenter.GuanzhuPresenter;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.view.adapter.MyDaifukuanadapter;
import com.bw.movie.view.adapter.MyGuanzhuadapter;
import com.bw.movie.view.core.DataCall;
import com.bw.movie.view.core.IView;
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Daifukuan_feagment extends BaseFragment implements IView.doView {

    private GuanzhuPresenter presenter;
    private RecyclerView recyclerView;
    private MyGuanzhuadapter myGuanzhuadapter;
    private LinearLayoutManager linearLayoutManager;
    private MyDaifukuanadapter myDaifukuanadapter;
    private GouPiaoPresenter gouPiaoPresenter;
    protected BasePersenter basePersenter;
    private IView.doData persenter;
    private String userId;
    private String sessionId;

    @Override
    protected void initData() {
        persenter = (IView.doData) initPersenter();
        basePersenter = initPersenter();
        recyclerView = getActivity().findViewById(R.id.recy_view1);

        presenter = new GuanzhuPresenter(new dianyin());
      //  presenter.guanzhu();

        gouPiaoPresenter = new GouPiaoPresenter(new dianyin());
        SharedPreferences login = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        userId = login.getString("userId", "");
        sessionId = login.getString("sessionId", "");
        gouPiaoPresenter.RequestData(Integer.valueOf(userId), sessionId,1,1,1);


        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myDaifukuanadapter = new MyDaifukuanadapter(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myDaifukuanadapter);
        myDaifukuanadapter.setIsWork(new MyDaifukuanadapter.IsWork() {
            @Override
            public void work(String id) {
                persenter.pay(userId, sessionId,1,id);
            }
        });
    }
    private BasePersenter initPersenter() {
        return new Presenter(this);
    }
    @Override
    protected int initView() {
        return R.layout.daifukuan_layout;
    }

    @Override
    public void onCurress(Object obj) {
        PayBean payBean = (PayBean) obj;
        PayReq payReq = new PayReq();
        payReq.appId =payBean.appId;
        payReq.partnerId = payBean.partnerId;
        payReq.prepayId = payBean.prepayId;
        payReq.nonceStr = payBean.nonceStr;
        payReq.timeStamp = payBean.timeStamp;
        payReq.packageValue = payBean.packageValue;
        payReq.sign = payBean.sign;
        payReq.extData = "app data"; // optional
        App.api.sendReq(payReq);
    }

    @Override
    public void onExcurr(String str) {

    }

    class dianyin implements DataCall<List<GouPao>>{

         @Override
         public void success(List<GouPao> data) {
            myDaifukuanadapter.addAll(data);

            myDaifukuanadapter.notifyDataSetChanged();
         }

         @Override
         public void fail(IRequest iRequest) {

         }
     }
}
