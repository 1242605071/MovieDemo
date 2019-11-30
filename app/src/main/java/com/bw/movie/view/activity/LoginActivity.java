package com.bw.movie.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.model.app.App;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.LogBean;
import com.bw.movie.model.bean.WxLogBean;
import com.bw.movie.model.encryption.Base64;
import com.bw.movie.model.encryption.EncryptUtil;
import com.bw.movie.presenter.BindingLoginPresenter;
import com.bw.movie.presenter.LoginPresenter;
import com.bw.movie.view.core.DataCall;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *  * <p>文件描述：登录页面<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.emailzh)
    EditText emailzh;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.zc)
    TextView zc;
    @BindView(R.id.dl)
    Button dl;
    @BindView(R.id.wxdl)
    ImageButton wxdl;
    @BindView(R.id.forget)
    Button forget;
    private String JmPwd = "";
    private LoginPresenter loginPresenter;
    private BindingLoginPresenter bindingLoginPresenter;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(new Login());
        bindingLoginPresenter = new BindingLoginPresenter(new BindingLog());
        EventBus.getDefault().register(this);
    }

    @OnClick({R.id.zc, R.id.dl, R.id.wxdl,R.id.forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zc:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.dl:
                String email = emailzh.getText().toString().trim();
                String pwd = this.pwd.getText().toString().trim();
                JmPwd = Base64.encode(pwd.getBytes());
                String encrypt = EncryptUtil.encrypt(JmPwd);
                Log.i("aaaa", encrypt);
                loginPresenter.RequestData(email, encrypt);
                break;
            case R.id.wxdl:
                if (!App.getWXApi().isWXAppInstalled()) {
                    Toast.makeText(LoginActivity.this, "您还未安装微信客户端", Toast.LENGTH_SHORT).show();
                    return;
                }
                SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "diandi_wx_login";
                App.getWXApi().sendReq(req);
                break;
            case R.id.forget:
                startActivity(new Intent(LoginActivity.this, ForgetActivity.class));
                break;
        }
    }

    private class Login implements DataCall <LogBean>{
        @Override
        public void success(LogBean data) {
            SharedPreferences login = getSharedPreferences("login", MODE_PRIVATE);
            SharedPreferences.Editor edit = login.edit();
            edit.putString("userId", data.userId + "");
            edit.putString("sessionId", data.sessionId );
            edit.commit();
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, ShowActivity.class));
        }


        @Override
        public void fail(IRequest iRequest) {
            Toast.makeText(LoginActivity.this, "账号密码错误", Toast.LENGTH_SHORT).show();
        }
    }

    private class BindingLog implements DataCall<WxLogBean> {
        @Override
        public void success(WxLogBean data) {
            SharedPreferences login = getSharedPreferences("login", MODE_PRIVATE);
            SharedPreferences.Editor edit = login.edit();
            edit.putString("userId", data.userId + "");
            edit.putString("sessionId", data.sessionId );
            edit.commit();
            Intent intent = new Intent(LoginActivity.this, ShowActivity.class);
            startActivity(intent);
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getWXlOGINcODE(BaseResp baseResp) {
        String code = ((SendAuth.Resp) baseResp).code;
        bindingLoginPresenter.RequestData(code);
    }
}
