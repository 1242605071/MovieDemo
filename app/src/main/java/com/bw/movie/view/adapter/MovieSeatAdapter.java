package com.bw.movie.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.bw.movie.R;
import com.bw.movie.model.bean.SeatleBean;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/25<p>
 *  * <p>更改时间：2019/10/25<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class MovieSeatAdapter extends RecyclerView.Adapter<MovieSeatAdapter.MovieVIewHolder> {
    List<SeatleBean.ResultBean> result;

    public MovieSeatAdapter(List<SeatleBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MovieVIewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_seat_item, viewGroup, false);
        return new MovieVIewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieVIewHolder movieVIewHolder, final int i) {
        String row = result.get(i).row;
        String seat1 = result.get(i).seat;
        String seat = row + "-" + seat1;


        int status = result.get(i).status;
            if (status == 1) {
                movieVIewHolder.cheBox.setChecked(false);
            } else if (status == 2) {
                movieVIewHolder.cheBox.setChecked(true);
                movieVIewHolder.cheBox.setBackgroundColor(R.drawable.myy_shape);
        }
        final ArrayList<String> list = new ArrayList<>();
        movieVIewHolder.cheBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (movieVIewHolder.cheBox.isChecked()) {
                    result.get(i).status = 3;
                    String row1 = result.get(i).row;
                    String seat2 = result.get(i).seat;
                    String s = row1 + "-" + seat2;
                    list.addAll(Collections.singleton(s));
                    callBack.getStrng(list);
                    callBack.getBack(result.get(i).row + "排" + result.get(i).seat + "座");
                } else {
                    result.get(i).status = 1;
                    callBack.getBack("取消选座");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MovieVIewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.che_box)
        CheckBox cheBox;
        public MovieVIewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public interface CallBack {
        void getBack(String s);
        void getStrng(ArrayList<String> list);
    }

    CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
