package com.bw.movie.view.fragment.mycomment;

import com.bw.movie.R;
import com.bw.movie.model.base.BaseFragment;
import com.bw.movie.model.base.BasePersenter;
import com.bw.movie.view.core.IView;

/**
 *  * <p>文件描述：我的评论影院<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/29<p>
 *  * <p>更改时间：2019/11/29<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class CinemaReviewFragment extends BaseFragment implements IView.doView {
    protected BasePersenter basePersenter;
    @Override
    protected void initData() {

    }

    @Override
    protected int initView() {
        return R.layout.fragment_cinema_review;
    }

    @Override
    public void onCurress(Object obj) {

    }

    @Override
    public void onExcurr(String str) {

    }
}
