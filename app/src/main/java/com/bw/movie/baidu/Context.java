package com.bw.movie.baidu;

import com.baidu.location.BDLocation;

/**
 * Time:  2019-11-08
 * Author:  l
 * Description:
 */
public class Context {
    //获得定位时间
    private String locationTime;
    //获得经度坐标
    private Double locationLongitude;
    //获得纬度坐标
    private Double locationLatitude;
    //获得详细地址信息
    private String locationAddrStr;
    //获取位置语义化信息，没有的话返回NULL
    private String locationDescribe;
    //回调的百度坐标类，内部封装了如经纬度、半径等属性信息
    private BDLocation mBdLocation;

}
