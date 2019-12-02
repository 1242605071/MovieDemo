package com.bw.movie.model.bean;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/12/2<p>
 * <p>更改时间：2019/12/2<p>
 */
public class GouPao {
//    id	int	购票记录id
//    movieName	string	电影名称
//    cinemaName	string	影院名称
//    imageUrl	string	电影封面
//    orderId	string	订单id
//    createTime	long	购票时间
//    price	double	单价
//    amount	int	购票数

    public int id;
    public int amount;
    public double price;
    public long createTime;
    public String orderId;
    public String imageUrl;
    public String cinemaName;
    public String movieName;
}
