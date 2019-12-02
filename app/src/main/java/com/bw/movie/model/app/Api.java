package com.bw.movie.model.app;

import com.android.volley.Request;
import com.bw.movie.model.bean.BanBean;
import com.bw.movie.model.bean.CinemaBean;
import com.bw.movie.model.bean.CinemaCommentBean;
import com.bw.movie.model.bean.CinemaInfo;
import com.bw.movie.model.bean.CinemaScheduleList;
import com.bw.movie.model.bean.CinemasInfoByRegionBean;
import com.bw.movie.model.bean.ComBean;
import com.bw.movie.model.bean.CommentsBean;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.FindAllCinemas;
import com.bw.movie.model.bean.GuanzhuBean;
import com.bw.movie.model.bean.HotBean;
import com.bw.movie.model.bean.IRequest;
import com.bw.movie.model.bean.LogBean;
import com.bw.movie.model.bean.MaBean;
import com.bw.movie.model.bean.MovieBean;
import com.bw.movie.model.bean.NearbyBean;
import com.bw.movie.model.bean.OrderBean;
import com.bw.movie.model.bean.PayBean;
import com.bw.movie.model.bean.PopBean;
import com.bw.movie.model.bean.RegioBean;
import com.bw.movie.model.bean.Requests;
import com.bw.movie.model.bean.ResultInfo;
import com.bw.movie.model.bean.SchedBean;
import com.bw.movie.model.bean.SeatleBean;
import com.bw.movie.model.bean.SerachBean;
import com.bw.movie.model.bean.Subscribe;
import com.bw.movie.model.bean.TonBean;
import com.bw.movie.model.bean.WxLogBean;
import com.bw.movie.model.bean.YingYuanPaiQi;

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

    //查询区域列表
    @GET("movieApi/tool/v2/findRegionList")
    Observable<IRequest<List<ResultInfo>>> findRegionList();

    //查询电影详情
    @GET("movieApi/movie/v2/findMoviesDetail")
    Observable<IRequest<DetailsBean>>  findMoviesDetail(@Query("movieId") int movieId);
    //评论列表
    @GET("movieApi/movie/v2/findAllMovieComment")
    Observable<IRequest<List<CommentsBean>>> commentsMap(@Query("movieId") int movieId,@Query("page") int page, @Query("count") int count);
    // 根据电影id和区域id查询影院
    @GET("movieApi/movie/v2/findCinemasInfoByRegion")
    Observable<CinemasInfoByRegionBean> findCinemasInfoByRegion(@Query("movieId") int movieId, @Query("regionId") int regionId,
                                                                @Query("page") int page, @Query("count") int count);

    //根据影厅id 查询座位信息
    @GET("movieApi/movie/v2/findSeatInfo")
    Observable<SeatleBean> seatle(@Query("hallId") int hallId);
    //根据电影ID和影院ID查询电影排期列表
    @GET("movieApi/movie/v2/findMovieSchedule")
    Observable<SchedBean> bySchedule(@Query("movieId") int movieId,@Query("cinemaId") int cinemaId);
    //购票下单
    @FormUrlEncoded
    @POST("movieApi/movie/v2/verify/buyMovieTickets")
    Observable<OrderBean> buyMovieTickets(@Header("userId") String userId,@Header("sessionId") String sessionId,@Field("scheduleId") int scheduleId,@Field("seat") String seat,@Field("sign") String sign);

    //查询电影信息明细
    @GET("movieApi/cinema/v1/findCinemaInfo")
    Observable<IRequest<CinemaInfo>> findCinemaInfo(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("cinemaId") int cinemaId);

    //查询影院用户评论列表
    @GET("movieApi/cinema/v1/findAllCinemaComment")
    Observable<IRequest<List<CinemaCommentBean>>> findAllCinemaComment(@Query("cinemaId") int cinemaId, @Query("page") int page, @Query("count") int count);

    //支付
    @FormUrlEncoded
    @POST("movieApi/movie/v2/verify/pay")
    Observable<PayBean> pay(@Header("userId") String userId, @Header("sessionId") String sessionId, @Field("payType") int paytype, @Field("orderId")String orderId);

//    //查询影院下的电影排期
//    @GET("movieApi/cinema/v2/findCinemaScheduleList")
//    Observable<IRequest<List<CinemaScheduleList>>> findCinemaScheduleList(@Query("cinemaId") int cinemaId, @Query("page") int page, @Query("count") int count);
    //查询影院下的电影排期
    @GET("cinema/v2/findCinemaScheduleList")
    Observable<Request<List<YingYuanPaiQi>>>findCinemaScheduleList(@Query("cinemaId")int cinemaId, @Query("page")int page,
                                                                   @Query("count")int count);
    //影片搜索
    @GET("movieApi/cinema/v1/findAllCinemas")
    Observable<IRequest<List<FindAllCinemas>>> findAllCinemas(@Query("page") int page, @Query("count") int count, @Query("cinemaName") String cinemaName);

    //查询一周排期的时间
    @GET("movieApi/tool/v2/findDateList")
    Observable<Requests> findDateList();

    //添加用户对影片的评论
    @FormUrlEncoded
    @POST("movieApi/movie/v1/verify/movieComment")
    Observable<IRequest> movieComment(@Header("userId") String userId, @Header("sessionId") String sessionId, @Field("movieId") int movieId,
                                      @Field("commentContent")String commentContent, @Field("score")double score );

    @GET("movieApi/user/v2/verify/findMyMovieCommentList")
    Observable<MovieBean> findMyMovieCommentList(@Header("userId") String userId,@Header("sessionId") String sessionId,@Query("page") int page, @Query("count") int count);


    @GET("movieApi/user/v2/verify/findUserFollowMovieList")
    Observable<IRequest<List<GuanzhuBean>>> findUserFollowMovieList(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("page")int page, @Query("count")int count);
    //查询系统消息列表
    @GET("movieApi/tool/v1/verify/findAllSysMsgList")
    Observable<TonBean> findAllSysMsgList(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("page")int page, @Query("count")int count);
    //@Header("userId")int userId, @Header("sessionId")String sessionId,
    //预约
    @POST("movieApi/movie/v2/verify/reserve")
    Observable<IRequest<Subscribe>> reserve(@Header("userId")int userId, @Header("sessionId")String sessionId,
                                            @Query("movieId")int movieId);
    //二维码
    @GET("movieApi/user/v2/verify/findExchangeCode")
    Observable<MaBean> findExchangeCode(@Header("userId")String userId, @Header("sessionId")String sessionId,@Query("recordId")int recordId);
}
