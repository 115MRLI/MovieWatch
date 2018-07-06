package movie.watch.moviewatch.presenter;

import movie.watch.moviewatch.base.BasePresenter;
import movie.watch.moviewatch.base.BaseView;

public interface WelcomePresenter<T extends BaseView> extends BasePresenter<T> {
    /**
     * 开启延时动画
     */
    void starAnimation();
}
