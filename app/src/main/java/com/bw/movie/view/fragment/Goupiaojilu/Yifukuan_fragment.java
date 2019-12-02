package com.bw.movie.view.fragment.Goupiaojilu;

import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.GouPao;
import com.bw.movie.model.bean.GuanzhuBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.GouPiaoPresenter;
import com.bw.movie.presenter.GuanzhuPresenter;
import com.bw.movie.view.adapter.MyGuanzhuadapter;
import com.bw.movie.view.adapter.MyYifukuanadapter;
import com.bw.movie.view.core.DataCall;
import com.bw.movie.view.fragment.Guanzhu.Dianying_fragment;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Yifukuan_fragment extends BaseFragment {

    private RecyclerView recyclerView;
    private MyGuanzhuadapter myGuanzhuadapter;
    private LinearLayoutManager linearLayoutManager;
    private MyYifukuanadapter myYifukuanadapter;
    private GouPiaoPresenter gouPiaoPresenter;

    @Override
    protected void initData() {
        recyclerView = getActivity().findViewById(R.id.recy_view2);

        gouPiaoPresenter = new GouPiaoPresenter(new yizhifu());
        SharedPreferences login = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        String  userId = login.getString("userId", "");
        String sessionId = login.getString("sessionId", "");
        gouPiaoPresenter.RequestData(Integer.valueOf(userId),sessionId,2,1,2);



       linearLayoutManager = new LinearLayoutManager(getContext());
       linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
       myYifukuanadapter = new MyYifukuanadapter(getContext());
       recyclerView.setLayoutManager(linearLayoutManager);
       recyclerView.setAdapter(myYifukuanadapter);

    }

    @Override
    protected int initView() {
        return R.layout.yifukuan_layout;





    }
    class yizhifu implements DataCall<List<GouPao>>{


        @Override
        public void success(List<GouPao> data) {
            myYifukuanadapter.addAll(data);

            myYifukuanadapter.notifyDataSetChanged();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
