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

    }
}
