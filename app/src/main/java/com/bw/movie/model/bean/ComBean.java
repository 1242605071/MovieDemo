package com.bw.movie.model.bean;

import java.util.List;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/12<p>
 *  * <p>更改时间：2019/10/12<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class ComBean {



        /**
         * imageUrl : http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg
         * movieId : 16
         * name : 碟中谍6：全面瓦解
         * releaseTime : 1600704000000
         * wantSeeNum : 23
         * whetherReserve : 2
         */

        public String imageUrl;
        public int movieId;
        public String name;
        public long releaseTime;
        public int wantSeeNum;
        public int whetherReserve;

        public ComBean(String imageUrl, int movieId, String name, long releaseTime, int wantSeeNum, int whetherReserve) {
                this.imageUrl = imageUrl;
                this.movieId = movieId;
                this.name = name;
                this.releaseTime = releaseTime;
                this.wantSeeNum = wantSeeNum;
                this.whetherReserve = whetherReserve;
        }

        public String getImageUrl() {
                return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
        }

        public int getMovieId() {
                return movieId;
        }

        public void setMovieId(int movieId) {
                this.movieId = movieId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public long getReleaseTime() {
                return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
                this.releaseTime = releaseTime;
        }

        public int getWantSeeNum() {
                return wantSeeNum;
        }

        public void setWantSeeNum(int wantSeeNum) {
                this.wantSeeNum = wantSeeNum;
        }

        public int getWhetherReserve() {
                return whetherReserve;
        }

        public void setWhetherReserve(int whetherReserve) {
                this.whetherReserve = whetherReserve;
        }
}
