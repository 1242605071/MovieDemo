package com.bw.movie.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 *  * <p>文件描述：function:扩展式自定义View,在ScrollView的基础上添加新的功能
 *  * 1.类继承继承控件,实现三个方法覆写
 *  * 2.自定义一个ScrollView滑动监听的接口
 *  * 3.覆写ScrollView自带的滑动监听(注意这个监听方法,你在外界调用不到,所以我们才要写接口暴露出去)
 *  * 4.提供方法,让外界可以设置ScrollView的滑动监听
 *  * 5.使用OBservablerScroollbIew自定义控件即可<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/16<p>
 *  * <p>更改时间：2019/10/16<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class ObservableScrollView extends ScrollView {
    //在Java代码时候回调
    public ObservableScrollView(Context context) {
        super(context,null);
    }
    //在XML里面回调
    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }
    //在XML设置样式的时候回掉
    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //ScollView自带的一个滑动监听方法,新的X,Y坐标,和旧的X,Y坐标
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mScrollViewListener!=null){
            mScrollViewListener.onScrollChanged(this,l,t,oldl,oldt);
        }

    }
    //定义一个接口
    public interface ScrollViewListener{
        void onScrollChanged(ObservableScrollView scrollView, int l, int t, int oldl, int oldt);
    }
    public ScrollViewListener mScrollViewListener;

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        mScrollViewListener = scrollViewListener;
    }
}
