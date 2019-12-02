package com.bw.movie.view.activity;

import android.content.Entity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.encryption.Base64;
import com.bw.movie.model.encryption.EncryptUtil;
import com.bw.movie.presenter.XiuGaiPresenter;
import com.bw.movie.view.core.DataCall;
import com.bw.movie.view.myactivity.SetupActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XuiGaiActivity extends BaseActivity {


    @BindView(R.id.jiupwd)
    EditText jiupwd;
    @BindView(R.id.xinpwd)
    EditText xinpwd;
    @BindView(R.id.xinpwd1)
    EditText xinpwd1;
    @BindView(R.id.quxiao)
    TextView quxiao;
    @BindView(R.id.xiugai)
    Button xiugai;
    private String pwd;
    private SharedPreferences sp;
    private String userId;
    private String sessionId;
    private XiuGaiPresenter xiuGaiPresenter;
    private String pwd1;
    private String encode;
    private String pwds;
    private String encodes;
    private String pwd1s;


    @Override
    protected int initLayout() {
        return R.layout.activity_xui_gai;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        sp = getSharedPreferences("login",MODE_PRIVATE);
        pwd1 = sp.getString("pwd", "");
        encode = Base64.encode(pwd1.getBytes());
        pwds = EncryptUtil.encrypt(encode);
        userId = sp.getString("userId", "");
        sessionId = sp.getString("sessionId", "");

    }

    @OnClick({R.id.quxiao, R.id.xiugai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.quxiao:
                finish();
                break;
            case R.id.xiugai:
                pwd = xinpwd1.getText().toString();
                encodes = Base64.encode(pwd.getBytes());
                pwd1s = EncryptUtil.encrypt(encodes);
                xiuGaiPresenter = new XiuGaiPresenter(new XiuGaiPresen());
                xiuGaiPresenter.RequestData(Integer.valueOf(userId),sessionId,pwds,pwd1s,pwd1s);
                break;
        }
    }

    private class XiuGaiPresen implements DataCall<IRequest> {
        @Override
        public void success(IRequest data) {
            Toast.makeText(XuiGaiActivity.this,"修改成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(XuiGaiActivity.this, SetupActivity.class);
            startActivity(intent);
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
