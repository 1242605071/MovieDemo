package com.bw.movie.view.fragment.cinema_detailsFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.bean.CinemaInfo;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.presenter.CinemaInfoPresenter;
import com.bw.movie.view.activity.ScheduActivity;
import com.bw.movie.view.core.DataCall;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Time:  2019-11-12
 * Author:  杨世博
 * Description: 影院详情
 */
public class DetailsFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.details_address)
    TextView detailsAddress;
    @BindView(R.id.details_phone)
    TextView detailsPhone;
    @BindView(R.id.details_bus)
    TextView detailsBus;
    public CinemaInfoPresenter presenter;
    @BindView(R.id.btn_paiqi)
    Button btnPaiqi;

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("id", 0);
        presenter = new CinemaInfoPresenter(new Cinmes());

        presenter.RequestData("13772", "157355978503213772", id);
    }

    @Override
    protected int initView() {
        return R.layout.fragment_details;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_paiqi)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), ScheduActivity.class);
        startActivity(intent);
    }


    private class Cinmes implements DataCall<CinemaInfo> {
        @Override
        public void success(CinemaInfo data) {

            detailsAddress.setText(data.address);
            detailsPhone.setText(data.phone);
            detailsBus.setText(data.vehicleRoute);
        }

        @Override
        public void fail(IRequest iRequest) {

        }
    }
}
