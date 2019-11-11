package com.bw.movie.model.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/11/6<p>
 *  * <p>更改时间：2019/11/6<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class App extends Application {
    public static Context context;
    public static IWXAPI api;
    public static IWXAPI getWXApi(){
        return api;


    }
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Fresco.initialize(this);
        regoToWx();
    }
    private void regoToWx() {
        api = WXAPIFactory.createWXAPI(this, "wxb3852e6a6b7d9516", true);
        api.registerApp("wxb3852e6a6b7d9516");
    }
}
