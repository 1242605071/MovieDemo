package com.bw.movie.model.bean;

import java.util.List;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/29<p>
 *  * <p>更改时间：2019/11/29<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class MovieBean {

    /**
     * result : [{"commentTime":1571900102000,"director":"克里斯托弗·麦奎里","imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieId":16,"movieName":"碟中谍6：全面瓦解","movieScore":0,"myCommentContent":"12113","myCommentScore":3,"starring":"汤姆·克鲁斯,亨利·卡维尔,丽贝卡·弗格森,西蒙·佩吉"},{"commentTime":1571830646000,"director":"庄文强","imageUrl":"http://172.17.8.100/images/movie/stills/ws/ws1.jpg","movieId":20,"movieName":"无双","movieScore":0,"myCommentContent":"","myCommentScore":0,"starring":"周润发,郭富城,张静初,冯文娟,廖启智"},{"commentTime":1571830540000,"director":"林德禄","imageUrl":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)1.jpg","movieId":17,"movieName":"反贪风暴3","movieScore":0,"myCommentContent":"","myCommentScore":1.5,"starring":"古天乐,张智霖,郑嘉颖,邓丽欣,谢天华"},{"commentTime":1571302323000,"director":"李海龙","imageUrl":"http://172.17.8.100/images/movie/stills/jmyx/jmyx1.jpg","movieId":14,"movieName":"解码游戏","movieScore":0,"myCommentContent":"看家里金坷垃","myCommentScore":2.5,"starring":"韩庚,凤小岳,李媛,山下智久"},{"commentTime":1571302213000,"director":"吕乐","imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg","movieId":21,"movieName":"找到你","movieScore":0,"myCommentContent":"手动阀爱迪生范德萨","myCommentScore":4.5,"starring":"姚晨,马伊琍,袁文康,吴昊宸"}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * commentTime : 1571900102000
         * director : 克里斯托弗·麦奎里
         * imageUrl : http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg
         * movieId : 16
         * movieName : 碟中谍6：全面瓦解
         * movieScore : 0
         * myCommentContent : 12113
         * myCommentScore : 3
         * starring : 汤姆·克鲁斯,亨利·卡维尔,丽贝卡·弗格森,西蒙·佩吉
         */

        public long commentTime;
        public String director;
        public String imageUrl;
        public int movieId;
        public String movieName;
        public int movieScore;
        public String myCommentContent;
        public String starring;
    }
}
