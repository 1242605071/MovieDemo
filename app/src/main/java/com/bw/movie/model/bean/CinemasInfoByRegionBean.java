package com.bw.movie.model.bean;

import java.util.List;

/**
 * <p>文件描述：根据电影id和区域id查询影院实体类<p>
 * <p>作者：李大辰<p>
 * <p>创建时间：2019/10/25<p>
 * <p>更改时间：2019/10/25<p>
 */
public class CinemasInfoByRegionBean {

    public String message;
    public String status;
    public List<ResultInfo> result;

    public static class ResultInfo {

        public String address;
        public int cinemaId;
        public String logo;
        public String name;
        public int price;

    }

}
