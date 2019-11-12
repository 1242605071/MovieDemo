package com.bw.movie.view.core;

import com.bw.movie.model.base.BasePersenter;
import com.bw.movie.model.base.IBaseView;

import retrofit2.http.Query;

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
        //根据影厅id 查询座位信息
        public abstract void seatle(int hallId);
        //根据电影ID和影院ID查询电影排期列表
        public abstract void bySchedule( int movieId, int cinemaId);
        //购票下单
        public abstract void buyMovieTickets(String userId,String sessionId, int scheduleId,String seat,String sign);
    }
}
