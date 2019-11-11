package com.bw.movie.model.bean;

import java.util.List;

/**
 * <p>文件描述：地区实体类<p>
 * <p>作者：zheng<p>
 * <p>创建时间：2019/10/22<p>
 * <p>更改时间：2019/10/22<p>
 */
public class RegionListBean {

    public String message;
    public String status;
    public List<ResultInfo> result;

    public static class ResultInfo {

        public int regionId;
        public String regionName;

    }

}
