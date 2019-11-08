package com.bw.movie.model.bean;

import java.util.List;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/16<p>
 *  * <p>更改时间：2019/10/16<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class CommentsBean {



        /**
         * commentContent : 好看
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/2019-09-11/20190911193258.jpg
         * commentId : 1670
         * commentTime : 1570603727000
         * commentUserId : 13607
         * commentUserName : 夏天
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 4.5
         */

        public String commentContent;
        public String commentHeadPic;
        public int commentId;
        public long commentTime;
        public int commentUserId;
        public String commentUserName;
        public int greatNum;
        public int isGreat;
        public int replyNum;
        public double score;
        public List<?> replyHeadPic;


}
