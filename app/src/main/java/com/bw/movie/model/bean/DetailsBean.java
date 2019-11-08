package com.bw.movie.model.bean;

import java.util.List;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/8<p>
 *  * <p>更改时间：2019/11/8<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class DetailsBean {

        public int commentNum;
        public String duration;
        public String imageUrl;
        public int movieId;
        public String movieType;
        public String name;
        public String placeOrigin;
        public long releaseTime;
        public double score;
        public String summary;
        public int whetherFollow;
        public List<MovieActorBean> movieActor;
        public List<MovieDirectorBean> movieDirector;
        public List<String> posterList;
        public List<ShortFilmListBean> shortFilmList;

        public static class MovieActorBean {
            /**
             * name : 徐峥
             * photo : http://172.17.8.100/images/movie/actor/wbsys/xuzheng.jpg
             * role : 程勇
             */

            public String name;
            public String photo;
            public String role;
        }

        public static class MovieDirectorBean {
            /**
             * name : 文牧野
             * photo : http://172.17.8.100/images/movie/director/wbsys/1.jpg
             */

            public String name;
            public String photo;
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://172.17.8.100/images/movie/stills/wbsys/wbsys2.jpg
             * videoUrl : http://172.17.8.100/video/movie/wbsys/wbsysygp1.ts
             */

            public String imageUrl;
            public String videoUrl;
        }


}
