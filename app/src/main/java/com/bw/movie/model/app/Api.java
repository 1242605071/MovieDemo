package com.bw.movie.model.app;

import com.android.volley.Request;
import com.bw.movie.model.bean.BanBean;
import com.bw.movie.model.bean.CinemaBean;
import com.bw.movie.model.bean.ComBean;
import com.bw.movie.model.bean.HotBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.LogBean;
import com.bw.movie.model.bean.NearbyBean;
import com.bw.movie.model.bean.PopBean;
import com.bw.movie.model.bean.RegioBean;
import com.bw.movie.model.bean.SerachBean;
import com.bw.movie.model.bean.WxLogBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    //登录
    @FormUrlEncoded
    @POST("movieApi/user/v2/login")
    Observable<IRequest<LogBean>> login(@Field("email") String email, @Field("pwd") String pwd);

    //微信登录
    @FormUrlEncoded
    @POST("movieApi/user/v1/weChatBindingLogin")
    Observable<IRequest<WxLogBean>> BindingLogin(@Field("code") String code);

    //轮播图
    @GET("movieApi/tool/v2/banner")
    Observable<IRequest<List<BanBean>>> banner();

    //正在上映
    @GET("movieApi/movie/v2/findReleaseMovieList")
    Observable<IRequest<List<HotBean>>> findReleaseMovieList(@Query("page") int page, @Query("count") int count);

    //注册
    @FormUrlEncoded
    @POST("movieApi/user/v2/register")
    Observable<IRequest> register(@Field("nickName") String nickName,
                                  @Field("email") String email,
                                  @Field("pwd") String pwd,
                                  @Field("code") String code);

    //发送验证码
    @FormUrlEncoded
    @POST("movieApi/user/v2/sendOutEmailCode")
    Observable<IRequest> sendOutEmailCode(@Field("email") String email);

    //即将上映
    @GET("movieApi/movie/v2/findComingSoonMovieList")
    Observable<IRequest<List<ComBean>>> findComingSoonMovieList(@Query("page") int page, @Query("count") int count);
    //热门电影
    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<IRequest<List<PopBean>>> findHotMovieList(@Query("page") int page, @Query("count") int count);
    //影片搜索
    @GET("movieApi/movie/v2/findMovieByKeyword")
    Observable<IRequest<List<SerachBean>>> findMovieByKeyword(@Query("keyword") String keyword, @Query("page") int page, @Query("count") int count);

    //推荐影院
    @GET("movieApi/cinema/v1/findRecommendCinemas")
    Observable<IRequest<List<CinemaBean>>> findRecommendCinemas(@Header("userId") String userId,
                                                               @Header("sessionId") String sessionId,
                                                               @Query("page") int page, @Query("count") int count);

    //查询附近影院
    @GET("movieApi/cinema/v1/findNearbyCinemas")
    Observable<IRequest<List<NearbyBean>>> findNearbyCinemas(@Header("userId") String userId,
                                                            @Header("sessionId") String sessionId,
                                                            @Query("longitude") String longitude, @Query("latitude") String latitude,
                                                            @Query("page") int page, @Query("count") int count);

    //根据区域查询影院
    @GET("movieApi/cinema/v2/findCinemaByRegion")
    Observable<IRequest<List<RegioBean>>> findCinemaByRegion(@Query("regionId") int regionId);
}
