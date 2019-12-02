package com.bw.movie.view.fragment.cinemaFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.Paiqi;
import com.bw.movie.model.bean.YingYuanPaiQi;
import com.bw.movie.presenter.PQPresenter;
import com.bw.movie.presenter.PaiqiPresenter;
import com.bw.movie.view.adapter.MyPaiqiadapter;
import com.bw.movie.view.adapter.PQMadapter;
import com.bw.movie.view.core.DataCall;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/15<p>
 * <p>更改时间：2019/11/15<p>
 */
@SuppressLint("ValidFragment")
public class Fragment_pq extends Fragment {
    private int status;
    private XRecyclerView pq_xrlv;
    private PQPresenter pqPresenter;
    private PQMadapter pqMadapter;
    private PaiqiPresenter presenter;
    private MyPaiqiadapter myPaiqiadapter;

    @SuppressLint("ValidFragment")
    public Fragment_pq(int i) {
        this.status = i;
    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_pq, null);
        initView(view);
        Fresco.initialize(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pq_xrlv.setLayoutManager(linearLayoutManager);
        pqMadapter = new PQMadapter(getContext());
        pq_xrlv.setAdapter(pqMadapter);
        pqPresenter = new PQPresenter(new PQPresen());
        pqPresenter.RequestData(status,1,5);

        presenter = new PaiqiPresenter(new paiqi());
        presenter.RequestData(1,1,5);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        pq_xrlv.setLayoutManager(linearLayoutManager);
        myPaiqiadapter = new MyPaiqiadapter(getContext());
        pq_xrlv.setAdapter(myPaiqiadapter);
        return view;
    }

    private void initView(View view) {
        pq_xrlv = (XRecyclerView) view.findViewById(R.id.pq_xrlv);
    }

    private class PQPresen implements DataCall<List<YingYuanPaiQi>> {
        @Override
        public void success(List<YingYuanPaiQi> data) {
            pqMadapter.addAll(data);

            pqMadapter.notifyDataSetChanged();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }

    class paiqi implements DataCall<List<Paiqi>>{

        @Override
        public void success(List<Paiqi> data) {

            Log.d("aaa", "success: "+data.get(0).name);
            myPaiqiadapter.AddAll(data);
            myPaiqiadapter.notifyDataSetChanged();


        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
