package com.bw.movie.view.fragment.Guanzhu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.GuanzhuBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.GuanzhuPresenter;
import com.bw.movie.view.adapter.MyGuanzhuadapter;
import com.bw.movie.view.core.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

public class Dianying_fragment extends BaseFragment {


    private GuanzhuPresenter guanzhuPresenter;
    private LinearLayoutManager linearLayoutManager;
    private MyGuanzhuadapter myGuanzhuadapter;
    private RecyclerView recyclerView;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    private String sessionId;
    private String userId;


    @Override
    protected void initData() {
        guanzhuPresenter = new GuanzhuPresenter(new guanzhu());
        SharedPreferences login = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        userId = login.getString("userId", "");
        sessionId = login.getString("sessionId", "");
       //guanzhuPresenter.guanzhu(userId, sessionId, 1, 5);
        recyclerView = getActivity().findViewById(R.id.recy_view);

        linearLayoutManager = new LinearLayoutManager(getContext());
        myGuanzhuadapter = new MyGuanzhuadapter(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myGuanzhuadapter);



      /*  sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        edit = sp.edit();
        //userId = sp.getInt("userId", 0);
        userId1 = sp.getString("userId", "");
        sessionId = sp.getString("sessionId", "");
        guanzhuPresenter.guanzhu(userId1,sessionId,1,5);
        Log.d("aaa", "initData: "+ this.userId);
        Log.d("aaa", "initData: "+sessionId);*/


    }

    @Override
    protected int initView() {
        return R.layout.dianying_layout;
    }




    class guanzhu implements DataCall<List<GuanzhuBean>> {

        @Override
        public void success(List<GuanzhuBean> data) {
            myGuanzhuadapter.addAll(data);
            myGuanzhuadapter.notifyDataSetChanged();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
