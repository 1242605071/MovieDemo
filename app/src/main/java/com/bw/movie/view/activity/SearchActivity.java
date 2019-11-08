package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseActivity;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.SerachBean;
import com.bw.movie.presenter.FindMovieByKeywordPresenter;
import com.bw.movie.view.adapter.SerachAdapter;
import com.bw.movie.view.core.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  * <p>文件描述：搜索影片<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class SearchActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.nr)
    EditText nr;
    @BindView(R.id.search)
    TextView search;
    @BindView(R.id.searrecycleview)
    RecyclerView searrecycleview;
    private FindMovieByKeywordPresenter findMovieByKeywordPresenter;

    @Override
    protected int initLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        findMovieByKeywordPresenter = new FindMovieByKeywordPresenter(new KeywordData());
    }

    @OnClick({R.id.back, R.id.search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                Intent intent = new Intent(this, ShowActivity.class);
                startActivity(intent);
                break;
            case R.id.search:
                findMovieByKeywordPresenter.RequestData(nr.getText().toString().trim(),1,100);
                String nrString = nr.getText().toString().trim();
                if (TextUtils.isEmpty(nrString)) {
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }
    }


    private class KeywordData implements DataCall <List<SerachBean>>{
        @Override
        public void success(List<SerachBean> data) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            searrecycleview.setLayoutManager(linearLayoutManager);
            SerachAdapter serachAdapter = new SerachAdapter(R.layout.serach_item,data);
            searrecycleview.setAdapter(serachAdapter);
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
