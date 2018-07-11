package movie.watch.moviewatch.presenter.impl;

import android.util.Log;

import java.util.List;

import movie.watch.moviewatch.model.bean.Location;
import movie.watch.moviewatch.model.http.response.TimeModel;
import movie.watch.moviewatch.presenter.HomePresenter;
import movie.watch.moviewatch.view.contract.HomeContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenterImpl<T extends HomeContract> implements HomePresenter<T> {
    private T baseView;
    private TimeModel model;

    public HomePresenterImpl() {
        model = new TimeModel();
    }

    @Override
    public void getLocation() {
        if (baseView != null) {
            baseView.progressDialog("数据加载中……");
            model.getLocation(new Callback<Location>() {
                @Override
                public void onResponse(Call<Location> call, Response<Location> response) {
                    baseView.cancelDialog();
                    for (Location.PBean pBean : response.body().getP()) {
                        Log.e("HomePresenterImpl: ", pBean.toString());
                    }
                }

                @Override
                public void onFailure(Call<Location> call, Throwable t) {
                    Log.e("HomePresenterImpl: ", t.toString());
                }
            });
        }
    }

    @Override
    public void attachView(T baseView) {
        this.baseView = baseView;
    }

    @Override
    public void detachView() {
        baseView = null;
    }
}
