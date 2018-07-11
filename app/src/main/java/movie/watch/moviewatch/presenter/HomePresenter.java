package movie.watch.moviewatch.presenter;

import movie.watch.moviewatch.base.BasePresenter;
import movie.watch.moviewatch.base.BaseView;

public interface HomePresenter<T extends BaseView> extends BasePresenter<T> {
    /**
     * 获取地区信息
     */
    void getLocation();
}
