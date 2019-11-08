package com.bw.movie.model.bean;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class LogBean {
        /**
         * sessionId : 157301844549213696
         * userId : 13696
         * userInfo : {"email":"1242605071@qq.com","headPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","id":13696,"lastLoginTime":1572608537000,"nickName":"我的神明","sex":1}
         */

        public String sessionId;
        public int userId;
        public UserInfoBean userInfo;

        public static class UserInfoBean {
            /**
             * email : 1242605071@qq.com
             * headPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
             * id : 13696
             * lastLoginTime : 1572608537000
             * nickName : 我的神明
             * sex : 1
             */

            public String email;
            public String headPic;
            public int id;
            public long lastLoginTime;
            public String nickName;
            public int sex;
        }

}
