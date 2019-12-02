package com.bw.movie.view.fragment.Goupiaojilu;

import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.GuanzhuBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.GuanzhuPresenter;
import com.bw.movie.view.adapter.MyDaifukuanadapter;
import com.bw.movie.view.adapter.MyGuanzhuadapter;
import com.bw.movie.view.core.DataCall;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Daifukuan_feagment extends BaseFragment {

    private GuanzhuPresenter presenter;
    private RecyclerView recyclerView;
    private MyGuanzhuadapter myGuanzhuadapter;
    private LinearLayoutManager linearLayoutManager;
    private MyDaifukuanadapter myDaifukuanadapter;

    @Override
    protected void initData() {
        recyclerView = getActivity().findViewById(R.id.recy_view1);

        presenter = new GuanzhuPresenter(new dianyin());
      //  presenter.guanzhu();

        SharedPreferences login = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        String  userId = login.getString("userId", "");
        String sessionId = login.getString("sessionId", "");
        presenter.guanzhu(userId, sessionId, 1, 5);


        linearLayoutManager = new LinearLayoutManager(getContext());
        myDaifukuanadapter = new MyDaifukuanadapter(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myDaifukuanadapter);
    }

    @Override
    protected int initView() {
        return R.layout.daifukuan_layout;





    }

     class dianyin implements DataCall<List<GuanzhuBean>>{

         @Override
         public void success(List<GuanzhuBean> data) {
             myDaifukuanadapter.addAll(data);
             myDaifukuanadapter.notifyDataSetChanged();
             Log.d("aaa", "success: "+data.get(0).name);




         }

         @Override
         public void fail(IRequest iRequest) {

         }
     }
}
