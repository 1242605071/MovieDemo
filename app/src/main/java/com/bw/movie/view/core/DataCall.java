package com.bw.movie.view.core;

import com.bw.movie.model.bean.IRequest;

public interface DataCall<T> {
    void success(T data);

    void fail(IRequest iRequest);
}
