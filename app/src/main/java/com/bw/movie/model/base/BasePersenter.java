package com.bw.movie.model.base;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/11<p>
 *  * <p>更改时间：2019/11/11<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class BasePersenter {
    protected IBaseView iBaseView;
    public BasePersenter (IBaseView iBaseView){
        this.iBaseView = iBaseView;
    }
    //内存泄漏
    public void onDestroy(){
        if (iBaseView!=null){
            iBaseView=null;
        }
    }
}
