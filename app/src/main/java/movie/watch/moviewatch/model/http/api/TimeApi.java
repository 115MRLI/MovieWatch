package movie.watch.moviewatch.model.http.api;

import java.util.List;

import movie.watch.moviewatch.model.bean.Location;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TimeApi {
    //Time时光api（非官方）
    //正在售票(包括正在热映和即将上映)
    //url：https://api-m.mtime.cn/PageSubArea/HotPlayMovies.api?locationId=?
    //正在热映
    //url：https://api-m.mtime.cn/Showtime/LocationMovies.api?locationId=?
    //即将上映
    //url：https://api-m.mtime.cn/Movie/MovieComingNew.api?locationId=?
    //影片详情
    //url：https://ticket-api-m.mtime.cn/movie/detail.api?locationId=?&movieId=?
    //演职员表
    //url：https://api-m.mtime.cn/Movie/MovieCreditsWithTypes.api?movieId=?
    //影片评论
    //url：https://ticket-api-m.mtime.cn/movie/hotComment.api?movieId=?
    //预告片&拍摄花絮
    //url：https://api-m.mtime.cn/Movie/Video.api?pageIndex=?&movieId=?
    //剧照
    //url：https://api-m.mtime.cn/Movie/ImageAll.api?movieId=?
    //获取地区信息
    // url：https://api-m.mtime.cn/Showtime/HotCitiesByCinema.api

    /**
     * 正在售票(包括正在热映和即将上映)
     */
    @GET("PageSubArea/HotPlayMovies.api?locationId={locationId}")
    Call<movie.watch.moviewatch.model.bean.TicketsSale> getTicketsSale(@Path("locationId") int locationId);

    /**
     * 获取地区信息
     *
     * @return
     */
    @GET("Showtime/HotCitiesByCinema.api")
    Call<Location> getLocation();

}
