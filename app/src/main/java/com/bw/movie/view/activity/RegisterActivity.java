package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.bw.movie.presenter.EmailCodePresenter;
import com.bw.movie.presenter.RegisterPresenter;
import com.bw.movie.view.core.DataCall;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  * <p>文件描述：注册页面<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class RegisterActivity extends BaseActivity {


    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.user)
    EditText user;
    @BindView(R.id.pwdd)
    EditText pwdd;
    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.Obtain)
    Button Obtain;
    @BindView(R.id.dl)
    TextView dl;
    @BindView(R.id.regist)
    Button regist;
    private EmailCodePresenter emailCodePresenter;
    private RegisterPresenter registerPresenter;
    private String recode;
    private String repwdd;
    private String reuser;
    private String rename;
    private String JmPwd;
    private String encrypt;

    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        rename = name.getText().toString().trim();
        reuser = user.getText().toString().trim();
        repwdd = pwdd.getText().toString().trim();
        recode = code.getText().toString().trim();

        registerPresenter = new RegisterPresenter(new Register());
        emailCodePresenter = new EmailCodePresenter(new EmailCode());

    }

    @OnClick({R.id.Obtain, R.id.dl, R.id.regist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Obtain:
                reuser = user.getText().toString().trim();
                emailCodePresenter.RequestData(reuser);
                break;
            case R.id.dl:
                finish();
                break;
            case R.id.regist:
                rename = name.getText().toString().trim();
                reuser = user.getText().toString().trim();
                repwdd = pwdd.getText().toString().trim();
                recode = code.getText().toString().trim();
                JmPwd = Base64.encode(repwdd.getBytes());
                encrypt = EncryptUtil.encrypt(JmPwd);
                registerPresenter.RequestData(rename, reuser, encrypt, recode);
                break;
        }
    }

    private class Register implements DataCall {
        @Override
        public void success(Object data) {
            if (!TextUtils.isEmpty(rename) && !TextUtils.isEmpty(reuser) && !TextUtils.isEmpty(repwdd) && !TextUtils.isEmpty(recode)) {
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        }

        @Override
        public void fail(IRequest iRequest) {
            if (rename.isEmpty())
                Toast.makeText(RegisterActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            if (reuser.isEmpty())
                Toast.makeText(RegisterActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
            if (encrypt.isEmpty())
                Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
            if (recode.isEmpty())
                Toast.makeText(RegisterActivity.this, "验证码不能为空", Toast.LENGTH_SHORT).show();

        }
    }

    private class EmailCode implements DataCall {
        @Override
        public void success(Object data) {
            Toast.makeText(RegisterActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
