package com.bw.movie.model.bean;

public class IRequest<T> {
    //    "result": {
    //    "message": "登录成功",
    //    "status": "0000"

    public String message;
    public String status;
    public T result;

}
