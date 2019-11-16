package com.bw.movie.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.MovieCommentPresneter;
import com.bw.movie.view.core.DataCall;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WritecommentsActivity extends BaseActivity {

    @BindView(R.id.deta_name)
    TextView detaName;
    @BindView(R.id.fs)
    TextView fs;
    @BindView(R.id.ratingbar)
    SimpleRatingBar ratingbar;
    @BindView(R.id.rn)
    EditText rn;
    @BindView(R.id.dll)
    Button dll;
    @BindView(R.id.write_ima)
    ImageView writeIma;

    private MovieCommentPresneter presneter;
    private String trim;
    private String userId;
    private String sessionId;
    private int movieId;
    private String name;

    @Override
    protected int initLayout() {
        return R.layout.activity_writecomments;
    }

    @OnClick({R.id.ratingbar, R.id.dll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ratingbar:
                break;
            case R.id.dll:
                trim = rn.getText().toString().trim();
                presneter.RequestData(userId, sessionId, movieId, trim, 4.5);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        detaName.setText(name);
        movieId = intent.getIntExtra("movieId", 0);
        SharedPreferences login = getSharedPreferences("login", MODE_PRIVATE);
        userId = login.getString("userId", "");
        sessionId = login.getString("sessionId", "");
        presneter = new MovieCommentPresneter(new Writecom());


    }

    @OnClick(R.id.write_ima)
    public void onViewClicked() {
        finish();
    }

    private class Writecom implements DataCall {
        @Override
        public void success(Object data) {
            Toast.makeText(WritecommentsActivity.this,"评论成功",Toast.LENGTH_SHORT).show();
          finish();
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
