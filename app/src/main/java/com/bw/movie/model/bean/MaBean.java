package com.bw.movie.model.bean;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/12/2<p>
 *  * <p>更改时间：2019/12/2<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class MaBean {

    /**
     * result : {"exchangeCode":"http://172.17.8.100/images/movie/movieCode/20191202104354184.jpg","id":0,"recordId":0,"status":0}
     * message : 查询成功
     * status : 0000
     */

    public ResultBean result;
    public String message;
    public String status;

    public static class ResultBean {
        /**
         * exchangeCode : http://172.17.8.100/images/movie/movieCode/20191202104354184.jpg
         * id : 0
         * recordId : 0
         * status : 0
         */

        public String exchangeCode;
        public int id;
        public int recordId;
        public int status;
    }
}
