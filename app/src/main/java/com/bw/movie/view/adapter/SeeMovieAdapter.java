package com.bw.movie.view.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.model.app.App;
import com.bw.movie.model.bean.SeenMovie;
import com.bw.movie.view.activity.WritecommentsActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * author: 徐涛
 * data: 2019/12/2 13:13:54
 * function:
 */
public class SeeMovieAdapter extends BaseQuickAdapter<SeenMovie,BaseViewHolder> {

    private ImageView image1;
    private Button person;

    public SeeMovieAdapter(int layoutResId, @Nullable List<SeenMovie> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final SeenMovie item) {

       helper.setText(R.id.name,item.movieName);
        SimpleDateFormat format=new SimpleDateFormat("MM"+"月"+"dd"+"日上映");
        String format1 = format.format(item.endTime);
        helper.setText(R.id.time1,format1+"");
        Uri parse = Uri.parse(item.imageUrl);
        image1 = helper.getView(R.id.image1);
        image1.setImageURI(parse);
        person = helper.getView(R.id.person);
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.context, WritecommentsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("movieId",item.cinemaId);
                App.context.startActivity(intent);
            }
        });

    }
}
