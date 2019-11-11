package com.bw.movie.view.core;

import com.bw.movie.model.base.BasePersenter;
import com.bw.movie.model.base.IBaseView;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/11<p>
 *  * <p>更改时间：2019/11/11<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public interface IView {
    interface doView extends IBaseView {}
    abstract class doData extends BasePersenter {
        public doData(IBaseView iBaseView) {
            super(iBaseView);
        }
        //根据电影id和区域id查询影院
        public abstract void findCinemasInfoByRegion( int movieId, int regionId, int page, int count);
        // 地区
        public abstract void findRegionList();
    }
}
