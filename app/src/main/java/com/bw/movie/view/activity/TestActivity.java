package com.bw.movie.view.activity;




import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;


import com.baidu.location.LocationClient;
import com.bw.movie.R;




import butterknife.BindView;
import butterknife.ButterKnife;



public class TestActivity extends AppCompatActivity  {

    @BindView(R.id.room_btn)
    Button btnStart;
    @BindView(R.id.tv)
    TextView tvLocationInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);



    }


}
