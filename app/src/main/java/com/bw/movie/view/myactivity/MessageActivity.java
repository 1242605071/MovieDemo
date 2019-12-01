package com.bw.movie.view.myactivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseIActivity;
import com.bw.movie.model.base.BasePersenter;
import com.bw.movie.model.bean.TonBean;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.view.adapter.MessageAdapter;
import com.bw.movie.view.core.IView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 系统消息
 */
public class MessageActivity extends BaseIActivity implements IView.doView {


    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.rv)
    RecyclerView mRv;
    private IView.doData persenter;
    @Override
    protected BasePersenter initPersenter() {
        return new Presenter(this);

    }

    @Override
    protected void initView() {
        persenter = (IView.doData) initPersenter();
        SharedPreferences login = getSharedPreferences("login", MODE_PRIVATE);
        String userId = login.getString("userId", "");
        String  sessionId = login.getString("sessionId", "");
        persenter.findAllSysMsgList(userId,sessionId,1,5);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_message;
    }

    @Override
    public void onCurress(Object obj) {
        TonBean tonBean = (TonBean) obj;
        final List<TonBean.ResultBean> result = tonBean.result;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MessageActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(linearLayoutManager);
        MessageAdapter serachcimAdapter = new MessageAdapter(R.layout.message_item, result);
        mRv.setAdapter(serachcimAdapter);
    }

    @Override
    public void onExcurr(String str) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
