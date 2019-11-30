package com.bw.movie.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ModifyActivity extends BaseActivity {


    @BindView(R.id.iv_user_headpic)
    ImageView ivUserHeadpic;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_user_sex)
    TextView tvUserSex;
    @BindView(R.id.tv_user_email)
    TextView tvUserEmail;
    @BindView(R.id.text_data)
    TextView textData;
    @BindView(R.id.jian)
    ImageView jian;
    private SharedPreferences sp;
    private String headPic;
    private String nickName;
    private String email;
    private int sex;
    private long lastLoginTime;

    @Override
    protected int initLayout() {
        return R.layout.activity_modify;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        sp = getSharedPreferences("login", MODE_PRIVATE);
        headPic = sp.getString("headPic", "");
        nickName = sp.getString("nickName", "");
        email = sp.getString("email", "");
        sex = sp.getInt("sex", 0);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy" + "年" + "MM" + "月" + "dd" + "号");
        lastLoginTime = sp.getLong("lastLoginTime", 0);
        String format = simpleDateFormat.format(lastLoginTime);
        Glide.with(this).load(headPic).into(ivUserHeadpic);
        tvUserName.setText(nickName);
        tvUserEmail.setText(email);
        if (sex == 1) {
            tvUserSex.setText("男");
        } else if (sex == 2) {
            tvUserSex.setText("女");
        }
        textData.setText(format);
    }

    @OnClick({R.id.jian,R.id.iv_user_headpic})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.jian:
                finish();
                break;
            case R.id.iv_user_headpic:
                showPopueWindow();
                break;
        }
    }
    private void showPopueWindow(){
        View popView = View.inflate(this,R.layout.popuewindow ,null);
        Button bt_album = (Button) popView.findViewById(R.id.btn_pop_album);
        Button bt_camera = (Button) popView.findViewById(R.id.btn_pop_camera);
        Button bt_cancle = (Button) popView.findViewById(R.id.btn_pop_cancel);
        //获取屏幕宽高
        int weight = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels*1/3;

        final PopupWindow popupWindow = new   PopupWindow(popView,weight,height);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);
        //点击外部popueWindow消失
        popupWindow.setOutsideTouchable(true);

        bt_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();

            }
        });
        bt_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();

            }
        });
        bt_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();

            }
        });
        //popupWindow消失屏幕变为不透明
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().setAttributes(lp);
            }
        });
        //popupWindow出现屏幕变为半透明
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.5f;
        getWindow().setAttributes(lp);
        popupWindow.update();
        popupWindow.showAtLocation(popView, Gravity.BOTTOM,0,50);

    }
}
