package com.bw.movie.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.app.App;
import com.bw.movie.model.base.BaseIActivity;
import com.bw.movie.model.base.BasePersenter;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.OrderBean;
import com.bw.movie.model.bean.PayBean;
import com.bw.movie.model.bean.SchedBean;
import com.bw.movie.model.bean.SeatleBean;
import com.bw.movie.presenter.FindMoviesDetailPresenter;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.view.adapter.MovieSeatAdapter;
import com.bw.movie.view.adapter.SchedAdapter;
import com.bw.movie.view.core.DataCall;
import com.bw.movie.view.core.IView;
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 *  * <p>文件描述：选座<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class SelectionActivity extends BaseIActivity implements IView.doView {


    @BindView(R.id.room_back)
    ImageView roomBack;
    @BindView(R.id.room_name)
    TextView roomName;
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.room_VideoPlayer)
    JCVideoPlayer roomVideoPlayer;
    @BindView(R.id.room_movieSeat)
    RecyclerView roomMovieSeat;
    @BindView(R.id.real)
    RelativeLayout real;
    @BindView(R.id.room_time)
    TextView roomTime;
    @BindView(R.id.room_recycler)
    RecyclerView roomRecycler;
    @BindView(R.id.imag_gb)
    ImageView imagGb;
    @BindView(R.id.radio_wx)
    RadioButton radioWx;
    @BindView(R.id.radio_zzfb)
    RadioButton radioZzfb;
    @BindView(R.id.liner_lay)
    RelativeLayout linerLay;
    @BindView(R.id.btn_purchaseOrder)
    Button btnPurchaseOrder;
    @BindView(R.id.room_btn)
    Button roomBtn;
    @BindView(R.id.weixin)
    TextView weixin;
    private int movieId;
    private int cinemaId;
    private long sum;
    private double zf;
    private double fare = 0.01;
    private IView.doData persenter;
    private String userId;
    private String sessionId;
    private String sign;
    private String order;
    public static int flag = 0;
    //排期表
    private int id;

    @Override
    protected BasePersenter initPersenter() {
        return new Presenter(this);
    }

    @Override
    protected void initView() {
        persenter = (IView.doData) initPersenter();
        Intent intent = getIntent();
        movieId = intent.getIntExtra("movieId", 0);
        cinemaId = intent.getIntExtra("cinemaId", 0);
        Log.i("aaa", "initView: " + cinemaId);
        persenter.bySchedule(24, 2);

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_selection;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        FindMoviesDetailPresenter findMoviesDetailPresenter = new FindMoviesDetailPresenter(new SerachData());
        findMoviesDetailPresenter.RequestData(movieId);
        SharedPreferences login = getSharedPreferences("login", MODE_PRIVATE);
        userId = login.getString("userId", "");
        sessionId = login.getString("sessionId", "");
        String s = userId+""+23 + "movie";
        Log.i("asd", "加密前 "+s);
        sign = MD5(s);
        Log.i("asdd", "加密后"+sign);
        imagGb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerLay.setVisibility(View.GONE);
            }
        });
    }

    @OnClick({R.id.btn_purchaseOrder, R.id.room_btn,R.id.weixin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_purchaseOrder:
                if (flag == 0) {
                    // 第一次单击触发的事件
                    linerLay.setVisibility(View.VISIBLE);
                    flag = 1;

                } else {
                    // 第二次单击buttont改变触发的事件
                    SharedPreferences qw = getSharedPreferences("zw", Context.MODE_PRIVATE);
                    String seat = qw.getString("seat", null);
                    persenter.buyMovieTickets(userId,sessionId,id,seat,sign);
                    flag = 0;
                }
                break;
            case R.id.room_btn:
                break;
            case R.id.weixin:
                break;
        }
    }



    @Override
    public void onCurress(Object obj) {
        if (obj instanceof SchedBean) {
            SchedBean schedBean = (SchedBean) obj;
            List<SchedBean.ResultBean> resut = schedBean.result;
            final int halld = resut.get(0).hallId;
            LinearLayoutManager manager = new LinearLayoutManager(SelectionActivity.this, LinearLayoutManager.HORIZONTAL, false);
            roomRecycler.setLayoutManager(manager);
            SchedAdapter schedAdapter = new SchedAdapter(R.layout.room_item, resut);
            roomRecycler.setAdapter(schedAdapter);
            schedAdapter.setCallBack(new SchedAdapter.iCallBack() {
                @Override
                public void getBack(String s) {
                    persenter.seatle(halld);
                }

                @Override
                public void getId(int idd) {
                    id = idd;
                }
            });
        } else if (obj instanceof SeatleBean) {
            SeatleBean seatleBean = (SeatleBean) obj;
            final List<SeatleBean.ResultBean> result = seatleBean.result;
            LinearLayoutManager manager = new GridLayoutManager(this, 8);
            roomMovieSeat.setLayoutManager(manager);
            MovieSeatAdapter seatAdapter = new MovieSeatAdapter(result);
            roomMovieSeat.setAdapter(seatAdapter);
            seatAdapter.setCallBack(new MovieSeatAdapter.CallBack() {
                @Override
                public void getBack(String s) {
                    Toast.makeText(SelectionActivity.this, s, Toast.LENGTH_SHORT).show();
                    String string = s;
                    for (int i = 0; i < result.size(); i++) {
                        if (result.get(i).status == 3) {
                            sum++;
                        }
                    }
                    if (sum > 100) {
                        Toast.makeText(SelectionActivity.this, "最多" + sum + "张", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        //设置价格
                        if (sum != 0) {
                            btnPurchaseOrder.setText("￥:" + sum * fare);
                            btnPurchaseOrder.setVisibility(View.VISIBLE);
                            roomBtn.setVisibility(View.INVISIBLE);
                            sum = 0;
                        } else if (sum == 0) {
                            roomBtn.setVisibility(View.VISIBLE);
                            btnPurchaseOrder.setVisibility(View.INVISIBLE);
                        }
                    }
                }

                @Override
                public void getStrng(ArrayList<String> list) {
                    String str = null;
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i);
                        str = s + ",";
                    }
                    Log.i("qqq", "getStrng: " + str);
                    String seat = str.substring(0, str.lastIndexOf(","));
                    Log.d("zzzz", "座位: "+seat);
                    SharedPreferences qq = getSharedPreferences("zw", Context.MODE_PRIVATE);
                    qq.edit().putString("seat",seat).commit();
                }
            });
        } else if (obj instanceof OrderBean) {
            OrderBean orderBean = (OrderBean) obj;
            order = orderBean.orderId;
            Toast.makeText(this, "订单号"+ order, Toast.LENGTH_SHORT).show();
            persenter.pay(userId,sessionId,1,order);

        }else if (obj instanceof PayBean){
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
    }

    @Override
    public void onExcurr(String str) {

    }



    private class SerachData implements DataCall<DetailsBean> {

        @Override
        public void success(DetailsBean data) {
            roomName.setText(data.name);
            List<DetailsBean.ShortFilmListBean> shortFilmList = data.shortFilmList;
            roomVideoPlayer.setUp(shortFilmList.get(0).videoUrl, null);
            Glide.with(SelectionActivity.this).load(shortFilmList.get(0).videoUrl).into(roomVideoPlayer.ivThumb);
            roomBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
    //MD5加密
    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
}
