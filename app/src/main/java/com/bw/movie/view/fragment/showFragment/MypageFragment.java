package com.bw.movie.view.fragment.showFragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.view.activity.LoginActivity;
import com.bw.movie.view.activity.ModifyActivity;
import com.bw.movie.view.activity.SubscribeActivity;
import com.bw.movie.view.myactivity.FeedBackActivity;
import com.bw.movie.view.myactivity.FollowActivity;
import com.bw.movie.view.myactivity.MessageActivity;
import com.bw.movie.view.myactivity.MyCommentActivity;
import com.bw.movie.view.myactivity.RecordActivity;
import com.bw.movie.view.myactivity.SeenActivity;
import com.bw.movie.view.myactivity.SetupActivity;
import com.bw.movie.view.myactivity.TicketActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 *  * <p>文件描述：我的<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class MypageFragment extends BaseFragment {
    @BindView(R.id.personimage)
    ImageView personimage;
    @BindView(R.id.textdying)
    TextView textdying;
    @BindView(R.id.carddl)
    CardView carddl;
    Unbinder unbinder;
    @BindView(R.id.dsz)
    ImageView dsz;
    @BindView(R.id.my_btn1)
    LinearLayout myBtn1;
    @BindView(R.id.my_btn2)
    LinearLayout myBtn2;
    @BindView(R.id.my_btn3)
    LinearLayout myBtn3;
    @BindView(R.id.my_btn4)
    LinearLayout myBtn4;
    @BindView(R.id.my_btn5)
    LinearLayout myBtn5;
    @BindView(R.id.my_btn6)
    LinearLayout myBtn6;
    @BindView(R.id.my_btn7)
    LinearLayout myBtn7;
    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.image_jian)
    ImageView imageJian;
    @BindView(R.id.rl_dian)
    RelativeLayout mRlDian;
    private SharedPreferences sp;
    private String name;
    private String headPic;
    private String userId;
    private String status;

    @Override
    protected void initData() {

    }

    @Override
    protected int initView() {
        return R.layout.fragment_mypage;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        name = sp.getString("nickName", "");
        userId = sp.getString("userId", "");
        headPic = sp.getString("headPic", "");
        status = sp.getString("status", "");
        textdying.setText(name);
        Glide.with(getActivity()).load(headPic)
                .placeholder(R.drawable.shape)
                .into(personimage);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.carddl, R.id.my_btn1, R.id.my_btn2, R.id.my_btn3, R.id.my_btn4, R.id.my_btn5, R.id.my_btn6, R.id.my_btn7, R.id.image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.carddl:
                if (status.equals("0000")) {
                    Toast.makeText(getActivity(), "您已登录!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), ModifyActivity.class);
                    startActivity(intent);
                } else {
                    Intent intentdl = new Intent(getContext(), LoginActivity.class);
                    startActivity(intentdl);
                }
                break;
            case R.id.my_btn1:
                Intent intent1 = new Intent(getContext(), FollowActivity.class);
                startActivity(intent1);
                break;
            case R.id.my_btn2:
                Intent intent2 = new Intent(getContext(), SubscribeActivity.class);
                startActivity(intent2);
                break;
            case R.id.my_btn3:
                Intent intent3 = new Intent(getContext(), RecordActivity.class);
                startActivity(intent3);
                break;
            case R.id.my_btn4:
                Intent intent4 = new Intent(getContext(), SeenActivity.class);
                startActivity(intent4);
                break;
            case R.id.my_btn5:
                Intent intent5 = new Intent(getContext(), MyCommentActivity.class);
                startActivity(intent5);
                break;
            case R.id.my_btn6:
                Intent intent6 = new Intent(getContext(), FeedBackActivity.class);
                startActivity(intent6);
                break;
            case R.id.my_btn7:
                Intent intent7 = new Intent(getContext(), SetupActivity.class);
                startActivity(intent7);
                break;
            case R.id.image:
                Intent intent8 = new Intent(getContext(), MessageActivity.class);
                startActivity(intent8);
                break;
        }
    }


    @OnClick(R.id.rl_dian)
    public void onViewClicked() {
        Intent intent9 = new Intent(getContext(), TicketActivity.class);
        startActivity(intent9);
    }
}
