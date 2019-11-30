package com.bw.movie.view.myactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 意见反馈
 */
public class FeedBackActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.tv)
    Button mTv;
    @BindView(R.id.text)
    EditText mText;


    @Override
    protected int initLayout() {
        return R.layout.activity_feed_back;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        String email = mText.getText().toString().trim();
    }

    @OnClick({R.id.back, R.id.tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tv:

                Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
