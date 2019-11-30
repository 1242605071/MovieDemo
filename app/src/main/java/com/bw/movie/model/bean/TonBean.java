package com.bw.movie.model.bean;

import java.util.List;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/30<p>
 *  * <p>更改时间：2019/11/30<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class TonBean {

    /**
     * result : [{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":7331,"pushTime":1575026457000,"status":0,"title":"系统通知","userId":13696},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":7330,"pushTime":1575026453000,"status":0,"title":"系统通知","userId":13696},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":7329,"pushTime":1575026449000,"status":0,"title":"系统通知","userId":13696},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":6405,"pushTime":1573870858000,"status":0,"title":"系统通知","userId":13696},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":6406,"pushTime":1573870858000,"status":0,"title":"系统通知","userId":13696},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":6407,"pushTime":1573870858000,"status":0,"title":"系统通知","userId":13696},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":6404,"pushTime":1573870857000,"status":0,"title":"系统通知","userId":13696},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":6403,"pushTime":1573870856000,"status":0,"title":"系统通知","userId":13696},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":6382,"pushTime":1573870730000,"status":0,"title":"系统通知","userId":13696}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * content : 您已购买电影票,请尽快完成支付,以免影响到您的观影
         * id : 7331
         * pushTime : 1575026457000
         * status : 0
         * title : 系统通知
         * userId : 13696
         */

        public String content;
        public int id;
        public long pushTime;
        public int status;
        public String title;
        public int userId;
    }
}
