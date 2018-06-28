package movie.watch.moviewatch.model.http.response;

import movie.watch.moviewatch.model.http.api.ServiceGenerator;
import movie.watch.moviewatch.model.http.api.TimeApi;
import retrofit2.Call;
import retrofit2.Callback;

public class TimeModel {
    private TimeApi apis;

    public TimeModel() {
        this.apis = ServiceGenerator.createServiceFrom(TimeApi.class);
    }

    /**
     * 正在售票(包括正在热映和即将上映)
     *
     * @param locationId
     * @param callback
     * @param <T>
     */
    public <T> void getGankWelfare(int locationId, Callback<T> callback) {
        Call<T> call = (Call<T>) apis.getTicketsSale(locationId);
        call.enqueue(callback);
    }

    /**
     * 获取地区信息
     *
     * @param callback
     * @param <T>
     */
    public <T> void getLocation(Callback<T> callback) {
        Call<T> call = (Call<T>) apis.getLocation();
        call.enqueue(callback);
    }


}
