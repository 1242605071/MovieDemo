package com.bw.movie.model.bean;

import android.util.Log;

import java.util.List;

/**
 * Time:  2019-11-14
 * Author:  杨世博
 * Description:
 */
public class CinemaCommentBean {
    // "commentContent": "很棒",
    //            "commentHeadPic": "http://172.17.8.100/images/movie/head_pic/bwjy.jpg",
    //            "commentId": 94,
    //            "commentTime": 1573480318000,
    //            "commentUserId": 13771,
    //            "commentUserName": "tzy",
    //            "greatHeadPic": [],
    //            "greatNum": 0,
    //            "hotComment": 0,
    //            "isGreat": 0
    public String commentContent;
    public String commentHeadPic;
    public int commentId;
    public Long commentTime;
    public int commentUserId;
    public String commentUserName;
    public List<GreatHeadPic> greatHeadPic;
    public int greatNum;
    public int hotComment;
    public int isGreat;
}
